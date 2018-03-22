package com.google.analytics.p268a.p270b;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import com.google.tagmanager.p271a.p272a.C3633a;

/* compiled from: Serving */
public final class C3641i extends C3633a {
    public static final C3641i[] f14017a = new C3641i[0];
    public String f14018b = "";
    public C3644b f14019c = null;
    public C3637e f14020d = null;

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
        r2 = r5 instanceof com.google.analytics.p268a.p270b.C3641i;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r5 = (com.google.analytics.p268a.p270b.C3641i) r5;
        r2 = r4.f14018b;
        if (r2 != 0) goto L_0x002f;
    L_0x0011:
        r2 = r5.f14018b;
        if (r2 != 0) goto L_0x002d;
    L_0x0015:
        r2 = r4.f14019c;
        if (r2 != 0) goto L_0x003a;
    L_0x0019:
        r2 = r5.f14019c;
        if (r2 != 0) goto L_0x002d;
    L_0x001d:
        r2 = r4.f14020d;
        if (r2 != 0) goto L_0x0045;
    L_0x0021:
        r2 = r5.f14020d;
        if (r2 != 0) goto L_0x002d;
    L_0x0025:
        r2 = r4.s;
        if (r2 != 0) goto L_0x0050;
    L_0x0029:
        r2 = r5.s;
        if (r2 == 0) goto L_0x0004;
    L_0x002d:
        r0 = r1;
        goto L_0x0004;
    L_0x002f:
        r2 = r4.f14018b;
        r3 = r5.f14018b;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002d;
    L_0x0039:
        goto L_0x0015;
    L_0x003a:
        r2 = r4.f14019c;
        r3 = r5.f14019c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002d;
    L_0x0044:
        goto L_0x001d;
    L_0x0045:
        r2 = r4.f14020d;
        r3 = r5.f14020d;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002d;
    L_0x004f:
        goto L_0x0025;
    L_0x0050:
        r2 = r4.s;
        r3 = r5.s;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x002d;
    L_0x005a:
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.a.b.i.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f14020d == null ? 0 : this.f14020d.hashCode()) + (((this.f14019c == null ? 0 : this.f14019c.hashCode()) + (((this.f14018b == null ? 0 : this.f14018b.hashCode()) + 527) * 31)) * 31)) * 31;
        if (this.s != null) {
            i = this.s.hashCode();
        }
        return hashCode + i;
    }
}
