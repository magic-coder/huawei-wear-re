package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ThreeWheelPicker */
class C1606f implements OnTouchListener {
    final /* synthetic */ C1605e f4076a;

    C1606f(C1605e c1605e) {
        this.f4076a = c1605e;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f4076a.f4068d != null) {
            this.f4076a.f4068d.setColor(false);
        }
        if (this.f4076a.f4067c != null) {
            this.f4076a.f4067c.setColor(true);
        }
        if (this.f4076a.f4069e != null) {
            this.f4076a.f4069e.setColor(false);
        }
        return false;
    }
}
