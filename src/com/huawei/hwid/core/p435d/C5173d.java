package com.huawei.hwid.core.p435d;

import com.huawei.hwid.core.p435d.p437b.C5165e;

/* compiled from: DataAnalyseUtil */
public class C5173d {
    private static boolean f18626a = false;
    private static boolean f18627b = false;
    private static String f18628c = "";

    public static boolean m24992a() {
        C5165e.m24904a("DataAnalyseUtil", "overSeaUniversalFlag is " + f18627b);
        return f18627b;
    }

    public static synchronized boolean m24993b() {
        boolean z;
        synchronized (C5173d.class) {
            z = f18626a;
        }
        return z;
    }

    public static void m24991a(String str) {
        f18628c = str;
    }

    public static String m24994c() {
        return f18628c;
    }
}
