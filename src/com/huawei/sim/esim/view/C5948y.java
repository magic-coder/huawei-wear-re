package com.huawei.sim.esim.view;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EsimProfileAcitvity */
class C5948y implements OnClickListener {
    final /* synthetic */ EsimProfileAcitvity f20463a;

    C5948y(EsimProfileAcitvity esimProfileAcitvity) {
        this.f20463a = esimProfileAcitvity;
    }

    public void onClick(View view) {
        new Handler().post(new C5949z(this));
    }
}
