package com.huawei.aa.p309a;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

/* compiled from: StressRecordIndexList */
public class C3945f {
    private int f15159a;
    private List<Integer> f15160b;

    public List<Integer> m19617a() {
        return (List) C0978h.a(this.f15160b);
    }

    public void m19619a(List<Integer> list) {
        this.f15160b = (List) C0978h.a(list);
    }

    public int m19620b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15159a))).intValue();
    }

    public void m19618a(int i) {
        this.f15159a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "[StressRecordIndexList :,stressFrameCnt = " + this.f15159a + ",stressFrameIndex = " + this.f15160b.toString() + "]";
    }
}
