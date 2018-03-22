package com.huawei.p032e.p264a.p265a.p385a;

/* compiled from: SleepData */
public class C4383a {
    private long f16285a;
    private int f16286b;
    private int f16287c;

    public C4383a(long j, int i) {
        this.f16285a = j;
        this.f16287c = i;
    }

    public long m21048a() {
        return this.f16285a;
    }

    public void m21050a(long j) {
        this.f16285a = j;
    }

    public int m21051b() {
        return this.f16287c;
    }

    public void m21049a(int i) {
        this.f16287c = i;
    }

    public String toString() {
        return "SleepData [time=" + this.f16285a + ", position=" + this.f16286b + ", frequency=" + this.f16287c + "]";
    }
}
