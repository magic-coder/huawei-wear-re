package com.huawei.hwcommonmodel.datatypes;

import java.util.ArrayList;
import java.util.List;

/* compiled from: TLVTransfer */
public class C4755v {
    public List<C4755v> f17339a;
    private int f17340b;
    private String f17341c;
    private String f17342d;

    public C4755v(int i, String str, String str2) {
        this.f17340b = i;
        this.f17342d = str2;
        this.f17341c = str;
    }

    public C4755v() {
        this.f17339a = new ArrayList();
    }

    public int m22736a() {
        return this.f17340b;
    }

    public String m22738b() {
        return this.f17342d;
    }

    public void m22737a(String str) {
        this.f17342d = str;
    }

    public String m22740c() {
        return this.f17341c;
    }

    public void m22739b(String str) {
        this.f17341c = str;
    }
}
