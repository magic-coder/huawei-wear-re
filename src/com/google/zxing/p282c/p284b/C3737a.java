package com.google.zxing.p282c.p284b;

import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.p278b.C3703g;
import com.google.zxing.p278b.C3717b;
import com.google.zxing.p278b.C3721i;
import com.google.zxing.p278b.p280a.C3710a;
import com.google.zxing.p278b.p280a.C3711b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Detector */
public final class C3737a {
    private final C3717b f14531a;
    private final C3711b f14532b;

    public C3737a(C3717b c3717b) throws C3932i {
        this.f14531a = c3717b;
        this.f14532b = new C3711b(c3717b);
    }

    public C3703g m18813a() throws C3932i {
        C3739c c3739c = null;
        C3922o[] a = this.f14532b.m18674a();
        C3922o c3922o = a[0];
        C3922o c3922o2 = a[1];
        C3922o c3922o3 = a[2];
        C3922o c3922o4 = a[3];
        List arrayList = new ArrayList(4);
        arrayList.add(m18812b(c3922o, c3922o2));
        arrayList.add(m18812b(c3922o, c3922o3));
        arrayList.add(m18812b(c3922o2, c3922o4));
        arrayList.add(m18812b(c3922o3, c3922o4));
        Collections.sort(arrayList, new C3739c());
        C3738b c3738b = (C3738b) arrayList.get(0);
        C3738b c3738b2 = (C3738b) arrayList.get(1);
        Map hashMap = new HashMap();
        C3737a.m18810a(hashMap, c3738b.m18814a());
        C3737a.m18810a(hashMap, c3738b.m18815b());
        C3737a.m18810a(hashMap, c3738b2.m18814a());
        C3737a.m18810a(hashMap, c3738b2.m18815b());
        C3922o c3922o5 = null;
        C3922o c3922o6 = null;
        for (Entry entry : hashMap.entrySet()) {
            C3922o c3922o7 = (C3922o) entry.getKey();
            if (((Integer) entry.getValue()).intValue() == 2) {
                c3922o5 = c3922o7;
            } else if (c3922o6 == null) {
                c3922o6 = c3922o7;
            } else {
                c3739c = c3922o7;
            }
        }
        if (c3922o6 == null || c3922o5 == null || c3739c == null) {
            throw C3932i.m19565a();
        }
        C3717b a2;
        a = new C3922o[]{c3922o6, c3922o5, c3739c};
        C3922o.m19521a(a);
        C3922o c3922o8 = a[0];
        c3922o7 = a[1];
        c3922o5 = a[2];
        if (!hashMap.containsKey(c3922o)) {
            c3922o6 = c3922o;
        } else if (!hashMap.containsKey(c3922o2)) {
            c3922o6 = c3922o2;
        } else if (hashMap.containsKey(c3922o3)) {
            c3922o6 = c3922o4;
        } else {
            c3922o6 = c3922o3;
        }
        int c = m18812b(c3922o5, c3922o6).m18816c();
        int c2 = m18812b(c3922o8, c3922o6).m18816c();
        if ((c & 1) == 1) {
            c++;
        }
        c += 2;
        if ((c2 & 1) == 1) {
            c2++;
        }
        int i = c2 + 2;
        int c3;
        if (c * 4 >= i * 7 || i * 4 >= c * 7) {
            c3922o4 = m18809a(c3922o7, c3922o8, c3922o5, c3922o6, c, i);
            if (c3922o4 == null) {
                c3922o4 = c3922o6;
            }
            c3 = m18812b(c3922o5, c3922o4).m18816c();
            int c4 = m18812b(c3922o8, c3922o4).m18816c();
            if ((c3 & 1) == 1) {
                c3++;
            }
            if ((c4 & 1) == 1) {
                c4++;
            }
            a2 = C3737a.m18807a(this.f14531a, c3922o5, c3922o7, c3922o8, c3922o4, c3, c4);
        } else {
            c3922o4 = m18808a(c3922o7, c3922o8, c3922o5, c3922o6, Math.min(i, c));
            if (c3922o4 == null) {
                c3922o4 = c3922o6;
            }
            c3 = Math.max(m18812b(c3922o5, c3922o4).m18816c(), m18812b(c3922o8, c3922o4).m18816c()) + 1;
            if ((c3 & 1) == 1) {
                c3++;
            }
            a2 = C3737a.m18807a(this.f14531a, c3922o5, c3922o7, c3922o8, c3922o4, c3, c3);
        }
        return new C3703g(a2, new C3922o[]{c3922o5, c3922o7, c3922o8, c3922o4});
    }

    private C3922o m18809a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4, int i, int i2) {
        float a = ((float) C3737a.m18806a(c3922o, c3922o2)) / ((float) i);
        int a2 = C3737a.m18806a(c3922o3, c3922o4);
        C3922o c3922o5 = new C3922o((((c3922o4.m19522a() - c3922o3.m19522a()) / ((float) a2)) * a) + c3922o4.m19522a(), (a * ((c3922o4.m19523b() - c3922o3.m19523b()) / ((float) a2))) + c3922o4.m19523b());
        float a3 = ((float) C3737a.m18806a(c3922o, c3922o3)) / ((float) i2);
        int a4 = C3737a.m18806a(c3922o2, c3922o4);
        C3922o c3922o6 = new C3922o((((c3922o4.m19522a() - c3922o2.m19522a()) / ((float) a4)) * a3) + c3922o4.m19522a(), (a3 * ((c3922o4.m19523b() - c3922o2.m19523b()) / ((float) a4))) + c3922o4.m19523b());
        if (m18811a(c3922o5)) {
            if (!m18811a(c3922o6)) {
                return c3922o5;
            }
            if (Math.abs(i - m18812b(c3922o3, c3922o5).m18816c()) + Math.abs(i2 - m18812b(c3922o2, c3922o5).m18816c()) <= Math.abs(i - m18812b(c3922o3, c3922o6).m18816c()) + Math.abs(i2 - m18812b(c3922o2, c3922o6).m18816c())) {
                return c3922o5;
            }
            return c3922o6;
        } else if (m18811a(c3922o6)) {
            return c3922o6;
        } else {
            return null;
        }
    }

    private C3922o m18808a(C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4, int i) {
        float a = ((float) C3737a.m18806a(c3922o, c3922o2)) / ((float) i);
        int a2 = C3737a.m18806a(c3922o3, c3922o4);
        C3922o c3922o5 = new C3922o((((c3922o4.m19522a() - c3922o3.m19522a()) / ((float) a2)) * a) + c3922o4.m19522a(), (a * ((c3922o4.m19523b() - c3922o3.m19523b()) / ((float) a2))) + c3922o4.m19523b());
        float a3 = ((float) C3737a.m18806a(c3922o, c3922o3)) / ((float) i);
        int a4 = C3737a.m18806a(c3922o2, c3922o4);
        C3922o c3922o6 = new C3922o((((c3922o4.m19522a() - c3922o2.m19522a()) / ((float) a4)) * a3) + c3922o4.m19522a(), (a3 * ((c3922o4.m19523b() - c3922o2.m19523b()) / ((float) a4))) + c3922o4.m19523b());
        if (m18811a(c3922o5)) {
            return (!m18811a(c3922o6) || Math.abs(m18812b(c3922o3, c3922o5).m18816c() - m18812b(c3922o2, c3922o5).m18816c()) <= Math.abs(m18812b(c3922o3, c3922o6).m18816c() - m18812b(c3922o2, c3922o6).m18816c())) ? c3922o5 : c3922o6;
        } else {
            if (m18811a(c3922o6)) {
                return c3922o6;
            }
            return null;
        }
    }

    private boolean m18811a(C3922o c3922o) {
        return c3922o.m19522a() >= 0.0f && c3922o.m19522a() < ((float) this.f14531a.m18719d()) && c3922o.m19523b() > 0.0f && c3922o.m19523b() < ((float) this.f14531a.m18720e());
    }

    private static int m18806a(C3922o c3922o, C3922o c3922o2) {
        return C3710a.m18670a(C3922o.m19519a(c3922o, c3922o2));
    }

    private static void m18810a(Map<C3922o, Integer> map, C3922o c3922o) {
        Integer num = (Integer) map.get(c3922o);
        map.put(c3922o, Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    private static C3717b m18807a(C3717b c3717b, C3922o c3922o, C3922o c3922o2, C3922o c3922o3, C3922o c3922o4, int i, int i2) throws C3932i {
        return C3721i.m18734a().mo4303a(c3717b, i, i2, 0.5f, 0.5f, ((float) i) - 0.5f, 0.5f, ((float) i) - 0.5f, ((float) i2) - 0.5f, 0.5f, ((float) i2) - 0.5f, c3922o.m19522a(), c3922o.m19523b(), c3922o4.m19522a(), c3922o4.m19523b(), c3922o3.m19522a(), c3922o3.m19523b(), c3922o2.m19522a(), c3922o2.m19523b());
    }

    private C3738b m18812b(C3922o c3922o, C3922o c3922o2) {
        Object obj;
        int i;
        int a = (int) c3922o.m19522a();
        int b = (int) c3922o.m19523b();
        int a2 = (int) c3922o2.m19522a();
        int b2 = (int) c3922o2.m19523b();
        if (Math.abs(b2 - b) > Math.abs(a2 - a)) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            int i2 = b2;
            b2 = a2;
            a2 = i2;
            int i3 = b;
            b = a;
            a = i3;
        }
        int abs = Math.abs(b2 - b);
        int abs2 = Math.abs(a2 - a);
        int i4 = (-abs) >> 1;
        int i5 = a < a2 ? 1 : -1;
        int i6 = b < b2 ? 1 : -1;
        int i7 = 0;
        C3717b c3717b = this.f14531a;
        if (obj != null) {
            i = a;
        } else {
            i = b;
        }
        boolean a3 = c3717b.m18712a(i, obj != null ? b : a);
        int i8 = a;
        int i9 = i4;
        while (b != b2) {
            boolean a4 = this.f14531a.m18712a(obj != null ? i8 : b, obj != null ? b : i8);
            if (a4 != a3) {
                i7++;
                a3 = a4;
            }
            a = i9 + abs2;
            if (a > 0) {
                if (i8 == a2) {
                    a2 = i7;
                    break;
                }
                i8 += i5;
                a -= abs;
            }
            b += i6;
            i9 = a;
        }
        a2 = i7;
        return new C3738b(c3922o, c3922o2, a2);
    }
}
