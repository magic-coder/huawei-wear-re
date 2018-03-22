package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WheelBirthdayPicker */
class C1613n implements OnTouchListener {
    final /* synthetic */ C1608i f4098a;

    C1613n(C1608i c1608i) {
        this.f4098a = c1608i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f4098a.f4084e.setColor(false);
        this.f4098a.f4086g.setColor(false);
        this.f4098a.f4085f.setColor(true);
        return false;
    }
}
