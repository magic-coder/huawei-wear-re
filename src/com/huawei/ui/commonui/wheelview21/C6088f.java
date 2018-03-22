package com.huawei.ui.commonui.wheelview21;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ThreeWheelPicker */
class C6088f implements OnTouchListener {
    final /* synthetic */ C6085c f21045a;

    C6088f(C6085c c6085c) {
        this.f21045a = c6085c;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f21045a.f21031d != null) {
            this.f21045a.f21031d.setColor(true);
        }
        if (this.f21045a.f21030c != null) {
            this.f21045a.f21030c.setColor(true);
        }
        if (this.f21045a.f21032e != null) {
            this.f21045a.f21032e.setColor(true);
        }
        return false;
    }
}
