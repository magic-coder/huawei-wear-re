package com.huawei.p523y.p524a;

import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

/* compiled from: HWOTAV1XMgr */
class C6178g implements IBaseResponseCallback {
    final /* synthetic */ C6177f f21661a;

    C6178g(C6177f c6177f) {
        this.f21661a = c6177f;
    }

    public void onResponse(int i, Object obj) {
        String a = a.a((byte[]) obj);
        try {
            c.a(this.f21661a.f21654a).a(this.f21661a.f21658e, this.f21661a.f21657d, new Gson().toJson(this.f21661a.m28587a(this.f21661a.f21655b.m22743a(a.substring(6, a.length())))), this.f21661a.f21659f, this.f21661a.f21656c);
            C6172a.m28560b();
        } catch (Exception e) {
            C2538c.e("HWOTAV1XMgr", new Object[]{"OTAParameterNegotiationCallback() TLV error = " + e.getMessage()});
        }
    }
}
