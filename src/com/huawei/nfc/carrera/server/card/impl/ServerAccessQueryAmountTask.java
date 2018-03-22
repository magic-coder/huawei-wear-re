package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessIssueAmount;
import com.huawei.nfc.carrera.server.card.model.ServerAccessRechargeAmount;
import com.huawei.nfc.carrera.server.card.request.ServerAccessQueryAmountRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessQueryAmountResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import com.huawei.p190v.C2538c;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessQueryAmountTask extends HttpConnTask<ServerAccessQueryAmountResponse, ServerAccessQueryAmountRequest> {
    private static final String HEAD_COMMANDER = "get.rechargecard";
    private static final String TAG = "ServerAccessQueryAmountTask";

    public ServerAccessQueryAmountTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessQueryAmountRequest serverAccessQueryAmountRequest) {
        if (serverAccessQueryAmountRequest == null || StringUtil.isEmpty(serverAccessQueryAmountRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessQueryAmountRequest.getFlag(), true) || StringUtil.isEmpty(serverAccessQueryAmountRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessQueryAmountRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessQueryAmountRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessQueryAmountRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessQueryAmountTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessQueryAmountRequest.getMerchantID(), serverAccessQueryAmountRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessQueryAmountRequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessQueryAmountRequest.getIsNeedServiceTokenAuth()), serverAccessQueryAmountRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessQueryAmountRequest serverAccessQueryAmountRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessQueryAmountTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessQueryAmountRequest.getIssuerId());
            jSONObject2.put("flag", serverAccessQueryAmountRequest.getFlag());
            jSONObject2.put("cplc", serverAccessQueryAmountRequest.getCplc());
            jSONObject2.put("appletAid", serverAccessQueryAmountRequest.getAppletAid());
            jSONObject2.put("deviceModel", serverAccessQueryAmountRequest.getDeviceModel());
            jSONObject2.put("seChipManuFacturer", serverAccessQueryAmountRequest.getSeChipManuFacturer());
        } catch (JSONException e) {
            LogX.e("ServerAccessQueryAmountTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessQueryAmountResponse readErrorResponse(int i) {
        ServerAccessQueryAmountResponse serverAccessQueryAmountResponse = new ServerAccessQueryAmountResponse();
        serverAccessQueryAmountResponse.returnCode = i;
        return serverAccessQueryAmountResponse;
    }

    protected ServerAccessQueryAmountResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessQueryAmountResponse serverAccessQueryAmountResponse = new ServerAccessQueryAmountResponse();
        serverAccessQueryAmountResponse.returnCode = i;
        serverAccessQueryAmountResponse.setResultDesc(str);
        if (i == 0) {
            try {
                JSONArray jSONArray;
                List arrayList;
                int length;
                int i2;
                if (jSONObject.has("rechargeCardList")) {
                    jSONArray = jSONObject.getJSONArray("rechargeCardList");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    arrayList = new ArrayList();
                    length = jSONArray.length();
                    for (i2 = 0; i2 < length; i2++) {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        C2538c.e(TAG, new Object[]{"readSuccessResponse jObject : " + jSONObject2});
                        ServerAccessRechargeAmount buildFromJson = ServerAccessRechargeAmount.buildFromJson(jSONObject2);
                        if (buildFromJson != null) {
                            arrayList.add(buildFromJson);
                        }
                    }
                    serverAccessQueryAmountResponse.setRechargeAmountList(arrayList);
                }
                if (jSONObject.has("transportationCardList")) {
                    jSONArray = jSONObject.getJSONArray("transportationCardList");
                } else {
                    jSONArray = null;
                }
                if (jSONArray != null) {
                    arrayList = new ArrayList();
                    length = jSONArray.length();
                    for (i2 = 0; i2 < length; i2++) {
                        ServerAccessIssueAmount buildFromJson2 = ServerAccessIssueAmount.buildFromJson(jSONArray.getJSONObject(i2));
                        if (buildFromJson2 != null) {
                            arrayList.add(buildFromJson2);
                        }
                    }
                    serverAccessQueryAmountResponse.setIssueAmountList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessQueryAmountTask readSuccessResponse, JSONException");
                serverAccessQueryAmountResponse.returnCode = -99;
            }
        }
        return serverAccessQueryAmountResponse;
    }
}
