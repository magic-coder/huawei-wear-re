package com.huawei.pluginkidwatch.home;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: HomeActivity */
class C1657l implements AnimationListener {
    final /* synthetic */ HomeActivity f4358a;

    C1657l(HomeActivity homeActivity) {
        this.f4358a = homeActivity;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f4358a.f4124U) {
            this.f4358a.f4121R.clearAnimation();
            this.f4358a.f4121R.startAnimation(this.f4358a.f4123T);
        }
    }
}
