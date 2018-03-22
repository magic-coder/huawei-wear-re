package com.amap.api.mapcore.util;

import java.util.HashMap;
import java.util.Map;

/* compiled from: AuthRequest */
class bx extends dp {
    private Map<String, String> f11563a = new HashMap();
    private String f11564b;
    private Map<String, String> f11565c = new HashMap();

    bx() {
    }

    void m15813a(Map<String, String> map) {
        this.f11563a.clear();
        this.f11563a.putAll(map);
    }

    void m15812a(String str) {
        this.f11564b = str;
    }

    void m15815b(Map<String, String> map) {
        this.f11565c.clear();
        this.f11565c.putAll(map);
    }

    public String mo4002a() {
        return this.f11564b;
    }

    public Map<String, String> mo4004c() {
        return this.f11563a;
    }

    public Map<String, String> mo4003b() {
        return this.f11565c;
    }
}
