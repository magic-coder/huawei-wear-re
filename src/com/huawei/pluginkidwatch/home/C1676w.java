package com.huawei.pluginkidwatch.home;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: HomeActivity */
class C1676w implements AnimationListener {
    final /* synthetic */ HomeActivity f4376a;

    C1676w(HomeActivity homeActivity) {
        this.f4376a = homeActivity;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        if (this.f4376a.f4124U) {
            this.f4376a.f4121R.clearAnimation();
            this.f4376a.f4121R.startAnimation(this.f4376a.f4122S);
        }
    }
}
