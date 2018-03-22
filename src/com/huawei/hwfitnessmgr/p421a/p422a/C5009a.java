package com.huawei.hwfitnessmgr.p421a.p422a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: LastTotalValue */
public class C5009a {
    private int f18134a = 0;
    private int f18135b = 0;
    private int f18136c = 0;
    private int f18137d = 0;
    private long f18138e;

    public int m24060a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18135b))).intValue();
    }

    public void m24061a(int i) {
        this.f18135b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24064b(int i) {
        this.f18135b += i;
    }

    public int m24063b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18136c))).intValue();
    }

    public void m24066c(int i) {
        this.f18136c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24068d(int i) {
        this.f18136c += i;
    }

    public int m24065c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18137d))).intValue();
    }

    public void m24069e(int i) {
        this.f18137d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24070f(int i) {
        this.f18137d += i;
    }

    public long m24067d() {
        return ((Long) C0978h.a(Long.valueOf(this.f18138e))).longValue();
    }

    public void m24062a(long j) {
        this.f18138e = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String toString() {
        return "LastTotalValue{sportType=" + this.f18134a + ", lastTotalSteps=" + this.f18135b + ", lastTotalCalories=" + this.f18136c + ", lastTotalDistance=" + this.f18137d + ", lastTimeStamp=" + this.f18138e + '}';
    }
}
