package com.huawei.pluginmessagecenter.p499a;

/* compiled from: HttpUtils */
class C5860f {
    private int f20122a;
    private String f20123b;
    private String f20124c;

    public C5860f(int i, String str, String str2) {
        this.f20122a = i;
        this.f20123b = str;
        this.f20124c = str2;
    }

    public int m27019a() {
        return this.f20122a;
    }

    public String m27020b() {
        return this.f20124c;
    }

    public String toString() {
        return "HttpResResult{mResultCode=" + this.f20122a + ", mResultDesc='" + this.f20123b + '\'' + ", mMessages='" + this.f20124c + '\'' + '}';
    }
}
