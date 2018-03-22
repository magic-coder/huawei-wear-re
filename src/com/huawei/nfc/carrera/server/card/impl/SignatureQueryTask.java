package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.nfc.carrera.server.card.request.CardServerBaseRequest;
import com.huawei.nfc.carrera.server.card.response.SignDataResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class SignatureQueryTask extends HttpConnTask<SignDataResponse, CardServerBaseRequest> {
    private static final String TASK_COMMANDER = "nfc.get.sinature";
    private final String content;
    private String signType;

    public SignatureQueryTask(Context context, String str, String str2) {
        super(context, str);
        this.content = str2;
    }

    public SignatureQueryTask(Context context, String str, String str2, String str3) {
        super(context, str);
        this.content = str2;
        this.signType = str3;
    }

    protected String prepareRequestStr(CardServerBaseRequest cardServerBaseRequest) {
        if (cardServerBaseRequest == null || StringUtil.isEmpty(cardServerBaseRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(this.content, true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(cardServerBaseRequest.getMerchantID(), cardServerBaseRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(cardServerBaseRequest.getSrcTransactionID(), TASK_COMMANDER, true), cardServerBaseRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, CardServerBaseRequest cardServerBaseRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, System.currentTimeMillis());
            if (!StringUtil.isEmpty(this.content, true)) {
                jSONObject2.put("content", this.content);
            }
            if (!StringUtil.isEmpty(this.signType, true)) {
                jSONObject2.put(SNBConstant.FIELD_RSA_SIGN_TYPE, this.signType);
            }
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected SignDataResponse readErrorResponse(int i) {
        SignDataResponse signDataResponse = new SignDataResponse();
        if (-1 == i) {
            signDataResponse.returnCode = -1;
        } else if (-3 == i) {
            signDataResponse.returnCode = 1;
        } else if (-2 == i) {
            signDataResponse.returnCode = -2;
        } else if (-4 == i) {
            signDataResponse.returnCode = -4;
        }
        return signDataResponse;
    }

    protected SignDataResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        SignDataResponse signDataResponse = new SignDataResponse();
        if (str == null) {
            signDataResponse.returnCode = -99;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
                int intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
                String stringValue2 = JSONHelper.getStringValue(jSONObject, "response");
                String stringValue3 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
                String stringValue4 = JSONHelper.getStringValue(jSONObject, "errorMsg");
                if (stringValue3 != null) {
                    LogX.d("readSuccessResponse, error code : " + stringValue3 + "error msg : " + stringValue4);
                    signDataResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    stringValue2 = JSONHelper.getStringValue(jSONObject, HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME);
                    stringValue4 = JSONHelper.getStringValue(jSONObject, "sign");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        signDataResponse.returnCode = -99;
                    } else {
                        signDataResponse.returnCode = Integer.parseInt(stringValue);
                        if (signDataResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                        } else if (StringUtil.isEmpty(stringValue2, true) || StringUtil.isEmpty(stringValue4, true)) {
                            LogX.d("readSuccessResponse, illegal time or sign");
                            signDataResponse.returnCode = -99;
                        } else {
                            signDataResponse.time = stringValue2;
                            signDataResponse.sign = stringValue4;
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    signDataResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                signDataResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                signDataResponse.returnCode = -99;
            }
        }
        return signDataResponse;
    }
}
