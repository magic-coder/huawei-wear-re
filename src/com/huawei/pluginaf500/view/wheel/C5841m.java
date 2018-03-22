package com.huawei.pluginaf500.view.wheel;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: WheelView */
class C5841m extends SimpleOnGestureListener {
    final /* synthetic */ WheelView f20107a;

    C5841m(WheelView wheelView) {
        this.f20107a = wheelView;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.f20107a.f20080z) {
            return false;
        }
        this.f20107a.f20042C.forceFinished(true);
        this.f20107a.m26956f();
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f20107a.m26960h();
        this.f20107a.m26943b((int) (-f2));
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int i2;
        this.f20107a.f20043D = (this.f20107a.f20067m * this.f20107a.getItemHeight()) + this.f20107a.f20040A;
        if (this.f20107a.f20057b) {
            i = Integer.MAX_VALUE;
        } else {
            i = this.f20107a.f20066l.mo5120a() * this.f20107a.getItemHeight();
        }
        if (this.f20107a.f20057b) {
            i2 = -i;
        } else {
            i2 = 0;
        }
        this.f20107a.f20042C.fling(0, this.f20107a.f20043D, 0, ((int) (-f2)) / 2, 0, 0, i2, i);
        this.f20107a.setNextMessage(0);
        return true;
    }
}
