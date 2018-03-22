package com.p230a.p231b.p232b;

import android.content.Context;
import com.p230a.p231b.p232b.p233a.C3115m;
import com.p230a.p231b.p232b.p233a.C3117o;
import com.p230a.p231b.p232b.p233a.p236a.C3097k;

public class C3127d {
    private static C3127d f10484a;
    private static C3117o f10485b;
    private static Context f10486c;

    private C3127d(Context context) {
        f10486c = context;
        f10485b = C3127d.m13928a();
    }

    public static C3117o m13928a() {
        if (f10485b == null) {
            f10485b = C3097k.m13837a(f10486c.getApplicationContext());
        }
        return f10485b;
    }

    public static synchronized C3127d m13929a(Context context) {
        C3127d c3127d;
        synchronized (C3127d.class) {
            if (f10484a == null) {
                f10484a = new C3127d(context);
            }
            c3127d = f10484a;
        }
        return c3127d;
    }

    public void m13930a(C3115m c3115m) {
        f10485b.m13897a(c3115m);
    }
}
