package com.tencent.wxop.stat.p546a;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.wxop.stat.C6547y;
import com.tencent.wxop.stat.C6548z;
import com.tencent.wxop.stat.p547b.C6517l;
import com.tencent.wxop.stat.p547b.C6523r;
import org.json.JSONObject;

public final class C6501g extends C6495d {
    private static String f22593a = null;
    private String f22594m = null;
    private String f22595n = null;

    public C6501g(Context context, int i, C6547y c6547y) {
        super(context, i, c6547y);
        this.f22594m = C6548z.m29898a(context).m29904b();
        if (f22593a == null) {
            f22593a = C6517l.m29753i(context);
        }
    }

    public final void m29645a(String str) {
        this.f22595n = str;
    }

    public final boolean mo5347a(JSONObject jSONObject) {
        C6523r.m29785a(jSONObject, "op", f22593a);
        C6523r.m29785a(jSONObject, HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, this.f22594m);
        jSONObject.put("sp", this.f22595n);
        return true;
    }

    public final C6499e mo5348b() {
        return C6499e.NETWORK_MONITOR;
    }
}
