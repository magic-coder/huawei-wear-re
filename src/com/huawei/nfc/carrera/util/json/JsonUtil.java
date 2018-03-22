package com.huawei.nfc.carrera.util.json;

import com.huawei.nfc.carrera.util.LogX;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class JsonUtil {
    private static final String TAG = "JsonUtil";

    private JsonUtil() {
    }

    public static String getStringValue(JSONObject jSONObject, String str) {
        String str2 = null;
        if (!jSONObject.isNull(str)) {
            try {
                str2 = jSONObject.getString(str);
            } catch (JSONException e) {
            }
        }
        return str2;
    }

    public static int getIntValue(JSONObject jSONObject, String str, int i) {
        if (!jSONObject.isNull(str)) {
            try {
                i = jSONObject.getInt(str);
            } catch (JSONException e) {
            }
        }
        return i;
    }

    public static long getLongValue(JSONObject jSONObject, String str, long j) {
        if (!jSONObject.isNull(str)) {
            try {
                j = jSONObject.getLong(str);
            } catch (JSONException e) {
            }
        }
        return j;
    }

    public static JSONArray getJsonArray(JSONObject jSONObject, String str) {
        if (!(jSONObject == null || jSONObject.isNull(str))) {
            try {
                return jSONObject.getJSONArray(str);
            } catch (Exception e) {
                LogX.d(TAG, "getJsonArray failed:" + str);
            }
        }
        return null;
    }

    public static double getDoubleValue(JSONObject jSONObject, String str) {
        double d = 0.0d;
        if (!jSONObject.isNull(str)) {
            try {
                d = jSONObject.getDouble(str);
            } catch (JSONException e) {
                LogX.d(TAG, "getDoubleValue failed.");
            }
        }
        return d;
    }

    public static JSONObject getJsonObject(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = null;
        try {
            jSONObject2 = jSONObject.getJSONObject(str);
        } catch (Throwable e) {
            LogX.w("getJsonObject error:" + str, e);
        }
        return jSONObject2;
    }

    public static ArrayList<String> getStringArrayValue(JSONObject jSONObject, String str) {
        ArrayList<String> arrayList;
        try {
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            if (jSONArray == null) {
                return null;
            }
            arrayList = new ArrayList();
            int i = 0;
            while (i < jSONArray.length()) {
                try {
                    arrayList.add(jSONArray.getString(i));
                    i++;
                } catch (JSONException e) {
                }
            }
            return arrayList;
        } catch (JSONException e2) {
            arrayList = null;
            LogX.e("getStringArrayValue, json exception.");
            return arrayList;
        }
    }
}
