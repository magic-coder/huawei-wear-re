package com.huawei.ui.device.activity.update;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: UpdateVersionActivity */
class C2174h implements OnClickListener {
    final /* synthetic */ UpdateVersionActivity f7754a;

    C2174h(UpdateVersionActivity updateVersionActivity) {
        this.f7754a = updateVersionActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("UpdateVersionActivity", "start wifiDialog, user click Negative button! ");
        this.f7754a.f7717E.dismiss();
        this.f7754a.f7717E = null;
        this.f7754a.m11165q();
    }
}
