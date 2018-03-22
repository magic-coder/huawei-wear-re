package com.tencent.wxop.stat;

import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import org.json.JSONException;
import org.json.JSONObject;

public final class C6543u {
    private long f22780a = 0;
    private int f22781b = 0;
    private String f22782c = "";
    private int f22783d = 0;
    private String f22784e = "";

    public final JSONObject m29809a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f22780a);
            jSONObject.put(BundleKey.KEY_ST, this.f22781b);
            if (this.f22782c != null) {
                jSONObject.put("dm", this.f22782c);
            }
            jSONObject.put("pt", this.f22783d);
            if (this.f22784e != null) {
                jSONObject.put("rip", this.f22784e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public final void m29810a(int i) {
        this.f22781b = i;
    }

    public final void m29811a(long j) {
        this.f22780a = j;
    }

    public final void m29812a(String str) {
        this.f22782c = str;
    }

    public final void m29813b(int i) {
        this.f22783d = i;
    }

    public final void m29814b(String str) {
        this.f22784e = str;
    }
}
