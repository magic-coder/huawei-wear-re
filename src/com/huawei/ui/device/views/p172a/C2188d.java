package com.huawei.ui.device.views.p172a;

import android.view.View.OnClickListener;

/* compiled from: SelectDeviceListItemNew */
public class C2188d {
    private String f7783a = null;
    private String[] f7784b = null;
    private int f7785c = -1;
    private int f7786d = -1;
    private OnClickListener f7787e = null;

    public int m11212a() {
        return this.f7786d;
    }

    public void m11213a(int i) {
        this.f7786d = i;
    }

    public int m11217b() {
        return this.f7785c;
    }

    public void m11218b(int i) {
        this.f7785c = i;
    }

    public String m11219c() {
        return this.f7783a;
    }

    public void m11215a(String str) {
        this.f7783a = str;
    }

    public String[] m11220d() {
        if (this.f7784b != null) {
            return (String[]) this.f7784b.clone();
        }
        return null;
    }

    public void m11216a(String[] strArr) {
        if (strArr != null) {
            this.f7784b = (String[]) strArr.clone();
        } else {
            this.f7784b = null;
        }
    }

    public OnClickListener m11221e() {
        return this.f7787e;
    }

    public void m11214a(OnClickListener onClickListener) {
        this.f7787e = onClickListener;
    }

    public String toString() {
        return "SelectDeviceListItemNew [title=" + this.f7783a + "]";
    }
}
