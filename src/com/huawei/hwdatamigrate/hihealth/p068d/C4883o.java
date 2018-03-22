package com.huawei.hwdatamigrate.hihealth.p068d;

import android.content.Context;
import com.huawei.hwdatamigrate.hihealth.d.g;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.p190v.C2538c;

/* compiled from: StoreClient */
public class C4883o {
    private static Context f17900b;
    private static final Object f17901c = new Object();
    public C4870a f17902a;

    private C4883o() {
        this.f17902a = new C4870a();
    }

    public static C4883o m23650a(Context context) {
        C4883o c4883o;
        synchronized (f17901c) {
            f17900b = context.getApplicationContext();
            c4883o = C4885q.f17903a;
        }
        return c4883o;
    }

    public g m23654a(int i, int i2, int i3) {
        return m23652c(i, i2, i3);
    }

    private g m23652c(int i, int i2, int i3) {
        synchronized (f17901c) {
            if (i < 0 || i2 < 0 || i3 < 0) {
                C2538c.d("HiH_StoreClient", new Object[]{"getUserClient app < 0 or device < 0 or who < 0"});
                return null;
            }
            String a = C4875f.m23636a(Integer.toString(i), Integer.toString(i2), Integer.toString(i3));
            g a2 = this.f17902a.m23630a(a);
            if (a2 != null) {
                return a2;
            }
            int a3 = C4850g.m23559a(f17900b).m23561a(i2, i3, i);
            if (a3 <= 0) {
                C2538c.d("HiH_StoreClient", new Object[]{"getUserClient client <= 0 key = ", a});
                return null;
            }
            a2 = new g(i, i3, i2, a3);
            this.f17902a.m23631a(a, a2);
            C2538c.b("HiH_StoreClient", new Object[]{"getUserClient ans is ", a2});
            return a2;
        }
    }

    public int m23656b(int i, int i2, int i3) {
        return m23653d(i, i2, i3);
    }

    private int m23653d(int i, int i2, int i3) {
        synchronized (f17901c) {
            if (i < 0 || i2 < 0 || i3 < 0) {
                C2538c.d("HiH_StoreClient", new Object[]{"getAllClientID app < 0 or device < 0 or who < 0"});
                return 0;
            }
            String a = C4875f.m23636a(Integer.toString(i), Integer.toString(i2), Integer.toString(i3));
            g a2 = this.f17902a.m23630a(a);
            if (a2 != null) {
                int c = a2.c();
                return c;
            }
            int a3 = C4850g.m23559a(f17900b).m23561a(i2, i3, i);
            if (a3 <= 0) {
                C2538c.d("HiH_StoreClient", new Object[]{"getAllClientID client <= 0 key = ", a});
                return 0;
            }
            this.f17902a.m23631a(a, new g(i, i3, i2, a3));
            C2538c.c("HiH_StoreClient", new Object[]{"getAllClientID ans is ", r0});
            return a3;
        }
    }

    public void m23655a(int i, int i2, int i3, g gVar) {
        synchronized (f17901c) {
            this.f17902a.m23631a(C4875f.m23636a(Integer.toString(i), Integer.toString(i2), Integer.toString(i3)), gVar);
        }
    }
}
