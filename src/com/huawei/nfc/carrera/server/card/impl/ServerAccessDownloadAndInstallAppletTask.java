package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import com.huawei.nfc.carrera.server.card.request.ServerAccessDownloadAndInstallAppletRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessDownloadAndInstallAppletResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessDownloadAndInstallAppletTask extends HttpConnTask<ServerAccessDownloadAndInstallAppletResponse, ServerAccessDownloadAndInstallAppletRequest> {
    private static final String HEAD_COMMANDER = "download.install.app";

    public ServerAccessDownloadAndInstallAppletTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessDownloadAndInstallAppletRequest serverAccessDownloadAndInstallAppletRequest) {
        if (serverAccessDownloadAndInstallAppletRequest == null || StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessDownloadAndInstallAppletTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessDownloadAndInstallAppletRequest.getMerchantID(), serverAccessDownloadAndInstallAppletRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessDownloadAndInstallAppletRequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessDownloadAndInstallAppletRequest.getIsNeedServiceTokenAuth()), serverAccessDownloadAndInstallAppletRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessDownloadAndInstallAppletRequest serverAccessDownloadAndInstallAppletRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessDownloadAndInstallAppletTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessDownloadAndInstallAppletRequest.getIssuerId());
            jSONObject2.put("cplc", serverAccessDownloadAndInstallAppletRequest.getCplc());
            jSONObject2.put("appletAid", serverAccessDownloadAndInstallAppletRequest.getAppletAid());
            jSONObject2.put("seChipManuFacturer", serverAccessDownloadAndInstallAppletRequest.getSeChipManuFacturer());
            jSONObject2.put("deviceModel", serverAccessDownloadAndInstallAppletRequest.getDeviceModel());
            if (!StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getOrderId(), true)) {
                jSONObject2.put("orderNo", serverAccessDownloadAndInstallAppletRequest.getOrderId());
            }
            if (!StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getPhoneNumber(), true)) {
                jSONObject2.put("phoneNumber", serverAccessDownloadAndInstallAppletRequest.getPhoneNumber());
            }
            if (!StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getUserID(), true)) {
                jSONObject2.put("userid", serverAccessDownloadAndInstallAppletRequest.getUserID());
            }
            if (!StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getImei(), true)) {
                jSONObject2.put("imei", serverAccessDownloadAndInstallAppletRequest.getImei());
            }
            if (!StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getPhoneManufacturer(), true)) {
                jSONObject2.put("phoneManufacturer", serverAccessDownloadAndInstallAppletRequest.getPhoneManufacturer());
            }
            if (!StringUtil.isEmpty(serverAccessDownloadAndInstallAppletRequest.getReserved(), true)) {
                jSONObject2.put("reserved", serverAccessDownloadAndInstallAppletRequest.getReserved());
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessDownloadAndInstallAppletTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessDownloadAndInstallAppletResponse readErrorResponse(int i) {
        ServerAccessDownloadAndInstallAppletResponse serverAccessDownloadAndInstallAppletResponse = new ServerAccessDownloadAndInstallAppletResponse();
        serverAccessDownloadAndInstallAppletResponse.returnCode = i;
        return serverAccessDownloadAndInstallAppletResponse;
    }

    protected ServerAccessDownloadAndInstallAppletResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessDownloadAndInstallAppletResponse serverAccessDownloadAndInstallAppletResponse = new ServerAccessDownloadAndInstallAppletResponse();
        serverAccessDownloadAndInstallAppletResponse.returnCode = i;
        serverAccessDownloadAndInstallAppletResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
                serverAccessDownloadAndInstallAppletResponse.setTransactionId(JSONHelper.getStringValue(jSONObject, "transactionid"));
                if (jSONObject.has("apduList")) {
                    jSONArray = jSONObject.getJSONArray("apduList");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    List arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        ServerAccessAPDU buildFromJson = ServerAccessAPDU.buildFromJson(jSONArray.getJSONObject(i2));
                        if (buildFromJson != null) {
                            arrayList.add(buildFromJson);
                        }
                    }
                    serverAccessDownloadAndInstallAppletResponse.setApduList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessDownloadAndInstallAppletTask readSuccessResponse, JSONException");
                serverAccessDownloadAndInstallAppletResponse.returnCode = -99;
            }
        }
        return serverAccessDownloadAndInstallAppletResponse;
    }
}
