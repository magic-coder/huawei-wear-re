package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.Date;

/* compiled from: DataRawSportData */
public class C5021d {
    private long f18204a;
    private int f18205b;
    private int f18206c;
    private int f18207d;
    private int f18208e;

    public long m24194a() {
        return ((Long) C0978h.a(Long.valueOf(this.f18204a))).longValue();
    }

    public void m24196a(long j) {
        this.f18204a = ((Long) C0978h.a(Long.valueOf((j / 60) * 60))).longValue();
    }

    public int m24197b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18205b))).intValue();
    }

    public void m24195a(int i) {
        this.f18205b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24199c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18206c))).intValue();
    }

    public void m24198b(int i) {
        this.f18206c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24201d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18207d))).intValue();
    }

    public void m24200c(int i) {
        this.f18207d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24203e() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18208e))).intValue();
    }

    public void m24202d(int i) {
        this.f18208e = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "DataRawSportData{startTime=" + new Date(this.f18204a * 1000) + ", currentStatus=" + this.f18205b + ", totalSteps=" + this.f18206c + ", totalCalorie=" + this.f18207d + ", totalDistance=" + this.f18208e + '}';
    }
}
