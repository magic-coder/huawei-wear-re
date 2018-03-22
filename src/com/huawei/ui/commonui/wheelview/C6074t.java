package com.huawei.ui.commonui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WheelCalendarPicker */
class C6074t implements OnTouchListener {
    final /* synthetic */ C6069o f20978a;

    C6074t(C6069o c6069o) {
        this.f20978a = c6069o;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f20978a.f20965d.setColor(false);
        this.f20978a.f20966e.setColor(false);
        this.f20978a.f20967f.setColor(true);
        return false;
    }
}
