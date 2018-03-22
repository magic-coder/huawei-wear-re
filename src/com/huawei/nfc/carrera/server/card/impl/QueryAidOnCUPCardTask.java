package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.QueryAidRequest;
import com.huawei.nfc.carrera.server.card.response.QueryAidResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class QueryAidOnCUPCardTask extends HttpConnTask<QueryAidResponse, QueryAidRequest> {
    private static final String ERROR_CODE_NOT_GET_AID = "N90300";
    private static final String ERROR_CODE_NO_QUERIED_ITEM = "N90317";
    private static final String QUERY_AID_COMMANDER = "nfc.get.cardaid";

    public QueryAidOnCUPCardTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QueryAidRequest queryAidRequest) {
        if (queryAidRequest == null || StringUtil.isEmpty(queryAidRequest.cplc, true) || StringUtil.isEmpty(queryAidRequest.cardRefId, true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(queryAidRequest.getMerchantID(), queryAidRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(queryAidRequest.getSrcTransactionID(), QUERY_AID_COMMANDER, true), queryAidRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QueryAidRequest queryAidRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("cplc", queryAidRequest.cplc);
            jSONObject2.put("cardRefId", queryAidRequest.cardRefId);
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected QueryAidResponse readErrorResponse(int i) {
        QueryAidResponse queryAidResponse = new QueryAidResponse();
        if (-1 == i) {
            queryAidResponse.returnCode = -1;
        } else if (-3 == i) {
            queryAidResponse.returnCode = 1;
        } else if (-2 == i) {
            queryAidResponse.returnCode = -2;
        } else if (-4 == i) {
            queryAidResponse.returnCode = -4;
        }
        return queryAidResponse;
    }

    protected QueryAidResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        QueryAidResponse queryAidResponse = new QueryAidResponse();
        if (str == null) {
            queryAidResponse.returnCode = -99;
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
                    queryAidResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    jSONObject = new JSONObject(stringValue2);
                    stringValue = JSONHelper.getStringValue(jSONObject, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject, "returnDesc");
                    if (stringValue == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        queryAidResponse.returnCode = -99;
                    } else if (ERROR_CODE_NOT_GET_AID.equals(stringValue) || ERROR_CODE_NO_QUERIED_ITEM.equals(stringValue)) {
                        queryAidResponse.returnCode = -3;
                        LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                    } else {
                        queryAidResponse.returnCode = Integer.parseInt(stringValue);
                        if (queryAidResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            queryAidResponse.virtualCardRefID = JSONHelper.getStringValue(jSONObject, "cardRefId");
                            queryAidResponse.aid = JSONHelper.getStringValue(jSONObject, "aid");
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    queryAidResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                queryAidResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                queryAidResponse.returnCode = -99;
            }
        }
        return queryAidResponse;
    }
}
