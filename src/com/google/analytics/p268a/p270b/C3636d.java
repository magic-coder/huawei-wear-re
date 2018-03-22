package com.google.analytics.p268a.p270b;

import com.google.tagmanager.p271a.p272a.C3633a;

/* compiled from: Serving */
public final class C3636d extends C3633a {
    public static final C3636d[] f13975a = new C3636d[0];
    public String f13976b = "";
    public long f13977c = 0;
    public long f13978d = 2147483647L;
    public boolean f13979e = false;
    public long f13980f = 0;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        if (r7 != r6) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r7 instanceof com.google.analytics.p268a.p270b.C3636d;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r7 = (com.google.analytics.p268a.p270b.C3636d) r7;
        r2 = r6.f13976b;
        if (r2 != 0) goto L_0x003d;
    L_0x0011:
        r2 = r7.f13976b;
        if (r2 != 0) goto L_0x003b;
    L_0x0015:
        r2 = r6.f13977c;
        r4 = r7.f13977c;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x003b;
    L_0x001d:
        r2 = r6.f13978d;
        r4 = r7.f13978d;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x003b;
    L_0x0025:
        r2 = r6.f13979e;
        r3 = r7.f13979e;
        if (r2 != r3) goto L_0x003b;
    L_0x002b:
        r2 = r6.f13980f;
        r4 = r7.f13980f;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x003b;
    L_0x0033:
        r2 = r6.s;
        if (r2 != 0) goto L_0x0048;
    L_0x0037:
        r2 = r7.s;
        if (r2 == 0) goto L_0x0004;
    L_0x003b:
        r0 = r1;
        goto L_0x0004;
    L_0x003d:
        r2 = r6.f13976b;
        r3 = r7.f13976b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003b;
    L_0x0047:
        goto L_0x0015;
    L_0x0048:
        r2 = r6.s;
        r3 = r7.s;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003b;
    L_0x0052:
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.a.b.d.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f13979e ? 1 : 2) + (((((((this.f13976b == null ? 0 : this.f13976b.hashCode()) + 527) * 31) + ((int) (this.f13977c ^ (this.f13977c >>> 32)))) * 31) + ((int) (this.f13978d ^ (this.f13978d >>> 32)))) * 31)) * 31) + ((int) (this.f13980f ^ (this.f13980f >>> 32)))) * 31;
        if (this.s != null) {
            i = this.s.hashCode();
        }
        return hashCode + i;
    }
}
