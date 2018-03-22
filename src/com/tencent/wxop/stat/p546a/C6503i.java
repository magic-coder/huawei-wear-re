package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.tencent.wxop.stat.C6547y;
import com.tencent.wxop.stat.p547b.C6509d;
import com.tencent.wxop.stat.p547b.C6517l;
import org.json.JSONObject;

public final class C6503i extends C6495d {
    private C6509d f22599a;
    private JSONObject f22600m = null;

    public C6503i(Context context, int i, JSONObject jSONObject, C6547y c6547y) {
        super(context, i, c6547y);
        this.f22599a = new C6509d(context);
        this.f22600m = jSONObject;
    }

    public final boolean mo5347a(JSONObject jSONObject) {
        if (this.f22565e != null) {
            jSONObject.put("ut", this.f22565e.m29715d());
        }
        if (this.f22600m != null) {
            jSONObject.put("cfg", this.f22600m);
        }
        if (C6517l.m29768v(this.l)) {
            jSONObject.put("ncts", 1);
        }
        this.f22599a.m29717a(jSONObject, null);
        return true;
    }

    public final C6499e mo5348b() {
        return C6499e.SESSION_ENV;
    }
}
