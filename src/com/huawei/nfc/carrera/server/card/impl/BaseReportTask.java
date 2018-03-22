package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONObject;

public abstract class BaseReportTask<RequestParams> extends HttpConnTask<CardServerBaseResponse, RequestParams> {
    public BaseReportTask(Context context, String str) {
        super(context, str);
    }

    protected CardServerBaseResponse readErrorResponse(int i) {
        CardServerBaseResponse cardServerBaseResponse = new CardServerBaseResponse();
        if (-1 == i) {
            cardServerBaseResponse.returnCode = -1;
        } else if (-3 == i) {
            cardServerBaseResponse.returnCode = 1;
        } else if (-2 == i) {
            cardServerBaseResponse.returnCode = -2;
        } else if (-4 == i) {
            cardServerBaseResponse.returnCode = -4;
        }
        return cardServerBaseResponse;
    }

    protected CardServerBaseResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        CardServerBaseResponse cardServerBaseResponse = new CardServerBaseResponse();
        if (str == null) {
            cardServerBaseResponse.returnCode = -99;
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
                    cardServerBaseResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    stringValue4 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        cardServerBaseResponse.returnCode = -99;
                    } else {
                        cardServerBaseResponse.returnCode = Integer.parseInt(stringValue);
                        LogX.d("readSuccessResponse, returnDesc : " + stringValue4);
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    cardServerBaseResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                cardServerBaseResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                cardServerBaseResponse.returnCode = -99;
            }
        }
        return cardServerBaseResponse;
    }
}
