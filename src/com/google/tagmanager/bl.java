package com.google.tagmanager;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: Types */
class bl {
    private static final Object f14313a = null;
    private static Long f14314b = new Long(0);
    private static Double f14315c = new Double(0.0d);
    private static bk f14316d = bk.m18522a(0);
    private static String f14317e = new String("");
    private static Boolean f14318f = new Boolean(false);
    private static List<Object> f14319g = new ArrayList(0);
    private static Map<Object, Object> f14320h = new HashMap();
    private static C3644b f14321i = m18535c(f14317e);

    public static C3644b m18529a() {
        return f14321i;
    }

    public static String m18532a(Object obj) {
        return obj == null ? f14317e : obj.toString();
    }

    public static Boolean m18534b(Object obj) {
        return obj instanceof Boolean ? (Boolean) obj : m18530a(m18532a(obj));
    }

    public static String m18531a(C3644b c3644b) {
        return m18532a(m18536c(c3644b));
    }

    public static Boolean m18533b(C3644b c3644b) {
        return m18534b(m18536c(c3644b));
    }

    public static C3644b m18535c(Object obj) {
        boolean z = false;
        C3644b c3644b = new C3644b();
        if (obj instanceof C3644b) {
            return (C3644b) obj;
        }
        if (obj instanceof String) {
            c3644b.f14026b = 1;
            c3644b.f14027c = (String) obj;
        } else if (obj instanceof List) {
            c3644b.f14026b = 2;
            List<Object> list = (List) obj;
            r5 = new ArrayList(list.size());
            r1 = false;
            for (Object c : list) {
                C3644b c2 = m18535c(c);
                if (c2 == f14321i) {
                    return f14321i;
                }
                if (r1 || c2.f14038n) {
                    r0 = true;
                } else {
                    r0 = false;
                }
                r5.add(c2);
                r1 = r0;
            }
            c3644b.f14028d = (C3644b[]) r5.toArray(new C3644b[0]);
            z = r1;
        } else if (obj instanceof Map) {
            c3644b.f14026b = 3;
            Set<Entry> entrySet = ((Map) obj).entrySet();
            r5 = new ArrayList(entrySet.size());
            List arrayList = new ArrayList(entrySet.size());
            r1 = false;
            for (Entry entry : entrySet) {
                C3644b c3 = m18535c(entry.getKey());
                C3644b c4 = m18535c(entry.getValue());
                if (c3 == f14321i || c4 == f14321i) {
                    return f14321i;
                }
                if (r1 || c3.f14038n || c4.f14038n) {
                    r0 = true;
                } else {
                    r0 = false;
                }
                r5.add(c3);
                arrayList.add(c4);
                r1 = r0;
            }
            c3644b.f14029e = (C3644b[]) r5.toArray(new C3644b[0]);
            c3644b.f14030f = (C3644b[]) arrayList.toArray(new C3644b[0]);
            z = r1;
        } else if (m18537d(obj)) {
            c3644b.f14026b = 1;
            c3644b.f14027c = obj.toString();
        } else if (m18538e(obj)) {
            c3644b.f14026b = 6;
            c3644b.f14033i = m18539f(obj);
        } else if (obj instanceof Boolean) {
            c3644b.f14026b = 8;
            c3644b.f14034j = ((Boolean) obj).booleanValue();
        } else {
            C3700z.m18624a("Converting to Value from unknown object type: " + (obj == null ? "null" : obj.getClass().toString()));
            return f14321i;
        }
        c3644b.f14038n = z;
        return c3644b;
    }

    private static boolean m18537d(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || ((obj instanceof bk) && ((bk) obj).m18524a());
    }

    private static boolean m18538e(Object obj) {
        return (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Integer) || (obj instanceof Long) || ((obj instanceof bk) && ((bk) obj).m18525b());
    }

    private static long m18539f(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        C3700z.m18624a("getInt64 received non-Number");
        return 0;
    }

    private static Boolean m18530a(String str) {
        if ("true".equalsIgnoreCase(str)) {
            return Boolean.TRUE;
        }
        if ("false".equalsIgnoreCase(str)) {
            return Boolean.FALSE;
        }
        return f14318f;
    }

    public static Object m18536c(C3644b c3644b) {
        int i = 0;
        if (c3644b == null) {
            return f14313a;
        }
        C3644b[] c3644bArr;
        int length;
        switch (c3644b.f14026b) {
            case 1:
                return c3644b.f14027c;
            case 2:
                ArrayList arrayList = new ArrayList(c3644b.f14028d.length);
                c3644bArr = c3644b.f14028d;
                length = c3644bArr.length;
                while (i < length) {
                    Object c = m18536c(c3644bArr[i]);
                    if (c == f14313a) {
                        return f14313a;
                    }
                    arrayList.add(c);
                    i++;
                }
                return arrayList;
            case 3:
                if (c3644b.f14029e.length != c3644b.f14030f.length) {
                    C3700z.m18624a("Converting an invalid value to object: " + c3644b.toString());
                    return f14313a;
                }
                Map linkedHashMap = new LinkedHashMap(c3644b.f14030f.length);
                while (i < c3644b.f14029e.length) {
                    Object c2 = m18536c(c3644b.f14029e[i]);
                    Object c3 = m18536c(c3644b.f14030f[i]);
                    if (c2 == f14313a || c3 == f14313a) {
                        return f14313a;
                    }
                    linkedHashMap.put(c2, c3);
                    i++;
                }
                return linkedHashMap;
            case 4:
                C3700z.m18624a("Trying to convert a macro reference to object");
                return f14313a;
            case 5:
                C3700z.m18624a("Trying to convert a function id to object");
                return f14313a;
            case 6:
                return Long.valueOf(c3644b.f14033i);
            case 7:
                StringBuffer stringBuffer = new StringBuffer();
                c3644bArr = c3644b.f14035k;
                length = c3644bArr.length;
                while (i < length) {
                    String a = m18531a(c3644bArr[i]);
                    if (a == f14317e) {
                        return f14313a;
                    }
                    stringBuffer.append(a);
                    i++;
                }
                return stringBuffer.toString();
            case 8:
                return Boolean.valueOf(c3644b.f14034j);
            default:
                C3700z.m18624a("Failed to convert a value of type: " + c3644b.f14026b);
                return f14313a;
        }
    }
}
