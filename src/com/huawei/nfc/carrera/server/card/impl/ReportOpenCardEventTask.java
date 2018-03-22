package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.server.card.request.ReportEventBaseRequest;
import com.huawei.nfc.carrera.server.card.response.CardServerBaseResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class ReportOpenCardEventTask extends HttpConnTask<CardServerBaseResponse, ReportEventBaseRequest> {
    private static final String OPEN_CARD_UPLOAD_COMMANDER = "post.event.cardenroll";

    public ReportOpenCardEventTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ReportEventBaseRequest reportEventBaseRequest) {
        if (reportEventBaseRequest == null) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(reportEventBaseRequest.getMerchantID(), reportEventBaseRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(reportEventBaseRequest.getSrcTransactionID(), OPEN_CARD_UPLOAD_COMMANDER, true), reportEventBaseRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ReportEventBaseRequest reportEventBaseRequest) {
        if (jSONObject == null || reportEventBaseRequest == null) {
            return null;
        }
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("requestid", reportEventBaseRequest.getRequestNum());
            jSONObject2.put(HciConfigInfo.HCI_DATA_TYPE_TRANSCTION_TIME, reportEventBaseRequest.getTime());
            jSONObject2.put("uid", reportEventBaseRequest.getUid());
            jSONObject2.put("issuerid", reportEventBaseRequest.getCardIssuerid());
            jSONObject2.put(Constant.KEY_CARD_TYPE, reportEventBaseRequest.getCardType());
            jSONObject2.put(HciConfigInfo.HCI_DATA_TYPE_AFTER_TERMINAL_ID, reportEventBaseRequest.getTerminal());
            jSONObject2.put("result", reportEventBaseRequest.getResult());
            jSONObject2.put(Constant.KEY_ERROR_DESC, reportEventBaseRequest.getErrorDesc());
            return jSONObject2;
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            return null;
        }
    }

    protected CardServerBaseResponse readErrorResponse(int i) {
        return new CardServerBaseResponse(i);
    }

    protected CardServerBaseResponse readSuccessResponse(String str) {
        return new CardServerBaseResponse(0);
    }
}
