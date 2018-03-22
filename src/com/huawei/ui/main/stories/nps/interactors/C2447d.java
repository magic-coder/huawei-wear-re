package com.huawei.ui.main.stories.nps.interactors;

import com.android.volley.Response.Listener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.p184b.C2444b;

/* compiled from: HWNPSManager */
class C2447d implements Listener<String> {
    final /* synthetic */ C2442a f8810a;

    C2447d(C2442a c2442a) {
        this.f8810a = c2442a;
    }

    public /* synthetic */ void onResponse(Object obj) {
        m12276a((String) obj);
    }

    public void m12276a(String str) {
        if (str == null) {
            C2538c.m12677c(this.f8810a.f8785a, "nps responseDestSiteListener response is null ");
            return;
        }
        C2444b.m12275a(new C2449e(this, str), new Object[0]);
    }
}
