package com.huawei.ui.main.stories.nps.interactors;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.huawei.p190v.C2538c;

/* compiled from: HWNPSManager */
class C2450f implements ErrorListener {
    final /* synthetic */ C2442a f8816a;

    C2450f(C2442a c2442a) {
        this.f8816a = c2442a;
    }

    public void onErrorResponse(VolleyError volleyError) {
        C2538c.m12677c(this.f8816a.f8785a, "nps errorDestSiteListener error!");
    }
}
