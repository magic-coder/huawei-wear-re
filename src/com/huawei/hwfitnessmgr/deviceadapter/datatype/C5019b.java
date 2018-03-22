package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: DataMotionStruct */
public class C5019b {
    private int f18194a;
    private int f18195b;
    private int f18196c;
    private int f18197d;
    private int f18198e;
    private int f18199f;

    public int m24177a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18194a))).intValue();
    }

    public void m24178a(int i) {
        this.f18194a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24179b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18195b))).intValue();
    }

    public void m24180b(int i) {
        this.f18195b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24181c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18196c))).intValue();
    }

    public void m24182c(int i) {
        this.f18196c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24183d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18197d))).intValue();
    }

    public void m24184d(int i) {
        this.f18197d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24185e() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18198e))).intValue();
    }

    public int m24187f() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18199f))).intValue();
    }

    public void m24186e(int i) {
        this.f18199f = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "DataMotionStruct{motion_type=" + this.f18194a + ", step=" + this.f18195b + ", calorie=" + this.f18196c + ", distance=" + this.f18197d + ", sleep_type=" + this.f18198e + ", start_time=" + this.f18199f + '}';
    }
}
