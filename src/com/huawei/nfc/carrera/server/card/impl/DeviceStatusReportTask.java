package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.server.card.request.DeviceStatusReportRequest;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceStatusReportTask extends BaseReportTask<DeviceStatusReportRequest> {
    private static final String REPORT_LOST_STATUS_COMMANDER = "retry.device.claimmiss";
    private static final String REPORT_REPAIR_STATUS_COMMANDER = "device.claimmiss";

    public DeviceStatusReportTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(DeviceStatusReportRequest deviceStatusReportRequest) {
        if (deviceStatusReportRequest == null || StringUtil.isEmpty(deviceStatusReportRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(deviceStatusReportRequest.getMerchantID(), true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        String str;
        if ("2".equals(deviceStatusReportRequest.status) || "4".equals(deviceStatusReportRequest.status)) {
            str = REPORT_LOST_STATUS_COMMANDER;
        } else {
            str = REPORT_REPAIR_STATUS_COMMANDER;
        }
        return JSONHelper.createRequestStr(deviceStatusReportRequest.getMerchantID(), deviceStatusReportRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(deviceStatusReportRequest.getSrcTransactionID(), str, true), deviceStatusReportRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, DeviceStatusReportRequest deviceStatusReportRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, "" + System.currentTimeMillis());
            jSONObject2.put("dType", "cplc");
            if (!StringUtil.isEmpty(deviceStatusReportRequest.reportDeviceInfo, true)) {
                jSONObject2.put("deviceID", deviceStatusReportRequest.reportDeviceInfo);
            }
            if (!StringUtil.isEmpty(deviceStatusReportRequest.status, true)) {
                jSONObject2.put("status", deviceStatusReportRequest.status);
            }
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }
}
