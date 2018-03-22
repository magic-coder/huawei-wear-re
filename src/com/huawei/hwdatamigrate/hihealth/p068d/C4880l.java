package com.huawei.hwdatamigrate.hihealth.p068d;

import android.content.Context;
import com.huawei.hwdatamigrate.hihealth.p067c.C4850g;
import com.huawei.hwdatamigrate.hihealth.p067c.bg;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: StatClients */
public class C4880l {
    private static Context f17896b;
    private static final Object f17897c = new Object();
    private C4871b f17898a;

    private C4880l() {
        synchronized (f17897c) {
            this.f17898a = new C4871b();
        }
    }

    public static C4880l m23643a(Context context) {
        C4880l c4880l;
        synchronized (f17897c) {
            f17896b = context.getApplicationContext();
            c4880l = C4882n.f17899a;
        }
        return c4880l;
    }

    public List<Integer> m23646a(int i) {
        return m23645c(i);
    }

    private List<Integer> m23645c(int i) {
        synchronized (f17897c) {
            if (i <= 0) {
                C2538c.d("Debug_StatClients", new Object[]{"getUserStatClients who <= 0 "});
                return null;
            }
            String a = C4875f.m23636a("0", Integer.toString(i), "0");
            List<Integer> a2 = this.f17898a.m23632a(a);
            if (a2 == null || a2.isEmpty()) {
                a2 = C4850g.m23559a(f17896b).m23565c(i);
                if (a2 == null || a2.isEmpty()) {
                    C2538c.d("Debug_StatClients", new Object[]{"getUserStatClients clients is null who = ", Integer.valueOf(i)});
                    return null;
                }
                this.f17898a.m23633a(a, a2);
                return a2;
            }
            return a2;
        }
    }

    public void m23648b(int i) {
        synchronized (f17897c) {
            if (i <= 0) {
                return;
            }
            List c = C4850g.m23559a(f17896b).m23565c(i);
            if (c == null || c.isEmpty()) {
                c.d("Debug_StatClients", new Object[]{"setUserStatClients clients is null who = ", Integer.valueOf(i)});
                return;
            }
            this.f17898a.m23633a(C4875f.m23636a("0", Integer.toString(i), "0"), c);
        }
    }

    public void m23647a(int i, int i2) {
        synchronized (f17897c) {
            if (i <= 0 || i2 <= 0) {
                C2538c.d("Debug_StatClients", new Object[]{"setUserDeviceStatClients who <= 0 or deviceID <= 0"});
                return;
            }
            List a = C4850g.m23559a(f17896b).m23563a(i, i2);
            if (a == null || a.isEmpty()) {
                C2538c.d("Debug_StatClients", new Object[]{"setUserDeviceStatClients clients is null who = ", Integer.valueOf(i), ",deviceID = ", Integer.valueOf(i2)});
                return;
            }
            this.f17898a.m23633a(C4875f.m23636a("0", Integer.toString(i), Integer.toString(i2)), a);
        }
    }

    public void m23649b(int i, int i2) {
        synchronized (f17897c) {
            if (i2 <= 0 || i <= 0) {
                C2538c.d("Debug_StatClients", new Object[]{"setUserAppStatClients who <= 0 or appID <= 0"});
                return;
            }
            List a = bg.m23504a(f17896b).m23506a(i2, i);
            if (a == null || a.isEmpty()) {
                C2538c.d("Debug_StatClients", new Object[]{"setUserAppStatClients clients is null who = ", Integer.valueOf(i2), ",appID = ", Integer.valueOf(i)});
                return;
            }
            this.f17898a.m23633a(C4875f.m23636a(Integer.toString(i), Integer.toString(i2), "0"), a);
        }
    }
}
