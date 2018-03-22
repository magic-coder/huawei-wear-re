package com.huawei.ui.commonui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ThreeWheelPicker */
class C6062h implements OnTouchListener {
    final /* synthetic */ C6059e f20950a;

    C6062h(C6059e c6059e) {
        this.f20950a = c6059e;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f20950a.f20936d != null) {
            this.f20950a.f20936d.setColor(false);
        }
        if (this.f20950a.f20935c != null) {
            this.f20950a.f20935c.setColor(false);
        }
        if (this.f20950a.f20937e != null) {
            this.f20950a.f20937e.setColor(true);
        }
        return false;
    }
}
