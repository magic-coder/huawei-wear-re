package com.google.zxing.client.p285a;

/* compiled from: TelParsedResult */
public final class C3766z extends C3743q {
    private final String f14641a;
    private final String f14642b;
    private final String f14643c;

    public C3766z(String str, String str2, String str3) {
        super(C3759r.TEL);
        this.f14641a = str;
        this.f14642b = str2;
        this.f14643c = str3;
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(20);
        C3743q.m18840a(this.f14641a, stringBuilder);
        C3743q.m18840a(this.f14643c, stringBuilder);
        return stringBuilder.toString();
    }
}
