package com.huawei.ui.device.activity.pairing;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2118c implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7523a;

    C2118c(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7523a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "noteToHealth showunBindDialog onclick");
        this.f7523a.m10927d();
        this.f7523a.ao = null;
        C2538c.m12677c("DevicePairGuideActivity", "Enter noteToHealth 1");
    }
}
