package com.huawei.coresleepresult.p381a;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;

/* compiled from: SleepStatusFrame */
public class C4362d {
    private long f16222a;
    private long f16223b;
    private ArrayList<Integer> f16224c = new ArrayList();

    public void m20980a(long j) {
        this.f16222a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m20979a() {
        return ((Long) C0978h.a(Long.valueOf(this.f16222a))).longValue();
    }

    public void m20983b(long j) {
        this.f16223b = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m20982b() {
        return ((Long) C0978h.a(Long.valueOf(this.f16223b))).longValue();
    }

    public void m20981a(ArrayList<Integer> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            this.f16224c.add(i, arrayList.get(i));
        }
    }

    public ArrayList<Integer> m20984c() {
        return this.f16224c;
    }

    public String toString() {
        return "SleepStatusFrame{startTime = " + this.f16222a + "endTime = " + this.f16223b + "statusList = " + this.f16224c.toString() + "}";
    }
}
