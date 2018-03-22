package com.cmcc.sso.sdk.p013b;

import android.util.Log;

public class C0327a {
    private static int f183a = 0;
    private static int f184b = 10;

    public static void m200a(String str) {
        C0327a.m201a("CMCC_SSO_SDK", str);
    }

    public static void m201a(String str, String str2) {
        if (f183a < 3) {
            Log.d(str, str2);
        }
    }

    public static void m202b(String str) {
        C0327a.m203b("CMCC_SSO_SDK", str);
    }

    public static void m203b(String str, String str2) {
        if (f183a < 4) {
            Log.i(str, str2);
        }
    }

    public static void m204c(String str) {
        C0327a.m205c("CMCC_SSO_SDK", str);
    }

    public static void m205c(String str, String str2) {
        if (f183a < 5) {
            Log.w(str, str2);
        }
    }

    public static void m206d(String str) {
        C0327a.m207d("CMCC_SSO_SDK", str);
    }

    public static void m207d(String str, String str2) {
        if (f183a < 6) {
            Log.e(str, str2);
        }
    }
}
