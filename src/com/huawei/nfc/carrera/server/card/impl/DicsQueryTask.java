package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.QueryDicsRequset;
import com.huawei.nfc.carrera.server.card.response.DicItem;
import com.huawei.nfc.carrera.server.card.response.QueryDicsResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.wallet.utils.log.LogC;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DicsQueryTask extends HttpConnTask<QueryDicsResponse, QueryDicsRequset> {
    private static final String QUERY_DICS_COMMANDER = "get.dics";

    public DicsQueryTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QueryDicsRequset queryDicsRequset) {
        if (queryDicsRequset == null || StringUtil.isEmpty(queryDicsRequset.getSrcTransactionID(), true) || StringUtil.isEmpty(queryDicsRequset.getMerchantID(), true)) {
            LogC.m28534d("DicsQueryTask prepareRequestStr params error.", false);
            return null;
        }
        return JSONHelper.createRequestStr(queryDicsRequset.getMerchantID(), queryDicsRequset.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(queryDicsRequset.getSrcTransactionID(), QUERY_DICS_COMMANDER, true), queryDicsRequset), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QueryDicsRequset queryDicsRequset) {
        if (jSONObject == null || StringUtil.isEmpty(queryDicsRequset.getDicName(), true)) {
            LogC.m28534d("DicsQueryTask createDataStr params error.", false);
            return null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("dicName", queryDicsRequset.dicName);
            jSONObject2.put("itemName", queryDicsRequset.itemName);
            return jSONObject2;
        } catch (Throwable e) {
            LogC.m28529b("DicsQueryTask createDataStr JSONException.", e, false);
            return null;
        }
    }

    protected QueryDicsResponse readErrorResponse(int i) {
        QueryDicsResponse queryDicsResponse = new QueryDicsResponse();
        if (-1 == i) {
            queryDicsResponse.returnCode = -1;
        } else if (-3 == i) {
            queryDicsResponse.returnCode = 1;
        } else if (-2 == i) {
            queryDicsResponse.returnCode = -2;
        }
        return queryDicsResponse;
    }

    protected QueryDicsResponse readSuccessResponse(String str) {
        QueryDicsResponse queryDicsResponse = new QueryDicsResponse();
        if (StringUtil.isEmpty(str, true)) {
            LogC.m28534d(" DicsQueryTask readSuccessResponse params error.", false);
            queryDicsResponse.returnCode = -99;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
                int intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
                String stringValue2 = JSONHelper.getStringValue(jSONObject, "response");
                String stringValue3 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
                String stringValue4 = JSONHelper.getStringValue(jSONObject, "errorMsg");
                if (stringValue3 != null) {
                    LogX.d("DicsQueryTask readSuccessResponse, error code : " + stringValue3 + "error msg : " + stringValue4);
                    queryDicsResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    JSONObject jSONObject2 = new JSONObject(stringValue2);
                    stringValue4 = JSONHelper.getStringValue(jSONObject2, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject2, "returnDesc");
                    if (stringValue4 == null) {
                        LogC.m28534d("DicsQueryTask readSuccessResponse, returnCode is invalid.", false);
                        queryDicsResponse.returnCode = -99;
                    } else {
                        queryDicsResponse.returnCode = Integer.parseInt(stringValue4);
                        if (queryDicsResponse.returnCode != 0) {
                            LogX.d("DicsQueryTask readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            JSONArray jSONArray;
                            if (jSONObject2.has("data")) {
                                jSONArray = jSONObject2.getJSONArray("data");
                            } else {
                                jSONArray = null;
                            }
                            if (jSONArray != null) {
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                                    if (jSONObject3 != null) {
                                        DicItem dicItem = new DicItem();
                                        dicItem.setParent(JSONHelper.getStringValue(jSONObject3, "parent"));
                                        dicItem.setName(JSONHelper.getStringValue(jSONObject3, "name"));
                                        dicItem.setValue(JSONHelper.getStringValue(jSONObject3, "value"));
                                        queryDicsResponse.dicItems.add(dicItem);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    LogC.m28534d("DicsQueryTask readSuccessResponse, unexpected error from server.", false);
                    queryDicsResponse.returnCode = -99;
                }
            } catch (JSONException e) {
                LogC.m28534d("DicsQueryTask readSuccessResponse exception", false);
                queryDicsResponse.returnCode = -99;
            }
        }
        return queryDicsResponse;
    }
}
