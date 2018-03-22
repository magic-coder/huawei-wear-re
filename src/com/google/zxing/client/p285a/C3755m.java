package com.google.zxing.client.p285a;

/* compiled from: GeoParsedResult */
public final class C3755m extends C3743q {
    private final double f14617a;
    private final double f14618b;
    private final double f14619c;
    private final String f14620d;

    C3755m(double d, double d2, double d3, String str) {
        super(C3759r.GEO);
        this.f14617a = d;
        this.f14618b = d2;
        this.f14619c = d3;
        this.f14620d = str;
    }

    public String mo4309a() {
        StringBuilder stringBuilder = new StringBuilder(20);
        stringBuilder.append(this.f14617a);
        stringBuilder.append(", ");
        stringBuilder.append(this.f14618b);
        if (this.f14619c > 0.0d) {
            stringBuilder.append(", ");
            stringBuilder.append(this.f14619c);
            stringBuilder.append('m');
        }
        if (this.f14620d != null) {
            stringBuilder.append(" (");
            stringBuilder.append(this.f14620d);
            stringBuilder.append(')');
        }
        return stringBuilder.toString();
    }
}
