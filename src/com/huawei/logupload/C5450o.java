package com.huawei.logupload;

import android.text.TextUtils;
import com.huawei.logupload.c.f;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UploadResponse */
public class C5450o {
    private int f19285a;
    private String f19286b;
    private String f19287c;
    private String f19288d;
    private String f19289e;
    private String f19290f;
    private String f19291g;
    private String f19292h;

    public int m26104a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                try {
                    this.f19285a = Integer.valueOf(jSONObject.getString("res")).intValue();
                    if (this.f19285a == 1 || this.f19285a == 2) {
                        m26105a(this.f19285a);
                        return 1001;
                    }
                    this.f19287c = jSONObject.getString("accessToken");
                    this.f19290f = jSONObject.getString("timeStamp");
                    this.f19291g = jSONObject.getString("callbackAddress");
                    f.b("LogUpload Service", "res" + this.f19285a);
                    m26105a(this.f19285a);
                    m26109c(this.f19287c);
                    f.b("LogUpload Service", "timeStamp" + this.f19290f);
                    if (this.f19290f != null) {
                        m26115f(this.f19290f);
                    }
                    if (this.f19291g != null) {
                        m26117g(this.f19291g);
                    }
                    this.f19286b = jSONObject.optString("policy");
                    f.b("LogUpload Service", "policy" + this.f19286b);
                    m26107b(this.f19286b);
                    this.f19288d = jSONObject.optString("secret");
                    m26111d(this.f19288d);
                    this.f19289e = jSONObject.optString("uploadPath");
                    if (!(this.f19289e == null || this.f19289e.equals(""))) {
                        m26113e(this.f19289e);
                    }
                    this.f19292h = jSONObject.optString("uploadAddress");
                    if (!(this.f19292h == null || this.f19292h.equals(""))) {
                        m26119h(this.f19292h);
                    }
                    return 0;
                } catch (Exception e) {
                    if (f.a(4)) {
                        f.d("LogUpload Service", e.getMessage());
                    }
                    return 1007;
                }
            } catch (JSONException e2) {
                if (f.a(4)) {
                    f.d("LogUpload Service", e2.getMessage());
                }
                return 1008;
            }
        } else if (!f.a(4)) {
            return 1001;
        } else {
            f.d("LogUpload Service", "Input param invalid.");
            return 1001;
        }
    }

    public int m26103a() {
        return this.f19285a;
    }

    public void m26105a(int i) {
        this.f19285a = i;
    }

    public String m26106b() {
        return this.f19286b;
    }

    public void m26107b(String str) {
        this.f19286b = str;
    }

    public String m26108c() {
        return this.f19287c;
    }

    public void m26109c(String str) {
        this.f19287c = str;
    }

    public String m26110d() {
        return this.f19288d;
    }

    public void m26111d(String str) {
        this.f19288d = str;
    }

    public String m26112e() {
        return this.f19289e;
    }

    public void m26113e(String str) {
        this.f19289e = str;
    }

    public String m26114f() {
        return this.f19290f;
    }

    public void m26115f(String str) {
        this.f19290f = str;
    }

    public String m26116g() {
        return this.f19291g;
    }

    public void m26117g(String str) {
        this.f19291g = str;
    }

    public String m26118h() {
        return this.f19292h;
    }

    public void m26119h(String str) {
        this.f19292h = str;
    }
}
