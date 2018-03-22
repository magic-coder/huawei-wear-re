package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.ApplyCUPVerificationRequest;
import com.huawei.nfc.carrera.server.card.response.ApplyVerificationResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class ApplyCUPVerificationTask extends HttpConnTask<ApplyVerificationResponse, ApplyCUPVerificationRequest> {
    private static final String APPLY_VERIFICATION_COMMANDER = "nfc.get.verification";

    public ApplyCUPVerificationTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ApplyCUPVerificationRequest applyCUPVerificationRequest) {
        if (applyCUPVerificationRequest == null || StringUtil.isEmpty(applyCUPVerificationRequest.getCplc(), true) || StringUtil.isEmpty(applyCUPVerificationRequest.getCardRefId(), true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(applyCUPVerificationRequest.getMerchantID(), applyCUPVerificationRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(applyCUPVerificationRequest.getSrcTransactionID(), APPLY_VERIFICATION_COMMANDER, true), applyCUPVerificationRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ApplyCUPVerificationRequest applyCUPVerificationRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("cplc", applyCUPVerificationRequest.getCplc());
            jSONObject2.put(Constant.KEY_METHOD, applyCUPVerificationRequest.getMethod());
            jSONObject2.put("cardRefId", applyCUPVerificationRequest.getCardRefId());
            jSONObject2.put("tsmChannel", 2);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, "" + System.currentTimeMillis());
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ApplyVerificationResponse readErrorResponse(int i) {
        ApplyVerificationResponse applyVerificationResponse = new ApplyVerificationResponse();
        if (-1 == i) {
            applyVerificationResponse.returnCode = -1;
        } else if (-3 == i) {
            applyVerificationResponse.returnCode = 1;
        } else if (-2 == i) {
            applyVerificationResponse.returnCode = -2;
        } else if (-4 == i) {
            applyVerificationResponse.returnCode = -4;
        }
        return applyVerificationResponse;
    }

    protected ApplyVerificationResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        ApplyVerificationResponse applyVerificationResponse = new ApplyVerificationResponse();
        if (str == null) {
            applyVerificationResponse.returnCode = -99;
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
                    applyVerificationResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        applyVerificationResponse.returnCode = -99;
                    } else {
                        applyVerificationResponse.returnCode = Integer.parseInt(stringValue);
                        if (applyVerificationResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            applyVerificationResponse.expiry = JSONHelper.getStringValue(jSONObject, "expiry");
                            applyVerificationResponse.currTime = JSONHelper.getStringValue(jSONObject, "currTime");
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    applyVerificationResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                applyVerificationResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                applyVerificationResponse.returnCode = -99;
            }
        }
        return applyVerificationResponse;
    }
}
