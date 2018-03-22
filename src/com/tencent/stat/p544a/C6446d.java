package com.tencent.stat.p544a;

import android.content.Context;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.tencent.stat.p545b.C6463m;
import org.json.JSONObject;

public class C6446d extends C6443b {
    private static String f22357k = null;
    private String f22358l = null;
    private String f22359m = null;

    public C6446d(Context context, int i) {
        super(context, i);
        this.f22358l = C6463m.m29474p(context);
        if (f22357k == null) {
            f22357k = C6463m.m29471m(context);
        }
    }

    public C6445c mo5342a() {
        return C6445c.NETWORK_MONITOR;
    }

    public void m29373a(String str) {
        this.f22359m = str;
    }

    public boolean mo5343a(JSONObject jSONObject) {
        C6463m.m29445a(jSONObject, "op", f22357k);
        C6463m.m29445a(jSONObject, HwAccountConstants.DEFAULT_SIMPLE_COUNTRY_CODE, this.f22358l);
        jSONObject.put("sp", this.f22359m);
        return true;
    }
}
