package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.QueryCardProductInfoRequest;
import com.huawei.nfc.carrera.server.card.response.CardProductInfoServerItem;
import com.huawei.nfc.carrera.server.card.response.QueryCardProductInfoResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class CardProductInfoQueryTask extends HttpConnTask<QueryCardProductInfoResponse, QueryCardProductInfoRequest> {
    private static final String CARDPRODUCT_INFO_GET_COMMANDER = "nfc.get.products";

    public CardProductInfoQueryTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QueryCardProductInfoRequest queryCardProductInfoRequest) {
        if (queryCardProductInfoRequest == null || StringUtil.isEmpty(queryCardProductInfoRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(queryCardProductInfoRequest.getMerchantID(), true) || queryCardProductInfoRequest.getFilters() == null) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(queryCardProductInfoRequest.getMerchantID(), queryCardProductInfoRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(queryCardProductInfoRequest.getSrcTransactionID(), CARDPRODUCT_INFO_GET_COMMANDER, true), queryCardProductInfoRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QueryCardProductInfoRequest queryCardProductInfoRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        try {
            if (queryCardProductInfoRequest.getFilters() == null || queryCardProductInfoRequest.getFilters().size() <= 0) {
                jSONObject2 = null;
            } else {
                jSONObject2 = new JSONObject();
                jSONObject2.put("header", jSONObject);
                jSONObject2.put("version", queryCardProductInfoRequest.getVersion());
                jSONObject2.put("client", queryCardProductInfoRequest.getClient());
                jSONObject2.put("filters", new JSONArray(queryCardProductInfoRequest.getFilters()));
                jSONObject2.put("timestamp", queryCardProductInfoRequest.getTimeStamp());
            }
        } catch (Throwable e) {
            LogX.e("CardProductInfoQueryTask createDataStr parse json error", e);
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected QueryCardProductInfoResponse readErrorResponse(int i) {
        QueryCardProductInfoResponse queryCardProductInfoResponse = new QueryCardProductInfoResponse();
        queryCardProductInfoResponse.returnCode = i;
        if (-1 == i) {
            queryCardProductInfoResponse.returnCode = -1;
        } else if (-3 == i) {
            queryCardProductInfoResponse.returnCode = 1;
        } else if (-2 == i) {
            queryCardProductInfoResponse.returnCode = -2;
        } else if (-4 == i) {
            queryCardProductInfoResponse.returnCode = -4;
        }
        return queryCardProductInfoResponse;
    }

    protected QueryCardProductInfoResponse readSuccessResponse(String str) {
        LogX.i("CardProductInfoQueryTask readSuccessResponse response str : " + str, true);
        QueryCardProductInfoResponse queryCardProductInfoResponse = new QueryCardProductInfoResponse();
        if (StringUtil.isEmpty(str, true)) {
            LogX.e("CardProductInfoQueryTask readSuccessResponse responseStr is null");
            queryCardProductInfoResponse.returnCode = -99;
        } else {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String stringValue = JSONHelper.getStringValue(jSONObject, "merchantID");
                int intValue = JSONHelper.getIntValue(jSONObject, "keyIndex");
                String stringValue2 = JSONHelper.getStringValue(jSONObject, "response");
                String stringValue3 = JSONHelper.getStringValue(jSONObject, Constant.KEY_ERROR_CODE);
                String stringValue4 = JSONHelper.getStringValue(jSONObject, "errorMsg");
                if (stringValue3 != null) {
                    LogX.d("CardProductInfoQueryTask readSuccessResponse, error code : " + stringValue3 + "error msg : " + stringValue4);
                    queryCardProductInfoResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("CardProductInfoQueryTask readSuccessResponse, responseDataStr : " + stringValue2, true);
                    JSONObject jSONObject2 = new JSONObject(stringValue2);
                    stringValue4 = JSONHelper.getStringValue(jSONObject2, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject2, "returnDesc");
                    if (stringValue4 == null) {
                        LogX.d("CardProductInfoQueryTask readSuccessResponse, returnCode is invalid.");
                        queryCardProductInfoResponse.returnCode = -99;
                    } else {
                        queryCardProductInfoResponse.returnCode = Integer.parseInt(stringValue4);
                        if (queryCardProductInfoResponse.returnCode != 0) {
                            LogX.d("CardProductInfoQueryTask readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            JSONArray jSONArray;
                            if (jSONObject2.has("data")) {
                                jSONArray = jSONObject2.getJSONArray("data");
                            } else {
                                jSONArray = null;
                            }
                            if (jSONArray != null) {
                                queryCardProductInfoResponse.items = new ArrayList();
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    CardProductInfoServerItem createCardProductInfoItem = createCardProductInfoItem(jSONArray.getJSONObject(i));
                                    if (createCardProductInfoItem != null) {
                                        queryCardProductInfoResponse.items.add(createCardProductInfoItem);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    LogX.d("CardProductInfoQueryTask readSuccessResponse, unexpected error from server.");
                    queryCardProductInfoResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("CardProductInfoQueryTask readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                queryCardProductInfoResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("CardProductInfoQueryTask readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                queryCardProductInfoResponse.returnCode = -99;
            }
        }
        return queryCardProductInfoResponse;
    }

    private CardProductInfoServerItem createCardProductInfoItem(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        CardProductInfoServerItem cardProductInfoServerItem = new CardProductInfoServerItem();
        try {
            cardProductInfoServerItem.setProductId(JSONHelper.getStringValue(jSONObject, "productid"));
            cardProductInfoServerItem.setProductName(JSONHelper.getStringValue(jSONObject, "name"));
            cardProductInfoServerItem.setPictureUrl(JSONHelper.getStringValue(jSONObject, "pictureUrl"));
            cardProductInfoServerItem.setDescription(JSONHelper.getStringValue(jSONObject, "description"));
            cardProductInfoServerItem.setType(JSONHelper.getIntValue(jSONObject, "type"));
            cardProductInfoServerItem.setTimeStamp(JSONHelper.getLongValue(jSONObject, "timestamp"));
            cardProductInfoServerItem.setVersion(JSONHelper.getStringValue(jSONObject, "version"));
            cardProductInfoServerItem.setIssuerId(JSONHelper.getStringValue(jSONObject, "issuerid"));
            cardProductInfoServerItem.setMktInfo(JSONHelper.getStringValue(jSONObject, "mktDesc"));
            cardProductInfoServerItem.setReservedInfo(JSONHelper.getStringValue(jSONObject, "reserved"));
            cardProductInfoServerItem.setReserved1(JSONHelper.getStringValue(jSONObject, "reserved1"));
            cardProductInfoServerItem.setReserved2(JSONHelper.getStringValue(jSONObject, "reserved2"));
            cardProductInfoServerItem.setReserved3(JSONHelper.getStringValue(jSONObject, "reserved3"));
            cardProductInfoServerItem.setReserved4(JSONHelper.getStringValue(jSONObject, "reserved4"));
            cardProductInfoServerItem.setReserved5(JSONHelper.getStringValue(jSONObject, "reserved5"));
            cardProductInfoServerItem.setReserved6(JSONHelper.getStringValue(jSONObject, "reserved6"));
        } catch (Throwable e) {
            LogX.e("CardProductInfoQueryTask createCardProductInfoItem JSONException : " + Log.getStackTraceString(e), true);
            cardProductInfoServerItem = null;
        }
        return cardProductInfoServerItem;
    }
}
