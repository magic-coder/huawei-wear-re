package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessQueryOrder;
import com.huawei.nfc.carrera.server.card.request.ServerAccessQueryOrderRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessQueryOrderResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessQueryOrderTask extends HttpConnTask<ServerAccessQueryOrderResponse, ServerAccessQueryOrderRequest> {
    private static final String HEAD_COMMANDER = "query.order";

    public ServerAccessQueryOrderTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessQueryOrderRequest serverAccessQueryOrderRequest) {
        if (serverAccessQueryOrderRequest == null || StringUtil.isEmpty(serverAccessQueryOrderRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessQueryOrderRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessQueryOrderRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessQueryOrderRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessQueryOrderRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessQueryOrderTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessQueryOrderRequest.getMerchantID(), serverAccessQueryOrderRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessQueryOrderRequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessQueryOrderRequest.getIsNeedServiceTokenAuth()), serverAccessQueryOrderRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessQueryOrderRequest serverAccessQueryOrderRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessQueryOrderTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessQueryOrderRequest.getIssuerId());
            jSONObject2.put("cplc", serverAccessQueryOrderRequest.getCplc());
            jSONObject2.put("appletAid", serverAccessQueryOrderRequest.getAppletAid());
            jSONObject2.put("deviceModel", serverAccessQueryOrderRequest.getDeviceModel());
            jSONObject2.put("seChipManuFacturer", serverAccessQueryOrderRequest.getSeChipManuFacturer());
            if (!StringUtil.isEmpty(serverAccessQueryOrderRequest.getPhoneNumber(), true)) {
                jSONObject2.put("phoneNumber", serverAccessQueryOrderRequest.getPhoneNumber());
            }
            if (!StringUtil.isEmpty(serverAccessQueryOrderRequest.getUserID(), true)) {
                jSONObject2.put("userid", serverAccessQueryOrderRequest.getUserID());
            }
            if (!StringUtil.isEmpty(serverAccessQueryOrderRequest.getOrderId(), true)) {
                jSONObject2.put("orderNo", serverAccessQueryOrderRequest.getOrderId());
            }
            if (!StringUtil.isEmpty(serverAccessQueryOrderRequest.getOrderStatus(), true)) {
                jSONObject2.put("orderStatus", serverAccessQueryOrderRequest.getOrderStatus());
            }
            if (!StringUtil.isEmpty(serverAccessQueryOrderRequest.getReserved(), true)) {
                jSONObject2.put("reserved", serverAccessQueryOrderRequest.getReserved());
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessQueryOrderTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessQueryOrderResponse readErrorResponse(int i) {
        ServerAccessQueryOrderResponse serverAccessQueryOrderResponse = new ServerAccessQueryOrderResponse();
        serverAccessQueryOrderResponse.returnCode = i;
        return serverAccessQueryOrderResponse;
    }

    protected ServerAccessQueryOrderResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessQueryOrderResponse serverAccessQueryOrderResponse = new ServerAccessQueryOrderResponse();
        serverAccessQueryOrderResponse.returnCode = i;
        serverAccessQueryOrderResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
                if (jSONObject.has("orderList")) {
                    jSONArray = jSONObject.getJSONArray("orderList");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    List arrayList = new ArrayList();
                    int length = jSONArray.length();
                    for (int i2 = 0; i2 < length; i2++) {
                        ServerAccessQueryOrder buildFromJson = ServerAccessQueryOrder.buildFromJson(jSONArray.getJSONObject(i2));
                        if (buildFromJson != null) {
                            arrayList.add(buildFromJson);
                        }
                    }
                    serverAccessQueryOrderResponse.setOrderList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessQueryOrderTask readSuccessResponse, JSONException");
                serverAccessQueryOrderResponse.returnCode = -99;
            }
        }
        return serverAccessQueryOrderResponse;
    }
}
