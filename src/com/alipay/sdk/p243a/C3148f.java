package com.alipay.sdk.p243a;

import java.util.TimerTask;
import org.json.JSONException;
import org.json.JSONObject;

final class C3148f extends TimerTask {
    final /* synthetic */ C3143a f10523a;
    final /* synthetic */ C3146d f10524b;

    C3148f(C3146d c3146d, C3143a c3143a) {
        this.f10524b = c3146d;
        this.f10523a = c3143a;
    }

    public final void run() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("toastCallBack", "true");
        } catch (JSONException e) {
        }
        C3143a c3143a = new C3143a("callback");
        c3143a.f10507a = this.f10523a.f10507a;
        c3143a.f10511e = jSONObject;
        this.f10524b.f10519a.mo3669a(c3143a);
    }
}
