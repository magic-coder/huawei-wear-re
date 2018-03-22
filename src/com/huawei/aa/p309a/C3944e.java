package com.huawei.aa.p309a;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

/* compiled from: StressRecordDetails */
public class C3944e {
    private int f15157a;
    private List<C3943d> f15158b;

    public void m19615a(int i) {
        this.f15157a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<C3943d> m19614a() {
        return (List) C0978h.a(this.f15158b);
    }

    public void m19616a(List<C3943d> list) {
        this.f15158b = (List) C0978h.a(list);
    }

    public String toString() {
        return "[StressRecordDetails : ,stressFrameIndex = " + this.f15157a + ",stressRecordDetails = " + this.f15158b.toString() + "]";
    }
}
