package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: SamplePoint */
public class C5027j {
    private long f18224a;
    private int f18225b;
    private int f18226c;
    private int f18227d;
    private int f18228e;
    private int f18229f;
    private int f18230g;
    private int f18231h;

    public C5027j() {
        this.f18224a = 0;
        this.f18225b = 60;
        this.f18226c = -1;
        this.f18227d = 0;
        this.f18228e = -1;
        this.f18229f = 0;
        this.f18230g = 0;
        this.f18231h = 0;
    }

    public C5027j(int i, int i2) {
        this.f18224a = 0;
        this.f18225b = 60;
        this.f18226c = i;
        this.f18227d = i2;
        this.f18228e = -1;
        this.f18229f = 0;
        this.f18230g = 0;
        this.f18231h = 0;
    }

    public long m24233a() {
        return ((Long) C0978h.a(Long.valueOf(this.f18224a))).longValue();
    }

    public int m24236b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18225b))).intValue();
    }

    public int m24238c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18226c))).intValue();
    }

    public int m24239d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18227d))).intValue();
    }

    public int m24240e() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18230g))).intValue();
    }

    public void m24235a(long j) {
        this.f18224a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void m24234a(int i) {
        this.f18230g = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24237b(int i) {
        this.f18231h = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        String str = "Sample{startTime=" + this.f18224a + ", duration=" + this.f18225b + ", type=" + this.f18226c;
        if (this.f18226c == 6 || this.f18226c == 7) {
            str = str + ", value=xx";
        } else {
            str = str + ", value=" + this.f18227d;
        }
        return str + ", intensive=" + this.f18231h + '}';
    }
}
