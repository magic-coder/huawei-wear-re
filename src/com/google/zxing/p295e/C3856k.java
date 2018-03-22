package com.google.zxing.p295e;

import com.android.volley.DefaultRetryPolicy;
import com.google.zxing.C3707k;
import com.google.zxing.C3740c;
import com.google.zxing.C3831l;
import com.google.zxing.C3832d;
import com.google.zxing.C3880e;
import com.google.zxing.C3900f;
import com.google.zxing.C3922o;
import com.google.zxing.C3932i;
import com.google.zxing.C3934m;
import com.google.zxing.C3935n;
import com.google.zxing.p278b.C3712a;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: OneDReader */
public abstract class C3856k implements C3707k {
    public abstract C3934m mo4321a(int i, C3712a c3712a, Map<C3880e, ?> map) throws C3932i, C3832d, C3900f;

    public C3934m mo4301a(C3740c c3740c, Map<C3880e, ?> map) throws C3932i, C3900f {
        try {
            return m19184b(c3740c, map);
        } catch (C3932i e) {
            Object obj = (map == null || !map.containsKey(C3880e.TRY_HARDER)) ? null : 1;
            if (obj == null || !c3740c.m18822d()) {
                throw e;
            }
            int i;
            C3740c e2 = c3740c.m18823e();
            C3934m b = m19184b(e2, map);
            Map e3 = b.m19579e();
            if (e3 == null || !e3.containsKey(C3935n.ORIENTATION)) {
                i = 270;
            } else {
                i = (((Integer) e3.get(C3935n.ORIENTATION)).intValue() + 270) % 360;
            }
            b.m19573a(C3935n.ORIENTATION, Integer.valueOf(i));
            C3922o[] c = b.m19577c();
            if (c != null) {
                int b2 = e2.m18820b();
                for (i = 0; i < c.length; i++) {
                    c[i] = new C3922o((((float) b2) - c[i].m19523b()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[i].m19522a());
                }
            }
            return b;
        }
    }

    public void mo4302a() {
    }

    private C3934m m19184b(C3740c c3740c, Map<C3880e, ?> map) throws C3932i {
        Object obj;
        int max;
        int i;
        C3712a c3712a;
        Map map2;
        int i2;
        int i3;
        int i4;
        Map enumMap;
        C3934m a;
        C3922o[] c;
        int a2 = c3740c.m18818a();
        int b = c3740c.m18820b();
        C3712a c3712a2 = new C3712a(a2);
        int i5 = b >> 1;
        if (map != null) {
            if (map.containsKey(C3880e.TRY_HARDER)) {
                obj = 1;
                max = Math.max(1, b >> (obj == null ? 8 : 5));
                if (obj == null) {
                    i = b;
                } else {
                    i = 15;
                }
                c3712a = c3712a2;
                map2 = map;
                for (i2 = 0; i2 < i; i2++) {
                    i3 = (i2 + 1) >> 1;
                    if (((i2 & 1) != 0 ? 1 : null) == null) {
                        i3 = -i3;
                    }
                    i4 = i5 + (i3 * max);
                    if (i4 < 0 || i4 >= b) {
                        break;
                    }
                    try {
                        c3712a = c3740c.m18819a(i4, c3712a);
                        i3 = 0;
                        while (i3 < 2) {
                            if (i3 == 1) {
                                c3712a.m18685d();
                                if (map2 != null && map2.containsKey(C3880e.NEED_RESULT_POINT_CALLBACK)) {
                                    enumMap = new EnumMap(C3880e.class);
                                    enumMap.putAll(map2);
                                    enumMap.remove(C3880e.NEED_RESULT_POINT_CALLBACK);
                                    a = mo4321a(i4, c3712a, enumMap);
                                    if (i3 == 1) {
                                        a.m19573a(C3935n.ORIENTATION, Integer.valueOf(180));
                                        c = a.m19577c();
                                        if (c != null) {
                                            c[0] = new C3922o((((float) a2) - c[0].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[0].m19523b());
                                            c[1] = new C3922o((((float) a2) - c[1].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[1].m19523b());
                                        }
                                    }
                                    return a;
                                }
                            }
                            enumMap = map2;
                            try {
                                a = mo4321a(i4, c3712a, enumMap);
                                if (i3 == 1) {
                                    a.m19573a(C3935n.ORIENTATION, Integer.valueOf(180));
                                    c = a.m19577c();
                                    if (c != null) {
                                        c[0] = new C3922o((((float) a2) - c[0].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[0].m19523b());
                                        c[1] = new C3922o((((float) a2) - c[1].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[1].m19523b());
                                    }
                                }
                                return a;
                            } catch (C3831l e) {
                                i3++;
                                map2 = enumMap;
                            }
                        }
                        continue;
                    } catch (C3932i e2) {
                    }
                }
                throw C3932i.m19565a();
            }
        }
        obj = null;
        if (obj == null) {
        }
        max = Math.max(1, b >> (obj == null ? 8 : 5));
        if (obj == null) {
            i = 15;
        } else {
            i = b;
        }
        c3712a = c3712a2;
        map2 = map;
        for (i2 = 0; i2 < i; i2++) {
            i3 = (i2 + 1) >> 1;
            if ((i2 & 1) != 0) {
            }
            if (((i2 & 1) != 0 ? 1 : null) == null) {
                i3 = -i3;
            }
            i4 = i5 + (i3 * max);
            c3712a = c3740c.m18819a(i4, c3712a);
            i3 = 0;
            while (i3 < 2) {
                if (i3 == 1) {
                    c3712a.m18685d();
                    enumMap = new EnumMap(C3880e.class);
                    enumMap.putAll(map2);
                    enumMap.remove(C3880e.NEED_RESULT_POINT_CALLBACK);
                    a = mo4321a(i4, c3712a, enumMap);
                    if (i3 == 1) {
                        a.m19573a(C3935n.ORIENTATION, Integer.valueOf(180));
                        c = a.m19577c();
                        if (c != null) {
                            c[0] = new C3922o((((float) a2) - c[0].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[0].m19523b());
                            c[1] = new C3922o((((float) a2) - c[1].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[1].m19523b());
                        }
                    }
                    return a;
                }
                enumMap = map2;
                a = mo4321a(i4, c3712a, enumMap);
                if (i3 == 1) {
                    a.m19573a(C3935n.ORIENTATION, Integer.valueOf(180));
                    c = a.m19577c();
                    if (c != null) {
                        c[0] = new C3922o((((float) a2) - c[0].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[0].m19523b());
                        c[1] = new C3922o((((float) a2) - c[1].m19522a()) - DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, c[1].m19523b());
                    }
                }
                return a;
            }
            continue;
        }
        throw C3932i.m19565a();
    }

    protected static void m19183a(C3712a c3712a, int i, int[] iArr) throws C3932i {
        int length = iArr.length;
        Arrays.fill(iArr, 0, length, 0);
        int a = c3712a.m18676a();
        if (i >= a) {
            throw C3932i.m19565a();
        }
        int i2;
        int i3 = c3712a.m18678a(i) ? 0 : 1;
        int i4 = 0;
        while (i < a) {
            if ((c3712a.m18678a(i) ^ i3) == 0) {
                i2 = i4 + 1;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                int i5 = i2;
                i2 = i3 != 0 ? 0 : 1;
                i4 = i5;
            } else {
                iArr[i4] = iArr[i4] + 1;
                i2 = i3;
            }
            i++;
            i3 = i2;
        }
        i2 = i4;
        if (i2 == length) {
            return;
        }
        if (i2 != length - 1 || i != a) {
            throw C3932i.m19565a();
        }
    }

    protected static void m19185b(C3712a c3712a, int i, int[] iArr) throws C3932i {
        int length = iArr.length;
        boolean a = c3712a.m18678a(i);
        while (i > 0 && length >= 0) {
            i--;
            if (c3712a.m18678a(i) != a) {
                length--;
                a = !a;
            }
        }
        if (length >= 0) {
            throw C3932i.m19565a();
        }
        C3856k.m19183a(c3712a, i + 1, iArr);
    }

    protected static int m19182a(int[] iArr, int[] iArr2, int i) {
        int i2;
        int length = iArr.length;
        int i3 = 0;
        int i4 = 0;
        for (i2 = 0; i2 < length; i2++) {
            i4 += iArr[i2];
            i3 += iArr2[i2];
        }
        if (i4 < i3) {
            return Integer.MAX_VALUE;
        }
        int i5 = (i4 << 8) / i3;
        int i6 = (i * i5) >> 8;
        i3 = 0;
        for (i2 = 0; i2 < length; i2++) {
            int i7 = iArr[i2] << 8;
            int i8 = iArr2[i2] * i5;
            i7 = i7 > i8 ? i7 - i8 : i8 - i7;
            if (i7 > i6) {
                return Integer.MAX_VALUE;
            }
            i3 += i7;
        }
        return i3 / i4;
    }
}
