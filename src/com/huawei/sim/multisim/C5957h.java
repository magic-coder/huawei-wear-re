package com.huawei.sim.multisim;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: MultiSimConfigActivity */
class C5957h implements OnClickListener {
    final /* synthetic */ MultiSimConfigActivity f20530a;

    C5957h(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20530a = multiSimConfigActivity;
    }

    public void onClick(View view) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"user choose cancel"});
        this.f20530a.af.dismiss();
        this.f20530a.af = null;
    }
}
