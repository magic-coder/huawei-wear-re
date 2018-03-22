package com.huawei.ui.device.views.p174c;

import android.widget.CompoundButton.OnCheckedChangeListener;

/* compiled from: DeviceSettingFactoryListItem */
public class C2194c {
    private int f7814a = -1;
    private int f7815b = 0;
    private int f7816c = 1;
    private String f7817d = null;
    private String f7818e = null;
    private String f7819f = null;
    private boolean f7820g = false;
    private OnCheckedChangeListener f7821h = null;
    private boolean f7822i = false;
    private boolean f7823j = true;

    public void m11257a(int i) {
        this.f7814a = i;
    }

    public int m11256a() {
        return this.f7814a;
    }

    public void m11259a(String str) {
        this.f7817d = str;
    }

    public String m11261b() {
        return this.f7817d;
    }

    public String m11265c() {
        return this.f7818e;
    }

    public void m11263b(String str) {
        this.f7818e = str;
    }

    public String m11269d() {
        return this.f7819f;
    }

    public void m11267c(String str) {
        this.f7819f = str;
    }

    public int m11270e() {
        return this.f7816c;
    }

    public void m11262b(int i) {
        this.f7816c = i;
    }

    public boolean m11271f() {
        return this.f7820g;
    }

    public void m11260a(boolean z) {
        this.f7820g = z;
    }

    public boolean m11272g() {
        return this.f7822i;
    }

    public void m11264b(boolean z) {
        this.f7822i = z;
    }

    public void m11258a(OnCheckedChangeListener onCheckedChangeListener) {
        this.f7821h = onCheckedChangeListener;
    }

    public OnCheckedChangeListener m11273h() {
        return this.f7821h;
    }

    public int m11274i() {
        return this.f7815b;
    }

    public void m11266c(int i) {
        this.f7815b = i;
    }

    public boolean m11275j() {
        return this.f7823j;
    }

    public void m11268c(boolean z) {
        this.f7823j = z;
    }

    public String toString() {
        return "DeviceSettingFactoryListItem [ID=" + this.f7814a + ", mContent=" + this.f7817d + ", mSubContent=" + this.f7818e + ", mRightText=" + this.f7819f + ", mChecked=" + this.f7820g + ", mType=" + this.f7816c + "]";
    }
}
