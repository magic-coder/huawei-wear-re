package com.google.analytics.p268a.p270b;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import com.google.tagmanager.p271a.p272a.C3633a;
import com.google.tagmanager.p271a.p272a.C3674d;

/* compiled from: Serving */
public final class C3639g extends C3633a {
    public static final C3639g[] f13988a = new C3639g[0];
    public String[] f13989b = C3674d.f14234j;
    public String[] f13990c = C3674d.f14234j;
    public C3644b[] f13991d = C3644b.f14025a;
    public C3638f[] f13992e = C3638f.f13985a;
    public C3635c[] f13993f = C3635c.f13969a;
    public C3635c[] f13994g = C3635c.f13969a;
    public C3635c[] f13995h = C3635c.f13969a;
    public C3640h[] f13996i = C3640h.f14006a;
    public String f13997j = "";
    public String f13998k = "";
    public String f13999l = "0";
    public String f14000m = "";
    public C3634b f14001n = null;
    public float f14002o = 0.0f;
    public boolean f14003p = false;
    public String[] f14004q = C3674d.f14234j;
    public int f14005r = 0;

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
        r2 = r5 instanceof com.google.analytics.p268a.p270b.C3639g;
        if (r2 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
        goto L_0x0004;
    L_0x000b:
        r5 = (com.google.analytics.p268a.p270b.C3639g) r5;
        r2 = r4.f13989b;
        r3 = r5.f13989b;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x0017:
        r2 = r4.f13990c;
        r3 = r5.f13990c;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x0021:
        r2 = r4.f13991d;
        r3 = r5.f13991d;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x002b:
        r2 = r4.f13992e;
        r3 = r5.f13992e;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x0035:
        r2 = r4.f13993f;
        r3 = r5.f13993f;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x003f:
        r2 = r4.f13994g;
        r3 = r5.f13994g;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x0049:
        r2 = r4.f13995h;
        r3 = r5.f13995h;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x0053:
        r2 = r4.f13996i;
        r3 = r5.f13996i;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x005d:
        r2 = r4.f13997j;
        if (r2 != 0) goto L_0x00ae;
    L_0x0061:
        r2 = r5.f13997j;
        if (r2 != 0) goto L_0x00ab;
    L_0x0065:
        r2 = r4.f13998k;
        if (r2 != 0) goto L_0x00b9;
    L_0x0069:
        r2 = r5.f13998k;
        if (r2 != 0) goto L_0x00ab;
    L_0x006d:
        r2 = r4.f13999l;
        if (r2 != 0) goto L_0x00c4;
    L_0x0071:
        r2 = r5.f13999l;
        if (r2 != 0) goto L_0x00ab;
    L_0x0075:
        r2 = r4.f14000m;
        if (r2 != 0) goto L_0x00cf;
    L_0x0079:
        r2 = r5.f14000m;
        if (r2 != 0) goto L_0x00ab;
    L_0x007d:
        r2 = r4.f14001n;
        if (r2 != 0) goto L_0x00da;
    L_0x0081:
        r2 = r5.f14001n;
        if (r2 != 0) goto L_0x00ab;
    L_0x0085:
        r2 = r4.f14002o;
        r3 = r5.f14002o;
        r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1));
        if (r2 != 0) goto L_0x00ab;
    L_0x008d:
        r2 = r4.f14003p;
        r3 = r5.f14003p;
        if (r2 != r3) goto L_0x00ab;
    L_0x0093:
        r2 = r4.f14004q;
        r3 = r5.f14004q;
        r2 = java.util.Arrays.equals(r2, r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x009d:
        r2 = r4.f14005r;
        r3 = r5.f14005r;
        if (r2 != r3) goto L_0x00ab;
    L_0x00a3:
        r2 = r4.s;
        if (r2 != 0) goto L_0x00e5;
    L_0x00a7:
        r2 = r5.s;
        if (r2 == 0) goto L_0x0004;
    L_0x00ab:
        r0 = r1;
        goto L_0x0004;
    L_0x00ae:
        r2 = r4.f13997j;
        r3 = r5.f13997j;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x00b8:
        goto L_0x0065;
    L_0x00b9:
        r2 = r4.f13998k;
        r3 = r5.f13998k;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x00c3:
        goto L_0x006d;
    L_0x00c4:
        r2 = r4.f13999l;
        r3 = r5.f13999l;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x00ce:
        goto L_0x0075;
    L_0x00cf:
        r2 = r4.f14000m;
        r3 = r5.f14000m;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x00d9:
        goto L_0x007d;
    L_0x00da:
        r2 = r4.f14001n;
        r3 = r5.f14001n;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x00e4:
        goto L_0x0085;
    L_0x00e5:
        r2 = r4.s;
        r3 = r5.s;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00ab;
    L_0x00ef:
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.analytics.a.b.g.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i;
        int i2;
        int i3 = 0;
        if (this.f13989b == null) {
            i = 527;
        } else {
            i = 17;
            for (i2 = 0; i2 < this.f13989b.length; i2++) {
                i = (this.f13989b[i2] == null ? 0 : this.f13989b[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13990c == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13990c.length; i2++) {
                i = (this.f13990c[i2] == null ? 0 : this.f13990c[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13991d == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13991d.length; i2++) {
                i = (this.f13991d[i2] == null ? 0 : this.f13991d[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13992e == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13992e.length; i2++) {
                i = (this.f13992e[i2] == null ? 0 : this.f13992e[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13993f == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13993f.length; i2++) {
                i = (this.f13993f[i2] == null ? 0 : this.f13993f[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13994g == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13994g.length; i2++) {
                i = (this.f13994g[i2] == null ? 0 : this.f13994g[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13995h == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13995h.length; i2++) {
                i = (this.f13995h[i2] == null ? 0 : this.f13995h[i2].hashCode()) + (i * 31);
            }
        }
        if (this.f13996i == null) {
            i *= 31;
        } else {
            for (i2 = 0; i2 < this.f13996i.length; i2++) {
                i = (this.f13996i[i2] == null ? 0 : this.f13996i[i2].hashCode()) + (i * 31);
            }
        }
        i2 = (this.f14003p ? 1 : 2) + (((((this.f14001n == null ? 0 : this.f14001n.hashCode()) + (((this.f14000m == null ? 0 : this.f14000m.hashCode()) + (((this.f13999l == null ? 0 : this.f13999l.hashCode()) + (((this.f13998k == null ? 0 : this.f13998k.hashCode()) + (((this.f13997j == null ? 0 : this.f13997j.hashCode()) + (i * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + Float.floatToIntBits(this.f14002o)) * 31);
        if (this.f14004q == null) {
            i = i2 * 31;
        } else {
            i = i2;
            for (i2 = 0; i2 < this.f14004q.length; i2++) {
                i = (this.f14004q[i2] == null ? 0 : this.f14004q[i2].hashCode()) + (i * 31);
            }
        }
        i2 = ((i * 31) + this.f14005r) * 31;
        if (this.s != null) {
            i3 = this.s.hashCode();
        }
        return i2 + i3;
    }
}
