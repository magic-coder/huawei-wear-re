package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: DataTextPrompt */
public class C4741g {
    private int f17303a;
    private int f17304b;
    private String f17305c;

    public int m22678a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17303a))).intValue();
    }

    public void m22679a(int i) {
        this.f17303a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m22681b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17304b))).intValue();
    }

    public void m22682b(int i) {
        this.f17304b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String m22683c() {
        return (String) C0978h.a(this.f17305c);
    }

    public void m22680a(String str) {
        this.f17305c = (String) C0978h.a(str);
    }
}
