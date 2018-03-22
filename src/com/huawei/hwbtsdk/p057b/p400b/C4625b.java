package com.huawei.hwbtsdk.p057b.p400b;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.Arrays;

/* compiled from: BTDeviceCommand */
public class C4625b {
    private String f16888a;
    private int f16889b;
    private byte[] f16890c;
    private int f16891d;
    private boolean f16892e;
    private boolean f16893f;
    private int f16894g = -1;
    private int f16895h = 1;
    private int f16896i = 0;
    private int f16897j = 0;

    public void m22109a(String str) {
        this.f16888a = (String) C0978h.a(str);
    }

    public String m22107a() {
        return (String) C0978h.a(this.f16888a);
    }

    public void m22108a(int i) {
        this.f16889b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22112b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16889b))).intValue();
    }

    public void m22111a(byte[] bArr) {
        if (bArr != null) {
            this.f16890c = (byte[]) C0978h.a(Arrays.copyOf(bArr, bArr.length));
        }
    }

    public byte[] m22116c() {
        if (this.f16890c != null) {
            return (byte[]) C0978h.a(Arrays.copyOf(this.f16890c, this.f16890c.length));
        }
        return null;
    }

    public void m22113b(int i) {
        this.f16891d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22117d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16891d))).intValue();
    }

    public void m22110a(boolean z) {
        this.f16892e = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean m22120e() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.f16892e))).booleanValue();
    }

    public void m22115c(int i) {
        this.f16894g = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22121f() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16894g))).intValue();
    }

    public void m22114b(boolean z) {
        this.f16893f = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean m22123g() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.f16893f))).booleanValue();
    }

    public void m22118d(int i) {
        this.f16895h = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22124h() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16895h))).intValue();
    }

    public void m22119e(int i) {
        this.f16896i = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22125i() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16896i))).intValue();
    }

    public void m22122f(int i) {
        this.f16897j = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22126j() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16897j))).intValue();
    }
}
