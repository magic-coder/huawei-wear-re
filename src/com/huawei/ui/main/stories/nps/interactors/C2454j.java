package com.huawei.ui.main.stories.nps.interactors;

import com.android.volley.Response.Listener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.p184b.C2444b;

/* compiled from: HWNPSManager */
class C2454j implements Listener<String> {
    final /* synthetic */ C2442a f8820a;

    C2454j(C2442a c2442a) {
        this.f8820a = c2442a;
    }

    public /* synthetic */ void onResponse(Object obj) {
        m12285a((String) obj);
    }

    public void m12285a(String str) {
        C2538c.m12677c(this.f8820a.f8785a, "nps responseListener get question successfull:" + str);
        if (str == null) {
            C2538c.m12677c(this.f8820a.f8785a, "nps responseListener response is null ");
            return;
        }
        C2444b.m12275a(new C2455k(this, str), new Object[0]);
    }
}
