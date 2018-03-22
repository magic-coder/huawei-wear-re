package com.huawei.pluginkidwatch.plugin.p152a;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p157a.C1681a;

/* compiled from: BtApiImpl */
public class C1721a {
    private C1681a f4634a;
    private Context f4635b;

    public void m8233a(Context context) {
        this.f4635b = context;
        if (this.f4634a == null) {
            this.f4634a = C1681a.m7837a(context);
        }
    }

    public C1721a(Context context) {
        this.f4635b = context;
        this.f4634a = C1681a.m7837a(context);
    }

    public void m8234a(String str, C1647c c1647c) {
        if (str != null && !"".equals(str)) {
            C1723d a = C1743x.m8322a(this.f4635b).m8323a();
            if (a != null) {
                a.m8284a(c1647c);
                return;
            }
            a = new C1723d(this.f4635b, str);
            a.m8284a(c1647c);
            C1743x.m8322a(this.f4635b).m8324a(a);
        }
    }

    public int m8232a(String str) {
        if (!this.f4634a.m7851b() || str == null || "".equals(str)) {
            return 0;
        }
        C1723d a = C1743x.m8322a(this.f4635b).m8323a();
        if (a == null || !a.m8281a().equals(str.toUpperCase())) {
            return 0;
        }
        C2538c.m12674b("BtApiImpl", "BT_device_connect_state kwDevice = " + a);
        return a.m8302i();
    }

    public void m8235a(String str, String str2) {
        if (this.f4634a.m7851b()) {
            C1723d a = C1743x.m8322a(this.f4635b).m8323a();
            C2538c.m12674b("BtApiImpl", "BT_immediate_refresh_settings macAddr = " + str);
            if (a == null) {
                if (!"".equals(str)) {
                    a = new C1723d(this.f4635b, str);
                    C1743x.m8322a(this.f4635b).m8324a(a);
                } else {
                    return;
                }
            }
            C2538c.m12674b("BtApiImpl", "BT_immediate_refresh_settings kwDevice.getImmediateRefreshState() = " + a.m8291c());
            if (10 != a.m8291c()) {
                a.m8285a(str2);
                a.m8282a(10);
                if (2 == a.m8302i()) {
                    a.m8304k();
                } else if (a.m8302i() == 0 || -1 == a.m8302i() || 3 == a.m8302i()) {
                    a.m8298f();
                }
            }
        }
    }
}
