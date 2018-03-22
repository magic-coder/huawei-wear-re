package com.huawei.aa.p309a;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

/* compiled from: RelaxRecordIndexList */
public class C3942c {
    private int f15152a;
    private List<Integer> f15153b;

    public List<Integer> m19604a() {
        return (List) C0978h.a(this.f15153b);
    }

    public void m19606a(List<Integer> list) {
        this.f15153b = (List) C0978h.a(list);
    }

    public int m19607b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f15152a))).intValue();
    }

    public void m19605a(int i) {
        this.f15152a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "[RelaxRecordIndexList :,relaxFrameCnt = " + this.f15152a + ",relaxFrameIndex = " + this.f15153b.toString() + "]";
    }
}
