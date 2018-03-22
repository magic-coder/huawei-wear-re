package com.huawei.ui.commonui.wheelview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: WheelView */
class C6079y extends SimpleOnGestureListener {
    final /* synthetic */ WheelView f20989a;

    C6079y(WheelView wheelView) {
        this.f20989a = wheelView;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.f20989a.f20875A) {
            return false;
        }
        this.f20989a.f20878D.forceFinished(true);
        this.f20989a.m27693g();
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f20989a.m27695h();
        this.f20989a.m27679b((int) (-f2));
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        int i2;
        this.f20989a.f20879E = (this.f20989a.f20900n * this.f20989a.getItemHeight()) + this.f20989a.f20876B;
        if (this.f20989a.f20890b) {
            i = Integer.MAX_VALUE;
        } else {
            i = this.f20989a.f20899m.mo5129a() * this.f20989a.getItemHeight();
        }
        if (this.f20989a.f20890b) {
            i2 = -i;
        } else {
            i2 = 0;
        }
        this.f20989a.f20878D.fling(0, this.f20989a.f20879E, 0, ((int) (-f2)) / 2, 0, 0, i2, i);
        this.f20989a.setNextMessage(0);
        return true;
    }
}
