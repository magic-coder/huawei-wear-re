package com.huawei.feedback.bean;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: NewFeedbackInfo */
public class C4410d implements Serializable, Cloneable {
    private int f16345a = -1;
    private String f16346b;
    private String f16347c;
    private int f16348d;
    private String f16349e;
    private String f16350f;
    private String f16351g;
    private String f16352h = "";
    private String f16353i;
    private String f16354j;
    private String f16355k;
    private int f16356l;
    private Bitmap f16357m;
    private int f16358n;
    private String f16359o;
    private int f16360p = 0;
    private String f16361q;
    private String f16362r;
    private String f16363s;
    private String f16364t;
    private boolean f16365u;
    private boolean f16366v;
    private String f16367w;
    private String f16368x;
    private int f16369y;

    public int m21187a() {
        return this.f16369y;
    }

    public void m21188a(int i) {
        this.f16369y = i;
    }

    public String m21192b() {
        return this.f16368x;
    }

    public void m21190a(String str) {
        this.f16368x = str;
    }

    public boolean m21198c() {
        return this.f16365u;
    }

    public void m21191a(boolean z) {
        this.f16365u = z;
    }

    public boolean m21201d() {
        return this.f16366v;
    }

    public void m21195b(boolean z) {
        this.f16366v = z;
    }

    public String m21202e() {
        return this.f16367w;
    }

    public void m21194b(String str) {
        this.f16367w = str;
    }

    public String m21205f() {
        return this.f16363s;
    }

    public void m21197c(String str) {
        this.f16363s = str;
    }

    public String m21208g() {
        return this.f16364t;
    }

    public void m21200d(String str) {
        this.f16364t = str;
    }

    public String m21210h() {
        return this.f16361q;
    }

    public void m21204e(String str) {
        this.f16361q = str;
    }

    public String m21212i() {
        return this.f16362r;
    }

    public void m21207f(String str) {
        this.f16362r = str;
    }

    public int m21214j() {
        return this.f16360p;
    }

    public void m21193b(int i) {
        this.f16360p = i;
    }

    public String m21216k() {
        return this.f16359o;
    }

    public void m21209g(String str) {
        this.f16359o = str;
    }

    public void m21189a(Bitmap bitmap) {
        this.f16357m = bitmap;
    }

    public String m21218l() {
        return this.f16346b;
    }

    public void m21211h(String str) {
        this.f16346b = str;
    }

    public String m21220m() {
        return this.f16347c;
    }

    public void m21213i(String str) {
        this.f16347c = str;
    }

    public String m21222n() {
        if (!TextUtils.isEmpty(this.f16352h)) {
            this.f16352h = this.f16352h.replace("-0", "/");
            this.f16352h = this.f16352h.replace("-", "/");
        }
        return this.f16352h;
    }

    public void m21215j(String str) {
        this.f16352h = str;
    }

    public int m21224o() {
        return this.f16348d;
    }

    public void m21196c(int i) {
        this.f16348d = i;
    }

    public String m21226p() {
        return this.f16349e;
    }

    public void m21217k(String str) {
        this.f16349e = str;
    }

    public String m21228q() {
        return this.f16350f;
    }

    public void m21219l(String str) {
        this.f16350f = str;
    }

    public String m21229r() {
        return this.f16353i;
    }

    public void m21221m(String str) {
        this.f16353i = str;
    }

    public int m21230s() {
        return this.f16356l;
    }

    public void m21199d(int i) {
        this.f16356l = i;
    }

    public int m21231t() {
        return this.f16345a;
    }

    public void m21203e(int i) {
        this.f16345a = i;
    }

    public String m21232u() {
        return this.f16351g;
    }

    public void m21223n(String str) {
        this.f16351g = str;
    }

    public String m21233v() {
        return this.f16354j;
    }

    public void m21225o(String str) {
        this.f16354j = str;
    }

    public String m21234w() {
        return this.f16355k;
    }

    public void m21227p(String str) {
        this.f16355k = str;
    }

    public int m21235x() {
        return this.f16358n;
    }

    public void m21206f(int i) {
        this.f16358n = i;
    }

    public Object clone() {
        return super.clone();
    }
}
