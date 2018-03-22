package com.google.analytics.p273b.p274a.p275a;

import com.google.tagmanager.p271a.p272a.C3633a;
import com.google.tagmanager.p271a.p272a.C3674d;

/* compiled from: TypeSystem */
public final class C3644b extends C3633a {
    public static final C3644b[] f14025a = new C3644b[0];
    public int f14026b = 1;
    public String f14027c = "";
    public C3644b[] f14028d = f14025a;
    public C3644b[] f14029e = f14025a;
    public C3644b[] f14030f = f14025a;
    public String f14031g = "";
    public String f14032h = "";
    public long f14033i = 0;
    public boolean f14034j = false;
    public C3644b[] f14035k = f14025a;
    public String f14036l = "";
    public int[] f14037m = C3674d.f14229e;
    public boolean f14038n = false;

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
        r2 = r7 instanceof com.google.analytics.p273b.p274a.p275a.C3644b;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r7 = (com.google.analytics.p273b.p274a.p275a.C3644b) r7;
        r2 = r6.f14026b;
        r3 = r7.f14026b;
        if (r2 != r3) goto L_0x0081;
    L_0x0013:
        r2 = r6.f14027c;
        if (r2 != 0) goto L_0x0083;
    L_0x0017:
        r2 = r7.f14027c;
        if (r2 != 0) goto L_0x0081;
    L_0x001b:
        r2 = r6.f14028d;
        r3 = r7.f14028d;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x0081;
    L_0x0025:
        r2 = r6.f14029e;
        r3 = r7.f14029e;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x0081;
    L_0x002f:
        r2 = r6.f14030f;
        r3 = r7.f14030f;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x0081;
    L_0x0039:
        r2 = r6.f14031g;
        if (r2 != 0) goto L_0x008e;
    L_0x003d:
        r2 = r7.f14031g;
        if (r2 != 0) goto L_0x0081;
    L_0x0041:
        r2 = r6.f14032h;
        if (r2 != 0) goto L_0x0099;
    L_0x0045:
        r2 = r7.f14032h;
        if (r2 != 0) goto L_0x0081;
    L_0x0049:
        r2 = r6.f14033i;
        r4 = r7.f14033i;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 != 0) goto L_0x0081;
    L_0x0051:
        r2 = r6.f14034j;
        r3 = r7.f14034j;
        if (r2 != r3) goto L_0x0081;
    L_0x0057:
        r2 = r6.f14035k;
        r3 = r7.f14035k;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x0081;
    L_0x0061:
        r2 = r6.f14036l;
        if (r2 != 0) goto L_0x00a4;
    L_0x0065:
        r2 = r7.f14036l;
        if (r2 != 0) goto L_0x0081;
    L_0x0069:
        r2 = r6.f14037m;
        r3 = r7.f14037m;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x0081;
    L_0x0073:
        r2 = r6.f14038n;
        r3 = r7.f14038n;
        if (r2 != r3) goto L_0x0081;
    L_0x0079:
        r2 = r6.s;
        if (r2 != 0) goto L_0x00af;
    L_0x007d:
        r2 = r7.s;
        if (r2 == 0) goto L_0x0004;
    L_0x0081:
        r0 = r1;
        goto L_0x0004;
    L_0x0083:
        r2 = r6.f14027c;
        r3 = r7.f14027c;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0081;
    L_0x008d:
        goto L_0x001b;
    L_0x008e:
        r2 = r6.f14031g;
        r3 = r7.f14031g;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0081;
    L_0x0098:
        goto L_0x0041;
    L_0x0099:
        r2 = r6.f14032h;
        r3 = r7.f14032h;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0081;
    L_0x00a3:
        goto L_0x0049;
    L_0x00a4:
        r2 = r6.f14036l;
        r3 = r7.f14036l;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0081;
    L_0x00ae:
        goto L_0x0069;
    L_0x00af:
        r2 = r6.s;
        r3 = r7.s;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x0081;
    L_0x00b9:
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.b.a.a.b.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int i2 = 1;
        int i3 = 0;
        int hashCode = (this.f14027c == null ? 0 : this.f14027c.hashCode()) + ((this.f14026b + 527) * 31);
        if (this.f14028d == null) {
            i = hashCode * 31;
        } else {
            i = hashCode;
            for (hashCode = 0; hashCode < this.f14028d.length; hashCode++) {
                i = (this.f14028d[hashCode] == null ? 0 : this.f14028d[hashCode].hashCode()) + (i * 31);
            }
        }
        if (this.f14029e == null) {
            i *= 31;
        } else {
            for (hashCode = 0; hashCode < this.f14029e.length; hashCode++) {
                i = (this.f14029e[hashCode] == null ? 0 : this.f14029e[hashCode].hashCode()) + (i * 31);
            }
        }
        if (this.f14030f == null) {
            i *= 31;
        } else {
            for (hashCode = 0; hashCode < this.f14030f.length; hashCode++) {
                i = (this.f14030f[hashCode] == null ? 0 : this.f14030f[hashCode].hashCode()) + (i * 31);
            }
        }
        i = ((((this.f14032h == null ? 0 : this.f14032h.hashCode()) + (((this.f14031g == null ? 0 : this.f14031g.hashCode()) + (i * 31)) * 31)) * 31) + ((int) (this.f14033i ^ (this.f14033i >>> 32)))) * 31;
        if (this.f14034j) {
            hashCode = 1;
        } else {
            hashCode = 2;
        }
        hashCode += i;
        if (this.f14035k == null) {
            i = hashCode * 31;
        } else {
            i = hashCode;
            for (hashCode = 0; hashCode < this.f14035k.length; hashCode++) {
                i = (this.f14035k[hashCode] == null ? 0 : this.f14035k[hashCode].hashCode()) + (i * 31);
            }
        }
        hashCode = (this.f14036l == null ? 0 : this.f14036l.hashCode()) + (i * 31);
        if (this.f14037m == null) {
            i = hashCode * 31;
        } else {
            i = hashCode;
            for (int i4 : this.f14037m) {
                i = (i * 31) + i4;
            }
        }
        hashCode = i * 31;
        if (!this.f14038n) {
            i2 = 2;
        }
        hashCode = (hashCode + i2) * 31;
        if (this.s != null) {
            i3 = this.s.hashCode();
        }
        return hashCode + i3;
    }
}
