package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.tencent.wxop.stat.C6547y;
import com.tencent.wxop.stat.p547b.C6523r;
import org.json.JSONObject;

public final class C6502h extends C6495d {
    Long f22596a = null;
    String f22597m;
    String f22598n;

    public C6502h(Context context, String str, String str2, int i, Long l, C6547y c6547y) {
        super(context, i, c6547y);
        this.f22598n = str;
        this.f22597m = str2;
        this.f22596a = l;
    }

    public final boolean mo5347a(JSONObject jSONObject) {
        C6523r.m29785a(jSONObject, "pi", this.f22597m);
        C6523r.m29785a(jSONObject, "rf", this.f22598n);
        if (this.f22596a != null) {
            jSONObject.put("du", this.f22596a);
        }
        return true;
    }

    public final C6499e mo5348b() {
        return C6499e.PAGE_VIEW;
    }
}
