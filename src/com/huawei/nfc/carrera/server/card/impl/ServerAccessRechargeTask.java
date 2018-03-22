package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import com.huawei.nfc.carrera.server.card.request.ServerAccessRechargeRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessRechargeResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessRechargeTask extends HttpConnTask<ServerAccessRechargeResponse, ServerAccessRechargeRequest> {
    private static final String HEAD_COMMANDER = "recharge";

    public ServerAccessRechargeTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessRechargeRequest serverAccessRechargeRequest) {
        if (serverAccessRechargeRequest == null || StringUtil.isEmpty(serverAccessRechargeRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getCardId(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getOrderId(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getSystemType(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getSystemVersion(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getPayType(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessRechargeRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessRechargeTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessRechargeRequest.getMerchantID(), serverAccessRechargeRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessRechargeRequest.getSrcTransactionID(), "recharge", serverAccessRechargeRequest.getIsNeedServiceTokenAuth()), serverAccessRechargeRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessRechargeRequest serverAccessRechargeRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessRechargeTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessRechargeRequest.getIssuerId());
            jSONObject2.put("appletAid", serverAccessRechargeRequest.getAppletAid());
            jSONObject2.put("orderNo", serverAccessRechargeRequest.getOrderId());
            jSONObject2.put("cplc", serverAccessRechargeRequest.getCplc());
            jSONObject2.put("cardNo", serverAccessRechargeRequest.getCardId());
            jSONObject2.put("systemType", serverAccessRechargeRequest.getSystemType());
            jSONObject2.put("systemVersion", serverAccessRechargeRequest.getSystemVersion());
            jSONObject2.put("payType", serverAccessRechargeRequest.getPayType());
            jSONObject2.put("seChipManuFacturer", serverAccessRechargeRequest.getSeChipManuFacturer());
            jSONObject2.put("deviceModel", serverAccessRechargeRequest.getDeviceModel());
            if (!StringUtil.isEmpty(serverAccessRechargeRequest.getPhoneNumber(), true)) {
                jSONObject2.put("phoneNumber", serverAccessRechargeRequest.getPhoneNumber());
            }
            if (!StringUtil.isEmpty(serverAccessRechargeRequest.getUserID(), true)) {
                jSONObject2.put("userid", serverAccessRechargeRequest.getUserID());
            }
            if (!StringUtil.isEmpty(serverAccessRechargeRequest.getImei(), true)) {
                jSONObject2.put("imei", serverAccessRechargeRequest.getImei());
            }
            if (!StringUtil.isEmpty(serverAccessRechargeRequest.getRechargeMode(), true)) {
                jSONObject2.put("rechargeFlag", serverAccessRechargeRequest.getRechargeMode());
            }
            if (!StringUtil.isEmpty(serverAccessRechargeRequest.getReserved(), true)) {
                jSONObject2.put("reserved", serverAccessRechargeRequest.getReserved());
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessRechargeTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessRechargeResponse readErrorResponse(int i) {
        ServerAccessRechargeResponse serverAccessRechargeResponse = new ServerAccessRechargeResponse();
        serverAccessRechargeResponse.returnCode = i;
        return serverAccessRechargeResponse;
    }

    protected ServerAccessRechargeResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessRechargeResponse serverAccessRechargeResponse = new ServerAccessRechargeResponse();
        serverAccessRechargeResponse.returnCode = i;
        serverAccessRechargeResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
                serverAccessRechargeResponse.setTransactionId(JSONHelper.getStringValue(jSONObject, "transactionid"));
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
                    serverAccessRechargeResponse.setApduList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessRechargeTask readSuccessResponse, JSONException");
                serverAccessRechargeResponse.returnCode = -99;
            }
        }
        return serverAccessRechargeResponse;
    }
}
