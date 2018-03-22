package com.huawei.hwservicesmgr.datetype;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: GPSFileInfo */
public class C5362d {
    private int f19109a;
    private String f19110b;
    private int f19111c = -1;

    public int m25826a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f19109a))).intValue();
    }

    public void m25827a(int i) {
        this.f19109a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String m25829b() {
        return (String) C0978h.a(this.f19110b);
    }

    public void m25828a(String str) {
        this.f19110b = (String) C0978h.a(str);
    }

    public int m25831c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f19111c))).intValue();
    }

    public void m25830b(int i) {
        this.f19111c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
