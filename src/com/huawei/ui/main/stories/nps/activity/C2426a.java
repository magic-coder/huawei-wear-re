package com.huawei.ui.main.stories.nps.activity;

import android.view.View.OnClickListener;

/* compiled from: DialogActivityUtils */
public class C2426a {
    private static final String f8743a = C2426a.class.getSimpleName();
    private static C2426a f8744b;
    private String f8745c;
    private String f8746d;
    private String f8747e;
    private String f8748f;
    private OnClickListener f8749g;
    private OnClickListener f8750h;

    private C2426a() {
    }

    public static C2426a m12202a() {
        if (f8744b == null) {
            f8744b = new C2426a();
        }
        return f8744b;
    }

    public void m12203a(String str) {
        this.f8745c = str;
    }

    public String m12205b() {
        return this.f8745c;
    }

    public void m12206b(String str) {
        this.f8746d = str;
    }

    public String m12208c() {
        return this.f8746d;
    }

    public void m12204a(String str, OnClickListener onClickListener) {
        this.f8747e = str;
        this.f8749g = onClickListener;
    }

    public String m12209d() {
        return this.f8747e;
    }

    public OnClickListener m12210e() {
        return this.f8749g;
    }

    public void m12207b(String str, OnClickListener onClickListener) {
        this.f8748f = str;
        this.f8750h = onClickListener;
    }

    public String m12211f() {
        return this.f8748f;
    }

    public OnClickListener m12212g() {
        return this.f8750h;
    }
}
