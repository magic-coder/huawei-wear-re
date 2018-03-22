package com.huawei.nfc.carrera.logic.cardoperate.cmb.verifycode;

import android.content.Context;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.HandleVerifyCodeResultTask;
import com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode.RequestVerifyCodeBaseTask;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.request.SmsCodeRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.SmsCodeResponse;
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;

public class RequestCmbVerifyCodeTask extends RequestVerifyCodeBaseTask {
    private static String CMB_BANK_SIGN_RSA_INDEX = "CMB";
    private CMBService cmbServiceApi;

    public RequestCmbVerifyCodeTask(Context context, String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask, int i, CMBService cMBService) {
        super(context, str, handleVerifyCodeResultTask, i);
        this.cmbServiceApi = cMBService;
    }

    protected String getVerifyToken() {
        return VerifyTokenUtil.getVerifyTokenString(this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN);
    }

    protected void setVerifyToken(String str) {
        VerifyTokenUtil.putVerifyTokenString(str, this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CMB_VERIFY_TOKEN);
    }

    protected SmsCodeResponse requestBankGetActiveSmsCode(SmsCodeRequest smsCodeRequest) {
        return this.cmbServiceApi.requestSmsForActivation(smsCodeRequest);
    }

    protected SmsCodeResponse requestBankGetNullifySmsCode(SmsCodeRequest smsCodeRequest) {
        return null;
    }

    protected String getBankSignRsaIndex() {
        return CMB_BANK_SIGN_RSA_INDEX;
    }

    protected void reportCardOpenedAvailableStatus(TACardInfo tACardInfo) {
        CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(tACardInfo.aid, tACardInfo.dpanDigest, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }
}
