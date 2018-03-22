package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.logic.appletcardinfo.model.HciConfigInfo;
import com.huawei.nfc.carrera.server.card.request.CardStatusReportRequest;
import com.huawei.nfc.carrera.storage.db.DataModel.ReportCardInfo;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.unionpay.tsmservice.data.Constant;
import org.json.JSONException;
import org.json.JSONObject;

public class CardStatusReportTask extends BaseReportTask<CardStatusReportRequest> {
    private static final String CARD_STATUS_REPORT_COMMANDER = "nfc.set.card";

    public CardStatusReportTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(CardStatusReportRequest cardStatusReportRequest) {
        if (cardStatusReportRequest == null || StringUtil.isEmpty(cardStatusReportRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(cardStatusReportRequest.getMerchantID(), true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(cardStatusReportRequest.getMerchantID(), cardStatusReportRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(cardStatusReportRequest.getSrcTransactionID(), CARD_STATUS_REPORT_COMMANDER, true), cardStatusReportRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, CardStatusReportRequest cardStatusReportRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            if (!StringUtil.isEmpty(cardStatusReportRequest.getCplc(), true)) {
                jSONObject2.put("cplc", cardStatusReportRequest.getCplc());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getTerminal(), true)) {
                jSONObject2.put(HciConfigInfo.HCI_DATA_TYPE_AFTER_TERMINAL_ID, cardStatusReportRequest.getTerminal());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getUserID(), true)) {
                jSONObject2.put("userID", cardStatusReportRequest.getUserID());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getAid(), true)) {
                jSONObject2.put("aid", cardStatusReportRequest.getAid());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getStatus(), true)) {
                jSONObject2.put("status", cardStatusReportRequest.getStatus());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getImei(), true)) {
                jSONObject2.put("imei", cardStatusReportRequest.getImei());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getDpanid(), true)) {
                jSONObject2.put(ReportCardInfo.COLUMN_NAME_DPANID, cardStatusReportRequest.getDpanid());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getCardName(), true)) {
                jSONObject2.put("cardName", cardStatusReportRequest.getCardName());
            }
            if (!StringUtil.isEmpty(cardStatusReportRequest.getCardNumber(), true)) {
                jSONObject2.put("cardNumber", cardStatusReportRequest.getCardNumber());
            }
            if ("0".equals(cardStatusReportRequest.getStatus())) {
                if (!StringUtil.isEmpty(cardStatusReportRequest.getWalletVersion(), true)) {
                    jSONObject2.put("clientVersion", cardStatusReportRequest.getWalletVersion());
                }
                if (!StringUtil.isEmpty(cardStatusReportRequest.getIssuerId(), true)) {
                    jSONObject2.put("issuerid", cardStatusReportRequest.getIssuerId());
                }
                jSONObject2.put(Constant.KEY_CARD_TYPE, cardStatusReportRequest.getCardType());
            }
            jSONObject2.put("ifNotify", cardStatusReportRequest.isIfNotify());
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }
}
