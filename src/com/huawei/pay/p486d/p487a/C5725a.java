package com.huawei.pay.p486d.p487a;

import android.content.Context;
import com.huawei.pay.e.c.a;

/* compiled from: PayCommonContext */
public final class C5725a {
    private static C5725a f19507b;
    private static final byte[] f19508c = new byte[0];
    private Context f19509a = null;

    private C5725a() {
    }

    public static C5725a m26393a() {
        C5725a c5725a;
        synchronized (f19508c) {
            if (f19507b == null) {
                f19507b = new C5725a();
            }
            c5725a = f19507b;
        }
        return c5725a;
    }

    public void m26394a(Context context) {
        if (this.f19509a != null) {
            a.a("initBackGround applicationContext init not null!", false);
        } else if (context != null) {
            this.f19509a = context.getApplicationContext();
        } else {
            a.d("initBackGround applicationContext init failed! context==null", false);
        }
    }

    public Context m26395b() {
        return this.f19509a;
    }
}
