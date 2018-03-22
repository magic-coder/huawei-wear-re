package com.huawei.nfc.carrera.server.card.impl;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.nfc.carrera.logic.ese.impl.ESEInfoManager;
import com.huawei.nfc.carrera.util.LogX;
import com.huawei.wallet.utils.log.LogC;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONHelper {
    public static final String APPID = "com.huawei.bone";
    public static final String CARD_SERVER_NEW_PROTOCAL_VERSION = "1.1";
    public static final String CARD_SERVER_PROTOCAL_VERSION = "1.0";
    public static final int DEVICE_TYPE = 0;

    static JSONObject createHeaderStr(String str, String str2, boolean z) {
        if (str2 == null) {
            return null;
        }
        JSONObject jSONObject;
        LogX.d("createHeaderStr commandStr : " + str2, true);
        ESEInfoManager instance = ESEInfoManager.getInstance(BaseApplication.b());
        String deviceSN = instance.getDeviceSN();
        String deviceModel = instance.getDeviceModel();
        try {
            jSONObject = new JSONObject();
            jSONObject.put("srcTranID", str);
            if (z) {
                jSONObject.put("version", "1.1");
                jSONObject.put("serviceTokenAuth", createServiceTokenAuthStr(deviceSN, deviceModel));
            } else {
                jSONObject.put("version", "1.0");
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
            jSONObject.put("commander", str2);
        } catch (JSONException e) {
            LogX.e("createHeaderObject, params invalid.");
            jSONObject = null;
        }
        return jSONObject;
    }

    static String createRequestStr(String str, int i, JSONObject jSONObject, Context context) {
        if (jSONObject == null) {
            return null;
        }
        JSONObject jSONObject2;
        LogX.d("prepareRequestStr dataStr : " + jSONObject.toString(), true);
        try {
            jSONObject2 = new JSONObject();
            jSONObject2.put("merchantID", str);
            jSONObject2.put("keyIndex", i);
            jSONObject2.put("data", jSONObject.toString());
        } catch (JSONException e) {
            LogX.e("createRequestStr, params invalid.");
            jSONObject2 = null;
        }
        if (jSONObject2 != null) {
            return jSONObject2.toString();
        }
        return null;
    }

    public static String getStringValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject == null || !jSONObject.has(str)) {
            return null;
        }
        return jSONObject.getString(str);
    }

    public static long getLongValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getLong(str);
        }
        return -1;
    }

    public static int getIntValue(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has(str)) {
            return jSONObject.getInt(str);
        }
        return -1;
    }

    public static JSONObject createServiceTokenAuthStr(String str, String str2) {
        a a = a.a(null);
        if (TextUtils.isEmpty(a.c())) {
            LogC.m28530b("createServiceTokenAuthStr, accountInfo invalid.", false);
            return null;
        }
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject();
            jSONObject.put("userid", a.c());
            jSONObject.put("serviceToken", a.g());
            jSONObject.put("appID", "com.huawei.bone");
            jSONObject.put("deviceID", str);
            jSONObject.put("deviceType", 0);
            jSONObject.put("terminalType", str2);
            jSONObject.put("stSite", a.e() + "");
        } catch (JSONException e) {
            LogC.m28530b("createServiceTokenAuthStr, accountInfo invalid.", false);
            jSONObject = null;
        }
        return jSONObject;
    }
}
