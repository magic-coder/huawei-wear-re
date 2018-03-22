package com.tencent.wxop.stat.p547b;

import org.json.JSONException;
import org.json.JSONObject;

public final class C6508c {
    private String f22661a = null;
    private String f22662b = null;
    private String f22663c = null;
    private String f22664d = "0";
    private int f22665e;
    private int f22666f = 0;
    private long f22667g = 0;

    public C6508c(String str, String str2, int i) {
        this.f22661a = str;
        this.f22662b = str2;
        this.f22665e = i;
    }

    private JSONObject m29711e() {
        JSONObject jSONObject = new JSONObject();
        try {
            C6523r.m29785a(jSONObject, "ui", this.f22661a);
            C6523r.m29785a(jSONObject, "mc", this.f22662b);
            C6523r.m29785a(jSONObject, "mid", this.f22664d);
            C6523r.m29785a(jSONObject, "aid", this.f22663c);
            jSONObject.put("ts", this.f22667g);
            jSONObject.put("ver", this.f22666f);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final String m29712a() {
        return this.f22661a;
    }

    public final String m29713b() {
        return this.f22662b;
    }

    public final void m29714c() {
        this.f22665e = 1;
    }

    public final int m29715d() {
        return this.f22665e;
    }

    public final String toString() {
        return m29711e().toString();
    }
}
