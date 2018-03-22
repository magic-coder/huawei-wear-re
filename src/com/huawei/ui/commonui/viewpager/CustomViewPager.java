package com.huawei.ui.commonui.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.p514d.C5999c;

public class CustomViewPager extends ViewPager {
    private boolean f20810a = false;
    private Context f20811b;
    private int f20812c = 0;
    private int f20813d = 1;

    public CustomViewPager(Context context) {
        super(context);
        this.f20811b = context;
        this.f20813d = 1;
    }

    public CustomViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20811b = context;
        this.f20813d = 1;
    }

    public void setScanScroll(boolean z) {
        this.f20813d = 1;
        this.f20810a = z;
    }

    public void setScrollHeightArea(int i) {
        this.f20812c = C5999c.m27451a(this.f20811b, (float) i);
    }

    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f20810a) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (motionEvent.getY() > ((float) this.f20812c)) {
                        this.f20813d = z;
                        try {
                            z = super.onTouchEvent(motionEvent);
                            break;
                        } catch (Exception e) {
                            C2538c.e("CustomViewPager", new Object[]{"onTouchEvent() Exception e = " + e.getMessage()});
                            break;
                        }
                    }
                    break;
                case 1:
                    if (this.f20813d == 0) {
                        this.f20813d = z;
                        try {
                            z = super.onTouchEvent(motionEvent);
                            break;
                        } catch (Exception e2) {
                            C2538c.e("CustomViewPager", new Object[]{"onTouchEvent() Exception e = " + e2.getMessage()});
                        }
                    }
                    this.f20813d = z;
                    break;
                default:
                    if (this.f20813d == 0) {
                        try {
                            z = super.onTouchEvent(motionEvent);
                            break;
                        } catch (Exception e22) {
                            C2538c.e("CustomViewPager", new Object[]{"onTouchEvent() Exception e = " + e22.getMessage()});
                            break;
                        }
                    }
                    break;
            }
        }
        return z;
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(i);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f20810a && motionEvent.getY() > ((float) this.f20812c)) {
            try {
                z = super.onInterceptTouchEvent(motionEvent);
            } catch (Exception e) {
                C2538c.e("CustomViewPager", new Object[]{"onInterceptTouchEvent() Exception e = " + e.getMessage()});
            }
        }
        return z;
    }
}
