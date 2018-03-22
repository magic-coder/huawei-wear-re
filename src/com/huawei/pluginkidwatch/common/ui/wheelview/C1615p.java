package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: WheelView */
class C1615p extends SimpleOnGestureListener {
    final /* synthetic */ WheelView f4100a;

    C1615p(WheelView wheelView) {
        this.f4100a = wheelView;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (!this.f4100a.f4016B) {
            return false;
        }
        this.f4100a.f4019E.forceFinished(true);
        this.f4100a.m7393f();
        return true;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.f4100a.m7397h();
        this.f4100a.m7380b((int) (-f2));
        return true;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int i;
        this.f4100a.f4020F = (this.f4100a.f4048o * this.f4100a.getItemHeight()) + this.f4100a.f4017C;
        int a = this.f4100a.f4038b ? Integer.MAX_VALUE : this.f4100a.f4047n.mo2550a() * this.f4100a.getItemHeight();
        if (this.f4100a.f4038b) {
            i = -a;
        } else {
            i = 0;
        }
        this.f4100a.f4019E.fling(0, this.f4100a.f4020F, 0, ((int) (-f2)) / 2, 0, 0, i, a);
        this.f4100a.setNextMessage(0);
        return true;
    }
}
