package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EsimConformInvailActivity */
class C5946w implements OnClickListener {
    final /* synthetic */ EsimConformInvailActivity f20461a;

    C5946w(EsimConformInvailActivity esimConformInvailActivity) {
        this.f20461a = esimConformInvailActivity;
    }

    public void onClick(View view) {
        this.f20461a.startActivity(new Intent(this.f20461a, EsimActivationActivity.class));
        this.f20461a.finish();
    }
}
