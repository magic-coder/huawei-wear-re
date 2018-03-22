package com.huawei.ui.device.activity.pairing;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2120e implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7525a;

    C2120e(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7525a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter noteToHealth 2");
        this.f7525a.finish();
    }
}
