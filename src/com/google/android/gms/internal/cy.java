package com.google.android.gms.internal;

import android.content.Context;

public class cy {
    private static cy f676b = new cy();
    private cx f677a = null;

    public static cx m1181b(Context context) {
        return f676b.m1182a(context);
    }

    public synchronized cx m1182a(Context context) {
        if (this.f677a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f677a = new cx(context);
        }
        return this.f677a;
    }
}
