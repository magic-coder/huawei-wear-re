package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import com.huawei.nfc.carrera.server.card.request.ServerAccessPersonalizeAppletRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessPersonalizeAppletResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessPersonalizeAppletTask extends HttpConnTask<ServerAccessPersonalizeAppletResponse, ServerAccessPersonalizeAppletRequest> {
    private static final String HEAD_COMMANDER = "personalized";

    public ServerAccessPersonalizeAppletTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessPersonalizeAppletRequest serverAccessPersonalizeAppletRequest) {
        if (serverAccessPersonalizeAppletRequest == null || StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getOrderId(), true) || StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessPersonalizeAppletTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessPersonalizeAppletRequest.getMerchantID(), serverAccessPersonalizeAppletRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessPersonalizeAppletRequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessPersonalizeAppletRequest.getIsNeedServiceTokenAuth()), serverAccessPersonalizeAppletRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessPersonalizeAppletRequest serverAccessPersonalizeAppletRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessPersonalizeAppletTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessPersonalizeAppletRequest.getIssuerId());
            jSONObject2.put("cplc", serverAccessPersonalizeAppletRequest.getCplc());
            jSONObject2.put("appletAid", serverAccessPersonalizeAppletRequest.getAppletAid());
            jSONObject2.put("orderNo", serverAccessPersonalizeAppletRequest.getOrderId());
            jSONObject2.put("deviceModel", serverAccessPersonalizeAppletRequest.getDeviceModel());
            jSONObject2.put("seChipManuFacturer", serverAccessPersonalizeAppletRequest.getSeChipManuFacturer());
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getPhoneNumber(), true)) {
                jSONObject2.put("phoneNumber", serverAccessPersonalizeAppletRequest.getPhoneNumber());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getUserID(), true)) {
                jSONObject2.put("userid", serverAccessPersonalizeAppletRequest.getUserID());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getBasebandVersion(), true)) {
                jSONObject2.put("basebandVersion", serverAccessPersonalizeAppletRequest.getBasebandVersion());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getSystemType(), true)) {
                jSONObject2.put("systemType", serverAccessPersonalizeAppletRequest.getSystemType());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getSystemVersion(), true)) {
                jSONObject2.put("systemVersion", serverAccessPersonalizeAppletRequest.getSystemVersion());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getSeCosVersion(), true)) {
                jSONObject2.put("seCosVersion", serverAccessPersonalizeAppletRequest.getSeCosVersion());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getImei(), true)) {
                jSONObject2.put("imei", serverAccessPersonalizeAppletRequest.getImei());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getPhoneManufacturer(), true)) {
                jSONObject2.put("phoneManufacturer", serverAccessPersonalizeAppletRequest.getPhoneManufacturer());
            }
            if (!StringUtil.isEmpty(serverAccessPersonalizeAppletRequest.getReserved(), true)) {
                jSONObject2.put("reserved", serverAccessPersonalizeAppletRequest.getReserved());
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessPersonalizeAppletTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessPersonalizeAppletResponse readErrorResponse(int i) {
        ServerAccessPersonalizeAppletResponse serverAccessPersonalizeAppletResponse = new ServerAccessPersonalizeAppletResponse();
        serverAccessPersonalizeAppletResponse.returnCode = i;
        return serverAccessPersonalizeAppletResponse;
    }

    protected ServerAccessPersonalizeAppletResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessPersonalizeAppletResponse serverAccessPersonalizeAppletResponse = new ServerAccessPersonalizeAppletResponse();
        serverAccessPersonalizeAppletResponse.returnCode = i;
        serverAccessPersonalizeAppletResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
                serverAccessPersonalizeAppletResponse.setTransactionId(JSONHelper.getStringValue(jSONObject, "transactionid"));
                serverAccessPersonalizeAppletResponse.setCardId(JSONHelper.getStringValue(jSONObject, "cardNo"));
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
                    serverAccessPersonalizeAppletResponse.setApduList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessPersonalizeAppletTask readSuccessResponse, JSONException");
                serverAccessPersonalizeAppletResponse.returnCode = -99;
            }
        }
        return serverAccessPersonalizeAppletResponse;
    }
}
