package com.huawei.sim.esim.view;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EsimConformInvailActivity */
class C5945v implements OnClickListener {
    final /* synthetic */ EsimConformInvailActivity f20460a;

    C5945v(EsimConformInvailActivity esimConformInvailActivity) {
        this.f20460a = esimConformInvailActivity;
    }

    public void onClick(View view) {
        this.f20460a.startActivity(new Intent(this.f20460a, EsimActivationActivity.class));
        this.f20460a.finish();
    }
}
