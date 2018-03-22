package com.google.analytics.tracking.android;

import android.text.TextUtils;

/* compiled from: Hit */
class ap {
    private String f14134a;
    private final long f14135b;
    private final long f14136c;
    private String f14137d = "https:";

    String m18255a() {
        return this.f14134a;
    }

    void m18256a(String str) {
        this.f14134a = str;
    }

    long m18257b() {
        return this.f14135b;
    }

    long m18259c() {
        return this.f14136c;
    }

    ap(String str, long j, long j2) {
        this.f14134a = str;
        this.f14135b = j;
        this.f14136c = j2;
    }

    String m18260d() {
        return this.f14137d;
    }

    void m18258b(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim()) && str.toLowerCase().startsWith("http:")) {
            this.f14137d = "http:";
        }
    }
}
