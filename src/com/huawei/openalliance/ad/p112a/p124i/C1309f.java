package com.huawei.openalliance.ad.p112a.p124i;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class C1309f implements OnTouchListener {
    final /* synthetic */ C1307d f2831a;

    C1309f(C1307d c1307d) {
        this.f2831a = c1307d;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!(motionEvent == null || motionEvent.getAction() != 0 || this.f2831a.f2827k == null)) {
            this.f2831a.f2827k.onOperation();
        }
        return false;
    }
}
