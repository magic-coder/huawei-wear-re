package com.huawei.ui.device.activity.pairing;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2136u implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7546a;

    C2136u(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7546a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "forceToHealth cancle");
        this.f7546a.finish();
    }
}
