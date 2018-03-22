package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DataHealthData */
public class C5018a {
    private int f18191a = 0;
    private List<C5020c> f18192b = new ArrayList();
    private List<C5021d> f18193c = new ArrayList();

    public int m24171a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18191a))).intValue();
    }

    public void m24172a(int i) {
        this.f18191a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public List<C5020c> m24174b() {
        return (List) C0978h.a(this.f18192b);
    }

    public void m24173a(List<C5020c> list) {
        this.f18192b = (List) C0978h.a(list);
    }

    public List<C5021d> m24176c() {
        return (List) C0978h.a(this.f18193c);
    }

    public void m24175b(List<C5021d> list) {
        this.f18193c = (List) C0978h.a(list);
    }
}
