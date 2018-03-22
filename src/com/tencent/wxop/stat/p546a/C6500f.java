package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.tencent.wxop.stat.C6544v;
import com.tencent.wxop.stat.C6547y;
import com.tencent.wxop.stat.p547b.C6523r;
import org.json.JSONObject;

public final class C6500f extends C6495d {
    public static final C6547y f22592a;

    static {
        C6547y c6547y = new C6547y();
        f22592a = c6547y;
        c6547y.m29891a("A9VH9B8L4GX4");
    }

    public C6500f(Context context) {
        super(context, 0, f22592a);
    }

    public final boolean mo5347a(JSONObject jSONObject) {
        C6523r.m29785a(jSONObject, "actky", C6544v.m29816a(this.l));
        return true;
    }

    public final C6499e mo5348b() {
        return C6499e.NETWORK_DETECTOR;
    }
}
