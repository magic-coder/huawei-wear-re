package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ThreeWheelPicker */
class C1607g implements OnTouchListener {
    final /* synthetic */ C1605e f4077a;

    C1607g(C1605e c1605e) {
        this.f4077a = c1605e;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f4077a.f4068d != null) {
            this.f4077a.f4068d.setColor(false);
        }
        if (this.f4077a.f4067c != null) {
            this.f4077a.f4067c.setColor(false);
        }
        if (this.f4077a.f4069e != null) {
            this.f4077a.f4069e.setColor(true);
        }
        return false;
    }
}
