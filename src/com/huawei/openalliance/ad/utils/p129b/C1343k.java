package com.huawei.openalliance.ad.utils.p129b;

public class C1343k {
    private StringBuilder f2922a = new StringBuilder(64);

    public static C1343k m5929a() {
        return new C1343k();
    }

    public <T> C1343k m5930a(T t) {
        if (this.f2922a != null) {
            this.f2922a.append(t);
        }
        return this;
    }

    public C1343k m5931b() {
        return m5930a(Character.valueOf('\n'));
    }

    public String m5932c() {
        if (this.f2922a == null) {
            return "";
        }
        String stringBuilder = this.f2922a.toString();
        this.f2922a = null;
        return stringBuilder;
    }

    public String toString() {
        return this.f2922a == null ? "" : this.f2922a.toString();
    }
}
