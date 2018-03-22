package com.huawei.ui.commonui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ThreeWheelPicker */
class C6060f implements OnTouchListener {
    final /* synthetic */ C6059e f20948a;

    C6060f(C6059e c6059e) {
        this.f20948a = c6059e;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f20948a.f20936d != null) {
            this.f20948a.f20936d.setColor(false);
        }
        if (this.f20948a.f20935c != null) {
            this.f20948a.f20935c.setColor(true);
        }
        if (this.f20948a.f20937e != null) {
            this.f20948a.f20937e.setColor(false);
        }
        return false;
    }
}
