package com.google.tagmanager;

import com.google.analytics.p273b.p274a.p275a.C3644b;
import java.util.Collections;
import java.util.Map;

/* compiled from: ResourceUtil */
public class at {
    private final Map<String, C3644b> f14263a;
    private final C3644b f14264b;

    public void m18480a(String str, C3644b c3644b) {
        this.f14263a.put(str, c3644b);
    }

    public Map<String, C3644b> m18479a() {
        return Collections.unmodifiableMap(this.f14263a);
    }

    public C3644b m18481b() {
        return this.f14264b;
    }

    public String toString() {
        return "Properties: " + m18479a() + " pushAfterEvaluate: " + this.f14264b;
    }
}
