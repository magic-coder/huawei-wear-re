package com.huawei.pluginkidwatch.plugin.feature.newsport.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.e;

public class NewSportCanScrollViewPager extends ViewPager {
    private boolean f5011a = true;

    public NewSportCanScrollViewPager(Context context) {
        super(context);
    }

    public NewSportCanScrollViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setScanScroll(boolean z) {
        this.f5011a = z;
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C2538c.m12674b("CustomCanScrollViewPager", "CustomCanScrollViewPager onTouchEvent...");
        if (this.f5011a) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        C2538c.m12674b("CustomCanScrollViewPager", "CustomCanScrollViewPager onInterceptTouchEvent...");
        try {
            if (this.f5011a && getResources().getDimensionPixelSize(e.kw_feature_sports_viewpager_height) <= ((int) motionEvent.getY())) {
                z = super.onInterceptTouchEvent(motionEvent);
            }
        } catch (IllegalArgumentException e) {
            C2538c.m12674b("IllegalArgumentException", e.getMessage());
        }
        return z;
    }
}
