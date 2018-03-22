package com.huawei.aa.p309a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: StressRecord */
public class C3943d {
    private int f15154a;
    private long f15155b;
    private int f15156c;

    public int m19608a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15154a))).intValue();
    }

    public void m19609a(int i) {
        this.f15154a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m19611b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15156c))).intValue();
    }

    public void m19612b(int i) {
        this.f15156c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long m19613c() {
        return ((Long) C0978h.a(Long.valueOf(this.f15155b))).longValue();
    }

    public void m19610a(long j) {
        this.f15155b = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public String toString() {
        return "[StressRecord:  stressScore = " + this.f15154a + ", stressTime = " + this.f15155b + ", stressTestType = " + this.f15156c + "]";
    }
}
