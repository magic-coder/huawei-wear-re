package com.huawei.hwcommonmodel.datatypes;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.Arrays;

/* compiled from: ESimProfile */
public class C4744k {
    private String f17309a;
    private String f17310b;
    private String f17311c;
    private String f17312d;
    private int f17313e;
    private byte[] f17314f;
    private String f17315g;
    private String f17316h;
    private String f17317i;

    public String m22692a() {
        return (String) C0978h.a(this.f17309a);
    }

    public void m22694a(String str) {
        this.f17309a = (String) C0978h.a(str);
    }

    public String m22696b() {
        return (String) C0978h.a(this.f17310b);
    }

    public void m22697b(String str) {
        this.f17310b = (String) C0978h.a(str);
    }

    public String m22698c() {
        return (String) C0978h.a(this.f17311c);
    }

    public void m22699c(String str) {
        this.f17311c = (String) C0978h.a(str);
    }

    public void m22700d(String str) {
        this.f17312d = (String) C0978h.a(str);
    }

    public void m22693a(int i) {
        this.f17313e = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public byte[] m22701d() {
        if (this.f17314f == null) {
            return null;
        }
        return (byte[]) this.f17314f.clone();
    }

    public void m22695a(byte[] bArr) {
        if (bArr == null) {
            this.f17314f = null;
        } else {
            this.f17314f = (byte[]) bArr.clone();
        }
    }

    public void m22702e(String str) {
        this.f17315g = (String) C0978h.a(str);
    }

    public void m22703f(String str) {
        this.f17316h = (String) C0978h.a(str);
    }

    public void m22704g(String str) {
        this.f17317i = (String) C0978h.a(str);
    }

    public String toString() {
        return "ESimProfile{mICCID='" + this.f17309a + '\'' + ", mSPN='" + this.f17310b + '\'' + ", mProfieName='" + this.f17311c + '\'' + ", mProfileClass='" + this.f17312d + '\'' + ", mIconType='" + this.f17313e + '\'' + ", mIcon=" + Arrays.toString(this.f17314f) + ", mConfigurationInfo='" + this.f17315g + '\'' + ", mProfileOwner='" + this.f17316h + '\'' + ", mProfilePolicyRules='" + this.f17317i + '\'' + '}';
    }
}
