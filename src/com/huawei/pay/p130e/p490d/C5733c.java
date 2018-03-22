package com.huawei.pay.p130e.p490d;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* compiled from: LastTimeKeeper */
public final class C5733c extends C5731a {
    private static Map<String, C5733c> f19511a = new HashMap();
    private static final C5732b f19512b = new C5732b();
    private static final byte[] f19513h = new byte[0];
    private C5734d f19514c = new C5734d();
    private final Context f19515d;
    private final String f19516e;
    private C5735e f19517f = new C5735e();
    private final Object f19518g = new Object();

    public static C5733c m26413a(Context context, String str) {
        C5733c c5733c;
        synchronized (f19513h) {
            c5733c = (C5733c) f19511a.get(str);
            if (c5733c == null) {
                c5733c = new C5733c(context, str);
            }
            f19511a.put(str, c5733c);
        }
        return c5733c;
    }

    private C5733c(Context context, String str) {
        this.f19515d = context;
        this.f19516e = str;
    }
}
