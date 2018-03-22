package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateVersionActivity */
class C2177k implements OnClickListener {
    final /* synthetic */ UpdateVersionActivity f7757a;

    C2177k(UpdateVersionActivity updateVersionActivity) {
        this.f7757a = updateVersionActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("UpdateVersionActivity", "showExitUpdateDialog ok click");
        this.f7757a.f7716D.dismiss();
        this.f7757a.f7716D = null;
    }
}
