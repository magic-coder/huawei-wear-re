package com.huawei.uploadlog.p188c;

import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager.WakeLock;
import android.util.LongSparseArray;

/* compiled from: CommonConstants */
public class C2507c {
    public static final Object f8987a = new Object();
    private static int f8988b = 0;
    private static int f8989c = 0;
    private static int f8990d = -1;
    private static WakeLock f8991e = null;
    private static WifiLock f8992f = null;
    private static LongSparseArray<Integer> f8993g = new LongSparseArray();
    private static String f8994h = "CdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIsDQJGfmGLh8t4TlOI+ub1a3FHAbs2G6goTa/hOtL1HaDDw16JRkudbN1+fG4kIA9l8ZiOZJbnHD5L/nsZWTbgPiSP+Vp3KfAk3bcGg2eqbikFLCxXeGqeen2MII";

    public static String m12456a() {
        return f8994h;
    }

    public static int m12460b() {
        return f8988b;
    }

    public static void m12457a(int i) {
        f8988b = i;
    }

    public static LongSparseArray<Integer> m12462c() {
        return f8993g;
    }

    public static WakeLock m12464d() {
        return f8991e;
    }

    public static void m12459a(WakeLock wakeLock) {
        f8991e = wakeLock;
    }

    public static WifiLock m12465e() {
        return f8992f;
    }

    public static void m12458a(WifiLock wifiLock) {
        f8992f = wifiLock;
    }

    public static int m12466f() {
        return f8989c;
    }

    public static void m12461b(int i) {
        f8989c = i;
    }

    public static int m12467g() {
        return f8990d;
    }

    public static void m12463c(int i) {
        f8990d = i;
    }

    public static String m12468h() {
        return "Ej1Nxlg";
    }
}
