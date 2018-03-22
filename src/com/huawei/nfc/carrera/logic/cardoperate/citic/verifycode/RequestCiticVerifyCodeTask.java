package com.huawei.nfc.carrera.logic.cardoperate.citic.verifycode;

import android.content.Context;
import com.huawei.nfc.carrera.logic.dbmanager.CardInfoDBManager;
import com.huawei.nfc.carrera.logic.lostmanager.CardLostManager;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.request.SmsCodeRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.SmsCodeResponse;
import com.huawei.nfc.carrera.logic.ta.TACardInfo;
import com.huawei.nfc.carrera.logic.util.VerifyTokenUtil;

public class RequestCiticVerifyCodeTask extends RequestVerifyCodeBaseTask {
    private static String CITIC_BANK_SIGN_RSA_INDEX = "CITIC";
    private CITICService citicServiceApi;

    public RequestCiticVerifyCodeTask(Context context, String str, HandleVerifyCodeResultTask handleVerifyCodeResultTask, int i, CITICService cITICService) {
        super(context, str, handleVerifyCodeResultTask, i);
        this.citicServiceApi = cITICService;
    }

    protected String getVerifyToken() {
        return VerifyTokenUtil.getVerifyTokenString(this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN);
    }

    protected void setVerifyToken(String str) {
        VerifyTokenUtil.putVerifyTokenString(str, this.mContext, VerifyTokenUtil.SHAREPREFERENCE_KEY_TAG_CITIC_VERIFY_TOKEN);
    }

    protected SmsCodeResponse requestBankGetActiveSmsCode(SmsCodeRequest smsCodeRequest) {
        return this.citicServiceApi.requestSmsForActivation(smsCodeRequest);
    }

    protected SmsCodeResponse requestBankGetNullifySmsCode(SmsCodeRequest smsCodeRequest) {
        return this.citicServiceApi.requestSmsForNullify(smsCodeRequest);
    }

    protected String getBankSignRsaIndex() {
        return CITIC_BANK_SIGN_RSA_INDEX;
    }

    protected void reportCardOpenedAvailableStatus(TACardInfo tACardInfo) {
        CardLostManager.getInstance(this.mContext).reportCardOpenedAvailableStatus(tACardInfo.aid, null, getCurCardName(tACardInfo.issuerId), tACardInfo.fpanFour, tACardInfo.issuerId, tACardInfo.cardGroupType);
    }

    private String getCurCardName(String str) {
        return new CardInfoDBManager(this.mContext).queryIssuerInfoById(str).getName();
    }
}
