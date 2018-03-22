package com.huawei.ui.device.activity.pairing;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.C1975c;

/* compiled from: DevicePairGuideActivity */
class C2121f implements OnClickListener {
    final /* synthetic */ DevicePairGuideActivity f7526a;

    C2121f(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7526a = devicePairGuideActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("DevicePairGuideActivity", "showunBindDialog onclick");
        C1975c u = this.f7526a.al;
        Handler t = this.f7526a.am;
        this.f7526a.al;
        u.m10373a(t, 700, System.currentTimeMillis(), new C2122g(this));
        this.f7526a.as = null;
    }
}
