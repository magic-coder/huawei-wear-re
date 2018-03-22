package com.huawei.logupload.p090c;

import android.net.wifi.WifiManager.WifiLock;
import android.os.PowerManager.WakeLock;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: CommonConstants */
public class C1102c {
    public static final Object f2274a = new Object();
    private static int f2275b = 0;
    private static int f2276c = 0;
    private static int f2277d = -1;
    private static int f2278e = -1;
    private static WakeLock f2279f = null;
    private static WifiLock f2280g = null;
    private static Map<String, Integer> f2281h = new ConcurrentHashMap();
    private static String f2282i = "EvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCYLKhv2RCG+W1RS5To1d+q7GYznfEvANriF6i+x7jVb4pigGTrgyAysI2wAWHi/MocP0SMb6qoUSltiFX5Rj2T9d4+57N8QwVec7Zpcp5Lkpl4tqOaEw5OZrKLO3QvWmOhtj8F0JD/j+0gZqhZTom97Y1vweBX6SweepVWL7akKLcpRxJe6RkNgLBdHyXd1l+GVW05kr63aKrtD8MDkK7G7U72dX920LDi+G+rVZt5ifgj4ETIv9Ltwhv1n/T05ms/3dr1oyMCnk7y3FqMII";

    public static String m4861a() {
        return f2282i;
    }

    public static int m4865b() {
        return f2275b;
    }

    public static void m4862a(int i) {
        f2275b = i;
    }

    public static Map<String, Integer> m4867c() {
        return f2281h;
    }

    public static WakeLock m4869d() {
        return f2279f;
    }

    public static void m4864a(WakeLock wakeLock) {
        f2279f = wakeLock;
    }

    public static WifiLock m4871e() {
        return f2280g;
    }

    public static void m4863a(WifiLock wifiLock) {
        f2280g = wifiLock;
    }

    public static int m4872f() {
        return f2276c;
    }

    public static void m4866b(int i) {
        f2276c = i;
    }

    public static int m4873g() {
        return f2277d;
    }

    public static void m4868c(int i) {
        f2277d = i;
    }

    public static String m4874h() {
        return "Ej1Nxlg";
    }

    public static int m4875i() {
        return f2278e;
    }

    public static void m4870d(int i) {
        f2278e = i;
    }
}
