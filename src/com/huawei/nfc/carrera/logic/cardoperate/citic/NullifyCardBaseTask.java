package com.huawei.nfc.carrera.logic.cardoperate.citic;

import android.content.Context;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardinfo.impl.CardInfoManager;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteAppletTsmOperator;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.ese.ESEInfoManagerApi;
import com.huawei.nfc.carrera.logic.spi.citic.request.NullifyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaCardNotExistException;
import com.huawei.nfc.carrera.logic.ta.WalletTaException.WalletTaSystemErrorException;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public abstract class NullifyCardBaseTask implements Runnable {
    protected Context mContext;
    private final String refId;
    private final HandleNullifyCardResultTask resultTask;
    private final String verifyCode;

    protected abstract boolean checkInputInfoValid(String str, String str2);

    protected abstract String getBankSignRsaIndex();

    protected abstract String getBankVerifyTokenKey();

    protected abstract boolean isNeedGetVerifySign();

    protected abstract ActivateOrNullifyCardResponse nullifyCard(NullifyCardRequest nullifyCardRequest);

    protected abstract void reportCardDeletedStatus(TACardInfo tACardInfo);

    public NullifyCardBaseTask(Context context, String str, String str2, HandleNullifyCardResultTask handleNullifyCardResultTask) {
        this.mContext = context;
        this.refId = str;
        this.verifyCode = str2;
        this.resultTask = handleNullifyCardResultTask;
    }

    public void run() {
        int i = -4;
        if (checkInputInfoValid(this.refId, this.verifyCode)) {
            NullifyCardRequest nullifyCardRequest = new NullifyCardRequest();
            if (checkIfNeedVerifySign(nullifyCardRequest)) {
                TACardInfo card = WalletTaManager.getInstance(this.mContext).getCard(this.refId);
                if (card == null || card.aid == null) {
                    doResult(-99);
                    return;
                }
                nullifyCardRequest.setVerifyToken(getVerifyToken());
                nullifyCardRequest.setAid(card.aid);
                nullifyCardRequest.setSmsCode(this.verifyCode);
                ESEInfoManagerApi createESEInfoManagerApi = ESEApiFactory.createESEInfoManagerApi(this.mContext);
                nullifyCardRequest.setCplc(createESEInfoManagerApi.queryCplc());
                nullifyCardRequest.setdPan(createESEInfoManagerApi.queryCardNum(card.aid));
                ActivateOrNullifyCardResponse nullifyCard = nullifyCard(nullifyCardRequest);
                if (nullifyCard == null) {
                    doResult(-99);
                    return;
                } else if (nullifyCard.getResultCode() != 0) {
                    if (-5 == nullifyCard.getResultCode()) {
                        i = -3;
                    } else if (-4 != nullifyCard.getResultCode()) {
                        if (-8 == nullifyCard.getResultCode()) {
                            i = -7;
                        } else if (-33 == nullifyCard.getResultCode()) {
                            i = -5;
                        } else if (-32 == nullifyCard.getResultCode()) {
                            i = -6;
                        } else {
                            i = -99;
                        }
                    }
                    doResult(i);
                    return;
                } else {
                    LogX.i("card nullified, but not finish delete.");
                    cleanLocalData(this.refId, card, nullifyCard.getVerifySignature(), nullifyCard.getTimeStamp());
                    return;
                }
            }
            LogX.d("nullify card task, checkIfNeedVerifySign failed.");
            return;
        }
        doResult(-1);
    }

    private boolean checkIfNeedVerifySign(NullifyCardRequest nullifyCardRequest) {
        int i = -3;
        if (!isNeedGetVerifySign()) {
            return true;
        }
        SignDataResponse nullifyCardVerifySign = getNullifyCardVerifySign();
        if (nullifyCardVerifySign == null) {
            doResult(-99);
            return false;
        } else if (nullifyCardVerifySign.returnCode != 0) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get nullify sign failed");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "" + nullifyCardVerifySign.returnCode);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_NULLIFY_SIGN_ERR, hashMap, null, false, false);
            if (!(-1 == nullifyCardVerifySign.returnCode || -2 == nullifyCardVerifySign.returnCode)) {
                i = -99;
            }
            doResult(i);
            return false;
        } else if (StringUtil.isEmpty(nullifyCardVerifySign.sign, true) || StringUtil.isEmpty(nullifyCardVerifySign.time, true)) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get nullify sign success, but params is null");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_NULLIFY_SIGN_ERR, hashMap2, null, false, false);
            doResult(-99);
            return false;
        } else {
            nullifyCardRequest.setWalletSignature(nullifyCardVerifySign.sign);
            nullifyCardRequest.setTimeStamp(nullifyCardVerifySign.time);
            return true;
        }
    }

    private void cleanLocalData(String str, TACardInfo tACardInfo, String str2, String str3) {
        boolean updateTACardNullified = updateTACardNullified(str);
        int excute = new DeleteAppletTsmOperator(this.mContext, tACardInfo.aid, str2, str3, getBankSignRsaIndex()).excute();
        LogX.d("excute tsm delete applet, result: " + excute);
        if (excute == 0) {
            LogX.d("card nullified and deleted, clean local data now.");
            try {
                WalletTaManager.getInstance(this.mContext).removeCard(str);
            } catch (WalletTaException e) {
                LogX.e("deleteCard failed. getCode==" + e.getCode());
            }
        } else if (-1 == excute || -2 == excute) {
            doResult(-3);
        } else {
            doResult(-99);
        }
        if (updateTACardNullified) {
            if (3 != tACardInfo.cardStatus) {
                CardInfoManager.getInstance(this.mContext).refreshCardList();
            }
            reportCardDeletedStatus(tACardInfo);
            LogX.d("nullify card on bank server and update ta status to nullified success.");
            doResult(0);
            return;
        }
        LogX.d("nullify card on bank server success, but update ta status failed.");
        doResult(-99);
    }

    private SignDataResponse getNullifyCardVerifySign() {
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        return ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForNullify(cardServerBaseRequest);
    }

    private boolean updateTACardNullified(String str) {
        try {
            WalletTaManager.getInstance(this.mContext).updateCardStatus(str, 3);
            return true;
        } catch (WalletTaCardNotExistException e) {
            LogX.e("updateTACardStatus, WalletTaCardNotExistException");
            return false;
        } catch (WalletTaSystemErrorException e2) {
            LogX.e("updateTACardStatus, WalletTaSystemErrorException");
            return false;
        }
    }

    private void doResult(int i) {
        if (this.resultTask != null) {
            this.resultTask.notifyNullifyResult(i);
        }
    }

    protected String getVerifyToken() {
        return VerifyTokenUtil.getVerifyTokenString(this.mContext, getBankVerifyTokenKey());
    }
}
