package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.hwcommonmodel.fitnessdatatype.FitnessTotalData;

import java.util.ArrayList;
import java.util.List;

/* compiled from: ReverseSyncData */
public class C5025h {
    private int f18218a = 0;
    private int f18219b = 0;
    private int f18220c = 0;
    private List<FitnessTotalData> f18221d = new ArrayList();

    public void m24223a(int i) {
        this.f18218a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24225b(int i) {
        this.f18219b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24227c(int i) {
        this.f18220c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24222a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18218a))).intValue();
    }

    public int m24224b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18219b))).intValue();
    }

    public int m24226c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18220c))).intValue();
    }

    public List<FitnessTotalData> m24228d() {
        return (List) C0978h.a(this.f18221d);
    }

    public String toString() {
        return "ReverseSyncData{step=" + this.f18218a + ", calorie=" + this.f18219b + ", distance=" + this.f18220c + ", totalData=" + this.f18221d + '}';
    }
}
