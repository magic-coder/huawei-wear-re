package com.google.tagmanager;

import android.content.Context;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

/* compiled from: InstallReferrerUtil */
class C3699y {
    static Map<String, String> f14358a = new HashMap();
    private static String f14359b;

    C3699y() {
    }

    static void m18622a(String str) {
        synchronized (C3699y.class) {
            f14359b = str;
        }
    }

    static void m18621a(Context context, String str) {
        bc.m18514a(context, "gtm_install_referrer", "referrer", str);
        C3699y.m18623b(context, str);
    }

    static void m18623b(Context context, String str) {
        String a = C3699y.m18620a(str, "conv");
        if (a != null && a.length() > 0) {
            f14358a.put(a, str);
            bc.m18514a(context, "gtm_click_referrers", a, str);
        }
    }

    static String m18620a(String str, String str2) {
        if (str2 != null) {
            return Uri.parse("http://hostname/?" + str).getQueryParameter(str2);
        }
        if (str.length() > 0) {
            return str;
        }
        return null;
    }
}
