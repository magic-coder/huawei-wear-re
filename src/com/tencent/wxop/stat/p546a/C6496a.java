package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.tencent.wxop.stat.C6546x;
import com.tencent.wxop.stat.C6547y;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

public final class C6496a extends C6495d {
    protected C6497b f22572a = new C6497b();
    private long f22573m = -1;

    public C6496a(Context context, int i, String str, C6547y c6547y) {
        super(context, i, c6547y);
        this.f22572a.f22574a = str;
    }

    public final C6497b m29636a() {
        return this.f22572a;
    }

    public final boolean mo5347a(JSONObject jSONObject) {
        jSONObject.put("ei", this.f22572a.f22574a);
        if (this.f22573m > 0) {
            jSONObject.put("du", this.f22573m);
        }
        if (this.f22572a.f22575b == null) {
            if (this.f22572a.f22574a != null) {
                Map a = C6546x.m29861a(this.f22572a.f22574a);
                if (a != null && a.size() > 0) {
                    if (this.f22572a.f22576c == null || this.f22572a.f22576c.length() == 0) {
                        this.f22572a.f22576c = new JSONObject(a);
                    } else {
                        for (Entry entry : a.entrySet()) {
                            try {
                                this.f22572a.f22576c.put(entry.getKey().toString(), entry.getValue());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
            jSONObject.put("kv", this.f22572a.f22576c);
        } else {
            jSONObject.put("ar", this.f22572a.f22575b);
        }
        return true;
    }

    public final C6499e mo5348b() {
        return C6499e.CUSTOM;
    }
}
