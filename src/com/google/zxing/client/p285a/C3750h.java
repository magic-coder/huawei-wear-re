package com.google.zxing.client.p285a;

/* compiled from: EmailAddressParsedResult */
public final class C3750h extends C3743q {
    private final String f14597a;
    private final String f14598b;
    private final String f14599c;
    private final String f14600d;

    C3750h(String str, String str2, String str3, String str4) {
        super(C3759r.EMAIL_ADDRESS);
        this.f14597a = str;
        this.f14598b = str2;
        this.f14599c = str3;
        this.f14600d = str4;
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(30);
        C3743q.m18840a(this.f14597a, stringBuilder);
        C3743q.m18840a(this.f14598b, stringBuilder);
        C3743q.m18840a(this.f14599c, stringBuilder);
        return stringBuilder.toString();
    }
}
