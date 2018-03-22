package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.request.PushInfoReportRequest;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class PushInfoReportTask extends BaseReportTask<PushInfoReportRequest> {
    private static final String REPORT_PUSH_INFO_APPID = "10131836";
    private static final String REPORT_PUSH_INFO_COMMANDER = "nfc.report.terminal";

    public PushInfoReportTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(PushInfoReportRequest pushInfoReportRequest) {
        if (pushInfoReportRequest == null || StringUtil.isEmpty(pushInfoReportRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(pushInfoReportRequest.getMerchantID(), true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(pushInfoReportRequest.getMerchantID(), pushInfoReportRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(pushInfoReportRequest.getSrcTransactionID(), REPORT_PUSH_INFO_COMMANDER, true), pushInfoReportRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, PushInfoReportRequest pushInfoReportRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            if (!StringUtil.isEmpty(pushInfoReportRequest.getCplc(), true)) {
                jSONObject2.put("cplc", pushInfoReportRequest.getCplc());
            }
            if (!StringUtil.isEmpty(pushInfoReportRequest.getReportType(), true)) {
                jSONObject2.put("type", pushInfoReportRequest.getReportType());
            }
            if (!StringUtil.isEmpty(pushInfoReportRequest.getDeviceInfo(), true)) {
                jSONObject2.put("infor", pushInfoReportRequest.getDeviceInfo());
            }
            jSONObject2.put("appid", "10131836");
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }
}
