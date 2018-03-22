package com.huawei.sim.multisim;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: MultiSimConfigActivity */
class C5956g implements OnClickListener {
    final /* synthetic */ MultiSimConfigActivity f20529a;

    C5956g(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20529a = multiSimConfigActivity;
    }

    public void onClick(View view) {
        C2538c.c("MultiSimConfigActivity", new Object[]{"user choose cancel"});
        if (this.f20529a.ad != null) {
            this.f20529a.ad.dismiss();
        }
    }
}
