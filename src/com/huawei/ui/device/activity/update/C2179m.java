package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateVersionActivity */
class C2179m implements OnClickListener {
    final /* synthetic */ UpdateVersionActivity f7759a;

    C2179m(UpdateVersionActivity updateVersionActivity) {
        this.f7759a = updateVersionActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("UpdateVersionActivity", "start showAppIsLowdialog, user click Negative button! ");
        this.f7759a.f7718F.dismiss();
        this.f7759a.f7718F = null;
        this.f7759a.m11169u();
    }
}
