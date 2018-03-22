package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: TLV */
public class C4752s {
    private String f17334a;
    private int f17335b;
    private String f17336c;

    public C4752s(String str, int i, String str2) {
        this.f17334a = str;
        this.f17335b = i;
        this.f17336c = str2;
    }

    public String m22732a() {
        return (String) C0978h.a(this.f17334a);
    }

    public String m22733b() {
        return (String) C0978h.a(this.f17336c);
    }
}
