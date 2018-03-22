package com.tencent.connect.p193b;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: ProGuard */
class C6275m implements OnTouchListener {
    final /* synthetic */ C6273k f21836a;

    C6275m(C6273k c6273k) {
        this.f21836a = c6273k;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
        }
        return false;
    }
}
