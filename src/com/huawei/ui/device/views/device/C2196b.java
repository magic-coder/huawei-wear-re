package com.huawei.ui.device.views.device;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;

/* compiled from: DeviceItemSlideHelper */
class C2196b implements AnimatorListener {
    final /* synthetic */ C2195a f7861a;

    C2196b(C2195a c2195a) {
        this.f7861a = c2195a;
    }

    public void onAnimationStart(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        this.f7861a.f7855i = null;
        if (this.f7861a.m11292c()) {
            this.f7861a.f7848b = null;
        }
    }

    public void onAnimationCancel(Animator animator) {
        this.f7861a.f7855i = null;
    }

    public void onAnimationRepeat(Animator animator) {
    }
}
