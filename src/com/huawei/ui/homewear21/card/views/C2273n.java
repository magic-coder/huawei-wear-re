package com.huawei.ui.homewear21.card.views;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.huawei.p190v.C2538c;

/* compiled from: PariedDevicesSwitcher */
class C2273n implements AnimationListener {
    final /* synthetic */ PariedDevicesSwitcher f8256a;

    C2273n(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f8256a = pariedDevicesSwitcher;
    }

    public void onAnimationStart(Animation animation) {
        C2538c.m12674b(PariedDevicesSwitcher.f8209b, "onAnimationStart");
    }

    public void onAnimationEnd(Animation animation) {
        C2538c.m12674b(PariedDevicesSwitcher.f8209b, "onAnimationEnd");
        if (this.f8256a.f8216h != null) {
            this.f8256a.f8230v.post(new C2274o(this));
        }
    }

    public void onAnimationRepeat(Animation animation) {
        C2538c.m12674b(PariedDevicesSwitcher.f8209b, "onAnimationRepeat");
    }
}
