package com.tencent.stat.p544a;

import android.content.Context;
import com.tencent.stat.p545b.C6453c;
import org.json.JSONObject;

public class C6448f extends C6443b {
    private C6453c f22363k;
    private JSONObject f22364l = null;

    public C6448f(Context context, int i, JSONObject jSONObject) {
        super(context, i);
        this.f22363k = new C6453c(context);
        this.f22364l = jSONObject;
    }

    public C6445c mo5342a() {
        return C6445c.SESSION_ENV;
    }

    public boolean mo5343a(JSONObject jSONObject) {
        if (this.f22337d != null) {
            jSONObject.put("ut", this.f22337d.m29394g());
        }
        if (this.f22364l != null) {
            jSONObject.put("cfg", this.f22364l);
        }
        this.f22363k.m29415a(jSONObject);
        return true;
    }
}
