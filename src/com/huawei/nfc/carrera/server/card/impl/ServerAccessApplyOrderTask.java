package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.server.card.impl.http.HttpConnTask;
import com.huawei.nfc.carrera.server.card.model.ServerAccessApplyOrder;
import com.huawei.nfc.carrera.server.card.request.ServerAccessApplyOrderRequest;
import com.huawei.nfc.carrera.server.card.response.ServerAccessApplyOrderResponse;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ServerAccessApplyOrderTask extends HttpConnTask<ServerAccessApplyOrderResponse, ServerAccessApplyOrderRequest> {
    private static final String HEAD_COMMANDER = "create.order";

    public ServerAccessApplyOrderTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(ServerAccessApplyOrderRequest serverAccessApplyOrderRequest) {
        if (serverAccessApplyOrderRequest == null || StringUtil.isEmpty(serverAccessApplyOrderRequest.getIssuerId(), true) || StringUtil.isEmpty(serverAccessApplyOrderRequest.getCplc(), true) || StringUtil.isEmpty(serverAccessApplyOrderRequest.getAppletAid(), true) || StringUtil.isEmpty(serverAccessApplyOrderRequest.getPayType(), true) || StringUtil.isEmpty(serverAccessApplyOrderRequest.getScene(), true) || StringUtil.isEmpty(serverAccessApplyOrderRequest.getDeviceModel(), true) || StringUtil.isEmpty(serverAccessApplyOrderRequest.getSeChipManuFacturer(), true)) {
            LogX.e("ServerAccessApplyOrderTask prepareRequestStr, invalid param");
            return null;
        }
        return JSONHelper.createRequestStr(serverAccessApplyOrderRequest.getMerchantID(), serverAccessApplyOrderRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(serverAccessApplyOrderRequest.getSrcTransactionID(), HEAD_COMMANDER, serverAccessApplyOrderRequest.getIsNeedServiceTokenAuth()), serverAccessApplyOrderRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, ServerAccessApplyOrderRequest serverAccessApplyOrderRequest) {
        if (jSONObject == null) {
            LogX.e("ServerAccessApplyOrderTask createDataStr, invalid param");
            return null;
        }
        JSONObject jSONObject2;
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put("issuerid", serverAccessApplyOrderRequest.getIssuerId());
            jSONObject2.put("cplc", serverAccessApplyOrderRequest.getCplc());
            jSONObject2.put("appletAid", serverAccessApplyOrderRequest.getAppletAid());
            jSONObject2.put("payType", serverAccessApplyOrderRequest.getPayType());
            jSONObject2.put("changeType", serverAccessApplyOrderRequest.getScene());
            jSONObject2.put("deviceModel", serverAccessApplyOrderRequest.getDeviceModel());
            jSONObject2.put("seChipManuFacturer", serverAccessApplyOrderRequest.getSeChipManuFacturer());
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getTheoreticalIssuePayment(), true)) {
                jSONObject2.put("priceEnroll", serverAccessApplyOrderRequest.getTheoreticalIssuePayment());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getActualIssuePayment(), true)) {
                jSONObject2.put("amountEnroll", serverAccessApplyOrderRequest.getActualIssuePayment());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getTheoreticalRecharegePayment(), true)) {
                jSONObject2.put("priceRecharge", serverAccessApplyOrderRequest.getTheoreticalRecharegePayment());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getActualRecharegePayment(), true)) {
                jSONObject2.put("amountRecharge", serverAccessApplyOrderRequest.getActualRecharegePayment());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getUserID(), true)) {
                jSONObject2.put("userid", serverAccessApplyOrderRequest.getUserID());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getPhoneNumber(), true)) {
                jSONObject2.put("phoneNumber", serverAccessApplyOrderRequest.getPhoneNumber());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getCardId(), true)) {
                jSONObject2.put("cardNo", serverAccessApplyOrderRequest.getCardId());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getCurrency(), true)) {
                jSONObject2.put(HwPayConstant.KEY_CURRENCY, serverAccessApplyOrderRequest.getCurrency());
            }
            if (!StringUtil.isEmpty(serverAccessApplyOrderRequest.getReserved(), true)) {
                jSONObject2.put("reserved", serverAccessApplyOrderRequest.getReserved());
            }
        } catch (JSONException e) {
            LogX.e("ServerAccessApplyOrderTask createDataStr, JSONException");
            jSONObject2 = null;
        }
        return jSONObject2;
    }

    protected ServerAccessApplyOrderResponse readErrorResponse(int i) {
        ServerAccessApplyOrderResponse serverAccessApplyOrderResponse = new ServerAccessApplyOrderResponse();
        serverAccessApplyOrderResponse.returnCode = i;
        return serverAccessApplyOrderResponse;
    }

    protected ServerAccessApplyOrderResponse readSuccessResponse(int i, String str, JSONObject jSONObject) {
        ServerAccessApplyOrderResponse serverAccessApplyOrderResponse = new ServerAccessApplyOrderResponse();
        serverAccessApplyOrderResponse.returnCode = i;
        serverAccessApplyOrderResponse.setResultDesc(str);
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
                        ServerAccessApplyOrder buildFromJson = ServerAccessApplyOrder.buildFromJson(jSONArray.getJSONObject(i2));
                        if (buildFromJson != null) {
                            arrayList.add(buildFromJson);
                        }
                    }
                    serverAccessApplyOrderResponse.setOrderList(arrayList);
                }
            } catch (JSONException e) {
                LogX.e("ServerAccessApplyOrderTask readSuccessResponse, JSONException");
                serverAccessApplyOrderResponse.returnCode = -99;
            }
        }
        return serverAccessApplyOrderResponse;
    }
}
