package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import com.huawei.hms.support.api.entity.pay.HwPayConstant;
import com.huawei.nfc.carrera.server.card.request.WipeAllCUPCardRequest;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.nfc.carrera.util.StringUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class WipeAllCUPCardTask extends BaseReportTask<WipeAllCUPCardRequest> {
    private static final String WIPE_ALL_CUP_CARD_COMMANDER = "wipe.device";

    public WipeAllCUPCardTask(Context context, String str) {
        super(context, str);
    }

    protected String prepareRequestStr(WipeAllCUPCardRequest wipeAllCUPCardRequest) {
        if (wipeAllCUPCardRequest == null || StringUtil.isEmpty(wipeAllCUPCardRequest.getSrcTransactionID(), true) || StringUtil.isEmpty(wipeAllCUPCardRequest.getMerchantID(), true)) {
            LogX.d("prepareRequestStr, params invalid.");
            return null;
        }
        return JSONHelper.createRequestStr(wipeAllCUPCardRequest.getMerchantID(), wipeAllCUPCardRequest.getRsaKeyIndex(), createDataStr(JSONHelper.createHeaderStr(wipeAllCUPCardRequest.getSrcTransactionID(), WIPE_ALL_CUP_CARD_COMMANDER, true), wipeAllCUPCardRequest), this.mContext);
    }

    private JSONObject createDataStr(JSONObject jSONObject, WipeAllCUPCardRequest wipeAllCUPCardRequest) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("createDataStr headerStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("header", jSONObject);
            jSONObject2.put(HwPayConstant.KEY_REQUESTID, "" + System.currentTimeMillis());
            if (!StringUtil.isEmpty(wipeAllCUPCardRequest.cplc, true)) {
                jSONObject2.put("cplc", wipeAllCUPCardRequest.cplc);
            }
            if (!StringUtil.isEmpty(wipeAllCUPCardRequest.event, true)) {
                jSONObject2.put("event", wipeAllCUPCardRequest.event);
            }
        } catch (JSONException e) {
            LogX.e("createDataStr, params invalid.");
            jSONObject2 = null;
        }
        return jSONObject2;
    }
}
