package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.Date;

/* compiled from: StatusPoint */
public class C5029l {
    private long f18234a;
    private long f18235b;
    private int f18236c;
    private int f18237d;
    private int f18238e;

    public void m24246a(long j) {
        this.f18234a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void m24245a(int i) {
        this.f18236c = i;
        this.f18235b = this.f18234a + ((long) i);
    }

    public void m24248b(int i) {
        this.f18237d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24250c(int i) {
        this.f18238e = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long m24244a() {
        return ((Long) C0978h.a(Long.valueOf(this.f18234a))).longValue();
    }

    public long m24247b() {
        return ((Long) C0978h.a(Long.valueOf(this.f18235b))).longValue();
    }

    public int m24249c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18237d))).intValue();
    }

    public int m24251d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18238e))).intValue();
    }

    public void m24252d(int i) {
        this.f18236c += i;
        this.f18235b += (long) i;
    }

    public String toString() {
        return "StatusPoint{startTime=" + new Date(this.f18234a * 1000) + "endTime=" + new Date(this.f18235b * 1000) + ", duration=" + this.f18236c + ", type=" + this.f18237d + '}';
    }
}
