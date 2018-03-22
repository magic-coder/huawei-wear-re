package com.tencent.stat;

import com.huawei.membercenter.sdk.membersdklibrary.api.model.BundleKey;
import org.json.JSONException;
import org.json.JSONObject;

public class C6469b {
    private long f22443a = 0;
    private int f22444b = 0;
    private String f22445c = "";
    private int f22446d = 0;
    private String f22447e = "";

    public JSONObject m29497a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f22443a);
            jSONObject.put(BundleKey.KEY_ST, this.f22444b);
            if (this.f22445c != null) {
                jSONObject.put("dm", this.f22445c);
            }
            jSONObject.put("pt", this.f22446d);
            if (this.f22447e != null) {
                jSONObject.put("rip", this.f22447e);
            }
            jSONObject.put("ts", System.currentTimeMillis() / 1000);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public void m29498a(int i) {
        this.f22444b = i;
    }

    public void m29499a(long j) {
        this.f22443a = j;
    }

    public void m29500a(String str) {
        this.f22445c = str;
    }

    public void m29501b(int i) {
        this.f22446d = i;
    }

    public void m29502b(String str) {
        this.f22447e = str;
    }
}
