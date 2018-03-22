package com.huawei.ui.commonui.wheelview21;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: WheelView */
class C6089g extends SimpleOnGestureListener {
    final /* synthetic */ WheelView f21046a;

    C6089g(WheelView wheelView) {
        this.f21046a = wheelView;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f21046a.m27788h();
        this.f21046a.m27777c((int) (-f2));
        return true;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.f21046a.f21016r) {
            return false;
        }
        this.f21046a.f21019u.forceFinished(true);
        this.f21046a.m27786g();
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int i2;
        this.f21046a.f21020v = (this.f21046a.f21008j * this.f21046a.getItemHeight()) + this.f21046a.f21017s;
        if (this.f21046a.f21000b) {
            i = Integer.MAX_VALUE;
        } else {
            i = this.f21046a.f21007i.mo5132a() * this.f21046a.getItemHeight();
        }
        if (this.f21046a.f21000b) {
            i2 = -i;
        } else {
            i2 = 0;
        }
        this.f21046a.f21019u.fling(0, this.f21046a.f21020v, 0, ((int) (-f2)) / 2, 0, 0, i2, i);
        this.f21046a.setNextMessage(0);
        return true;
    }
}
