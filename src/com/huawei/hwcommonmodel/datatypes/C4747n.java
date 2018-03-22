package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: MateData */
public class C4747n {
    private int f17327a = -1;
    private int f17328b;
    private C4744k f17329c;

    public C4744k m22715a() {
        return (C4744k) C0978h.a(this.f17329c);
    }

    public void m22717a(C4744k c4744k) {
        this.f17329c = (C4744k) C0978h.a(c4744k);
    }

    public int m22718b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17328b))).intValue();
    }

    public void m22716a(int i) {
        this.f17328b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22720c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17327a))).intValue();
    }

    public void m22719b(int i) {
        this.f17327a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
