package com.tencent.p527a.p528a.p529a.p530a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import com.sina.weibo.sdk.component.GameManager;
import com.tencent.wxop.stat.p547b.C6512g;
import org.json.JSONObject;

public final class C6243h {
    static String m28689a(Context context) {
        try {
            if (C6243h.m28692a(context, "android.permission.READ_PHONE_STATE")) {
                String deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    return deviceId;
                }
            }
            Log.i("MID", "Could not get permission of android.permission.READ_PHONE_STATE");
        } catch (Throwable th) {
            Log.w("MID", th);
        }
        return "";
    }

    private static void m28690a(String str, Throwable th) {
        Log.e("MID", str, th);
    }

    static void m28691a(JSONObject jSONObject, String str, String str2) {
        if (C6243h.m28693a(str2)) {
            jSONObject.put(str, str2);
        }
    }

    static boolean m28692a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            C6243h.m28690a("checkPermission error", th);
            return false;
        }
    }

    static boolean m28693a(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    static String m28694b(Context context) {
        if (C6243h.m28692a(context, "android.permission.ACCESS_WIFI_STATE")) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
            } catch (Exception e) {
                Log.i("MID", "get wifi address error" + e);
                return "";
            }
        }
        Log.i("MID", "Could not get permission of android.permission.ACCESS_WIFI_STATE");
        return "";
    }

    public static boolean m28695b(String str) {
        return str != null && str.trim().length() >= 40;
    }

    static String m28696c(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(C6512g.m29722b(Base64.decode(str.getBytes(GameManager.DEFAULT_CHARSET), 0)), GameManager.DEFAULT_CHARSET).trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            C6243h.m28690a("decode error", th);
            return str;
        }
    }

    static String m28697d(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(C6512g.m29720a(str.getBytes(GameManager.DEFAULT_CHARSET)), 0), GameManager.DEFAULT_CHARSET).trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            C6243h.m28690a("decode error", th);
            return str;
        }
    }
}
