package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;
import java.util.List;

/* compiled from: SampleFrame */
public class C5026i {
    private long f18222a = 0;
    private List<C5027j> f18223b = new ArrayList();

    public long m24229a() {
        return ((Long) C0978h.a(Long.valueOf(this.f18222a))).longValue();
    }

    public List<C5027j> m24232b() {
        return (List) C0978h.a(this.f18223b);
    }

    public void m24230a(long j) {
        this.f18222a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void m24231a(List<C5027j> list) {
        this.f18223b = (List) C0978h.a(list);
    }
}
