package com.huawei.ui.main.stories.account.interactor;

import com.huawei.p190v.C2538c;
import com.tencent.tauth.b;
import com.tencent.tauth.d;
import org.json.JSONObject;

/* compiled from: QQ */
class C2362m implements b {
    final /* synthetic */ C2360k f8541a;

    private C2362m(C2360k c2360k) {
        this.f8541a = c2360k;
    }

    public void m11973a(Object obj) {
        try {
            JSONObject jSONObject = (JSONObject) obj;
            if (!jSONObject.isNull("openid") && !jSONObject.isNull("access_token")) {
                new C2363n(this, jSONObject.getString("access_token"), jSONObject.getString("openid")).execute(new Void[0]);
            }
        } catch (RuntimeException e) {
            C2538c.m12680e(C2360k.f8534a, "onComplete() Exception=" + e.getMessage());
        } catch (Exception e2) {
            C2538c.m12680e(C2360k.f8534a, "onComplete() Exception=" + e2.getMessage());
        }
    }

    public void m11972a(d dVar) {
        if (this.f8541a.f8536c != null) {
            this.f8541a.f8536c.mo2654a(1, null, null, null, -1);
        }
    }

    public void m11971a() {
        if (this.f8541a.f8536c != null) {
            this.f8541a.f8536c.mo2654a(2, null, null, null, -1);
        }
    }
}
