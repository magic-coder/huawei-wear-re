package com.huawei.nfc.carrera.logic.cardoperate.bus.task.snb.opencard;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardAndIssuerInfoCache;
import com.huawei.nfc.carrera.logic.cardinfo.impl.pic.CardPicPathConfig;
import com.huawei.nfc.carrera.logic.cardoperate.bus.SpiResultCodeTranslator;
import com.huawei.nfc.carrera.logic.cardoperate.bus.callback.IssueTrafficCardCallback;
import com.huawei.nfc.carrera.logic.cardoperate.bus.model.TrafficOrder;
import com.huawei.nfc.carrera.logic.cardoperate.bus.resulthandler.IssueTrafficCardResultHandler;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.CreateSSDTsmOperator;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.dbmanager.CardProductInfoItem;
import com.huawei.nfc.carrera.logic.dbmanager.IssuerInfoItem;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.logic.ese.response.QueryCardInfoResponse;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.NfcHianalyticsUtil;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.huawei.p190v.C2538c;

import java.util.HashMap;
import java.util.Map;

public class IssueTrafficCardSNBOperator {
    private static final String DEFAULT_PHONE_NUM = "18888888888";
    private static final String TAG = "IssueTrafficCardSNBOperator";
    private final Context mContext;
    private final IssuerInfoItem mInfo;
    private final TrafficOrder mOrder;
    private final IssueTrafficCardResultHandler mResultHandler;

    public IssueTrafficCardSNBOperator(Context context, IssuerInfoItem issuerInfoItem, TrafficOrder trafficOrder, IssueTrafficCardResultHandler issueTrafficCardResultHandler) {
        this.mContext = context;
        this.mInfo = issuerInfoItem;
        this.mOrder = trafficOrder;
        this.mResultHandler = issueTrafficCardResultHandler;
    }

    public int issueTrafficCard() {
        if (this.mInfo == null || this.mOrder == null) {
            handleResult(10);
            return 10;
        }
        LogX.i("issueTrafficCard task begin");
        String aid = this.mInfo.getAid();
        String issuerId = this.mInfo.getIssuerId();
        String productId = this.mInfo.getProductId();
        if (StringUtil.isEmpty(aid, true) || StringUtil.isEmpty(issuerId, true) || StringUtil.isEmpty(productId, true)) {
            handleResult(10);
            return 10;
        }
        CardProductInfoItem cacheCardProductInfoItem = CardAndIssuerInfoCache.getInstance(this.mContext).cacheCardProductInfoItem(productId);
        if (cacheCardProductInfoItem == null) {
            handleResult(99);
            return 99;
        }
        int createDMSD = createDMSD(aid);
        if (createDMSD != 0) {
            handleResult(createDMSD);
            return createDMSD;
        } else if (this.mOrder.getPayInfo() == null) {
            handleResult(10);
            return 10;
        } else {
            String str;
            String requestId = this.mOrder.getPayInfo().getRequestId();
            Map hashMap = new HashMap();
            String str2 = null;
            if (Constant.LNT_CARD_ISSERID.equals(cacheCardProductInfoItem.getIssuerId())) {
                str2 = new QueryCityAndCardListSNBOperator(this.mContext).queryCityAndCardList(aid);
                if (StringUtil.isEmpty(str2, true)) {
                    handleResult(10);
                    return 10;
                }
                hashMap.put("city_code", str2);
            } else if (!StringUtil.isEmpty(cacheCardProductInfoItem.getSnbCityBusCode(), true)) {
                hashMap = new HashMap();
                hashMap.put("city_code", cacheCardProductInfoItem.getSnbCityBusCode());
            }
            hashMap.put("mobnum", getPhoneNum(this.mOrder.getPhoneNum(), aid));
            LogX.i("IssueTrafficCardSNBOperator SNB issuerId LNT , issuerId" + cacheCardProductInfoItem.getIssuerId());
            if (Constant.LNT_CARD_ISSERID.equals(cacheCardProductInfoItem.getIssuerId())) {
                LogX.i("IssueTrafficCardSNBOperator SNB issuerId is LNT begin.");
                int loadAndInstallApplet = SPIServiceFactory.createSNBService(this.mContext).loadAndInstallApplet(aid, hashMap);
                LogX.i("IssueTrafficCardSNBOperator SNB issuerId LNT , response" + loadAndInstallApplet);
                if (loadAndInstallApplet != 0) {
                    String queryCplc = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc();
                    str = "IssueTrafficCardSNBOperator SNBService loadAndInstallApplet failed. response = " + loadAndInstallApplet;
                    Map hashMap2 = new HashMap();
                    hashMap2.put("aid", aid);
                    hashMap2.put("cplc", queryCplc);
                    hashMap2.put(CloudEyeLogger.FAIL_CODE, String.valueOf(loadAndInstallApplet));
                    LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_LOAD_AND_INSTALL_APPLET_FAIL, hashMap2, str, false, false);
                }
                LogX.i("IssueTrafficCardSNBOperator SNB loadAndInstallApplet success.response" + loadAndInstallApplet);
                LogX.i("IssueTrafficCardSNBOperator successfully end");
            }
            C2538c.b(TAG, new Object[]{" CardEvent PERSONALIZED bus cardEvent START_LOCK"});
            WalletTaManager.getInstance(this.mContext).cardEvent(aid, 2);
            createDMSD = SPIServiceFactory.createSNBService(this.mContext).issueCard(aid, requestId, hashMap);
            if (createDMSD != 0) {
                LogX.e("IssueTrafficCardSNBTask SNBService issueCard failed. resultCode = " + createDMSD);
                createDMSD = SpiResultCodeTranslator.getSnbResultCode(createDMSD);
                handleResult(createDMSD);
                return createDMSD;
            }
            LogX.i("IssueTrafficCardSNBTask SNB issuerCard success.");
            C2538c.b(TAG, new Object[]{" CardEvent PERSONALIZED bus cardEvent END_LOCK"});
            WalletTaManager.getInstance(this.mContext).cardEvent(aid, 3);
            if (createDMSD == 0) {
                QueryCardInfoResponse queryTrafficCardInfo = ESEInfoManager.getInstance(this.mContext).queryTrafficCardInfo(aid, 1);
                createDMSD = queryTrafficCardInfo.resultCode;
                LogX.i("queryTrafficCardInfo ,resultCode=" + createDMSD);
                if (queryTrafficCardInfo.cardInfo != null) {
                    TACardInfo generateTaCardInfo;
                    String cardNo = queryTrafficCardInfo.cardInfo.getCardNo();
                    LogX.i("IssueTrafficCardSNBTask queryTrafficCardNum cardNum = " + cardNo);
                    if (Constant.LNT_CARD_ISSERID.equals(cacheCardProductInfoItem.getIssuerId())) {
                        generateTaCardInfo = generateTaCardInfo(aid, 2, issuerId, productId, cardNo, str2);
                    } else {
                        generateTaCardInfo = generateTaCardInfo(aid, 2, issuerId, productId, cardNo, null);
                    }
                    generateTaCardInfo.name = cacheCardProductInfoItem.getProductName();
                    LogX.i("IssueTrafficCardSNBTask generateTaCardInfo info = " + generateTaCardInfo.toString());
                    int addCardToTa = addCardToTa(generateTaCardInfo);
                    str = getCurCardName(issuerId);
                    CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(aid, null, str, cardNo, issuerId, 2);
                    NfcHianalyticsUtil.onReportForCardOpened(this.mContext, aid, str, issuerId, generateTaCardInfo.cardType);
                    createDMSD = addCardToTa;
                }
            }
            handleResult(createDMSD);
            return createDMSD;
        }
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }

    private TACardInfo generateTaCardInfo(String str, int i, String str2, String str3, String str4, String str5) {
        TACardInfo tACardInfo = new TACardInfo();
        tACardInfo.aid = str;
        tACardInfo.cardGroupType = 2;
        tACardInfo.cardStatus = i;
        tACardInfo.cardType = 11;
        tACardInfo.dpanDigest = str;
        tACardInfo.dpanFour = str5;
        tACardInfo.fpanDigest = null;
        tACardInfo.fpanFour = str4;
        tACardInfo.isDefaultCard = false;
        tACardInfo.issuerId = str2;
        tACardInfo.productId = str3;
        tACardInfo.Rf_file_name = str3 + CardPicPathConfig.WALLET_CARD_STORAGE_NAME;
        tACardInfo.background_file_name = str3 + CardPicPathConfig.WALLET_CARD_ICON_STORAGE_NAME;
        tACardInfo.statusUpdateTime = System.currentTimeMillis();
        tACardInfo.name = this.mInfo.getName();
        return tACardInfo;
    }

    private int addCardToTa(TACardInfo tACardInfo) {
        if (!WalletTaManager.getInstance(this.mContext).updateCardInfo(tACardInfo)) {
            return 99;
        }
        LogX.i("addCardToTa success.");
        return 0;
    }

    private void handleResult(int i) {
        LogX.i("IssueTrafficCardSNBTask task end result = " + i);
        if (this.mResultHandler != null) {
            this.mResultHandler.handleResult(i);
        }
    }

    private String getPhoneNum(String str, String str2) {
        if (!StringUtil.isEmpty(str, true)) {
            return str;
        }
        TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(str2);
        if (card == null) {
            return DEFAULT_PHONE_NUM;
        }
        str = card.dpanFour;
        if (StringUtil.isEmpty(str, true)) {
            return DEFAULT_PHONE_NUM;
        }
        return str;
    }

    private int createDMSD(String str) {
        LogX.i("IssueTrafficCardSNBOperator createDMSD begin");
        int excute = new CreateSSDTsmOperator(this.mContext, str, this.mInfo.getIssuerId()).excute();
        if (excute == 0) {
            return 0;
        }
        String str2 = "IssueTrafficCardSNBOperator createDMSD, create ssd failed response = " + excute;
        Map hashMap = new HashMap();
        hashMap.put("aid", str);
        hashMap.put(CloudEyeLogger.FAIL_CODE, String.valueOf(excute));
        LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_SNB_DMSD_INSTALL_FAIL, hashMap, str2, false, false);
        return IssueTrafficCardCallback.RETURN_FAILED_SSD_INSTALL_FAILED;
    }
}
