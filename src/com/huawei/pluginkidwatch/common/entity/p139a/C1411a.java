package com.huawei.pluginkidwatch.common.entity.p139a;

import android.content.Context;
import com.huawei.pluginkidwatch.plugin.p152a.C1647c;
import com.huawei.pluginkidwatch.plugin.p152a.C1721a;

/* compiled from: BtAPI */
public class C1411a {
    private static C1411a f3219b;
    private C1721a f3220a;

    private C1411a(Context context) {
        this.f3220a = new C1721a(context);
    }

    public static C1411a m6450a(Context context) {
        C1411a c1411a;
        synchronized (C1411a.class) {
            if (f3219b == null) {
                f3219b = new C1411a(context);
            } else {
                f3219b.m6451b(context);
            }
            c1411a = f3219b;
        }
        return c1411a;
    }

    private void m6451b(Context context) {
        if (this.f3220a != null) {
            this.f3220a.m8233a(context);
        }
    }

    public void m6453a(String str, C1647c c1647c) {
        this.f3220a.m8234a(str, c1647c);
    }

    public int m6452a(String str) {
        return this.f3220a.m8232a(str);
    }

    public void m6454a(String str, String str2) {
        this.f3220a.m8235a(str, str2);
    }
}
