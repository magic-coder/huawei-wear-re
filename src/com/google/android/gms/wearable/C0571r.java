package com.google.android.gms.wearable;

import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class C0571r {
    private final HashMap<String, Object> f1077a = new HashMap();

    private void m2229a(String str, Object obj, String str2, ClassCastException classCastException) {
        m2230a(str, obj, str2, "<null>", classCastException);
    }

    private void m2230a(String str, Object obj, String str2, Object obj2, ClassCastException classCastException) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Key ");
        stringBuilder.append(str);
        stringBuilder.append(" expected ");
        stringBuilder.append(str2);
        stringBuilder.append(" but value was a ");
        stringBuilder.append(obj.getClass().getName());
        stringBuilder.append(".  The default value ");
        stringBuilder.append(obj2);
        stringBuilder.append(" was returned.");
        Log.w("DataMap", stringBuilder.toString());
        Log.w("DataMap", "Attempt to cast generated internal exception:", classCastException);
    }

    private static boolean m2231a(Asset asset, Asset asset2) {
        return (asset == null || asset2 == null) ? asset == asset2 : !TextUtils.isEmpty(asset.getDigest()) ? asset.getDigest().equals(asset2.getDigest()) : Arrays.equals(asset.getData(), asset2.getData());
    }

    private static boolean m2232a(C0571r c0571r, C0571r c0571r2) {
        if (c0571r.m2233a() != c0571r2.m2233a()) {
            return false;
        }
        for (String str : c0571r.m2251b()) {
            Object a = c0571r.m2234a(str);
            Object a2 = c0571r2.m2234a(str);
            if (a instanceof Asset) {
                if (!(a2 instanceof Asset)) {
                    return false;
                }
                if (!C0571r.m2231a((Asset) a, (Asset) a2)) {
                    return false;
                }
            } else if (a instanceof String[]) {
                if (!(a2 instanceof String[])) {
                    return false;
                }
                if (!Arrays.equals((String[]) a, (String[]) a2)) {
                    return false;
                }
            } else if (a instanceof long[]) {
                if (!(a2 instanceof long[])) {
                    return false;
                }
                if (!Arrays.equals((long[]) a, (long[]) a2)) {
                    return false;
                }
            } else if (a instanceof float[]) {
                if (!(a2 instanceof float[])) {
                    return false;
                }
                if (!Arrays.equals((float[]) a, (float[]) a2)) {
                    return false;
                }
            } else if (a instanceof byte[]) {
                if (!(a2 instanceof byte[])) {
                    return false;
                }
                if (!Arrays.equals((byte[]) a, (byte[]) a2)) {
                    return false;
                }
            } else if (a == null || a2 == null) {
                return a == a2;
            } else if (!a.equals(a2)) {
                return false;
            }
        }
        return true;
    }

    public int m2233a() {
        return this.f1077a.size();
    }

    public <T> T m2234a(String str) {
        return this.f1077a.get(str);
    }

    public void m2235a(C0571r c0571r) {
        for (String str : c0571r.m2251b()) {
            this.f1077a.put(str, c0571r.m2234a(str));
        }
    }

    public void m2236a(String str, byte b) {
        this.f1077a.put(str, Byte.valueOf(b));
    }

    public void m2237a(String str, double d) {
        this.f1077a.put(str, Double.valueOf(d));
    }

    public void m2238a(String str, float f) {
        this.f1077a.put(str, Float.valueOf(f));
    }

    public void m2239a(String str, int i) {
        this.f1077a.put(str, Integer.valueOf(i));
    }

    public void m2240a(String str, long j) {
        this.f1077a.put(str, Long.valueOf(j));
    }

    public void m2241a(String str, Asset asset) {
        this.f1077a.put(str, asset);
    }

    public void m2242a(String str, C0571r c0571r) {
        this.f1077a.put(str, c0571r);
    }

    public void m2243a(String str, String str2) {
        this.f1077a.put(str, str2);
    }

    public void m2244a(String str, ArrayList<C0571r> arrayList) {
        this.f1077a.put(str, arrayList);
    }

    public void m2245a(String str, boolean z) {
        this.f1077a.put(str, Boolean.valueOf(z));
    }

    public void m2246a(String str, byte[] bArr) {
        this.f1077a.put(str, bArr);
    }

    public void m2247a(String str, float[] fArr) {
        this.f1077a.put(str, fArr);
    }

    public void m2248a(String str, long[] jArr) {
        this.f1077a.put(str, jArr);
    }

    public void m2249a(String str, String[] strArr) {
        this.f1077a.put(str, strArr);
    }

    public Asset m2250b(String str) {
        Object obj = this.f1077a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (Asset) obj;
        } catch (ClassCastException e) {
            m2229a(str, obj, "Asset", e);
            return null;
        }
    }

    public Set<String> m2251b() {
        return this.f1077a.keySet();
    }

    public void m2252b(String str, ArrayList<Integer> arrayList) {
        this.f1077a.put(str, arrayList);
    }

    public void m2253c(String str, ArrayList<String> arrayList) {
        this.f1077a.put(str, arrayList);
    }

    public byte[] m2254c(String str) {
        Object obj = this.f1077a.get(str);
        if (obj == null) {
            return null;
        }
        try {
            return (byte[]) obj;
        } catch (ClassCastException e) {
            m2229a(str, obj, "byte[]", e);
            return null;
        }
    }

    public boolean equals(Object obj) {
        return !(obj instanceof C0571r) ? false : C0571r.m2232a(this, (C0571r) obj);
    }

    public int hashCode() {
        return this.f1077a.hashCode() * 29;
    }

    public String toString() {
        return this.f1077a.toString();
    }
}
