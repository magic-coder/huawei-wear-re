package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.NullifyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.NullifyCardResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class NullifyCUPCardTask extends HttpConnTask<NullifyCardResponse, NullifyCUPCardRequest> {
    private static final String DELETE_CARD_COMMANDER = "nfc.delete.card";

    public NullifyCUPCardTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(NullifyCUPCardRequest nullifyCUPCardRequest) {
        if (nullifyCUPCardRequest == null || StringUtil.isEmpty(nullifyCUPCardRequest.cplc, true) || StringUtil.isEmpty(nullifyCUPCardRequest.cardRefId, true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(nullifyCUPCardRequest.getMerchantID(), nullifyCUPCardRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(nullifyCUPCardRequest.getSrcTransactionID(), DELETE_CARD_COMMANDER, true), nullifyCUPCardRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, NullifyCUPCardRequest nullifyCUPCardRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("cplc", nullifyCUPCardRequest.cplc);
            jSONObject2.put("reason", Constant.DELETE_REASON_USER);
            jSONObject2.put("cardRefId", nullifyCUPCardRequest.cardRefId);
            jSONObject2.put("tsmChannel", 2);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, "" + System.currentTimeMillis());
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected NullifyCardResponse readErrorResponse(int i) {
        NullifyCardResponse nullifyCardResponse = new NullifyCardResponse();
        if (-1 == i) {
            nullifyCardResponse.returnCode = -1;
        } else if (-3 == i) {
            nullifyCardResponse.returnCode = 1;
        } else if (-2 == i) {
            nullifyCardResponse.returnCode = -2;
        } else if (-4 == i) {
            nullifyCardResponse.returnCode = -4;
        }
        return nullifyCardResponse;
    }

    protected NullifyCardResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        NullifyCardResponse nullifyCardResponse = new NullifyCardResponse();
        if (str == null) {
            nullifyCardResponse.returnCode = -99;
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
                    nullifyCardResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    stringValue4 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        nullifyCardResponse.returnCode = -99;
                    } else {
                        nullifyCardResponse.returnCode = Integer.parseInt(stringValue);
                        if (nullifyCardResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue4);
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    nullifyCardResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                nullifyCardResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                nullifyCardResponse.returnCode = -99;
            }
        }
        return nullifyCardResponse;
    }
}
