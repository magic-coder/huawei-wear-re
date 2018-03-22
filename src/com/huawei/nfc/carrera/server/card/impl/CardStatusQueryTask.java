package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.constant.ServiceConfig;
import com.huawei.nfc.carrera.server.card.request.CardStatusQueryRequest;
import com.huawei.nfc.carrera.server.card.response.CardStatusItem;
import com.huawei.nfc.carrera.server.card.response.CardStatusQueryResponse;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CardStatusQueryTask extends HttpConnTask<CardStatusQueryResponse, CardStatusQueryRequest> {
    private static final String CARD_STATUS_GET_COMMANDER = "nfc.get.list.card";
    private static final String QUERY_CARD_OPERATE_AND_DEVICE = "2";

    public CardStatusQueryTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(CardStatusQueryRequest cardStatusQueryRequest) {
        if (cardStatusQueryRequest == null || StringUtil.isEmpty(cardStatusQueryRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(cardStatusQueryRequest.getMerchantID(), true) || StringUtil.isEmpty(cardStatusQueryRequest.cplc, true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(cardStatusQueryRequest.getMerchantID(), cardStatusQueryRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(cardStatusQueryRequest.getSrcTransactionID(), CARD_STATUS_GET_COMMANDER, true), cardStatusQueryRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, CardStatusQueryRequest cardStatusQueryRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            if (!StringUtil.isEmpty(cardStatusQueryRequest.cplc, true)) {
                jSONObject2.put("cplc", cardStatusQueryRequest.cplc);
            }
            if (!StringUtil.isEmpty(cardStatusQueryRequest.imei, true)) {
                jSONObject2.put("imei", cardStatusQueryRequest.imei);
            }
            jSONObject2.put("flag", "2");
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected CardStatusQueryResponse readErrorResponse(int i) {
        CardStatusQueryResponse cardStatusQueryResponse = new CardStatusQueryResponse();
        if (-1 == i) {
            cardStatusQueryResponse.returnCode = -1;
        } else if (-3 == i) {
            cardStatusQueryResponse.returnCode = 1;
        } else if (-2 == i) {
            cardStatusQueryResponse.returnCode = -2;
        } else if (-4 == i) {
            cardStatusQueryResponse.returnCode = -4;
        }
        return cardStatusQueryResponse;
    }

    protected CardStatusQueryResponse readSuccessResponse(String str) {
        LogX.d("readSuccessResponse response str : " + str, true);
        CardStatusQueryResponse cardStatusQueryResponse = new CardStatusQueryResponse();
        if (str == null) {
            cardStatusQueryResponse.returnCode = -99;
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
                    cardStatusQueryResponse.returnCode = Integer.parseInt(stringValue3);
                } else if (ServiceConfig.WALLET_MERCHANT_ID.equals(stringValue) && -1 == intValue && !StringUtil.isEmpty(stringValue2, true)) {
                    LogX.d("readSuccessResponse, responseDataStr : " + stringValue2, true);
                    JSONObject jSONObject2 = new JSONObject(stringValue2);
                    stringValue4 = JSONHelper.getStringValue(jSONObject2, "returnCode");
                    String stringValue5 = JSONHelper.getStringValue(jSONObject2, "returnDesc");
                    if (stringValue4 == null) {
                        LogX.d("readSuccessResponse, returnCode is invalid.");
                        cardStatusQueryResponse.returnCode = -99;
                    } else {
                        cardStatusQueryResponse.returnCode = Integer.parseInt(stringValue4);
                        if (cardStatusQueryResponse.returnCode != 0) {
                            LogX.d("readSuccessResponse, returnDesc : " + stringValue5);
                        } else {
                            JSONArray jSONArray;
                            cardStatusQueryResponse.setDevStatus(JSONHelper.getStringValue(jSONObject2, "devStatus"));
                            cardStatusQueryResponse.setCardCount((long) JSONHelper.getIntValue(jSONObject2, "count"));
                            if (jSONObject2.has("data")) {
                                jSONArray = jSONObject2.getJSONArray("data");
                            } else {
                                jSONArray = null;
                            }
                            if (jSONArray != null) {
                                cardStatusQueryResponse.setItems(new ArrayList());
                                for (int i = 0; i < jSONArray.length(); i++) {
                                    CardStatusItem createCardStatusItem = createCardStatusItem(jSONArray.getJSONObject(i));
                                    if (createCardStatusItem != null) {
                                        cardStatusQueryResponse.getItems().add(createCardStatusItem);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    LogX.d("readSuccessResponse, unexpected error from server.");
                    cardStatusQueryResponse.returnCode = -99;
                }
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, NumberFormatException : " + Log.getStackTraceString(e));
                cardStatusQueryResponse.returnCode = -99;
            } catch (Throwable e2) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e2));
                cardStatusQueryResponse.returnCode = -99;
            }
        }
        return cardStatusQueryResponse;
    }

    private CardStatusItem createCardStatusItem(JSONObject jSONObject) {
        try {
            CardStatusItem cardStatusItem = new CardStatusItem();
            cardStatusItem.setUserID(JSONHelper.getStringValue(jSONObject, "userID"));
            cardStatusItem.setCplc(JSONHelper.getStringValue(jSONObject, "cplc"));
            cardStatusItem.setAid(JSONHelper.getStringValue(jSONObject, "aid"));
            cardStatusItem.setStatus(JSONHelper.getStringValue(jSONObject, "status"));
            cardStatusItem.setDpanid(JSONHelper.getStringValue(jSONObject, ReportCardInfo.COLUMN_NAME_DPANID));
            return cardStatusItem;
        } catch (Throwable e) {
            LogX.e("createCardItemFromJson JSONException : " + Log.getStackTraceString(e), true);
            return null;
        }
    }
}
