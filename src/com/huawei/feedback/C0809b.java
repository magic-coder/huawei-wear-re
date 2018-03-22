package com.huawei.feedback;

import android.os.Environment;

/* compiled from: FeedbackConstData */
public class C0809b {
    public static final String f1236a = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/com.huawei.lcagent/cache");
    public static final Object f1237b = new Object();
    public static final String f1238c = (Environment.getExternalStorageDirectory().getAbsolutePath() + "/phoneservice");
    private static boolean f1239d = false;
    private static int f1240e = 0;

    public static boolean m2735a() {
        return f1239d;
    }

    public static void m2734a(boolean z) {
        f1239d = z;
    }

    public static int m2736b() {
        return f1240e;
    }

    public static void m2733a(int i) {
        f1240e = i;
    }
}
