package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateVersionActivity */
class C2180n implements OnClickListener {
    final /* synthetic */ UpdateVersionActivity f7760a;

    C2180n(UpdateVersionActivity updateVersionActivity) {
        this.f7760a = updateVersionActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("UpdateVersionActivity", "start showAppIsLowdialog, user click Positive button!");
        this.f7760a.f7718F.dismiss();
        this.f7760a.f7718F = null;
        this.f7760a.finish();
    }
}
