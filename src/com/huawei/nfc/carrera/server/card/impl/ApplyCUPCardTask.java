package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.model.CardMetadata;
import com.huawei.nfc.carrera.server.card.model.VirtualCardMetadata;
import com.huawei.nfc.carrera.server.card.request.ApplyCUPCardRequest;
import com.huawei.nfc.carrera.server.card.response.ApplyUPCardResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class ApplyCUPCardTask extends HttpConnTask<ApplyUPCardResponse, ApplyCUPCardRequest> {
    private static final String APPLY_UP_CARD_COMMANDER = "nfc.cardRoll";

    public ApplyCUPCardTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ApplyCUPCardRequest applyCUPCardRequest) {
        if (applyCUPCardRequest == null || StringUtil.isEmpty(applyCUPCardRequest.getCplc(), true) || applyCUPCardRequest.getCardInfor() == null) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(applyCUPCardRequest.getMerchantID(), applyCUPCardRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(applyCUPCardRequest.getSrcTransactionID(), APPLY_UP_CARD_COMMANDER, true), applyCUPCardRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ApplyCUPCardRequest applyCUPCardRequest) {
        if (jSONObject == null || applyCUPCardRequest.getCardInfor() == null) {
            return null;
        }
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("cplc", applyCUPCardRequest.getCplc());
            jSONObject2.put("tsmChannel", 2);
            jSONObject2.put("cardInfo", applyCUPCardRequest.getCardInfor().toJasonString());
            jSONObject2.put("tncStatus", applyCUPCardRequest.getTncStatus());
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, "" + System.currentTimeMillis());
            jSONObject2.put("riskInfo", applyCUPCardRequest.getRiskInfo().toJasonString());
            return jSONObject2;
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            return null;
        }
    }

    protected ApplyUPCardResponse readErrorResponse(int i) {
        ApplyUPCardResponse applyUPCardResponse = new ApplyUPCardResponse();
        if (-1 == i) {
            applyUPCardResponse.returnCode = -1;
        } else if (-3 == i) {
            applyUPCardResponse.returnCode = 1;
        } else if (-2 == i) {
            applyUPCardResponse.returnCode = -2;
        } else if (-4 == i) {
            applyUPCardResponse.returnCode = -4;
        }
        return applyUPCardResponse;
    }

    protected ApplyUPCardResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        ApplyUPCardResponse applyUPCardResponse = new ApplyUPCardResponse();
        if (str == null) {
            applyUPCardResponse.returnCode = -99;
            return applyUPCardResponse;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
            int intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
            String stringValue2 = JSONHelper.getStringValue(jSONObject, "response");
            String stringValue3 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
            String stringValue4 = JSONHelper.getStringValue(jSONObject, "errorMsg");
            if (stringValue3 != null) {
                LogX.d("readSuccessResponse, error code : " + stringValue3 + "error msg : " + stringValue4);
                applyUPCardResponse.returnCode = Integer.parseInt(stringValue3);
                return applyUPCardResponse;
            } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                JSONObject jSONObject2 = new JSONObject(stringValue2);
                stringValue4 = JSONHelper.getStringValue(jSONObject2, "returnCode");
                String stringValue5 = JSONHelper.getStringValue(jSONObject2, "returnDesc");
                if (stringValue4 == null) {
                    LogX.d("readSuccessResponse, returnCode is invalid.");
                    applyUPCardResponse.returnCode = -99;
                    return applyUPCardResponse;
                }
                applyUPCardResponse.returnCode = Integer.parseInt(stringValue4);
                if (applyUPCardResponse.returnCode != 0) {
                    LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                    return applyUPCardResponse;
                }
                applyUPCardResponse.cardMetadata = new CardMetadata((JSONObject) jSONObject2.get("cardMetadata"));
                applyUPCardResponse.virtualCardMetadata = new VirtualCardMetadata((JSONObject) jSONObject2.get("virtualCardMetadata"));
                return applyUPCardResponse;
            } else {
                LogX.d("readSuccessResponse, unexpected error from server.");
                applyUPCardResponse.returnCode = -99;
                return applyUPCardResponse;
            }
        } catch (Throwable e) {
            LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
            applyUPCardResponse.returnCode = -99;
        } catch (Throwable e2) {
            LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
            applyUPCardResponse.returnCode = -99;
        }
    }
}
