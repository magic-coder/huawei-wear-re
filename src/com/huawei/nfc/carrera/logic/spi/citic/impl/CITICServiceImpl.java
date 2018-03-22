package com.huawei.nfc.carrera.logic.spi.citic.impl;

import android.content.Context;
import cn.com.fmsh.tsm.business.constants.Constants.XMLNode;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.logic.spi.citic.CITICService;
import com.huawei.nfc.carrera.logic.spi.citic.request.ActivateCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyAidRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.ApplyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.NullifyCardRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.PersonalizedRequest;
import com.huawei.nfc.carrera.logic.spi.citic.request.SmsCodeRequest;
import com.huawei.nfc.carrera.logic.spi.citic.response.ActivateOrNullifyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyAidResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.ApplyCardResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.PersonalizedResponse;
import com.huawei.nfc.carrera.logic.spi.citic.response.SmsCodeResponse;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import com.p230a.C3079b;
import com.p230a.C3080a;
import java.util.HashMap;
import java.util.Map;

public class CITICServiceImpl implements CITICService {
    private static final String GET_SMS_FUNCTION_ACTIVATE_CARD = "activateCard";
    private static final String GET_SMS_FUNCTION_NULLIFY_ACTION = "nullifyAction";
    private static final String HUAWEI_VENDER_CODE = "A";
    private C3079b citicAction = new C3080a();
    private Context mContext;
    private ResultCodeInterpreter resultInterpreter = new ResultCodeInterpreter();

    public CITICServiceImpl(Context context) {
        this.mContext = context;
    }

    public ApplyAidResponse applyAid(ApplyAidRequest applyAidRequest) {
        LogX.i("applyAid");
        ApplyAidResponse applyAidResponse = new ApplyAidResponse();
        if (applyAidRequest == null || StringUtil.isEmpty(applyAidRequest.getWalletSignature(), true) || StringUtil.isEmpty(applyAidRequest.getTimeStamp(), true) || StringUtil.isEmpty(applyAidRequest.getCplc(), true) || StringUtil.isEmpty(applyAidRequest.fpan, true)) {
            LogX.d("applyAid, but request is illegal.");
            applyAidResponse.setResultCode(-6);
            return applyAidResponse;
        }
        LogX.d("applyAid, " + applyAidRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("Signature", applyAidRequest.getWalletSignature());
        hashMap.put("Timespan", applyAidRequest.getTimeStamp());
        hashMap.put("CPLC", applyAidRequest.getCplc());
        hashMap.put("FPAN", applyAidRequest.fpan);
        Map a = this.citicAction.mo3645a(this.mContext, hashMap);
        if (a == null) {
            LogX.e("applyAid, response is illegal.");
            applyAidResponse.setResultCode(-7);
            return applyAidResponse;
        }
        String str = (String) a.get("Result");
        applyAidResponse.setResultCode(this.resultInterpreter.handleBaseResultCode(str));
        applyAidResponse.aid = (String) a.get(XMLNode.AID);
        applyAidResponse.setToken((String) a.get("Token"));
        applyAidResponse.setVerifySignature((String) a.get("Signature"));
        applyAidResponse.setTimeStamp((String) a.get("Timespan"));
        if (applyAidResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get aid failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + applyAidRequest.getCplc());
            LogX.e(907125700, hashMap2, null, false, false);
        }
        LogX.d("applyAid, " + applyAidResponse.toString(), true);
        return applyAidResponse;
    }

    public ApplyCardResponse applyCard(ApplyCardRequest applyCardRequest) {
        LogX.i("applyCard");
        ApplyCardResponse applyCardResponse = new ApplyCardResponse();
        if (applyCardRequest == null || StringUtil.isEmpty(applyCardRequest.getCplc(), true) || StringUtil.isEmpty(applyCardRequest.getCardNum(), true) || StringUtil.isEmpty(applyCardRequest.getAid(), true) || StringUtil.isEmpty(applyCardRequest.getCvv2Code(), true)) {
            LogX.d("applyCard, but request is illegal.");
            applyCardResponse.setResultCode(-6);
            return applyCardResponse;
        }
        LogX.d("applyCard, " + applyCardRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("Signature", applyCardRequest.getWalletSignature());
        hashMap.put("Timespan", applyCardRequest.getTimeStamp());
        hashMap.put("CPLC", applyCardRequest.getCplc());
        hashMap.put("Token", applyCardRequest.getVerifyToken());
        hashMap.put("FPAN", applyCardRequest.getCardNum());
        hashMap.put("Cvv2", applyCardRequest.getCvv2Code());
        hashMap.put(XMLNode.AID, applyCardRequest.getAid());
        hashMap.put("VendorCode", HUAWEI_VENDER_CODE);
        Map b = this.citicAction.mo3646b(this.mContext, hashMap);
        if (b == null) {
            LogX.e("applyCard, response is illegal.");
            applyCardResponse.setResultCode(-7);
            return applyCardResponse;
        }
        String str = (String) b.get("Result");
        applyCardResponse.setResultCode(this.resultInterpreter.handleApplyCardResultCode(str));
        applyCardResponse.setVerifySignature((String) b.get("Signature"));
        applyCardResponse.setTimeStamp((String) b.get("Timespan"));
        applyCardResponse.setToken((String) b.get("Token"));
        applyCardResponse.dPan = (String) b.get("DPAN");
        if (applyCardResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "apply card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + applyCardRequest.getCplc());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CITIC_BIND_CARD_FAIL_APPLY_CARD, hashMap2, null, false, false);
        }
        LogX.d("applyCard, " + applyCardResponse.toString(), true);
        return applyCardResponse;
    }

    public SmsCodeResponse requestSmsForActivation(SmsCodeRequest smsCodeRequest) {
        LogX.i("requestSmsForActivation");
        return requestSmsCode(smsCodeRequest, GET_SMS_FUNCTION_ACTIVATE_CARD);
    }

    public ActivateOrNullifyCardResponse activateCard(ActivateCardRequest activateCardRequest) {
        LogX.i(GET_SMS_FUNCTION_ACTIVATE_CARD);
        ActivateOrNullifyCardResponse activateOrNullifyCardResponse = new ActivateOrNullifyCardResponse();
        if (activateCardRequest == null || StringUtil.isEmpty(activateCardRequest.getCplc(), true) || StringUtil.isEmpty(activateCardRequest.getdPan(), true) || StringUtil.isEmpty(activateCardRequest.getAid(), true) || StringUtil.isEmpty(activateCardRequest.getSmsCode(), true)) {
            LogX.d("activateCard, but request is illegal.");
            activateOrNullifyCardResponse.setResultCode(-6);
            return activateOrNullifyCardResponse;
        }
        LogX.d("activateCard, " + activateCardRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("Signature", activateCardRequest.getWalletSignature());
        hashMap.put("Timespan", activateCardRequest.getTimeStamp());
        hashMap.put("CPLC", activateCardRequest.getCplc());
        hashMap.put("Token", activateCardRequest.getVerifyToken());
        hashMap.put("DPAN", activateCardRequest.getdPan());
        hashMap.put(XMLNode.AID, activateCardRequest.getAid());
        hashMap.put("SmsCode", activateCardRequest.getSmsCode());
        Map d = this.citicAction.mo3648d(this.mContext, hashMap);
        if (d == null) {
            LogX.e("activateCard, response is illegal.");
            activateOrNullifyCardResponse.setResultCode(-7);
            return activateOrNullifyCardResponse;
        }
        String str = (String) d.get("Result");
        activateOrNullifyCardResponse.setResultCode(this.resultInterpreter.handleVerifySMSCodeResultCode(str));
        activateOrNullifyCardResponse.setVerifySignature((String) d.get("Signature"));
        activateOrNullifyCardResponse.setTimeStamp((String) d.get("Timespan"));
        activateOrNullifyCardResponse.setToken((String) d.get("Token"));
        if (activateOrNullifyCardResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "activate card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + activateCardRequest.getCplc());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CITIC_BIND_CARD_FAIL_ACTIVATE_CARD, hashMap2, null, false, false);
        }
        LogX.d("activateCard, " + activateOrNullifyCardResponse.toString(), true);
        return activateOrNullifyCardResponse;
    }

    public PersonalizedResponse personalizeCard(PersonalizedRequest personalizedRequest) {
        LogX.i("personalizeCard");
        PersonalizedResponse personalizedResponse = new PersonalizedResponse();
        if (personalizedRequest == null) {
            LogX.d("personalizeCard, but request is illegal.");
            personalizedResponse.setResultCode(-6);
            return personalizedResponse;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Signature", personalizedRequest.getWalletSignature());
        hashMap.put("Timespan", personalizedRequest.getTimeStamp());
        hashMap.put("CPLC", personalizedRequest.getCplc());
        hashMap.put("Token", personalizedRequest.getVerifyToken());
        hashMap.put("DPAN", personalizedRequest.getdPan());
        hashMap.put(XMLNode.AID, personalizedRequest.getAid());
        Map f = this.citicAction.mo3650f(this.mContext, hashMap);
        if (f == null) {
            LogX.e("personalizeCard, response is illegal.");
            personalizedResponse.setResultCode(-7);
            return personalizedResponse;
        }
        String str = (String) f.get("Result");
        personalizedResponse.setResultCode(this.resultInterpreter.handleBaseResultCode(str));
        personalizedResponse.setVerifySignature((String) f.get("Signature"));
        personalizedResponse.setTimeStamp((String) f.get("Timespan"));
        personalizedResponse.setToken((String) f.get("Token"));
        if (personalizedResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "personalize card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + personalizedRequest.getCplc());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CITIC_BIND_CARD_FAIL_PERSONALIZE_CARD, hashMap2, null, false, false);
        }
        LogX.d("personalizeCard, " + personalizedResponse.toString(), true);
        return personalizedResponse;
    }

    public SmsCodeResponse requestSmsForNullify(SmsCodeRequest smsCodeRequest) {
        LogX.i("requestSmsForNullify");
        return requestSmsCode(smsCodeRequest, GET_SMS_FUNCTION_NULLIFY_ACTION);
    }

    private SmsCodeResponse requestSmsCode(SmsCodeRequest smsCodeRequest, String str) {
        SmsCodeResponse smsCodeResponse = new SmsCodeResponse();
        if (smsCodeRequest == null || StringUtil.isEmpty(smsCodeRequest.getCplc(), true) || StringUtil.isEmpty(smsCodeRequest.getdPan(), true) || StringUtil.isEmpty(smsCodeRequest.getAid(), true)) {
            LogX.d("requestSmsCode, but request is illegal.");
            smsCodeResponse.setResultCode(-6);
            return smsCodeResponse;
        }
        LogX.d("requestSmsCode, " + smsCodeRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("Signature", smsCodeRequest.getWalletSignature());
        hashMap.put("Timespan", smsCodeRequest.getTimeStamp());
        hashMap.put("CPLC", smsCodeRequest.getCplc());
        hashMap.put("Token", smsCodeRequest.getVerifyToken());
        hashMap.put("DPAN", smsCodeRequest.getdPan());
        hashMap.put(XMLNode.AID, smsCodeRequest.getAid());
        hashMap.put("Function", str);
        Map c = this.citicAction.mo3647c(this.mContext, hashMap);
        if (c == null) {
            LogX.e("requestSmsCode, response is illegal.");
            smsCodeResponse.setResultCode(-7);
            return smsCodeResponse;
        }
        String str2 = (String) c.get("Result");
        smsCodeResponse.setResultCode(this.resultInterpreter.handleGetSMSResultCode(str2));
        smsCodeResponse.setVerifySignature((String) c.get("Signature"));
        smsCodeResponse.setTimeStamp((String) c.get("Timespan"));
        smsCodeResponse.setToken((String) c.get("Token"));
        smsCodeResponse.phone = (String) c.get("Phone");
        if (smsCodeResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "request smscode failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str2);
            hashMap2.put("cplc", "" + smsCodeRequest.getCplc());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CITIC_BIND_CARD_FAIL_REQUEST_SMS, hashMap2, null, false, false);
        }
        LogX.d("requestSmsCode, " + smsCodeResponse.toString(), true);
        return smsCodeResponse;
    }

    public ActivateOrNullifyCardResponse nullifyCard(NullifyCardRequest nullifyCardRequest) {
        LogX.i("nullify");
        ActivateOrNullifyCardResponse activateOrNullifyCardResponse = new ActivateOrNullifyCardResponse();
        if (nullifyCardRequest == null) {
            LogX.d("nullify, but request is illegal.");
            activateOrNullifyCardResponse.setResultCode(-6);
            return activateOrNullifyCardResponse;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("Signature", nullifyCardRequest.getWalletSignature());
        hashMap.put("Timespan", nullifyCardRequest.getTimeStamp());
        hashMap.put("CPLC", nullifyCardRequest.getCplc());
        hashMap.put("Token", nullifyCardRequest.getVerifyToken());
        hashMap.put("DPAN", nullifyCardRequest.getdPan());
        hashMap.put(XMLNode.AID, nullifyCardRequest.getAid());
        hashMap.put("SmsCode", nullifyCardRequest.getSmsCode());
        Map e = this.citicAction.mo3649e(this.mContext, hashMap);
        if (e == null) {
            LogX.e("nullify, response is illegal.");
            activateOrNullifyCardResponse.setResultCode(-7);
            return activateOrNullifyCardResponse;
        }
        String str = (String) e.get("Result");
        activateOrNullifyCardResponse.setResultCode(this.resultInterpreter.handleVerifySMSCodeResultCode(str));
        activateOrNullifyCardResponse.setVerifySignature((String) e.get("Signature"));
        activateOrNullifyCardResponse.setTimeStamp((String) e.get("Timespan"));
        activateOrNullifyCardResponse.setToken((String) e.get("Token"));
        if (activateOrNullifyCardResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "nullify card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + nullifyCardRequest.getCplc());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CITIC_NULLIFY_CARD_FAIL, hashMap2, null, false, false);
        }
        LogX.d("nullify, " + activateOrNullifyCardResponse.toString(), true);
        return activateOrNullifyCardResponse;
    }
}
