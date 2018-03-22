package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p359a;

public class C4240b {
    private StringBuilder f15887a = new StringBuilder(64);

    public static C4240b m20525a() {
        return new C4240b();
    }

    public <T> C4240b m20526a(T t) {
        if (this.f15887a != null) {
            this.f15887a.append(t);
        }
        return this;
    }

    public C4240b m20527b() {
        return m20526a(Character.valueOf('\n'));
    }

    public String m20528c() {
        if (this.f15887a == null) {
            return "";
        }
        String stringBuilder = this.f15887a.toString();
        this.f15887a = null;
        return stringBuilder;
    }

    public String toString() {
        return this.f15887a == null ? "" : this.f15887a.toString();
    }
}
