package com.huawei.multisimsdk.multidevicemanager.common;

import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import org.json.JSONArray;

/* compiled from: RequestInfo */
public class C1161m {
    private static final String f2496d = C1160l.class.getSimpleName();
    C1158j f2497a;
    C1163o f2498b = null;
    C1160l f2499c = null;

    public void m5194a(C1158j c1158j) {
        this.f2497a = c1158j;
    }

    public void m5196a(C1163o c1163o) {
        this.f2498b = c1163o;
    }

    public void m5195a(C1160l c1160l) {
        this.f2499c = c1160l;
    }

    public String m5193a() {
        C1183h.m5282b(f2496d, "RequestInfo start");
        JSONArray jSONArray = new JSONArray();
        if (this.f2497a != null) {
            jSONArray.put(this.f2497a.m5173b());
        }
        if (this.f2499c != null) {
            jSONArray.put(this.f2499c.m5184a());
        }
        if (this.f2498b != null) {
            jSONArray.put(this.f2498b.m5204a());
        }
        if (C1183h.f2599a.booleanValue()) {
            C1183h.m5282b(f2496d, "buildJsonObj-RequestInfo end:" + jSONArray.toString());
        }
        return jSONArray.toString();
    }
}
