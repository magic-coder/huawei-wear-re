package com.tencent.connect.avatar;

import com.tencent.tauth.C6252b;
import com.tencent.tauth.C6494d;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
class C6254g implements C6252b {
    final /* synthetic */ ImageActivity f21763a;

    C6254g(ImageActivity imageActivity) {
        this.f21763a = imageActivity;
    }

    public void mo5287a(C6494d c6494d) {
        m28759a(0);
    }

    public void mo5288a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        int i = -1;
        try {
            i = jSONObject.getInt("ret");
            if (i == 0) {
                this.f21763a.f21735d.post(new C6255h(this, jSONObject.getString("nickname")));
                this.f21763a.m28752a("10659", 0);
            } else {
                this.f21763a.m28752a("10661", 0);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (i != 0) {
            m28759a(i);
        }
    }

    public void mo5286a() {
    }

    private void m28759a(int i) {
        if (this.f21763a.f21742k < 2) {
            this.f21763a.m28741e();
        }
    }
}
