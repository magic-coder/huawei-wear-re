package com.tencent.stat.p544a;

import android.content.Context;
import com.tencent.stat.p545b.C6463m;
import org.json.JSONObject;

public class C6447e extends C6443b {
    Long f22360k = null;
    String f22361l;
    String f22362m;

    public C6447e(Context context, String str, String str2, int i, Long l) {
        super(context, i);
        this.f22362m = str;
        this.f22361l = str2;
        this.f22360k = l;
    }

    public C6445c mo5342a() {
        return C6445c.PAGE_VIEW;
    }

    public boolean mo5343a(JSONObject jSONObject) {
        C6463m.m29445a(jSONObject, "pi", this.f22361l);
        C6463m.m29445a(jSONObject, "rf", this.f22362m);
        if (this.f22360k != null) {
            jSONObject.put("du", this.f22360k);
        }
        return true;
    }
}
