package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.Arrays;

/* compiled from: DataMetrixPrompt */
public class C4737b {
    private int f17288a;
    private int f17289b;
    private int f17290c;
    private int f17291d;
    private byte[] f17292e;

    public void m22654a(int i) {
        this.f17288a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m22656b(int i) {
        this.f17289b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m22657c(int i) {
        this.f17290c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m22658d(int i) {
        this.f17291d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m22655a(byte[] bArr) {
        if (bArr != null) {
            this.f17292e = Arrays.copyOf(bArr, bArr.length);
        }
    }
}
