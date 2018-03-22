package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.Arrays;

/* compiled from: HWOTAModuleStruct */
public class C4745l {
    private int f17318a;
    private int f17319b;
    private int f17320c;
    private String f17321d;
    private byte[] f17322e;

    public void m22705a(int i) {
        this.f17318a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m22706b(int i) {
        this.f17319b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "DataModuleStruct [moduleID=" + this.f17318a + ", moduleVersion=" + this.f17319b + ", length=" + this.f17320c + ", content=" + this.f17321d + ", buffer=" + Arrays.toString(this.f17322e) + "]";
    }
}
