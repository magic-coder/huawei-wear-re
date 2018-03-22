package com.huawei.sim.multisim;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MultiSimConfigActivity */
class C5954e implements OnClickListener {
    final /* synthetic */ MultiSimConfigActivity f20527a;

    C5954e(MultiSimConfigActivity multiSimConfigActivity) {
        this.f20527a = multiSimConfigActivity;
    }

    public void onClick(View view) {
        new Handler().post(new C5955f(this));
    }
}
