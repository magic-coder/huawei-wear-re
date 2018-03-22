package com.huawei.ui.device.activity.pairing;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2137v implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7547a;

    C2137v(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7547a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "forceToHealth showunBindDialog onclick");
        this.f7547a.m10927d();
        this.f7547a.ap = null;
    }
}
