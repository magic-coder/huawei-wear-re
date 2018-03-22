package com.huawei.ui.device.activity.pairing;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2134s implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7544a;

    C2134s(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7544a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "noteToHealth showunBindDialog onclick");
        this.f7544a.m10927d();
        this.f7544a.aq = null;
    }
}
