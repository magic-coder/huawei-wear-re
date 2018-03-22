package com.huawei.ui.main.stories.nps.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class QuestionMainViewPager extends ViewPager {
    private boolean f8824a = true;

    public QuestionMainViewPager(Context context) {
        super(context);
    }

    public QuestionMainViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setDisableScroll(boolean z) {
        this.f8824a = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8824a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8824a) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }
}
