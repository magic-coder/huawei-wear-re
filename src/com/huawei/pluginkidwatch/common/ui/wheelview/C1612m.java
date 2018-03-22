package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: WheelBirthdayPicker */
class C1612m implements OnTouchListener {
    final /* synthetic */ C1608i f4097a;

    C1612m(C1608i c1608i) {
        this.f4097a = c1608i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.f4097a.f4085f.setColor(false);
        this.f4097a.f4086g.setColor(false);
        this.f4097a.f4084e.setColor(true);
        return false;
    }
}
