package com.huawei.ui.commonui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WheelCalendarPicker */
class C6073s implements OnTouchListener {
    final /* synthetic */ C6069o f20977a;

    C6073s(C6069o c6069o) {
        this.f20977a = c6069o;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f20977a.f20965d.setColor(false);
        this.f20977a.f20967f.setColor(false);
        this.f20977a.f20966e.setColor(true);
        return false;
    }
}
