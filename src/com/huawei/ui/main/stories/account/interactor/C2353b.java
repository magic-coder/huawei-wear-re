package com.huawei.ui.main.stories.account.interactor;

/* compiled from: AccountContext */
public class C2353b {
    private int f8507a;
    private String f8508b;
    private String f8509c;
    private String f8510d;
    private int f8511e;
    private int f8512f;
    private String f8513g;

    public int m11931a() {
        return this.f8512f;
    }

    public void m11932a(int i) {
        this.f8512f = i;
    }

    public String m11934b() {
        return this.f8509c;
    }

    public void m11933a(String str) {
        this.f8509c = str;
    }

    public void m11935b(int i) {
        this.f8511e = i;
    }

    public int m11937c() {
        return this.f8507a;
    }

    public void m11938c(int i) {
        this.f8507a = i;
    }

    public String m11940d() {
        return this.f8508b;
    }

    public void m11936b(String str) {
        this.f8508b = str;
    }

    public String m11942e() {
        return this.f8510d;
    }

    public void m11939c(String str) {
        this.f8510d = str;
    }

    public String m11943f() {
        return this.f8513g;
    }

    public void m11941d(String str) {
        this.f8513g = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AccountContext [loginType=");
        stringBuilder.append(this.f8507a);
        stringBuilder.append(", thirdToken=");
        stringBuilder.append(this.f8508b);
        stringBuilder.append(", accessToken=");
        stringBuilder.append(this.f8509c);
        stringBuilder.append(", thirdOpenId=");
        stringBuilder.append(this.f8510d);
        stringBuilder.append(", expiresIn=");
        stringBuilder.append(this.f8511e);
        stringBuilder.append(", siteId=");
        stringBuilder.append(this.f8512f);
        stringBuilder.append(", userName=");
        stringBuilder.append(this.f8513g);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
