package com.huawei.aa.p309a;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

/* compiled from: RelaxRecordDetails */
public class C3941b {
    private int f15150a;
    private List<C3940a> f15151b;

    public void m19602a(int i) {
        this.f15150a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<C3940a> m19601a() {
        return (List) C0978h.a(this.f15151b);
    }

    public void m19603a(List<C3940a> list) {
        this.f15151b = (List) C0978h.a(list);
    }

    public String toString() {
        return "[RelaxRecordDetails : ,relaxFrameIndex = " + this.f15150a + ",relaxRecordDetails = " + this.f15151b.toString() + "]";
    }
}
