package com.huawei.appmarket.p348a.p352d;

import java.io.Serializable;
import java.util.Comparator;

public class C4220c implements Serializable, Comparator<C4220c> {
    protected int f15837a;
    public C4223f f15838b = C4223f.NOT_HANDLER;
    public Object f15839c;
    public int f15840d;
    public boolean f15841e = false;
    public String f15842f;
    public String f15843g;
    public C4224g f15844h = C4224g.INSTALL;
    public C4218a f15845i;
    public int f15846j = -1;
    public boolean f15847k = false;

    protected C4220c() {
    }

    protected C4220c(String str, String str2, Object obj) {
        this.f15843g = str2;
        this.f15842f = str;
        this.f15839c = obj;
    }

    public int m20494a(C4220c c4220c, C4220c c4220c2) {
        return (!c4220c.m20496b() && c4220c.f15837a > c4220c2.f15837a) ? 1 : -1;
    }

    protected void m20495a() {
        this.f15837a = -1;
    }

    protected boolean m20496b() {
        return this.f15837a == -1;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m20494a((C4220c) obj, (C4220c) obj2);
    }

    public String toString() {
        return getClass().getName() + " {\n\tindex: " + this.f15837a + "\n\tstatus: " + this.f15838b + "\n\tparam: " + (this.f15839c == null ? "null" : this.f15839c.toString()) + "\n\tmFlag: " + this.f15840d + "\n\tpackageName: " + this.f15842f + "\n\tpath: " + this.f15843g + "\n\tprocessType: " + this.f15844h + "\n}";
    }
}
