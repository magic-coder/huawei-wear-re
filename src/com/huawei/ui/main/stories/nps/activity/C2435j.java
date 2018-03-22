package com.huawei.ui.main.stories.nps.activity;

import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;

/* compiled from: QuestionMainActivity */
class C2435j implements ErrorListener {
    final /* synthetic */ QuestionMainActivity f8767a;

    C2435j(QuestionMainActivity questionMainActivity) {
        this.f8767a = questionMainActivity;
    }

    public void onErrorResponse(VolleyError volleyError) {
        this.f8767a.f8741v = false;
        if (volleyError != null) {
            C2538c.m12677c(this.f8767a.f8720a, "nps upload answers error:" + volleyError.getMessage());
            if (!C0977d.m3555e(this.f8767a.f8722c)) {
            }
        }
    }
}
