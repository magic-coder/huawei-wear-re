package com.google.analytics.p268a.p270b;

import com.google.tagmanager.p271a.p272a.C3633a;

/* compiled from: Serving */
public final class C3642j extends C3633a {
    public static final C3642j[] f14021a = new C3642j[0];
    public C3641i[] f14022b = C3641i.f14017a;
    public C3639g f14023c = null;
    public String f14024d = "";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r5) {
        /*
        r4 = this;
        r0 = 1;
        r1 = 0;
        if (r5 != r4) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r2 = r5 instanceof com.google.analytics.p268a.p270b.C3642j;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r5 = (com.google.analytics.p268a.p270b.C3642j) r5;
        r2 = r4.f14022b;
        r3 = r5.f14022b;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x002f;
    L_0x0017:
        r2 = r4.f14023c;
        if (r2 != 0) goto L_0x0031;
    L_0x001b:
        r2 = r5.f14023c;
        if (r2 != 0) goto L_0x002f;
    L_0x001f:
        r2 = r4.f14024d;
        if (r2 != 0) goto L_0x003c;
    L_0x0023:
        r2 = r5.f14024d;
        if (r2 != 0) goto L_0x002f;
    L_0x0027:
        r2 = r4.s;
        if (r2 != 0) goto L_0x0047;
    L_0x002b:
        r2 = r5.s;
        if (r2 == 0) goto L_0x0004;
    L_0x002f:
        r0 = r1;
        goto L_0x0004;
    L_0x0031:
        r2 = r4.f14023c;
        r3 = r5.f14023c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002f;
    L_0x003b:
        goto L_0x001f;
    L_0x003c:
        r2 = r4.f14024d;
        r3 = r5.f14024d;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002f;
    L_0x0046:
        goto L_0x0027;
    L_0x0047:
        r2 = r4.s;
        r3 = r5.s;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002f;
    L_0x0051:
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.a.b.j.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        if (this.f14022b == null) {
            i = 527;
        } else {
            i = 17;
            for (i2 = 0; i2 < this.f14022b.length; i2++) {
                i = (this.f14022b[i2] == null ? 0 : this.f14022b[i2].hashCode()) + (i * 31);
            }
        }
        i2 = ((this.f14024d == null ? 0 : this.f14024d.hashCode()) + (((this.f14023c == null ? 0 : this.f14023c.hashCode()) + (i * 31)) * 31)) * 31;
        if (this.s != null) {
            i3 = this.s.hashCode();
        }
        return i2 + i3;
    }
}
