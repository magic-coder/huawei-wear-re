package com.tencent.stat.p544a;

import android.content.Context;
import com.tencent.stat.C6449a;
import com.tencent.stat.C6470c;
import com.tencent.stat.C6487u;
import com.tencent.stat.p545b.C6463m;
import org.json.JSONObject;

public abstract class C6443b {
    private static volatile boolean f22333k = false;
    protected String f22334a = null;
    protected long f22335b;
    protected int f22336c;
    protected C6449a f22337d = null;
    protected int f22338e;
    protected String f22339f = null;
    protected String f22340g = null;
    protected String f22341h = null;
    protected String f22342i = null;
    protected Context f22343j;

    C6443b(Context context, int i) {
        this.f22343j = context;
        this.f22335b = System.currentTimeMillis() / 1000;
        this.f22336c = i;
        this.f22334a = C6470c.m29504a(context);
        this.f22339f = C6470c.m29517c(context);
        this.f22337d = C6487u.m29594a(context).m29618b(context);
        this.f22338e = C6463m.m29481w(context).intValue();
        this.f22341h = C6463m.m29472n(context);
        this.f22340g = C6470c.m29512b(context);
    }

    public abstract C6445c mo5342a();

    public abstract boolean mo5343a(JSONObject jSONObject);

    public long m29364b() {
        return this.f22335b;
    }

    public boolean m29365b(JSONObject jSONObject) {
        try {
            C6463m.m29445a(jSONObject, "ky", this.f22334a);
            jSONObject.put("et", mo5342a().m29371a());
            if (this.f22337d != null) {
                jSONObject.put("ui", this.f22337d.m29391e());
                C6463m.m29445a(jSONObject, "mc", this.f22337d.m29393f());
                jSONObject.put("ut", this.f22337d.m29394g());
            }
            C6463m.m29445a(jSONObject, "cui", this.f22339f);
            if (mo5342a() != C6445c.SESSION_ENV) {
                C6463m.m29445a(jSONObject, "av", this.f22341h);
                C6463m.m29445a(jSONObject, "ch", this.f22340g);
            }
            C6463m.m29445a(jSONObject, "mid", C6470c.m29520d(this.f22343j));
            jSONObject.put("idx", this.f22338e);
            jSONObject.put("si", this.f22336c);
            jSONObject.put("ts", this.f22335b);
            if (this.f22337d.m29394g() == 0 && C6463m.m29437E(this.f22343j) == 1) {
                jSONObject.put("ia", 1);
            }
            return mo5343a(jSONObject);
        } catch (Throwable th) {
            return false;
        }
    }

    public Context m29366c() {
        return this.f22343j;
    }

    public String m29367d() {
        try {
            JSONObject jSONObject = new JSONObject();
            m29365b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable th) {
            return "";
        }
    }
}
