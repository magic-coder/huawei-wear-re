package com.huawei.coresleepresult.p381a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: SleepCalcFrame */
public class C4360b {
    private long f16203a;
    private long f16204b;
    private long f16205c;
    private int f16206d;
    private int f16207e;
    private long f16208f;
    private float f16209g;
    private int f16210h;
    private int f16211i;
    private int f16212j;
    private int f16213k;
    private int f16214l;
    private int f16215m;
    private int f16216n;
    private int f16217o;
    private int f16218p;

    public void m20957a(long j) {
        this.f16203a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m20954a() {
        return ((Long) C0978h.a(Long.valueOf(this.f16203a))).longValue();
    }

    public void m20960b(long j) {
        this.f16204b = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m20958b() {
        return ((Long) C0978h.a(Long.valueOf(this.f16204b))).longValue();
    }

    public void m20963c(long j) {
        this.f16205c = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m20961c() {
        return ((Long) C0978h.a(Long.valueOf(this.f16205c))).longValue();
    }

    public void m20956a(int i) {
        this.f16206d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m20964d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16206d))).intValue();
    }

    public void m20959b(int i) {
        this.f16207e = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m20967e() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16207e))).intValue();
    }

    public void m20966d(long j) {
        this.f16208f = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m20969f() {
        return ((Long) C0978h.a(Long.valueOf(this.f16208f))).longValue();
    }

    public void m20955a(float f) {
        this.f16209g = ((Float) C0978h.a(Float.valueOf(f))).floatValue();
    }

    public float m20970g() {
        return ((Float) C0978h.a(Float.valueOf(this.f16209g))).floatValue();
    }

    public void m20962c(int i) {
        this.f16210h = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m20971h() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16210h))).intValue();
    }

    public void m20965d(int i) {
        this.f16217o = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m20972i() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16217o))).intValue();
    }

    public void m20968e(int i) {
        this.f16218p = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m20973j() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f16218p))).intValue();
    }

    public String toString() {
        return "SleepCalcFrame{startTime=" + this.f16203a + "fallAsleepTime=" + this.f16204b + "wakeUpTime=" + this.f16205c + "sleepScore=" + this.f16206d + "sleepLatency=" + this.f16207e + "goBedTime=" + this.f16208f + "validData=" + this.f16209g + "sleepEfficiency=" + this.f16210h + "aWakeTime=" + this.f16215m + "lightSleepTime=" + this.f16211i + "deepSleepTime=" + this.f16212j + "dreamTime=" + this.f16213k + "allSleepTime=" + this.f16214l + "wakeUpCnt=" + this.f16216n + "deepSleepPart=" + this.f16217o + "snoreFreq=" + this.f16218p;
    }
}
