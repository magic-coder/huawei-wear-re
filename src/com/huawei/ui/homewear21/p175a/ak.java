package com.huawei.ui.homewear21.p175a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: HomeFragment */
class ak implements AnimationListener {
    final /* synthetic */ C2217a f8052a;

    ak(C2217a c2217a) {
        this.f8052a = c2217a;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f8052a.f8027l.setImageResource(this.f8052a.aD());
        this.f8052a.f8027l.startAnimation(this.f8052a.f8001J);
    }
}
