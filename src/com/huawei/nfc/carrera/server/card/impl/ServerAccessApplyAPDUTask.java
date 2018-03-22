package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessAPDU;
import com.huawei.nfc.carrera.server.card.request.ServerAccessApplyAPDURequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessApplyAPDUResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessApplyAPDUTask extends HttpConnTask<ServerAccessApplyAPDUResponse, ServerAccessApplyAPDURequest> {
    private static final String HEAD_COMMANDER = "get.apdu";

    public ServerAccessApplyAPDUTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessApplyAPDURequest serverAccessApplyAPDURequest) {
        if (serverAccessApplyAPDURequest == null || StringUtil.isEmpty(serverAccessApplyAPDURequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessApplyAPDURequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessApplyAPDURequest.getCplc(), true) || StringUtil.isEmpty(serverAccessApplyAPDURequest.getTransactionId(), true) || serverAccessApplyAPDURequest.getApduList() == null || serverAccessApplyAPDURequest.getApduList().isEmpty() || serverAccessApplyAPDURequest.getApduCount() != serverAccessApplyAPDURequest.getApduList().size() || StringUtil.isEmpty(serverAccessApplyAPDURequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessApplyAPDURequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessApplyAPDUTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessApplyAPDURequest.getMerchantID(), serverAccessApplyAPDURequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessApplyAPDURequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessApplyAPDURequest.getIsNeedServiceTokenAuth()), serverAccessApplyAPDURequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessApplyAPDURequest serverAccessApplyAPDURequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessApplyAPDUTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("header", jSONObject);
            jSONObject3.put("issuerid", serverAccessApplyAPDURequest.getIssuerId());
            jSONObject3.put("appletAid", serverAccessApplyAPDURequest.getAppletAid());
            jSONObject3.put("cplc", serverAccessApplyAPDURequest.getCplc());
            jSONObject3.put("transactionid", serverAccessApplyAPDURequest.getTransactionId());
            jSONObject3.put("apduCount", serverAccessApplyAPDURequest.getApduCount());
            jSONObject3.put("seChipManuFacturer", serverAccessApplyAPDURequest.getSeChipManuFacturer());
            jSONObject3.put("deviceModel", serverAccessApplyAPDURequest.getDeviceModel());
            JSONArray jSONArray = new JSONArray();
            for (ServerAccessAPDU serverAccessAPDU : serverAccessApplyAPDURequest.getApduList()) {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("apduNo", serverAccessAPDU.getApduId());
                jSONObject4.put("apduContent", serverAccessAPDU.getApduContent());
                if (!StringUtil.isEmpty(serverAccessAPDU.getApduStatus(), true)) {
                    jSONObject4.put("apduStatus", serverAccessAPDU.getApduStatus());
                }
                jSONArray.put(jSONObject4);
            }
            jSONObject3.put("apduList", jSONArray);
            jSONObject2 = jSONObject3;
        } catch (JSONException e) {
            LogX.e("ServerAccessApplyAPDUTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessApplyAPDUResponse readErrorResponse(int i) {
        ServerAccessApplyAPDUResponse serverAccessApplyAPDUResponse = new ServerAccessApplyAPDUResponse();
        serverAccessApplyAPDUResponse.returnCode = i;
        return serverAccessApplyAPDUResponse;
    }

    protected ServerAccessApplyAPDUResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessApplyAPDUResponse serverAccessApplyAPDUResponse = new ServerAccessApplyAPDUResponse();
        serverAccessApplyAPDUResponse.returnCode = i;
        serverAccessApplyAPDUResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
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
                    serverAccessApplyAPDUResponse.setApduList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessApplyAPDUTask readSuccessResponse, JSONException");
                serverAccessApplyAPDUResponse.returnCode = -99;
            }
        }
        return serverAccessApplyAPDUResponse;
    }
}
