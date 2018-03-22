package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.util.Log;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.request.QuerySupportedCardListByTerminalRequest;
import com.huawei.nfc.carrera.server.card.response.QuerySupportedCardListByTerminalResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import org.json.JSONObject;

public class QuerySupportedCardListByTerminalTask extends HttpConnTask<QuerySupportedCardListByTerminalResponse, QuerySupportedCardListByTerminalRequest> {
    private static final String QUERY_SUPPORTED_CARD_LIST_COMMANDER = "query.rule.issuer";

    public QuerySupportedCardListByTerminalTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(QuerySupportedCardListByTerminalRequest querySupportedCardListByTerminalRequest) {
        if (querySupportedCardListByTerminalRequest == null || StringUtil.isEmpty(querySupportedCardListByTerminalRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(querySupportedCardListByTerminalRequest.getMerchantID(), true)) {
            LogX.d("QuerySupportedCardListByTerminalTask prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(querySupportedCardListByTerminalRequest.getMerchantID(), querySupportedCardListByTerminalRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(querySupportedCardListByTerminalRequest.getSrcTransactionID(), QUERY_SUPPORTED_CARD_LIST_COMMANDER, true), querySupportedCardListByTerminalRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, QuerySupportedCardListByTerminalRequest querySupportedCardListByTerminalRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("timestamp", querySupportedCardListByTerminalRequest.getTimeStamp());
            jSONObject2.put("romVersion", querySupportedCardListByTerminalRequest.getRomVersion());
            jSONObject2.put("clientVersion", querySupportedCardListByTerminalRequest.getWalletVersion());
            jSONObject2.put(HciConfigInfo.HCI_DATA_TYPE_AFTER_TERMINAL_ID, querySupportedCardListByTerminalRequest.getTerminal());
        } catch (Throwable e) {
            LogX.e("QuerySupportedCardListByTerminalTask createDataStr parse json error", e);
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected QuerySupportedCardListByTerminalResponse readErrorResponse(int i) {
        QuerySupportedCardListByTerminalResponse querySupportedCardListByTerminalResponse = new QuerySupportedCardListByTerminalResponse();
        querySupportedCardListByTerminalResponse.returnCode = i;
        return querySupportedCardListByTerminalResponse;
    }

    protected QuerySupportedCardListByTerminalResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        QuerySupportedCardListByTerminalResponse querySupportedCardListByTerminalResponse = new QuerySupportedCardListByTerminalResponse();
        querySupportedCardListByTerminalResponse.returnCode = i;
        querySupportedCardListByTerminalResponse.issuersString = null;
        if (i == 0) {
            try {
                querySupportedCardListByTerminalResponse.issuersString = JSONHelper.getStringValue(jSONObject, "issuers");
            } catch (Throwable e) {
                LogX.e("readSuccessResponse, JSONException : " + Log.getStackTraceString(e));
                querySupportedCardListByTerminalResponse.returnCode = -99;
            }
        }
        return querySupportedCardListByTerminalResponse;
    }
}
