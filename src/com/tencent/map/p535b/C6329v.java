package com.tencent.map.p535b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* compiled from: ProGuard */
public final class C6329v {
    private static C6329v f22066b;
    private Context f22067a;

    public static C6329v m29014a() {
        if (f22066b == null) {
            f22066b = new C6329v();
        }
        return f22066b;
    }

    private C6329v() {
    }

    public static Context m29015b() {
        return C6329v.m29014a().f22067a;
    }

    public static boolean m29016c() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C6329v.m29014a().f22067a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean m29017d() {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) C6329v.m29014a().f22067a.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                return activeNetworkInfo.isAvailable();
            }
        } catch (Exception e) {
        }
        return false;
    }
}
