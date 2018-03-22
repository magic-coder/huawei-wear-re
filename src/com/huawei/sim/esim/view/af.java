package com.huawei.sim.esim.view;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EsimProfileBTFailActivity */
class af implements OnClickListener {
    final /* synthetic */ EsimProfileBTFailActivity f20427a;

    af(EsimProfileBTFailActivity esimProfileBTFailActivity) {
        this.f20427a = esimProfileBTFailActivity;
    }

    public void onClick(View view) {
        new Handler().post(new ag(this));
    }
}
