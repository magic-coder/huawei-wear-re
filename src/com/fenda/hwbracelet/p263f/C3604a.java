package com.fenda.hwbracelet.p263f;

import android.content.Context;
import com.huawei.p032e.p264a.p265a.p266b.C3605d;

/* compiled from: AF500HealthFactory */
public class C3604a {
    private static C3605d f13826a = null;

    public static C3605d m18086a(Context context) {
        if (f13826a == null) {
            synchronized (C3604a.class) {
                if (f13826a == null && context != null) {
                    f13826a = new C3606b(context);
                }
            }
        }
        return f13826a;
    }
}
