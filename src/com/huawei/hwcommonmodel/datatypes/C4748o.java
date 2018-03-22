package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;

/* compiled from: MsgDataPromptContent */
public class C4748o {
    private int f17330a;
    private ArrayList<MsgImage> f17331b;
    private ArrayList<MsgText> f17332c;
    private boolean f17333d;

    public C4748o(int i, ArrayList<MsgImage> arrayList, ArrayList<MsgText> arrayList2, boolean z) {
        this.f17330a = i;
        this.f17331b = arrayList;
        this.f17332c = arrayList2;
        this.f17333d = z;
    }

    public int m22721a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17330a))).intValue();
    }

    public ArrayList<MsgText> m22723b() {
        return (ArrayList) C0978h.a(this.f17332c);
    }

    public ArrayList<MsgImage> m22724c() {
        return (ArrayList) C0978h.a(this.f17331b);
    }

    public void m22722a(boolean z) {
        this.f17333d = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    public boolean m22725d() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.f17333d))).booleanValue();
    }
}
