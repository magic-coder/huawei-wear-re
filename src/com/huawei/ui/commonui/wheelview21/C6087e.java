package com.huawei.ui.commonui.wheelview21;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ThreeWheelPicker */
class C6087e implements OnTouchListener {
    final /* synthetic */ C6085c f21044a;

    C6087e(C6085c c6085c) {
        this.f21044a = c6085c;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f21044a.f21031d != null) {
            this.f21044a.f21031d.setColor(true);
        }
        if (this.f21044a.f21030c != null) {
            this.f21044a.f21030c.setColor(true);
        }
        if (this.f21044a.f21032e != null) {
            this.f21044a.f21032e.setColor(true);
        }
        return false;
    }
}
