package com.huawei.ui.homewear21.p175a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: HomeFragment */
class aj implements AnimationListener {
    final /* synthetic */ C2217a f8051a;

    aj(C2217a c2217a) {
        this.f8051a = c2217a;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f8051a.f8027l.startAnimation(this.f8051a.f8002K);
    }
}
