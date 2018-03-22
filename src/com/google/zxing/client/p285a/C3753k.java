package com.google.zxing.client.p285a;

import java.util.Map;

/* compiled from: ExpandedProductParsedResult */
public final class C3753k extends C3743q {
    private final String f14602a;
    private final String f14603b;
    private final String f14604c;
    private final String f14605d;
    private final String f14606e;
    private final String f14607f;
    private final String f14608g;
    private final String f14609h;
    private final String f14610i;
    private final String f14611j;
    private final String f14612k;
    private final String f14613l;
    private final String f14614m;
    private final String f14615n;
    private final Map<String, String> f14616o;

    public C3753k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(C3759r.PRODUCT);
        this.f14602a = str;
        this.f14603b = str2;
        this.f14604c = str3;
        this.f14605d = str4;
        this.f14606e = str5;
        this.f14607f = str6;
        this.f14608g = str7;
        this.f14609h = str8;
        this.f14610i = str9;
        this.f14611j = str10;
        this.f14612k = str11;
        this.f14613l = str12;
        this.f14614m = str13;
        this.f14615n = str14;
        this.f14616o = map;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3753k)) {
            return false;
        }
        C3753k c3753k = (C3753k) obj;
        if (C3753k.m18897a(this.f14603b, c3753k.f14603b) && C3753k.m18897a(this.f14604c, c3753k.f14604c) && C3753k.m18897a(this.f14605d, c3753k.f14605d) && C3753k.m18897a(this.f14606e, c3753k.f14606e) && C3753k.m18897a(this.f14608g, c3753k.f14608g) && C3753k.m18897a(this.f14609h, c3753k.f14609h) && C3753k.m18897a(this.f14610i, c3753k.f14610i) && C3753k.m18897a(this.f14611j, c3753k.f14611j) && C3753k.m18897a(this.f14612k, c3753k.f14612k) && C3753k.m18897a(this.f14613l, c3753k.f14613l) && C3753k.m18897a(this.f14614m, c3753k.f14614m) && C3753k.m18897a(this.f14615n, c3753k.f14615n) && C3753k.m18897a(this.f14616o, c3753k.f14616o)) {
            return true;
        }
        return false;
    }

    private static boolean m18897a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else {
            return obj.equals(obj2);
        }
    }

    public int hashCode() {
        return ((((((((((((0 ^ C3753k.m18896a(this.f14603b)) ^ C3753k.m18896a(this.f14604c)) ^ C3753k.m18896a(this.f14605d)) ^ C3753k.m18896a(this.f14606e)) ^ C3753k.m18896a(this.f14608g)) ^ C3753k.m18896a(this.f14609h)) ^ C3753k.m18896a(this.f14610i)) ^ C3753k.m18896a(this.f14611j)) ^ C3753k.m18896a(this.f14612k)) ^ C3753k.m18896a(this.f14613l)) ^ C3753k.m18896a(this.f14614m)) ^ C3753k.m18896a(this.f14615n)) ^ C3753k.m18896a(this.f14616o);
    }

    private static int m18896a(Object obj) {
        return obj == null ? 0 : obj.hashCode();
    }

    public String mo4309a() {
        return String.valueOf(this.f14602a);
    }
}
