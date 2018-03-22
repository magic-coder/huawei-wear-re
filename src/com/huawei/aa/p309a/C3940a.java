package com.huawei.aa.p309a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: RelaxRecord */
public class C3940a {
    private int f15146a;
    private int f15147b;
    private long f15148c;
    private int f15149d;

    public int m19593a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15147b))).intValue();
    }

    public void m19594a(int i) {
        this.f15147b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m19596b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15146a))).intValue();
    }

    public void m19597b(int i) {
        this.f15146a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public long m19598c() {
        return ((Long) C0978h.a(Long.valueOf(this.f15148c))).longValue();
    }

    public void m19595a(long j) {
        this.f15148c = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public int m19600d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15149d))).intValue();
    }

    public void m19599c(int i) {
        this.f15149d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "[RelaxRecord:  relaxScore = " + this.f15146a + ", relaxLength = " + this.f15147b + ", relaxTime = " + this.f15148c + ", relaxType = " + this.f15149d + "]";
    }
}
