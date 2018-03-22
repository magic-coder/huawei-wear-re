package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import com.huawei.nfc.carrera.server.card.request.ServerAccessDeleteAppletRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessDeleteAppletResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessDeleteAppletTask extends HttpConnTask<ServerAccessDeleteAppletResponse, ServerAccessDeleteAppletRequest> {
    private static final String HEAD_COMMANDER = "delete.app";

    public ServerAccessDeleteAppletTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessDeleteAppletRequest serverAccessDeleteAppletRequest) {
        if (serverAccessDeleteAppletRequest == null || StringUtil.isEmpty(serverAccessDeleteAppletRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessDeleteAppletRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessDeleteAppletRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessDeleteAppletRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessDeleteAppletRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessDeleteAppletTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessDeleteAppletRequest.getMerchantID(), serverAccessDeleteAppletRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessDeleteAppletRequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessDeleteAppletRequest.getIsNeedServiceTokenAuth()), serverAccessDeleteAppletRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessDeleteAppletRequest serverAccessDeleteAppletRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessDeleteAppletTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessDeleteAppletRequest.getIssuerId());
            jSONObject2.put("cplc", serverAccessDeleteAppletRequest.getCplc());
            jSONObject2.put("appletAid", serverAccessDeleteAppletRequest.getAppletAid());
            jSONObject2.put("deviceModel", serverAccessDeleteAppletRequest.getDeviceModel());
            jSONObject2.put("seChipManuFacturer", serverAccessDeleteAppletRequest.getSeChipManuFacturer());
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getPhoneNumber(), true)) {
                jSONObject2.put("phoneNumber", serverAccessDeleteAppletRequest.getPhoneNumber());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getUserID(), true)) {
                jSONObject2.put("userid", serverAccessDeleteAppletRequest.getUserID());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getImei(), true)) {
                jSONObject2.put("imei", serverAccessDeleteAppletRequest.getImei());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getPhoneManufacturer(), true)) {
                jSONObject2.put("phoneManufacturer", serverAccessDeleteAppletRequest.getPhoneManufacturer());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getReserved(), true)) {
                jSONObject2.put("reserved", serverAccessDeleteAppletRequest.getReserved());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getCardId(), true)) {
                jSONObject2.put("cardNo", serverAccessDeleteAppletRequest.getCardId());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getRefundTicketId(), true)) {
                jSONObject2.put("refundTicketid", serverAccessDeleteAppletRequest.getRefundTicketId());
            }
            if (!StringUtil.isEmpty(serverAccessDeleteAppletRequest.getReason(), true)) {
                jSONObject2.put("reason", serverAccessDeleteAppletRequest.getReason());
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessDeleteAppletTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessDeleteAppletResponse readErrorResponse(int i) {
        ServerAccessDeleteAppletResponse serverAccessDeleteAppletResponse = new ServerAccessDeleteAppletResponse();
        serverAccessDeleteAppletResponse.returnCode = i;
        return serverAccessDeleteAppletResponse;
    }

    protected ServerAccessDeleteAppletResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessDeleteAppletResponse serverAccessDeleteAppletResponse = new ServerAccessDeleteAppletResponse();
        serverAccessDeleteAppletResponse.returnCode = i;
        serverAccessDeleteAppletResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
                serverAccessDeleteAppletResponse.setTransactionId(JSONHelper.getStringValue(jSONObject, "transactionid"));
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
                    serverAccessDeleteAppletResponse.setApduList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessDeleteAppletTask readSuccessResponse, JSONException");
                serverAccessDeleteAppletResponse.returnCode = -99;
            }
        }
        return serverAccessDeleteAppletResponse;
    }
}
