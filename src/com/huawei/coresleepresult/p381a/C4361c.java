package com.huawei.coresleepresult.p381a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: SleepErrorFrame */
public class C4361c {
    private long f16219a;
    private long f16220b;
    private int f16221c;

    public void m20976a(long j) {
        this.f16219a = j;
    }

    public void m20978b(long j) {
        this.f16220b = j;
    }

    public long m20974a() {
        return ((Long) C0978h.a(Long.valueOf(this.f16220b))).longValue();
    }

    public void m20975a(int i) {
        this.f16221c = i;
    }

    public int m20977b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16221c))).intValue();
    }

    public String toString() {
        return "SleepErrorFrame{startTime = " + this.f16219a + "endTime = " + this.f16220b + "errorCode = " + this.f16221c + "}";
    }
}
