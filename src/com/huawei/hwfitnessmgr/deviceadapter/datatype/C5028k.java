package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;
import java.util.List;

/* compiled from: StatusFrame */
public class C5028k {
    private long f18232a = 0;
    private List<C5029l> f18233b = new ArrayList();

    public List<C5029l> m24241a() {
        return (List) C0978h.a(this.f18233b);
    }

    public void m24242a(long j) {
        this.f18232a = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }

    public void m24243a(List<C5029l> list) {
        this.f18233b = (List) C0978h.a(list);
    }
}
