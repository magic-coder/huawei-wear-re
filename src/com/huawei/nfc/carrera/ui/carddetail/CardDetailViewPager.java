package com.huawei.nfc.carrera.ui.carddetail;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class CardDetailViewPager extends ViewPager {
    private boolean isAllowScroll = false;

    public boolean isCanScroll() {
        return this.isAllowScroll;
    }

    public void setAllowScroll(boolean z) {
        this.isAllowScroll = z;
    }

    public CardDetailViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CardDetailViewPager(Context context) {
        super(context);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.isAllowScroll) {
            return super.onTouchEvent(motionEvent);
        }
        return this.isAllowScroll;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.isAllowScroll) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return this.isAllowScroll;
    }
}
