package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;

/* compiled from: DataPromptContent */
public class C4739d {
    private int f17299a;
    private int f17300b;
    private ArrayList<C4741g> f17301c;
    private ArrayList<C4737b> f17302d;

    public int m22669a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17299a))).intValue();
    }

    public void m22670a(int i) {
        this.f17299a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public ArrayList<C4741g> m22672b() {
        return (ArrayList) C0978h.a(this.f17301c);
    }

    public void m22671a(ArrayList<C4741g> arrayList) {
        this.f17301c = (ArrayList) C0978h.a(arrayList);
    }

    public void m22674b(ArrayList<C4737b> arrayList) {
        this.f17302d = (ArrayList) C0978h.a(arrayList);
    }

    public int m22675c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17300b))).intValue();
    }

    public void m22673b(int i) {
        this.f17300b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }
}
