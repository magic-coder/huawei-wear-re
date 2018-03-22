package com.huawei.sim.esim.view;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EsimConformBTFailActivity */
class C5938o implements OnClickListener {
    final /* synthetic */ EsimConformBTFailActivity f20451a;

    C5938o(EsimConformBTFailActivity esimConformBTFailActivity) {
        this.f20451a = esimConformBTFailActivity;
    }

    public void onClick(View view) {
        new Handler().post(new C5939p(this));
    }
}
