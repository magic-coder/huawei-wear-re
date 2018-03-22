package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.IdentifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.IdentifyCUPCardResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class IdentifyCUPCardTask extends HttpConnTask<IdentifyCUPCardResponse, IdentifyCUPCardRequest> {
    private static final String CHECK_CARD_COMMANDER = "nfc.checkCard";

    public IdentifyCUPCardTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(IdentifyCUPCardRequest identifyCUPCardRequest) {
        if (identifyCUPCardRequest == null || StringUtil.isEmpty(identifyCUPCardRequest.cplc, true) || StringUtil.isEmpty(identifyCUPCardRequest.encryptedFpan, true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(identifyCUPCardRequest.getMerchantID(), identifyCUPCardRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(identifyCUPCardRequest.getSrcTransactionID(), CHECK_CARD_COMMANDER, true), identifyCUPCardRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, IdentifyCUPCardRequest identifyCUPCardRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("cplc", identifyCUPCardRequest.cplc);
            jSONObject2.put(Constant.KEY_PAN, identifyCUPCardRequest.encryptedFpan);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, "" + System.currentTimeMillis());
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected IdentifyCUPCardResponse readErrorResponse(int i) {
        IdentifyCUPCardResponse identifyCUPCardResponse = new IdentifyCUPCardResponse();
        if (-1 == i) {
            identifyCUPCardResponse.returnCode = -1;
        } else if (-3 == i) {
            identifyCUPCardResponse.returnCode = 1;
        } else if (-2 == i) {
            identifyCUPCardResponse.returnCode = -2;
        } else if (-4 == i) {
            identifyCUPCardResponse.returnCode = -4;
        }
        return identifyCUPCardResponse;
    }

    protected IdentifyCUPCardResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        IdentifyCUPCardResponse identifyCUPCardResponse = new IdentifyCUPCardResponse();
        if (str == null) {
            identifyCUPCardResponse.returnCode = -99;
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
                    identifyCUPCardResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        identifyCUPCardResponse.returnCode = -99;
                    } else {
                        identifyCUPCardResponse.returnCode = Integer.parseInt(stringValue);
                        if (identifyCUPCardResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            identifyCUPCardResponse.issuerId = JSONHelper.getStringValue(jSONObject, "issuerId");
                            stringValue4 = JSONHelper.getStringValue(jSONObject, Constant.KEY_CARD_TYPE);
                            LogX.d("bank card type: " + stringValue4);
                            if ("DEBIT".equals(stringValue4)) {
                                identifyCUPCardResponse.cardType = 2;
                            } else if ("CREDIT".equals(stringValue4)) {
                                identifyCUPCardResponse.cardType = 3;
                            }
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    identifyCUPCardResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                identifyCUPCardResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                identifyCUPCardResponse.returnCode = -99;
            }
        }
        return identifyCUPCardResponse;
    }
}
