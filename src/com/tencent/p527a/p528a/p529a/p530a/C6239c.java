package com.tencent.p527a.p528a.p529a.p530a;

import android.util.Log;
import org.json.JSONObject;

public final class C6239c {
    String f21706a = null;
    String f21707b = null;
    String f21708c = "0";
    long f21709d = 0;

    static C6239c m28676a(String str) {
        C6239c c6239c = new C6239c();
        if (C6243h.m28693a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c6239c.f21706a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    c6239c.f21707b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    c6239c.f21708c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull("ts")) {
                    c6239c.f21709d = jSONObject.getLong("ts");
                }
            } catch (Throwable e) {
                Log.w("MID", e);
            }
        }
        return c6239c;
    }

    private JSONObject m28677b() {
        JSONObject jSONObject = new JSONObject();
        try {
            C6243h.m28691a(jSONObject, "ui", this.f21706a);
            C6243h.m28691a(jSONObject, "mc", this.f21707b);
            C6243h.m28691a(jSONObject, "mid", this.f21708c);
            jSONObject.put("ts", this.f21709d);
        } catch (Throwable e) {
            Log.w("MID", e);
        }
        return jSONObject;
    }

    public final String m28678a() {
        return this.f21708c;
    }

    public final String toString() {
        return m28677b().toString();
    }
}
