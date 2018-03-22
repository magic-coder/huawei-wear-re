package com.huawei.sim.esim.view;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EsimActivationActivity */
class C5934k implements OnClickListener {
    final /* synthetic */ EsimActivationActivity f20447a;

    C5934k(EsimActivationActivity esimActivationActivity) {
        this.f20447a = esimActivationActivity;
    }

    public void onClick(View view) {
        new Handler().post(new C5935l(this));
    }
}
