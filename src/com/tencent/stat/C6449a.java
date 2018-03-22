package com.tencent.stat;

import com.tencent.stat.p545b.C6452b;
import com.tencent.stat.p545b.C6463m;
import org.json.JSONObject;

public class C6449a {
    private static C6452b f22365h = C6463m.m29449b();
    private String f22366a = null;
    private String f22367b = null;
    private String f22368c = null;
    private String f22369d = "0";
    private int f22370e;
    private int f22371f = 0;
    private long f22372g = 0;

    C6449a() {
    }

    C6449a(String str, String str2, int i) {
        this.f22366a = str;
        this.f22367b = str2;
        this.f22370e = i;
    }

    static C6449a m29379a(String str) {
        C6449a c6449a = new C6449a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("ui")) {
                c6449a.m29390d(jSONObject.getString("ui"));
            }
            if (!jSONObject.isNull("mc")) {
                c6449a.m29392e(jSONObject.getString("mc"));
            }
            if (!jSONObject.isNull("mid")) {
                c6449a.m29388c(jSONObject.getString("mid"));
            }
            if (!jSONObject.isNull("aid")) {
                c6449a.m29386b(jSONObject.getString("aid"));
            }
            if (!jSONObject.isNull("ts")) {
                c6449a.m29383a(jSONObject.getLong("ts"));
            }
            if (!jSONObject.isNull("ver")) {
                c6449a.m29382a(jSONObject.getInt("ver"));
            }
        } catch (Exception e) {
            f22365h.m29406b(e);
        }
        return c6449a;
    }

    int m29380a() {
        return this.f22371f;
    }

    int m29381a(C6449a c6449a) {
        if (c6449a == null) {
            return 1;
        }
        String d = m29389d();
        String d2 = c6449a.m29389d();
        if (d != null && d2 != null && d.equals(d2)) {
            return 0;
        }
        int a = m29380a();
        int a2 = c6449a.m29380a();
        if (a > a2) {
            return 1;
        }
        if (a != a2) {
            return -1;
        }
        long b = m29384b();
        long b2 = c6449a.m29384b();
        return b <= b2 ? b == b2 ? 0 : -1 : 1;
    }

    void m29382a(int i) {
        this.f22371f = i;
    }

    void m29383a(long j) {
        this.f22372g = j;
    }

    long m29384b() {
        return this.f22372g;
    }

    void m29385b(int i) {
        this.f22370e = i;
    }

    void m29386b(String str) {
        this.f22368c = str;
    }

    JSONObject m29387c() {
        JSONObject jSONObject = new JSONObject();
        try {
            C6463m.m29445a(jSONObject, "ui", this.f22366a);
            C6463m.m29445a(jSONObject, "mc", this.f22367b);
            C6463m.m29445a(jSONObject, "mid", this.f22369d);
            C6463m.m29445a(jSONObject, "aid", this.f22368c);
            jSONObject.put("ts", this.f22372g);
            jSONObject.put("ver", this.f22371f);
        } catch (Exception e) {
            f22365h.m29406b(e);
        }
        return jSONObject;
    }

    void m29388c(String str) {
        this.f22369d = str;
    }

    public String m29389d() {
        return this.f22369d;
    }

    void m29390d(String str) {
        this.f22366a = str;
    }

    public String m29391e() {
        return this.f22366a;
    }

    void m29392e(String str) {
        this.f22367b = str;
    }

    public String m29393f() {
        return this.f22367b;
    }

    public int m29394g() {
        return this.f22370e;
    }

    public String toString() {
        return m29387c().toString();
    }
}
