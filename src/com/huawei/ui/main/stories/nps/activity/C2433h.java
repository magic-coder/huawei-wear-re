package com.huawei.ui.main.stories.nps.activity;

import com.android.volley.Response.Listener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.nps.interactors.p184b.C2444b;

/* compiled from: QuestionMainActivity */
class C2433h implements Listener<String> {
    final /* synthetic */ QuestionMainActivity f8764a;

    C2433h(QuestionMainActivity questionMainActivity) {
        this.f8764a = questionMainActivity;
    }

    public /* synthetic */ void onResponse(Object obj) {
        m12217a((String) obj);
    }

    public void m12217a(String str) {
        C2538c.m12677c(this.f8764a.f8720a, "nps upload answers sucessfull response:" + str);
        this.f8764a.f8741v = false;
        if (str != null) {
            C2444b.m12275a(new C2434i(this, str), new Object[0]);
        }
    }
}
