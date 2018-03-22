package com.google.zxing.client.p285a;

/* compiled from: SMSParsedResult */
public final class C3763w extends C3743q {
    private final String[] f14637a;
    private final String[] f14638b;
    private final String f14639c;
    private final String f14640d;

    public C3763w(String str, String str2, String str3, String str4) {
        super(C3759r.SMS);
        this.f14637a = new String[]{str};
        this.f14638b = new String[]{str2};
        this.f14639c = str3;
        this.f14640d = str4;
    }

    public C3763w(String[] strArr, String[] strArr2, String str, String str2) {
        super(C3759r.SMS);
        this.f14637a = strArr;
        this.f14638b = strArr2;
        this.f14639c = str;
        this.f14640d = str2;
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(100);
        C3743q.m18841a(this.f14637a, stringBuilder);
        C3743q.m18840a(this.f14639c, stringBuilder);
        C3743q.m18840a(this.f14640d, stringBuilder);
        return stringBuilder.toString();
    }
}
