package com.google.analytics.tracking.android;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Tracker */
public class bh {
    private final String f14170a;
    private final bi f14171b;
    private final Map<String, String> f14172c;
    private ba f14173d;
    private final C3658j f14174e;
    private final bb f14175f;
    private final C3657i f14176g;

    bh(String str, String str2, bi biVar) {
        this(str, str2, biVar, C3658j.m18356a(), bb.m18312a(), C3657i.m18353a(), new bc());
    }

    bh(String str, String str2, bi biVar, C3658j c3658j, bb bbVar, C3657i c3657i, ba baVar) {
        this.f14172c = new HashMap();
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Tracker name cannot be empty.");
        }
        this.f14170a = str;
        this.f14171b = biVar;
        this.f14172c.put("&tid", str2);
        this.f14172c.put("useSecure", "1");
        this.f14174e = c3658j;
        this.f14175f = bbVar;
        this.f14176g = c3657i;
        this.f14173d = baVar;
    }

    public void m18338a(Map<String, String> map) {
        am.m18240a().m18241a(an.SEND);
        Map hashMap = new HashMap();
        hashMap.putAll(this.f14172c);
        if (map != null) {
            hashMap.putAll(map);
        }
        if (TextUtils.isEmpty((CharSequence) hashMap.get("&tid"))) {
            ar.m18269d(String.format("Missing tracking id (%s) parameter.", new Object[]{"&tid"}));
        }
        String str = (String) hashMap.get("&t");
        if (TextUtils.isEmpty(str)) {
            ar.m18269d(String.format("Missing hit type (%s) parameter.", new Object[]{"&t"}));
            str = "";
        }
        if (str.equals("transaction") || str.equals("item") || this.f14173d.mo4249a()) {
            this.f14171b.mo4238a(hashMap);
        } else {
            ar.m18269d("Too many hits sent too quickly, rate limiting invoked.");
        }
    }

    public void m18337a(String str, String str2) {
        am.m18240a().m18241a(an.SET);
        if (str2 == null) {
            this.f14172c.remove(str);
        } else {
            this.f14172c.put(str, str2);
        }
    }
}
