package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateVersionActivity */
class C2175i implements OnClickListener {
    final /* synthetic */ UpdateVersionActivity f7755a;

    C2175i(UpdateVersionActivity updateVersionActivity) {
        this.f7755a = updateVersionActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("UpdateVersionActivity", "start wifiDialog, user click Positive button!");
        this.f7755a.f7717E.dismiss();
        this.f7755a.f7717E = null;
    }
}
