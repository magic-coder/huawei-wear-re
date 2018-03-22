package com.tencent.open.yyb;

import android.content.Intent;
import com.tencent.open.p541a.C6367n;
import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6425a implements C6252b {
    final /* synthetic */ AppbarActivity f22308a;

    public void mo5287a(C6494d c6494d) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarJsBridge)openLoginActivity onError");
        this.f22308a.f22297f.m29331a("loginCallback", 0, null, -5);
    }

    public void mo5288a(Object obj) {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarJsBridge)openLoginActivity onComplete");
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optInt("ret", -1) != 0) {
            this.f22308a.f22297f.m29331a("loginCallback", 0, null, -5);
            return;
        }
        try {
            String string = jSONObject.getString("openid");
            String string2 = jSONObject.getString("access_token");
            jSONObject.getString("expires_in");
            C6438n.m29354a(this.f22308a, this.f22308a.f22293b.getUrl(), string, string2, this.f22308a.m29303i().m28849b());
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("logintype", "SSO");
                jSONObject2.put("openid", string);
                jSONObject2.put("accesstoken", string2);
                this.f22308a.f22297f.m29332a("loginCallback", 0, null, jSONObject2.toString());
                Intent intent = new Intent();
                intent.putExtra("login_info", jSONObject.toString());
                this.f22308a.setResult(10101, intent);
            } catch (JSONException e) {
                this.f22308a.f22297f.m29331a("loginCallback", 0, null, -5);
                C6367n.m29107b("openSDK_LOG", "-->(AppbarJsBridge)openLoginActivity onComplete: put keys callback failed.");
            }
        } catch (JSONException e2) {
            this.f22308a.f22297f.m29331a("loginCallback", 0, null, -5);
            C6367n.m29107b("openSDK_LOG", "-->(AppbarJsBridge)openLoginActivity onComplete: get keys failed.");
        }
    }

    public void mo5286a() {
        C6367n.m29107b("openSDK_LOG", "-->(AppbarJsBridge)openLoginActivity onCancel");
        this.f22308a.f22297f.m29331a("loginCallback", 0, null, -2);
    }
}
