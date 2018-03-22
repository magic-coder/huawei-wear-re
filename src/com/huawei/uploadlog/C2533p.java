package com.huawei.uploadlog;

import android.text.TextUtils;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.uploadlog.p188c.C2511g;
import org.json.JSONObject;

/* compiled from: UploadResponse */
public class C2533p {
    private int f9021a;
    private String f9022b;
    private String f9023c;
    private String f9024d;
    private String f9025e;
    private String f9026f;
    private String f9027g;
    private String f9028h;
    private int f9029i;

    public int m12619a(String str) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] 服务器返回信息" + str);
        if (TextUtils.isEmpty(str)) {
            C2511g.m12484d("BETACLUB_SDK", "Input param invalid.");
            return 1001;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            try {
                this.f9021a = Integer.parseInt(jSONObject.getString("res"));
                if (this.f9021a == 1 || this.f9021a == 2) {
                    m12620a(this.f9021a);
                    return 1001;
                }
                this.f9023c = jSONObject.getString("accessToken");
                this.f9026f = jSONObject.getString("timeStamp");
                this.f9027g = jSONObject.getString("callbackAddress");
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] res=" + this.f9021a);
                m12620a(this.f9021a);
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] accessToken=" + this.f9023c);
                m12627d(this.f9023c);
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] timeStamp=" + this.f9026f);
                if (this.f9026f != null) {
                    m12633g(this.f9026f);
                }
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] callbackAddress=" + this.f9027g);
                if (this.f9027g != null) {
                    m12635h(this.f9027g);
                }
                this.f9022b = jSONObject.optString("policy");
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] policy=" + this.f9022b);
                m12625c(this.f9022b);
                this.f9024d = jSONObject.optString("secret");
                m12629e(this.f9024d);
                this.f9025e = jSONObject.optString("uploadPath");
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] uploadPath=" + this.f9025e);
                if (!(this.f9025e == null || this.f9025e.equals(""))) {
                    m12631f(this.f9025e);
                }
                this.f9028h = jSONObject.optString("uploadAddress");
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parse] uploadAddress=" + this.f9028h);
                if (!(this.f9028h == null || this.f9028h.equals(""))) {
                    m12637i(this.f9028h);
                }
                return 0;
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", e.getMessage(), e);
                return 1007;
            }
        } catch (Throwable e2) {
            C2511g.m12482b("BETACLUB_SDK", e2.getMessage(), e2);
            return 1008;
        }
    }

    public int m12621b(String str) {
        C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parseInnerResponse] 服务器返回信息" + str);
        if (StringUtils.isNullOrEmpty(str)) {
            C2511g.m12484d("BETACLUB_SDK", "Input param invalid.");
            return 1001;
        }
        try {
            try {
                this.f9029i = Integer.parseInt(new JSONObject(str).getString("returnCode"));
                C2511g.m12481b("BETACLUB_SDK", "[UploadResponse.parseInnerResponse] returnCode=" + this.f9029i);
                m12623b(this.f9029i);
                return 0;
            } catch (Throwable e) {
                C2511g.m12482b("BETACLUB_SDK", "[UploadResponse.parseInnerResponse]Exception", e);
                return 1007;
            }
        } catch (Throwable e2) {
            C2511g.m12482b("BETACLUB_SDK", "[UploadResponse.parseInnerResponse]JSONException", e2);
            return 1008;
        }
    }

    public int m12618a() {
        return this.f9021a;
    }

    public void m12620a(int i) {
        this.f9021a = i;
    }

    public String m12622b() {
        return this.f9022b;
    }

    public void m12625c(String str) {
        this.f9022b = str;
    }

    public String m12624c() {
        return this.f9023c;
    }

    public void m12627d(String str) {
        this.f9023c = str;
    }

    public String m12626d() {
        return this.f9024d;
    }

    public void m12629e(String str) {
        this.f9024d = str;
    }

    public String m12628e() {
        return this.f9025e;
    }

    public void m12631f(String str) {
        this.f9025e = str;
    }

    public String m12630f() {
        return this.f9026f;
    }

    public void m12633g(String str) {
        this.f9026f = str;
    }

    public String m12632g() {
        return this.f9027g;
    }

    public void m12635h(String str) {
        this.f9027g = str;
    }

    public String m12634h() {
        return this.f9028h;
    }

    public void m12637i(String str) {
        this.f9028h = str;
    }

    public int m12636i() {
        return this.f9029i;
    }

    public void m12623b(int i) {
        this.f9029i = i;
    }
}
