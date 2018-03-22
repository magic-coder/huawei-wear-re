package com.huawei.sim.multisim;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.multisimsdk.multidevicemanager.common.a;

/* compiled from: MultiSimPairedDevice */
public class C5967r extends a {
    private int f20547a;
    private String f20548b;
    private String f20549c;
    private String f20550d;

    public void m27364a(int i) {
        this.f20547a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m27370e() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f20547a))).intValue();
    }

    public void m27365a(String str) {
        this.f20548b = (String) C0978h.a(str);
    }

    public String m27371f() {
        return (String) C0978h.a(this.f20548b);
    }

    public void m27367b(String str) {
        this.f20549c = (String) C0978h.a(str);
    }

    public String m27372g() {
        return (String) C0978h.a(this.f20549c);
    }

    public void m27369c(String str) {
        this.f20550d = (String) C0978h.a(str);
    }

    public String m27373h() {
        return (String) C0978h.a(this.f20550d);
    }

    public int m27363a() {
        return m27370e();
    }

    public String m27366b() {
        if (this.f20547a == 1) {
            return m27372g();
        }
        return m27371f();
    }

    public String m27368c() {
        return m27373h();
    }
}
