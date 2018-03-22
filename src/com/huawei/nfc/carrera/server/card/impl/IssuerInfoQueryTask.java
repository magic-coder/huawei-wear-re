package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.QueryIssuerInfoRequest;
import com.huawei.nfc.carrera.server.card.response.IssuerInfoServerItem;
import com.huawei.nfc.carrera.server.card.response.QueryIssuerInfoResponse;
import com.huawei.nfc.carrera.storage.db.DataModel.IssuerInfoColumns;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class IssuerInfoQueryTask extends HttpConnTask<QueryIssuerInfoResponse, QueryIssuerInfoRequest> {
    private static final String ISSUER_INFO_GET_COMMANDER = "nfc.get.issuers";

    public IssuerInfoQueryTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QueryIssuerInfoRequest queryIssuerInfoRequest) {
        if (queryIssuerInfoRequest == null || StringUtil.isEmpty(queryIssuerInfoRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(queryIssuerInfoRequest.getMerchantID(), true)) {
            LogX.d("IssuerInfoQueryTask prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(queryIssuerInfoRequest.getMerchantID(), queryIssuerInfoRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(queryIssuerInfoRequest.getSrcTransactionID(), ISSUER_INFO_GET_COMMANDER, true), queryIssuerInfoRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QueryIssuerInfoRequest queryIssuerInfoRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("timestamp", queryIssuerInfoRequest.timeStamp);
        } catch (Throwable e) {
            LogX.e("IssuerInfoQueryTask createDataStr parse json error", e);
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected QueryIssuerInfoResponse readErrorResponse(int i) {
        QueryIssuerInfoResponse queryIssuerInfoResponse = new QueryIssuerInfoResponse();
        queryIssuerInfoResponse.returnCode = i;
        if (-1 == i) {
            queryIssuerInfoResponse.returnCode = -1;
        } else if (-3 == i) {
            queryIssuerInfoResponse.returnCode = 1;
        } else if (-2 == i) {
            queryIssuerInfoResponse.returnCode = -2;
        } else if (-4 == i) {
            queryIssuerInfoResponse.returnCode = -4;
        }
        return queryIssuerInfoResponse;
    }

    protected QueryIssuerInfoResponse readSuccessResponse(String str) {
        LogX.d("IssuerInfoQueryTask readSuccessResponse response str : " + str, true);
        QueryIssuerInfoResponse queryIssuerInfoResponse = new QueryIssuerInfoResponse();
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("IssuerInfoQueryTask readSuccessResponse responseStr is null");
            queryIssuerInfoResponse.returnCode = -99;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
                int intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
                String stringValue2 = JSONHelper.getStringValue(jSONObject, "response");
                String stringValue3 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
                String stringValue4 = JSONHelper.getStringValue(jSONObject, "errorMsg");
                if (stringValue3 != null) {
                    LogX.d("IssuerInfoQueryTask readSuccessResponse, error code : " + stringValue3 + "error msg : " + stringValue4);
                    queryIssuerInfoResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("IssuerInfoQueryTask readSuccessResponse, responseDataStr : " + stringValue2, true);
                    JSONObject jSONObject2 = new JSONObject(stringValue2);
                    stringValue4 = JSONHelper.getStringValue(jSONObject2, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject2, "returnDesc");
                    if (stringValue4 == null) {
                        LogX.d("IssuerInfoQueryTask readSuccessResponse, returnCode is invalid.");
                        queryIssuerInfoResponse.returnCode = -99;
                    } else {
                        queryIssuerInfoResponse.returnCode = Integer.parseInt(stringValue4);
                        if (queryIssuerInfoResponse.returnCode != 0) {
                            LogX.d("IssuerInfoQueryTask readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            JSONArray jSONArray;
                            if (jSONObject2.has("data")) {
                                jSONArray = jSONObject2.getJSONArray("data");
                            } else {
                                jSONArray = null;
                            }
                            if (jSONArray != null) {
                                queryIssuerInfoResponse.issueInfos = new ArrayList();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    IssuerInfoServerItem createIssuerInfoItem = createIssuerInfoItem(jSONArray.getJSONObject(i));
                                    if (createIssuerInfoItem != null) {
                                        queryIssuerInfoResponse.issueInfos.add(createIssuerInfoItem);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    LogX.d("IssuerInfoQueryTask readSuccessResponse, unexpected error from server.");
                    queryIssuerInfoResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("IssuerInfoQueryTask readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                queryIssuerInfoResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("IssuerInfoQueryTask readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                queryIssuerInfoResponse.returnCode = -99;
            }
        }
        return queryIssuerInfoResponse;
    }

    private IssuerInfoServerItem createIssuerInfoItem(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        IssuerInfoServerItem issuerInfoServerItem = new IssuerInfoServerItem();
        try {
            issuerInfoServerItem.setIssuerId(JSONHelper.getStringValue(jSONObject, "issuerid"));
            issuerInfoServerItem.setName(JSONHelper.getStringValue(jSONObject, "name"));
            issuerInfoServerItem.setDescription(JSONHelper.getStringValue(jSONObject, "description"));
            issuerInfoServerItem.setLogoUrl(JSONHelper.getStringValue(jSONObject, "logo"));
            issuerInfoServerItem.setIssuerType(JSONHelper.getIntValue(jSONObject, "issuerType"));
            issuerInfoServerItem.setSupportType(JSONHelper.getIntValue(jSONObject, "supportedProduct"));
            issuerInfoServerItem.setMode(JSONHelper.getIntValue(jSONObject, IssuerInfoColumns.COLUMN_NAME_MODE));
            issuerInfoServerItem.setWalletVersion(JSONHelper.getStringValue(jSONObject, "walletVersion"));
            issuerInfoServerItem.setContactNumber(JSONHelper.getStringValue(jSONObject, "contactNumber"));
            issuerInfoServerItem.setDebitCallCenterNumber(JSONHelper.getStringValue(jSONObject, "debitCallCenterNumber"));
            issuerInfoServerItem.setCreditCallCenterNumber(JSONHelper.getStringValue(jSONObject, "creditCallCenterNumber"));
            issuerInfoServerItem.setDebitTcUrl(JSONHelper.getStringValue(jSONObject, "debitTcUrl"));
            issuerInfoServerItem.setCreditTcUrl(JSONHelper.getStringValue(jSONObject, "creditTcUrl"));
            issuerInfoServerItem.setDebitWebsite(JSONHelper.getStringValue(jSONObject, "debitWebsite"));
            issuerInfoServerItem.setCreditWebsite(JSONHelper.getStringValue(jSONObject, "creditWebsite"));
            issuerInfoServerItem.setTimeStamp(JSONHelper.getLongValue(jSONObject, "timestamp"));
            issuerInfoServerItem.setAppInfo(JSONHelper.getStringValue(jSONObject, "appInfo"));
            issuerInfoServerItem.setReservedInfo(JSONHelper.getStringValue(jSONObject, "reserved"));
            issuerInfoServerItem.setSn(JSONHelper.getIntValue(jSONObject, "sn"));
        } catch (Throwable e) {
            LogX.e("IssuerInfoQueryTask createIssuerInfoItem JSONException : " + Log.getStackTraceString(e), true);
            issuerInfoServerItem = null;
        }
        return issuerInfoServerItem;
    }
}
