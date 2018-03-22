package com.huawei.hwid.openapi.p445e;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.sina.weibo.sdk.component.GameManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.apache.log4j.helpers.DateLayout;
import org.json.JSONObject;

public class C5251f {
    private static String f18884a = C5213b.f18818a;
    private static int f18885b = -1;
    private static String f18886c = "";
    private static String f18887d = "";
    private static String f18888e = "";

    public static int m25457a(Bundle bundle, String str, int i) {
        if (bundle != null) {
            try {
                i = Integer.parseInt(String.valueOf(bundle.get(str)));
            } catch (Throwable th) {
            }
        }
        return i;
    }

    public static String m25458a(Context context) {
        String b = C5251f.m25462b(context);
        if (b == null || DateLayout.NULL_DATE_FORMAT.equals(b)) {
            b = C5251f.m25464c(context);
            if (b == null) {
                b = C5251f.m25465d(context);
                if (b == null) {
                    return b;
                }
            }
        }
        return b;
    }

    public static String m25459a(Context context, String str) {
        if (-1 == f18885b) {
            f18885b = ((TelephonyManager) context.getSystemService("phone")).getPhoneType();
        }
        return 2 == f18885b ? "2" : C5251f.m25464c(context).equals(str) ? "5" : C5251f.m25465d(context).equals(str) ? "6" : "0";
    }

    public static HashMap m25460a(String str) {
        HashMap hashMap = new HashMap();
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, jSONObject.get(valueOf));
                }
            }
        } catch (Exception e) {
            C5248c.m25450d(f18884a, e.toString());
        }
        return hashMap;
    }

    public static void m25461a(Context context, String str, String str2) {
        Editor edit = C5246b.m25435a(context).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static String m25462b(Context context) {
        if (TextUtils.isEmpty(f18886c)) {
            f18886c = C5246b.m25435a(context).getString("DDID", "");
            if (TextUtils.isEmpty(f18886c)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    f18886c = telephonyManager.getDeviceId();
                }
                if (TextUtils.isEmpty(f18886c) || "unknown".equalsIgnoreCase(f18886c)) {
                    return DateLayout.NULL_DATE_FORMAT;
                }
                C5251f.m25461a(context, "DDID", f18886c);
            }
        }
        return f18886c;
    }

    public static byte[] m25463b(String str) {
        try {
            return str.getBytes(GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            C5248c.m25448b("DESEncryptor", "getBytes error:" + str, e);
            return new byte[0];
        }
    }

    public static String m25464c(Context context) {
        if (TextUtils.isEmpty(f18887d)) {
            f18887d = C5246b.m25435a(context).getString("MHID", "");
            if (TextUtils.isEmpty(f18887d)) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        f18887d = C5249d.m25452a(connectionInfo.getMacAddress() + ":Realm");
                    }
                }
                if (TextUtils.isEmpty(f18887d)) {
                    return DateLayout.NULL_DATE_FORMAT;
                }
                C5251f.m25461a(context, "MHID", f18887d);
            }
        }
        return f18887d;
    }

    public static String m25465d(Context context) {
        if (TextUtils.isEmpty(f18888e)) {
            f18887d = C5246b.m25435a(context).getString("UUID", "");
            if (TextUtils.isEmpty(f18888e)) {
                f18888e = UUID.randomUUID().toString();
                if (TextUtils.isEmpty(f18888e)) {
                    return DateLayout.NULL_DATE_FORMAT;
                }
                C5251f.m25461a(context, "UUID", f18888e);
            }
        }
        return f18888e;
    }

    public static boolean m25466e(Context context) {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            C5248c.m25449c(f18884a, "App miss permission android.permission.ACCESS_NETWORK_STATE! Some mobile's WebView don't display page!");
            return false;
        } else if (context.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
            C5248c.m25449c(f18884a, "App miss permission android.permission.INTERNET! Some mobile's WebView don't display page!");
            return false;
        } else if (-100 != C5250e.m25455b(context)) {
            return true;
        } else {
            C5248c.m25449c(f18884a, "no net work, Some mobile's WebView don't display page!");
            return false;
        }
    }
}
