package com.huawei.ui.commonui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WheelCalendarPicker */
class C6072r implements OnTouchListener {
    final /* synthetic */ C6069o f20976a;

    C6072r(C6069o c6069o) {
        this.f20976a = c6069o;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f20976a.f20966e.setColor(false);
        this.f20976a.f20967f.setColor(false);
        this.f20976a.f20965d.setColor(true);
        return false;
    }
}
