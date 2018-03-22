package com.google.zxing.p295e.p296a;

import android.support.v4.media.TransportMediator;
import com.google.zxing.C3709a;
import com.google.zxing.C3803p;
import com.google.zxing.C3880e;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.p278b.C3712a;
import com.google.zxing.p295e.C3856k;
import com.unionpay.tsmservice.data.Constant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* compiled from: RSS14Reader */
public final class C3862e extends C3857a {
    private static final int[] f14908a = new int[]{1, 10, 34, 70, TransportMediator.KEYCODE_MEDIA_PLAY};
    private static final int[] f14909b = new int[]{4, 20, 48, 81};
    private static final int[] f14910c;
    private static final int[] f14911d;
    private static final int[] f14912e = new int[]{8, 6, 4, 3, 1};
    private static final int[] f14913f = new int[]{2, 4, 6, 8};
    private static final int[][] f14914g = new int[][]{new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    private final List<C3861d> f14915h = new ArrayList();
    private final List<C3861d> f14916i = new ArrayList();

    static {
        int[] iArr = new int[5];
        iArr[1] = 161;
        iArr[2] = 961;
        iArr[3] = 2015;
        iArr[4] = 2715;
        f14910c = iArr;
        iArr = new int[4];
        iArr[1] = 336;
        iArr[2] = Constant.CALLBACK_UNITE_APP_DELETE;
        iArr[3] = 1516;
        f14911d = iArr;
    }

    public C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i {
        C3862e.m19231a(this.f14915h, m19229a(c3712a, false, i, (Map) map));
        c3712a.m18685d();
        C3862e.m19231a(this.f14916i, m19229a(c3712a, true, i, (Map) map));
        c3712a.m18685d();
        int size = this.f14915h.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3861d c3861d = (C3861d) this.f14915h.get(i2);
            if (c3861d.m19225d() > 1) {
                int size2 = this.f14916i.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    C3861d c3861d2 = (C3861d) this.f14916i.get(i3);
                    if (c3861d2.m19225d() > 1 && C3862e.m19234b(c3861d, c3861d2)) {
                        return C3862e.m19230a(c3861d, c3861d2);
                    }
                }
                continue;
            }
        }
        throw C3932i.m19565a();
    }

    private static void m19231a(Collection<C3861d> collection, C3861d c3861d) {
        if (c3861d != null) {
            Object obj;
            for (C3861d c3861d2 : collection) {
                if (c3861d2.m19219a() == c3861d.m19219a()) {
                    c3861d2.m19226e();
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null) {
                collection.add(c3861d);
            }
        }
    }

    public void mo4302a() {
        this.f14915h.clear();
        this.f14916i.clear();
    }

    private static C3934m m19230a(C3861d c3861d, C3861d c3861d2) {
        int length;
        String valueOf = String.valueOf((4537077 * ((long) c3861d.m19219a())) + ((long) c3861d2.m19219a()));
        StringBuilder stringBuilder = new StringBuilder(14);
        for (length = 13 - valueOf.length(); length > 0; length--) {
            stringBuilder.append('0');
        }
        stringBuilder.append(valueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            length = stringBuilder.charAt(i2) - 48;
            if ((i2 & 1) == 0) {
                length *= 3;
            }
            i += length;
        }
        length = 10 - (i % 10);
        if (length == 10) {
            length = 0;
        }
        stringBuilder.append(length);
        C3922o[] c = c3861d.m19224c().m19223c();
        C3922o[] c2 = c3861d2.m19224c().m19223c();
        return new C3934m(String.valueOf(stringBuilder.toString()), null, new C3922o[]{c[0], c[1], c2[0], c2[1]}, C3709a.RSS_14);
    }

    private static boolean m19234b(C3861d c3861d, C3861d c3861d2) {
        int b = (c3861d.m19220b() + (c3861d2.m19220b() * 16)) % 79;
        int a = (c3861d.m19224c().m19221a() * 9) + c3861d2.m19224c().m19221a();
        if (a > 72) {
            a--;
        }
        if (a > 8) {
            a--;
        }
        return b == a;
    }

    private C3861d m19229a(C3712a c3712a, boolean z, int i, Map<C3880e, ?> map) {
        try {
            C3803p c3803p;
            int[] a = m19233a(c3712a, 0, z);
            C3860c a2 = m19228a(c3712a, i, z, a);
            if (map == null) {
                c3803p = null;
            } else {
                c3803p = (C3803p) map.get(C3880e.NEED_RESULT_POINT_CALLBACK);
            }
            if (c3803p != null) {
                float f = ((float) (a[0] + a[1])) / 2.0f;
                if (z) {
                    f = ((float) (c3712a.m18676a() - 1)) - f;
                }
                c3803p.mo4312a(new C3922o(f, (float) i));
            }
            C3859b a3 = m19227a(c3712a, a2, true);
            C3859b a4 = m19227a(c3712a, a2, false);
            return new C3861d((a3.m19219a() * 1597) + a4.m19219a(), a3.m19220b() + (a4.m19220b() * 4), a2);
        } catch (C3932i e) {
            return null;
        }
    }

    private C3859b m19227a(C3712a c3712a, C3860c c3860c, boolean z) throws C3932i {
        int i;
        int length;
        int i2;
        int[] c = m19195c();
        c[0] = 0;
        c[1] = 0;
        c[2] = 0;
        c[3] = 0;
        c[4] = 0;
        c[5] = 0;
        c[6] = 0;
        c[7] = 0;
        if (z) {
            C3856k.m19185b(c3712a, c3860c.m19222b()[0], c);
        } else {
            C3856k.m19183a(c3712a, c3860c.m19222b()[1] + 1, c);
            i = 0;
            for (length = c.length - 1; i < length; length--) {
                i2 = c[i];
                c[i] = c[length];
                c[length] = i2;
                i++;
            }
        }
        length = z ? 16 : 15;
        float a = ((float) C3857a.m19189a(c)) / ((float) length);
        int[] f = m19198f();
        int[] g = m19199g();
        float[] d = m19196d();
        float[] e = m19197e();
        for (i = 0; i < c.length; i++) {
            float f2 = ((float) c[i]) / a;
            i2 = (int) (0.5f + f2);
            if (i2 < 1) {
                i2 = 1;
            } else if (i2 > 8) {
                i2 = 8;
            }
            int i3 = i >> 1;
            if ((i & 1) == 0) {
                f[i3] = i2;
                d[i3] = f2 - ((float) i2);
            } else {
                g[i3] = i2;
                e[i3] = f2 - ((float) i2);
            }
        }
        m19232a(z, length);
        length = f.length - 1;
        int i4 = 0;
        int i5 = 0;
        while (length >= 0) {
            i = (i4 * 9) + f[length];
            length--;
            i4 = i;
            i5 = f[length] + i5;
        }
        i2 = 0;
        i = 0;
        for (length = g.length - 1; length >= 0; length--) {
            i2 = (i2 * 9) + g[length];
            i += g[length];
        }
        i2 = i4 + (i2 * 3);
        if (z) {
            if ((i5 & 1) != 0 || i5 > 12 || i5 < 4) {
                throw C3932i.m19565a();
            }
            length = (12 - i5) / 2;
            i = f14912e[length];
            i4 = 9 - i;
            return new C3859b(((C3863f.m19238a(f, i, false) * f14908a[length]) + C3863f.m19238a(g, i4, true)) + f14910c[length], i2);
        } else if ((i & 1) != 0 || i > 10 || i < 4) {
            throw C3932i.m19565a();
        } else {
            length = (10 - i) / 2;
            i = f14913f[length];
            return new C3859b((C3863f.m19238a(f, i, true) + (C3863f.m19238a(g, 9 - i, false) * f14909b[length])) + f14911d[length], i2);
        }
    }

    private int[] m19233a(C3712a c3712a, int i, boolean z) throws C3932i {
        int[] b = m19194b();
        b[0] = 0;
        b[1] = 0;
        b[2] = 0;
        b[3] = 0;
        int a = c3712a.m18676a();
        int i2 = 0;
        int i3 = i;
        while (i3 < a) {
            boolean z2 = c3712a.m18678a(i3) ? 0 : 1;
            if (z == z2) {
                break;
            }
            i3++;
        }
        int i4 = i2;
        i2 = i3;
        i3 = 0;
        for (int i5 = i3; i5 < a; i5++) {
            if ((c3712a.m18678a(i5) ^ i4) != 0) {
                b[i3] = b[i3] + 1;
            } else {
                if (i3 != 3) {
                    i3++;
                } else if (C3857a.m19193b(b)) {
                    return new int[]{i2, i5};
                } else {
                    i2 += b[0] + b[1];
                    b[0] = b[2];
                    b[1] = b[3];
                    b[2] = 0;
                    b[3] = 0;
                    i3--;
                }
                b[i3] = 1;
                if (i4 != 0) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
            }
        }
        throw C3932i.m19565a();
    }

    private C3860c m19228a(C3712a c3712a, int i, boolean z, int[] iArr) throws C3932i {
        int a;
        boolean a2 = c3712a.m18678a(iArr[0]);
        int i2 = iArr[0] - 1;
        while (i2 >= 0 && (c3712a.m18678a(i2) ^ a2) != 0) {
            i2--;
        }
        int i3 = i2 + 1;
        i2 = iArr[0] - i3;
        Object b = m19194b();
        System.arraycopy(b, 0, b, 1, b.length - 1);
        b[0] = i2;
        int a3 = C3857a.m19190a((int[]) b, f14914g);
        int i4 = iArr[1];
        if (z) {
            a = (c3712a.m18676a() - 1) - i3;
            i4 = (c3712a.m18676a() - 1) - i4;
        } else {
            a = i3;
        }
        return new C3860c(a3, new int[]{i3, iArr[1]}, a, i4, i);
    }

    private void m19232a(boolean z, int i) throws C3932i {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int i2;
        Object obj5 = null;
        Object obj6 = 1;
        int a = C3857a.m19189a(m19198f());
        int a2 = C3857a.m19189a(m19199g());
        int i3 = (a + a2) - i;
        Object obj7 = (a & 1) == (z ? 1 : 0) ? 1 : null;
        if ((a2 & 1) == 1) {
            obj = 1;
        } else {
            obj = null;
        }
        int i4;
        if (z) {
            if (a > 12) {
                obj2 = 1;
                obj3 = null;
            } else if (a < 4) {
                obj2 = null;
                i4 = 1;
            } else {
                obj2 = null;
                obj3 = null;
            }
            if (a2 > 12) {
                obj4 = null;
                obj5 = 1;
            } else {
                if (a2 < 4) {
                    i2 = 1;
                }
                obj4 = null;
            }
        } else {
            if (a > 11) {
                obj2 = 1;
                obj3 = null;
            } else if (a < 5) {
                obj2 = null;
                i4 = 1;
            } else {
                obj2 = null;
                obj3 = null;
            }
            if (a2 > 10) {
                obj4 = null;
                int i5 = 1;
            } else {
                if (a2 < 4) {
                    i2 = 1;
                }
                obj4 = null;
            }
        }
        if (i3 == 1) {
            if (obj7 != null) {
                if (obj != null) {
                    throw C3932i.m19565a();
                }
                obj2 = obj3;
                obj6 = obj4;
                obj4 = 1;
            } else if (obj == null) {
                throw C3932i.m19565a();
            } else {
                i5 = 1;
                obj6 = obj4;
                obj4 = obj2;
                obj2 = obj3;
            }
        } else if (i3 == -1) {
            if (obj7 != null) {
                if (obj != null) {
                    throw C3932i.m19565a();
                }
                r12 = obj4;
                obj4 = obj2;
                r3 = 1;
                obj6 = r12;
            } else if (obj == null) {
                throw C3932i.m19565a();
            } else {
                obj4 = obj2;
                obj2 = obj3;
            }
        } else if (i3 != 0) {
            throw C3932i.m19565a();
        } else if (obj7 != null) {
            if (obj == null) {
                throw C3932i.m19565a();
            } else if (a < a2) {
                i5 = 1;
                r12 = obj4;
                obj4 = obj2;
                r3 = 1;
                obj6 = r12;
            } else {
                i2 = 1;
                obj2 = obj3;
            }
        } else if (obj != null) {
            throw C3932i.m19565a();
        } else {
            obj6 = obj4;
            obj4 = obj2;
            obj2 = obj3;
        }
        if (obj2 != null) {
            if (obj4 != null) {
                throw C3932i.m19565a();
            }
            C3857a.m19191a(m19198f(), m19196d());
        }
        if (obj4 != null) {
            C3857a.m19192b(m19198f(), m19196d());
        }
        if (obj6 != null) {
            if (obj5 != null) {
                throw C3932i.m19565a();
            }
            C3857a.m19191a(m19199g(), m19196d());
        }
        if (obj5 != null) {
            C3857a.m19192b(m19199g(), m19197e());
        }
    }
}
