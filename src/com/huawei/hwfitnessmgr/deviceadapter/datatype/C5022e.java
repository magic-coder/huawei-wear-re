package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import java.util.List;

/* compiled from: DataRealtimeFramePageList */
public class C5022e {
    private int f18209a;
    private List<Integer> f18210b;

    public int m24204a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18209a))).intValue();
    }

    public void m24205a(int i) {
        this.f18209a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<Integer> m24207b() {
        return (List) C0978h.a(this.f18210b);
    }

    public void m24206a(List<Integer> list) {
        this.f18210b = (List) C0978h.a(list);
    }
}
