package com.huawei.wallet.ui.cardholder;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.huawei.nfc.util.GodClassUtil;

public class ScrollViewTouchListener implements OnTouchListener {
    private boolean f21501a;

    public ScrollViewTouchListener(boolean z) {
        m28321b(z);
    }

    private void m28321b(boolean z) {
        m28322a(z);
    }

    public void m28322a(boolean z) {
        this.f21501a = ((Boolean) GodClassUtil.commonFunc(Boolean.valueOf(z))).booleanValue();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f21501a) {
            return false;
        }
        return true;
    }
}
