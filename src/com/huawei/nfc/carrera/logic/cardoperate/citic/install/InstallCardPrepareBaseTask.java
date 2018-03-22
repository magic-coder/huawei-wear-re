package com.huawei.nfc.carrera.logic.cardoperate.citic.install;

import android.content.Context;
import android.os.Handler;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteAppletTsmOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.DeleteSSDTsmOperator;
import com.huawei.nfc.carrera.logic.cardoperate.tsm.InstallAppletTsmOperator;
import com.huawei.nfc.carrera.logic.ese.ESEApiFactory;
import com.huawei.nfc.carrera.logic.spi.SPIServiceFactory;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyAidRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.NullifyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyAidResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.ta.WalletTaManager;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;
import com.huawei.nfc.carrera.server.ServerServiceFactory;
import com.huawei.nfc.carrera.server.card.CardServerApi;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public abstract class InstallCardPrepareBaseTask implements Runnable {
    private final String mCardNum;
    private final Context mContext;
    private InstallPrepareTaskListener mListener;
    private final CardServerApi mServerApi;

    protected abstract ApplyAidResponse applyCardAid(ApplyAidRequest applyAidRequest);

    protected abstract String getBankRsaIndex();

    protected abstract String getBankVerifyTokenKey();

    protected InstallCardPrepareBaseTask(Context context, CardServerApi cardServerApi, String str) {
        this.mServerApi = cardServerApi;
        this.mCardNum = str;
        this.mContext = context;
    }

    void doPrepareTask(Handler handler, InstallPrepareTaskListener installPrepareTaskListener) {
        this.mListener = installPrepareTaskListener;
        LogX.d("install card prepare status: queing.");
        if (this.mListener != null) {
            this.mListener.prepareTaskQueqing();
        }
        handler.post(this);
    }

    public void run() {
        LogX.d("install card prepare status: executing.");
        if (this.mListener != null) {
            this.mListener.prepareTaskStart();
        }
        ApplyAidRequest applyAidRequest = new ApplyAidRequest();
        if (getVerifySign(applyAidRequest)) {
            ApplyAidResponse handleApplyAid = handleApplyAid(applyAidRequest);
            if (handleApplyAid == null) {
                LogX.d("install card prepare task, applyAid failed");
                return;
            } else {
                installApplet(handleApplyAid.aid, handleApplyAid.getVerifySignature(), handleApplyAid.getTimeStamp());
                return;
            }
        }
        LogX.d("install card prepare task, get apply aid verify sign failed");
    }

    private ApplyAidResponse handleApplyAid(ApplyAidRequest applyAidRequest) {
        int i = -99;
        applyAidRequest.fpan = this.mCardNum;
        applyAidRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        ApplyAidResponse applyCardAid = applyCardAid(applyAidRequest);
        if (applyCardAid == null) {
            LogX.d("install card prepare status: finished, after apply aid, code: " + -99);
            doResult(-99);
            return null;
        }
        switch (applyCardAid.getResultCode()) {
            case ApplyAidResponse.RESULT_CODE_APPLYAID_DPAN_INF /*-44*/:
                TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(applyCardAid.aid);
                String str = applyCardAid.aid;
                String str2 = applyCardAid.dPan;
                if (cardInfoByAid != null) {
                    i = checkDpan(str, str2);
                    break;
                }
                ActivateOrNullifyCardResponse nullityCard = nullityCard(str, str2);
                if (nullityCard != null) {
                    deleteAppelt(str, nullityCard.getVerifySignature(), nullityCard.getTimeStamp());
                    applyCardAid = applyCardAid(applyAidRequest);
                    i = checkApplyAidResponse(0, applyCardAid);
                    break;
                }
                break;
            case ApplyAidResponse.RESULT_CODE_APPLYAID_DEL_SSD /*-43*/:
                i = deleteSSD(applyCardAid.aid, applyCardAid.getVerifySignature(), applyCardAid.getTimeStamp());
                break;
            case ApplyAidResponse.RESULT_CODE_APPLYAID_DEL_APPLET /*-42*/:
                i = deleteAppelt(applyCardAid.aid, null, null);
                break;
            case ApplyAidResponse.RESULT_CODE_APPLYAID_EXCEED_LIMIT /*-41*/:
                i = -7;
                break;
            case -8:
                i = -14;
                break;
            case -5:
                i = -3;
                break;
            case -4:
                i = -4;
                break;
            case 0:
                LogX.d("checkApplyAidResponse, success.");
                i = checkApplyAidResult(applyCardAid);
                break;
        }
        if (i != 0) {
            LogX.d("install card prepare status: finished, after apply aid, code: " + i);
            doResult(i);
            return null;
        }
        LogX.d("install card prepare task, aid applied: " + applyCardAid.aid);
        callbackPrepareAidApplied(applyCardAid);
        VerifyTokenUtil.putVerifyTokenString(applyCardAid.getToken(), this.mContext, getBankVerifyTokenKey());
        return applyCardAid;
    }

    private int checkApplyAidResponse(int i, ApplyAidResponse applyAidResponse) {
        if (applyAidResponse == null || applyAidResponse.getResultCode() != 0) {
            return -99;
        }
        return i;
    }

    private int checkApplyAidResult(ApplyAidResponse applyAidResponse) {
        int i = 0;
        if (StringUtil.isEmpty(applyAidResponse.aid, true) || StringUtil.isEmpty(applyAidResponse.getVerifySignature(), true) || StringUtil.isEmpty(applyAidResponse.getTimeStamp(), true)) {
            i = -99;
        }
        TACardInfo cardInfoByAid = WalletTaManager.getInstance(this.mContext).getCardInfoByAid(applyAidResponse.aid);
        if (cardInfoByAid == null) {
            return i;
        }
        if ((1 == cardInfoByAid.cardStatus || 2 == cardInfoByAid.cardStatus) && ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCardNum(applyAidResponse.aid) != null) {
            return -15;
        }
        return i;
    }

    private void callbackPrepareAidApplied(ApplyAidResponse applyAidResponse) {
        if (this.mListener != null) {
            this.mListener.prepareAidApplied(applyAidResponse.aid);
        }
    }

    private int checkDpan(String str, String str2) {
        String queryCardNum = ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCardNum(str);
        if (queryCardNum == null || !queryCardNum.equals(str2)) {
            return -99;
        }
        return -15;
    }

    private ActivateOrNullifyCardResponse nullityCard(String str, String str2) {
        NullifyCardRequest nullifyCardRequest = new NullifyCardRequest();
        getNullifyCardVerifySign(nullifyCardRequest);
        nullifyCardRequest.setAid(str);
        nullifyCardRequest.setCplc(ESEApiFactory.createESEInfoManagerApi(this.mContext).queryCplc());
        nullifyCardRequest.setdPan(str2);
        return SPIServiceFactory.createCMBService(this.mContext).nullifyCard(nullifyCardRequest);
    }

    private boolean getVerifySign(ApplyAidRequest applyAidRequest) {
        int i = -99;
        SignDataResponse applyAidSign = getApplyAidSign();
        if (applyAidSign == null) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "getVerifySign response is null");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_QUERY_SIGN_ERR, hashMap, null, false, false);
            doResult(-99);
            return false;
        }
        Map hashMap2;
        switch (applyAidSign.returnCode) {
            case -2:
                i = -4;
                break;
            case -1:
                i = -3;
                break;
            case 0:
                if (!StringUtil.isEmpty(applyAidSign.sign, true) && !StringUtil.isEmpty(applyAidSign.time, true)) {
                    i = 0;
                    break;
                }
                hashMap2 = new HashMap();
                hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "getVerifySign code right, but params invalid");
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_QUERY_SIGN_ERR, hashMap2, null, false, false);
                break;
            default:
                hashMap2 = new HashMap();
                hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "getVerifySign response error : " + applyAidSign.returnCode);
                LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_QUERY_SIGN_ERR, hashMap2, null, false, false);
                break;
        }
        if (i != 0) {
            LogX.d("install card prepare status: finished, after get sign, code: " + i);
            doResult(i);
            return false;
        }
        applyAidRequest.setWalletSignature(applyAidSign.sign);
        applyAidRequest.setTimeStamp(applyAidSign.time);
        return true;
    }

    private void installApplet(String str, String str2, String str3) {
        int excute = new InstallAppletTsmOperator(this.mContext, str, str2, str3, getBankRsaIndex()).excute();
        LogX.d("excute tsm install, result: " + excute);
        if (excute == 0) {
            excute = 0;
        } else if (-1 == excute) {
            excute = -3;
        } else if (-2 == excute) {
            excute = -4;
        } else {
            excute = -99;
        }
        LogX.d("install card prepare, install applet end, code: " + excute);
        doResult(excute);
    }

    private SignDataResponse getApplyAidSign() {
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        return this.mServerApi.querySignDataForApplyAid(cardServerBaseRequest);
    }

    private void doResult(int i) {
        if (this.mListener != null) {
            this.mListener.prepareFaskFinished(i);
        }
    }

    private int deleteAppelt(String str, String str2, String str3) {
        int excute = new DeleteAppletTsmOperator(this.mContext, str, str2, str3, getBankRsaIndex()).excute();
        LogX.d("excute tsm delete applet, result: " + excute);
        if (excute == 0) {
            excute = 0;
        } else if (-1 == excute) {
            excute = -3;
        } else if (-2 == excute) {
            excute = -4;
        } else {
            excute = -99;
        }
        LogX.d("install card prepare, delete applet end, code: " + excute);
        return excute;
    }

    private int deleteSSD(String str, String str2, String str3) {
        int deleteAppelt = deleteAppelt(str, null, null);
        if (deleteAppelt != 0) {
            return deleteAppelt;
        }
        deleteAppelt = new DeleteSSDTsmOperator(this.mContext, str).excute();
        LogX.d("install card prepare, delete ssd response=" + deleteAppelt);
        if (deleteAppelt == 0) {
            return 0;
        }
        if (-1 == deleteAppelt) {
            return -3;
        }
        if (-2 == deleteAppelt) {
            return -4;
        }
        return -99;
    }

    private void getNullifyCardVerifySign(NullifyCardRequest nullifyCardRequest) {
        int i = -3;
        SignDataResponse verifySignFromServer = getVerifySignFromServer();
        if (verifySignFromServer == null) {
            doResult(-99);
        } else if (verifySignFromServer.returnCode != 0) {
            Map hashMap = new HashMap();
            hashMap.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get nullify sign fail");
            hashMap.put(CloudEyeLogger.FAIL_CODE, "" + verifySignFromServer.returnCode);
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_NULLIFY_SIGN_ERR, hashMap, null, false, false);
            if (!(-1 == verifySignFromServer.returnCode || -2 == verifySignFromServer.returnCode)) {
                i = -99;
            }
            doResult(i);
        } else if (StringUtil.isEmpty(verifySignFromServer.sign, true) || StringUtil.isEmpty(verifySignFromServer.time, true)) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get nullify sign success, but params is null");
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_TSM_GET_NULLIFY_SIGN_ERR, hashMap2, null, false, false);
            doResult(-99);
        } else {
            nullifyCardRequest.setWalletSignature(verifySignFromServer.sign);
            nullifyCardRequest.setTimeStamp(verifySignFromServer.time);
        }
    }

    private SignDataResponse getVerifySignFromServer() {
        CardServerBaseRequest cardServerBaseRequest = new CardServerBaseRequest();
        cardServerBaseRequest.setMerchantID(ServiceConfig.WALLET_MERCHANT_ID);
        cardServerBaseRequest.setRsaKeyIndex(-1);
        cardServerBaseRequest.setSrcTransactionID(ServiceConfig.WALLET_MERCHANT_ID);
        return ServerServiceFactory.createCardServerApi(this.mContext).querySignDataForNullify(cardServerBaseRequest);
    }
}
