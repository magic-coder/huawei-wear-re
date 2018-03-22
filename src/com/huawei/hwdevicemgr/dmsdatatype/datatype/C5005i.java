package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: LPosition */
public class C5005i {
    private int f18127a;
    private int f18128b;

    public C5005i(int i, int i2) {
        this.f18127a = i;
        this.f18128b = i2;
    }

    public int m24042a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18127a))).intValue();
    }

    public int m24043b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18128b))).intValue();
    }
}
