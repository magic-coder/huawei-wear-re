package com.huawei.android.pushselfshow.richpush.p341c.p343b;

import com.huawei.android.pushagent.c.a.e;
import org.json.JSONObject;

public class C4188i {
    private static final String[] f15750a = new String[]{"OK.", "Failed to start compass.", "Can't find method.", "Service not found.", "Class not found.", "Illegal access.", "Instantiation error.", "Malformed url.", "IO error.", "Invalid action.", "Illegal parameter.", "Subject to play the file is not found.", "Supports only HTTP / HTTPS or local file.", "Play abnormal, please try again.", "Application does not exist.", "Application does not exist, thus opening the application market.", "Application market does not exist.", "NetWork provider is not available.", "GPS provider is not available.", "NetWork Provider is out of service.", "GPS Provider is out of service.", "Location API is not available for this device.", "No sensors found to register accelerometer listening to.", "Accelerometer could not be started.", "Not found Sd card.", "Error"};
    private String f15751b;
    private JSONObject f15752c = null;

    public C4188i(String str, C4189j c4189j) {
        this.f15751b = str;
        this.f15752c = m20376a(c4189j, new JSONObject());
    }

    public C4188i(String str, C4189j c4189j, JSONObject jSONObject) {
        this.f15751b = str;
        this.f15752c = m20376a(c4189j, jSONObject);
    }

    private JSONObject m20376a(C4189j c4189j, JSONObject jSONObject) {
        try {
            int ordinal = c4189j.ordinal();
            jSONObject.put("result_code", ordinal);
            jSONObject.put("result_info", f15750a[ordinal]);
            return jSONObject;
        } catch (Throwable e) {
            e.d("PushSelfShowLog", "pluginRecsult encodeMsg error ", e);
            return null;
        }
    }

    public static String[] m20377a() {
        Object obj = new String[f15750a.length];
        System.arraycopy(f15750a, 0, obj, 0, f15750a.length);
        return obj;
    }
}
