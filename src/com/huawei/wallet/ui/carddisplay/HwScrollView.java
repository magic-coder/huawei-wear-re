package com.huawei.wallet.ui.carddisplay;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;
import com.huawei.hwcommonmodel.p064d.C0978h;

public class HwScrollView extends ScrollView {
    public boolean f21436a;
    private int f21437b;
    private int f21438c;
    private int f21439d;
    private int f21440e;
    private int f21441f;
    private View f21442g;
    private float f21443h;
    private Rect f21444i;
    private boolean f21445j;
    private boolean f21446k;
    private boolean f21447l;

    public int getHwScrollY() {
        return this.f21437b;
    }

    public HwScrollView(Context context) {
        this(context, null);
    }

    public HwScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HwScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21444i = new Rect();
        this.f21445j = false;
        this.f21446k = false;
        this.f21436a = false;
        this.f21438c = getPaddingLeft();
        this.f21439d = getPaddingRight();
        this.f21441f = getPaddingBottom();
        this.f21440e = getPaddingTop();
    }

    public boolean m28269a() {
        return this.f21447l;
    }

    public void setCanRebound(boolean z) {
        this.f21447l = ((Boolean) C0978h.a(Boolean.valueOf(z))).booleanValue();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.f21442g = getChildAt(0);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f21442g != null) {
            this.f21444i.set(this.f21442g.getLeft(), this.f21442g.getTop(), this.f21442g.getRight(), this.f21442g.getBottom());
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f21442g == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (!m28269a()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f21445j = m28270b();
                this.f21446k = m28271c();
                this.f21443h = motionEvent.getY();
                break;
            case 1:
                if (this.f21436a) {
                    Animation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) this.f21442g.getTop(), (float) this.f21444i.top);
                    translateAnimation.setDuration(300);
                    this.f21442g.startAnimation(translateAnimation);
                    this.f21442g.layout(this.f21444i.left, this.f21444i.top, this.f21444i.right, this.f21444i.bottom);
                    this.f21445j = false;
                    this.f21446k = false;
                    this.f21436a = false;
                    break;
                }
                break;
            case 2:
                if (!this.f21445j && !this.f21446k) {
                    this.f21443h = motionEvent.getY();
                    this.f21445j = m28270b();
                    this.f21446k = m28271c();
                    break;
                }
                int y = (int) (motionEvent.getY() - this.f21443h);
                if ((this.f21445j && y > 0) || ((this.f21446k && y < 0) || (this.f21446k && this.f21445j))) {
                    z = true;
                }
                if (z) {
                    int i = (int) (((float) y) * 0.5f);
                    this.f21442g.layout(this.f21444i.left, this.f21444i.top + i, this.f21444i.right, i + this.f21444i.bottom);
                    this.f21436a = true;
                    break;
                }
                break;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean m28270b() {
        return getScrollY() == 0 || this.f21442g.getHeight() < getHeight() + getScrollY();
    }

    public boolean m28271c() {
        return this.f21442g.getHeight() <= getHeight() + getScrollY();
    }

    public int getContentHeight() {
        if (this.f21442g != null) {
            return this.f21442g.getHeight();
        }
        return 0;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        this.f21437b = i2;
        if (getScrollY() < 0) {
            setPadding(this.f21438c, this.f21440e, this.f21439d, this.f21441f);
        } else {
            setPadding(this.f21438c, 0, this.f21439d, this.f21441f);
        }
    }

    public void fling(int i) {
        super.fling(i);
        Log.i("HwScrollView", "fling velocityY= " + i);
    }
}
