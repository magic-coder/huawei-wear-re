package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WheelBirthdayPicker */
class C1614o implements OnTouchListener {
    final /* synthetic */ C1608i f4099a;

    C1614o(C1608i c1608i) {
        this.f4099a = c1608i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f4099a.f4084e.setColor(false);
        this.f4099a.f4085f.setColor(false);
        this.f4099a.f4086g.setColor(true);
        return false;
    }
}
