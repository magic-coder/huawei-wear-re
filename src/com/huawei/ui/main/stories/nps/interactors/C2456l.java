package com.huawei.ui.main.stories.nps.interactors;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.huawei.p190v.C2538c;

/* compiled from: HWNPSManager */
class C2456l implements ErrorListener {
    final /* synthetic */ C2442a f8823a;

    C2456l(C2442a c2442a) {
        this.f8823a = c2442a;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (volleyError != null) {
            C2538c.m12674b(this.f8823a.f8785a, "nps errorListener get question error:" + volleyError.toString());
        }
    }
}
