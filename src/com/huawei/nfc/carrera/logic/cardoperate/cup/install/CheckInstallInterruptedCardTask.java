package com.huawei.nfc.carrera.logic.cardoperate.cup.install;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.LogicApiFactory;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.QueryAidRequest;
import com.huawei.nfc.carrera.server.card.response.QueryAidResponse;
import com.huawei.nfc.carrera.storage.sp.NFCPreferences;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.json.JsonUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class CheckInstallInterruptedCardTask implements Runnable {
    private static final long INSTALL_INTERRUPTED_CARD_VALID_TIME = 220000;
    private final Context mContext;
    private final HandleCheckCUPCardResultTask resultTask;

    public CheckInstallInterruptedCardTask(Context context, HandleCheckCUPCardResultTask handleCheckCUPCardResultTask) {
        this.mContext = context;
        this.resultTask = handleCheckCUPCardResultTask;
    }

    public void run() {
        ArrayList cardList = WalletTaManager.getInstance(this.mContext).getCardList();
        if (cardList == null || cardList.isEmpty()) {
            LogX.e("check cup card, but ta card info is empty.");
            checkTaskFinished();
            return;
        }
        Iterator it = cardList.iterator();
        while (it.hasNext()) {
            TACardInfo tACardInfo = (TACardInfo) it.next();
            Object obj = (98 == tACardInfo.cardStatus || 97 == tACardInfo.cardStatus || 96 == tACardInfo.cardStatus || 95 == tACardInfo.cardStatus) ? null : 1;
            if (obj == null) {
                checkServiceData(tACardInfo);
            }
        }
        checkTaskFinished();
    }

    private void checkServiceData(TACardInfo tACardInfo) {
        boolean z = false;
        QueryAidResponse queryPersonalizedInfo = queryPersonalizedInfo(tACardInfo.dpanDigest);
        if (queryPersonalizedInfo == null) {
            return;
        }
        if (queryPersonalizedInfo.returnCode == 0) {
            if (StringUtil.isEmpty(queryPersonalizedInfo.aid, true) || queryPersonalizedInfo.virtualCardRefID == null || "".equals(queryPersonalizedInfo.virtualCardRefID) || !queryPersonalizedInfo.virtualCardRefID.equals(tACardInfo.dpanDigest)) {
                z = true;
            }
            if (z) {
                LogX.d("query aid success, but result illegal.");
                return;
            }
            doTaUpdate(tACardInfo, queryPersonalizedInfo.aid);
            NFCPreferences.getInstance(this.mContext).remove(tACardInfo.dpanDigest);
            CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(queryPersonalizedInfo.aid, null, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
            return;
        }
        Map hashMap;
        if (-3 == queryPersonalizedInfo.returnCode) {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "card has not been downloaded.");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "" + queryPersonalizedInfo.returnCode);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR, hashMap, null, false, false);
            LogX.d("card has not been downloaded.");
        } else {
            hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "checkServiceData fail");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "" + queryPersonalizedInfo.returnCode);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SERVER_ERR, hashMap, "checkServiceData fail", false, false);
        }
        checkTimeOutAndCleanTempData(tACardInfo);
    }

    private void updateTaCardStatusToErr(String str, int i) {
        int i2 = 94;
        Object obj = 1;
        if (!(i == 93 || i == 94 || i == 1 || i == 2)) {
            obj = null;
        }
        if (obj == null) {
            if (i == 96 || i == 95) {
                i2 = 93;
            }
            try {
                WalletTaManager.getInstance(this.mContext).updateCardStatus(str, i2);
            } catch (WalletTaCardNotExistException e) {
                LogX.d("card info has been already deleted! refID = " + str);
            } catch (WalletTaSystemErrorException e2) {
                LogX.w("updateCardStatus err! refID = " + str);
            }
            CardInfoManager.getInstance(this.mContext).refreshCardList();
        }
    }

    private void checkTimeOutAndCleanTempData(TACardInfo tACardInfo) {
        try {
            String string = NFCPreferences.getInstance(this.mContext).getString(tACardInfo.dpanDigest, null);
            if (string != null) {
                try {
                    if (System.currentTimeMillis() - JsonUtil.getLongValue(new JSONObject(string), Constant.KEY_DOWNLOAD_INFO_TIME_STAMP, 0) > INSTALL_INTERRUPTED_CARD_VALID_TIME) {
                        LogX.i("card downloaded timeout, refID2 : " + tACardInfo.dpanDigest);
                        updateTaCardStatusToErr(tACardInfo.dpanDigest, tACardInfo.cardStatus);
                        return;
                    }
                    LogicApiFactory.createCardOperateApi(this.mContext).checkCUPInterruptedCard(true, null);
                } catch (JSONException e) {
                    LogX.d("parsPushConsumeMsg, get json exception.");
                }
            } else if (System.currentTimeMillis() - Long.valueOf(tACardInfo.aid).longValue() > INSTALL_INTERRUPTED_CARD_VALID_TIME) {
                LogX.i("card downloaded timeout, refID1 : " + tACardInfo.dpanDigest);
                updateTaCardStatusToErr(tACardInfo.dpanDigest, tACardInfo.cardStatus);
            }
        } catch (NumberFormatException e2) {
            LogX.d("CheckInstallInterruptedCardTask card is already update,no need check.");
        }
    }

    private void doTaUpdate(TACardInfo tACardInfo, String str) {
        int i = tACardInfo.cardStatus;
        if (98 == tACardInfo.cardStatus || 97 == tACardInfo.cardStatus || 94 == tACardInfo.cardStatus) {
            tACardInfo.cardStatus = 1;
        } else {
            tACardInfo.cardStatus = 2;
        }
        tACardInfo.aid = str;
        if (updataTaCardInfo(tACardInfo)) {
            if (i != tACardInfo.cardStatus) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
            if (1 == tACardInfo.cardStatus) {
                CardLostManager.getInstance(this.mContext).reportCardOpenedNotActiveStatus(tACardInfo.aid, null, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour);
            } else if (2 == tACardInfo.cardStatus) {
                CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(tACardInfo.aid, null, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
                reportBiCardStatus(tACardInfo.dpanDigest, tACardInfo.productId, tACardInfo.aid, tACardInfo.issuerId, tACardInfo.cardType);
            }
        }
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    private void reportBiCardStatus(String str, String str2, String str3, String str4, int i) {
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(str2);
        if (cacheCardProductInfoItem == null) {
            NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str3, "", str4, i);
        } else {
            NfcHianalyticsUtil.onReportForCardOpened(this.mContext, str3, cacheCardProductInfoItem.getProductName(), str4, i);
        }
    }

    private void checkTaskFinished() {
        this.resultTask.notifyCheckFinished();
    }

    private QueryAidResponse queryPersonalizedInfo(String str) {
        QueryAidRequest queryAidRequest = new QueryAidRequest();
        queryAidRequest.cplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
        queryAidRequest.setRsaKeyIndex(-1);
        queryAidRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        queryAidRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        queryAidRequest.cardRefId = str;
        return ServerServiceFactory.createCardServerApi(this.mContext).queryAidOnCUP(queryAidRequest);
    }

    private boolean updataTaCardInfo(TACardInfo tACardInfo) {
        return WalletTaManager.getInstance(this.mContext).updateTaCardInfoForCUP(tACardInfo.dpanDigest, tACardInfo.aid, tACardInfo.cardStatus);
    }
}
