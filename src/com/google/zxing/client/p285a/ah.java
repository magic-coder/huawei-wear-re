package com.google.zxing.client.p285a;

/* compiled from: WifiParsedResult */
public final class ah extends C3743q {
    private final String f14561a;
    private final String f14562b;
    private final String f14563c;
    private final boolean f14564d;

    public ah(String str, String str2, String str3, boolean z) {
        super(C3759r.WIFI);
        this.f14561a = str2;
        this.f14562b = str;
        this.f14563c = str3;
        this.f14564d = z;
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(80);
        C3743q.m18840a(this.f14561a, stringBuilder);
        C3743q.m18840a(this.f14562b, stringBuilder);
        C3743q.m18840a(this.f14563c, stringBuilder);
        C3743q.m18840a(Boolean.toString(this.f14564d), stringBuilder);
        return stringBuilder.toString();
    }
}
