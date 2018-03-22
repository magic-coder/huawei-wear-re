package com.huawei.pluginkidwatch.common.ui.listview;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: PariedDevicesSwitcher */
class C1527g implements AnimationListener {
    final /* synthetic */ PariedDevicesSwitcher f3611a;

    C1527g(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f3611a = pariedDevicesSwitcher;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f3611a.f3591f != null) {
            this.f3611a.f3598m.post(new C1528h(this));
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
