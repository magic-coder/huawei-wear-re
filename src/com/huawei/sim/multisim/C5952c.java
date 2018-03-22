package com.huawei.sim.multisim;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MultiSimConfigActivity */
class C5952c implements OnClickListener {
    final /* synthetic */ MultiSimConfigActivity f20525a;

    C5952c(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20525a = multiSimConfigActivity;
    }

    public void onClick(View view) {
        new Handler().post(new C5953d(this));
    }
}
