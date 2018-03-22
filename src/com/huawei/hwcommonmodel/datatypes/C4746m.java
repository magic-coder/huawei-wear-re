package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: HealthDataContent */
public class C4746m {
    private int f17323a;
    private int f17324b;
    private String f17325c;
    private String f17326d;

    public int m22707a() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.f17324b))).intValue();
    }

    public void m22708a(int i) {
        this.f17324b = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public void m22709a(String str) {
        this.f17325c = (String) C0978h.m3579a(str);
    }

    public String m22710b() {
        return (String) C0978h.m3579a(this.f17325c);
    }

    public void m22712b(String str) {
        this.f17326d = (String) C0978h.m3579a(str);
    }

    public String m22713c() {
        return (String) C0978h.m3579a(this.f17326d);
    }

    public void m22711b(int i) {
        this.f17323a = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int m22714d() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.f17323a))).intValue();
    }
}
