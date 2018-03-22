package com.huawei.nfc.carrera.logic.spi.cmb.impl;

import android.content.Context;
import com.cmb.pboc.cardop.CMBHWSDK;
import com.huawei.nfc.carrera.constant.AutoReportErrorCode;
import com.huawei.nfc.carrera.constant.ServiceConfig;
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
import com.huawei.nfc.carrera.logic.spi.cmb.CMBService;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.ui.bus.exception.ShowBindBusResultActivity;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.nfc.carrera.util.logger.CloudEyeLogger;
import java.util.HashMap;
import java.util.Map;

public class CMBServiceImpl implements CMBService {
    private static final String COMMOND_ACTIVATE_ACTION = "ACTIVATEACTION";
    private static final String PHONE_NUM_HIDE_CODE = "*******";
    private final CMBHWSDK cmbSdk;
    private final Context mContext;
    private final CMBResultCodeInterpreter resultInterpreter = new CMBResultCodeInterpreter();

    public CMBServiceImpl(Context context) {
        this.mContext = context;
        HashMap hashMap = new HashMap();
        hashMap.put("cmb_url", ServiceConfig.CMB_SERVER_URL);
        this.cmbSdk = new CMBHWSDK(this.mContext, hashMap);
    }

    public ApplyAidResponse applyAid(ApplyAidRequest applyAidRequest) {
        ApplyAidResponse applyAidResponse = new ApplyAidResponse();
        if (applyAidRequest == null || StringUtil.isEmpty(applyAidRequest.getCplc(), true) || StringUtil.isEmpty(applyAidRequest.fpan, true)) {
            LogX.d("applyAid, but request is illegal.");
            applyAidResponse.setResultCode(-6);
            return applyAidResponse;
        }
        Map aid;
        LogX.d("cmb applyAid, " + applyAidRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("hwsign", applyAidRequest.getWalletSignature());
        hashMap.put("timestamp", applyAidRequest.getTimeStamp());
        hashMap.put("cplc", applyAidRequest.getCplc());
        hashMap.put("fpan", applyAidRequest.fpan);
        try {
            aid = this.cmbSdk.getAid(this.mContext, hashMap);
        } catch (Throwable e) {
            LogX.e("getAid", "", e);
            aid = null;
        }
        if (aid == null) {
            LogX.e("cmb applyAid, response is illegal.");
            applyAidResponse.setResultCode(-7);
            return applyAidResponse;
        }
        String str = (String) aid.get("result");
        applyAidResponse.setResultCode(this.resultInterpreter.handleApplyAidResultCode(str));
        applyAidResponse.setVerifySignature((String) aid.get("bankSign"));
        applyAidResponse.setTimeStamp((String) aid.get("timestamp"));
        applyAidResponse.aid = (String) aid.get("aid");
        applyAidResponse.setToken((String) aid.get(SNBConstant.FIELD_TOKEN));
        applyAidResponse.dPan = (String) aid.get("dpan");
        if (applyAidResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "get aid failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + applyAidRequest.getCplc());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CMB_BIND_CARD_FAIL_GET_AID, hashMap2, null, false, false);
        }
        LogX.d("cmb applyAid, " + applyAidResponse.toString(), true);
        return applyAidResponse;
    }

    public ApplyCardResponse applyCard(ApplyCardRequest applyCardRequest) {
        ApplyCardResponse applyCardResponse = new ApplyCardResponse();
        if (applyCardRequest == null || StringUtil.isEmpty(applyCardRequest.getCplc(), true) || StringUtil.isEmpty(applyCardRequest.getCardNum(), true) || StringUtil.isEmpty(applyCardRequest.getAid(), true)) {
            LogX.d("cmb applyCard, but request is illegal.");
            applyCardResponse.setResultCode(-6);
            return applyCardResponse;
        }
        Map verify;
        LogX.d("cmb applyCard, " + applyCardRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("hwsign", applyCardRequest.getWalletSignature());
        hashMap.put("timestamp", applyCardRequest.getTimeStamp());
        hashMap.put("cplc", applyCardRequest.getCplc());
        hashMap.put("fpan", applyCardRequest.getCardNum());
        hashMap.put("aid", applyCardRequest.getAid());
        hashMap.put("cardtype", Integer.valueOf(applyCardRequest.getCardType()));
        hashMap.put(SNBConstant.FIELD_TOKEN, applyCardRequest.getVerifyToken());
        if (2 == applyCardRequest.getCardType()) {
            hashMap.put("passcode", applyCardRequest.getPasscode());
        } else if (3 == applyCardRequest.getCardType()) {
            hashMap.put("cvv2", applyCardRequest.getCvv2Code());
            hashMap.put("userid", applyCardRequest.getIdNum());
            hashMap.put("expire", applyCardRequest.getValidDate());
        }
        try {
            verify = this.cmbSdk.verify(this.mContext, hashMap);
        } catch (Throwable e) {
            LogX.e("verify", "", e);
            verify = null;
        }
        if (verify == null) {
            LogX.e("cmb applyCard, response is illegal.");
            applyCardResponse.setResultCode(-7);
            return applyCardResponse;
        }
        String str = (String) verify.get("result");
        applyCardResponse.setResultCode(this.resultInterpreter.handleApplyCardResultCode(str));
        applyCardResponse.setVerifySignature((String) verify.get("bankSign"));
        applyCardResponse.setTimeStamp((String) verify.get("timestamp"));
        applyCardResponse.setToken(String.valueOf(verify.get(SNBConstant.FIELD_TOKEN)));
        if (applyCardResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "apply card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + applyCardRequest.getCplc());
            hashMap2.put("aid", "" + applyCardRequest.getAid());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CMB_BIND_CARD_FAIL_APPLY_CARD, hashMap2, null, false, false);
        }
        LogX.d("cmb applyCard, " + applyCardResponse.toString(), true);
        return applyCardResponse;
    }

    public PersonalizedResponse personalizeCard(PersonalizedRequest personalizedRequest) {
        PersonalizedResponse personalizedResponse = new PersonalizedResponse();
        if (personalizedRequest == null) {
            LogX.d("cmb personalizeCard, but request is illegal.");
            personalizedResponse.setResultCode(-6);
            return personalizedResponse;
        }
        Map personalize;
        LogX.d("cmb personalizeCard, " + personalizedRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("hwsign", personalizedRequest.getWalletSignature());
        hashMap.put("timestamp", personalizedRequest.getTimeStamp());
        hashMap.put("cplc", personalizedRequest.getCplc());
        hashMap.put(SNBConstant.FIELD_TOKEN, personalizedRequest.getVerifyToken());
        hashMap.put("aid", personalizedRequest.getAid());
        try {
            personalize = this.cmbSdk.personalize(this.mContext, hashMap);
        } catch (Throwable e) {
            LogX.e("cmb personalize", "", e);
            personalize = null;
        }
        if (personalize == null) {
            LogX.e("cmb personalizeCard, response is illegal.");
            personalizedResponse.setResultCode(-7);
            return personalizedResponse;
        }
        String str = (String) personalize.get("result");
        personalizedResponse.setResultCode(this.resultInterpreter.handlePersonalizeCardResultCode(str));
        personalizedResponse.setVerifySignature((String) personalize.get("bankSign"));
        personalizedResponse.setTimeStamp((String) personalize.get("timestamp"));
        personalizedResponse.dpanid = (String) personalize.get(ReportCardInfo.COLUMN_NAME_DPANID);
        personalizedResponse.productId = (String) personalize.get("cardart");
        if (personalizedResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "personalize card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + personalizedRequest.getCplc());
            hashMap2.put("aid", "" + personalizedRequest.getAid());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CMB_BIND_CARD_FAIL_PERSONALIZE_CARD, hashMap2, null, false, false);
        }
        LogX.d("cmb personalizeCard, " + personalizedResponse.toString(), true);
        return personalizedResponse;
    }

    public SmsCodeResponse requestSmsForActivation(SmsCodeRequest smsCodeRequest) {
        LogX.i("cmb requestSmsForActivation");
        return requestSmsCode(smsCodeRequest, COMMOND_ACTIVATE_ACTION);
    }

    public ActivateOrNullifyCardResponse activateCard(ActivateCardRequest activateCardRequest) {
        ActivateOrNullifyCardResponse activateOrNullifyCardResponse = new ActivateOrNullifyCardResponse();
        if (activateCardRequest == null || StringUtil.isEmpty(activateCardRequest.getCplc(), true) || StringUtil.isEmpty(activateCardRequest.getdPan(), true) || StringUtil.isEmpty(activateCardRequest.getAid(), true) || StringUtil.isEmpty(activateCardRequest.getSmsCode(), true)) {
            LogX.d("activateCard, but request is illegal.");
            activateOrNullifyCardResponse.setResultCode(-6);
            return activateOrNullifyCardResponse;
        }
        Map activate;
        LogX.d("activateCard, " + activateCardRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("cplc", activateCardRequest.getCplc());
        hashMap.put("dpan", activateCardRequest.getdPan());
        hashMap.put("aid", activateCardRequest.getAid());
        hashMap.put("smscode", activateCardRequest.getSmsCode());
        hashMap.put(SNBConstant.FIELD_TOKEN, activateCardRequest.getVerifyToken());
        try {
            activate = this.cmbSdk.activate(this.mContext, hashMap);
        } catch (Throwable e) {
            LogX.e("activate", "", e);
            activate = null;
        }
        if (activate == null) {
            LogX.e("activateCard, response is illegal.");
            activateOrNullifyCardResponse.setResultCode(-7);
            return activateOrNullifyCardResponse;
        }
        String str = (String) activate.get("result");
        activateOrNullifyCardResponse.setResultCode(this.resultInterpreter.handleVerifySMSCodeResultCode(str));
        activateOrNullifyCardResponse.setVerifySignature((String) activate.get("bankSign"));
        activateOrNullifyCardResponse.setTimeStamp((String) activate.get("timestamp"));
        activateOrNullifyCardResponse.setToken((String) activate.get(SNBConstant.FIELD_TOKEN));
        if (activateOrNullifyCardResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "activate card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + activateCardRequest.getCplc());
            hashMap2.put("aid", "" + activateCardRequest.getAid());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CMB_BIND_CARD_FAIL_ACTIVATE_CARD, hashMap2, null, false, false);
        }
        LogX.d("activateCard, " + activateOrNullifyCardResponse.toString(), true);
        return activateOrNullifyCardResponse;
    }

    private SmsCodeResponse requestSmsCode(SmsCodeRequest smsCodeRequest, String str) {
        SmsCodeResponse smsCodeResponse = new SmsCodeResponse();
        if (smsCodeRequest == null || StringUtil.isEmpty(smsCodeRequest.getCplc(), true) || StringUtil.isEmpty(smsCodeRequest.getdPan(), true) || StringUtil.isEmpty(smsCodeRequest.getAid(), true)) {
            LogX.d("cmb requestSmsCode, but request is illegal.");
            smsCodeResponse.setResultCode(-6);
            return smsCodeResponse;
        }
        Map map;
        HashMap hashMap = new HashMap();
        hashMap.put("hwsign", smsCodeRequest.getWalletSignature());
        hashMap.put("timestamp", smsCodeRequest.getTimeStamp());
        hashMap.put("cplc", smsCodeRequest.getCplc());
        hashMap.put("dpan", smsCodeRequest.getdPan());
        hashMap.put("aid", smsCodeRequest.getAid());
        hashMap.put("command", str);
        try {
            map = this.cmbSdk.getsms(this.mContext, hashMap);
        } catch (Throwable e) {
            LogX.e("cmb getsms", "", e);
            map = null;
        }
        if (map == null) {
            LogX.e("cmb requestSmsCode, response is illegal.");
            smsCodeResponse.setResultCode(-7);
            return smsCodeResponse;
        }
        String str2 = (String) map.get("result");
        smsCodeResponse.setResultCode(this.resultInterpreter.handleGetSMSResultCode(str2));
        smsCodeResponse.setVerifySignature((String) map.get("bankSign"));
        smsCodeResponse.setTimeStamp((String) map.get("timestamp"));
        smsCodeResponse.phone = PHONE_NUM_HIDE_CODE + ((String) map.get("phonenum"));
        smsCodeResponse.setToken(String.valueOf(map.get(SNBConstant.FIELD_TOKEN)));
        if (smsCodeResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "request smscode failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str2);
            hashMap2.put("cplc", "" + smsCodeRequest.getCplc());
            hashMap2.put("aid", "" + smsCodeRequest.getAid());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CMB_BIND_CARD_FAIL_REQUEST_SMS, hashMap2, null, false, false);
        }
        LogX.d("cmb requestSmsCode, " + smsCodeResponse.toString(), true);
        return smsCodeResponse;
    }

    public ActivateOrNullifyCardResponse nullifyCard(NullifyCardRequest nullifyCardRequest) {
        ActivateOrNullifyCardResponse activateOrNullifyCardResponse = new ActivateOrNullifyCardResponse();
        if (nullifyCardRequest == null) {
            LogX.d("nullify, but request is illegal.");
            activateOrNullifyCardResponse.setResultCode(-6);
            return activateOrNullifyCardResponse;
        }
        Map uninstall;
        LogX.d("nullifyCard, " + nullifyCardRequest.toString(), true);
        HashMap hashMap = new HashMap();
        hashMap.put("hwsign", nullifyCardRequest.getWalletSignature());
        hashMap.put("timestamp", nullifyCardRequest.getTimeStamp());
        hashMap.put("cplc", nullifyCardRequest.getCplc());
        hashMap.put(SNBConstant.FIELD_TOKEN, nullifyCardRequest.getVerifyToken());
        hashMap.put("dpan", nullifyCardRequest.getdPan());
        hashMap.put("aid", nullifyCardRequest.getAid());
        try {
            uninstall = this.cmbSdk.uninstall(this.mContext, hashMap);
        } catch (Throwable e) {
            LogX.e("uninstall", "", e);
            uninstall = null;
        }
        if (uninstall == null) {
            LogX.e("nullify, response is illegal.");
            activateOrNullifyCardResponse.setResultCode(-7);
            return activateOrNullifyCardResponse;
        }
        String str = (String) uninstall.get("result");
        activateOrNullifyCardResponse.setResultCode(this.resultInterpreter.handleBaseResultCode(str));
        activateOrNullifyCardResponse.setVerifySignature((String) uninstall.get("bankSign"));
        activateOrNullifyCardResponse.setTimeStamp((String) uninstall.get("timestamp"));
        if (activateOrNullifyCardResponse.getResultCode() != 0) {
            Map hashMap2 = new HashMap();
            hashMap2.put(ShowBindBusResultActivity.FAIL_REASON_KEY, "nullify card failed");
            hashMap2.put(CloudEyeLogger.FAIL_CODE, "" + str);
            hashMap2.put("cplc", "" + nullifyCardRequest.getCplc());
            hashMap2.put("aid", "" + nullifyCardRequest.getAid());
            LogX.e(AutoReportErrorCode.ERROR_EVENT_ID_NFC_CMB_NULLIFY_CARD_FAIL, hashMap2, null, false, false);
        }
        LogX.d("nullifyCard, " + activateOrNullifyCardResponse.toString(), true);
        return activateOrNullifyCardResponse;
    }
}
