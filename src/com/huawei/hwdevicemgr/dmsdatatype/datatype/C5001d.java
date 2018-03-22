package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.List;

/* compiled from: DataOtaApplyReport */
public class C5001d {
    private long f18120a;
    private long f18121b;
    private List<Integer> f18122c;

    public long m24026a() {
        return ((Long) C0978h.a(Long.valueOf(this.f18120a))).longValue();
    }

    public void m24027a(long j) {
        this.f18120a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public long m24029b() {
        return ((Long) C0978h.a(Long.valueOf(this.f18121b))).longValue();
    }

    public void m24030b(long j) {
        this.f18121b = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public List<Integer> m24031c() {
        return (List) C0978h.a(this.f18122c);
    }

    public void m24028a(List<Integer> list) {
        this.f18122c = (List) C0978h.a(list);
    }
}
