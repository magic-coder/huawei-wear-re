package com.huawei.ui.device.views.onelevelmenu.dragonelevelsortlistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.e;

public class MenuDragListView extends ListView {
    private ImageView f7916a;
    private int f7917b;
    private int f7918c;
    private int f7919d;
    private int f7920e;
    private int f7921f;
    private int f7922g;
    private int f7923h;
    private int f7924i;
    private int f7925j = 0;
    private int f7926k;
    private int f7927l;
    private WindowManager f7928m;
    private LayoutParams f7929n;
    private boolean f7930o = false;
    private boolean f7931p = false;
    private boolean f7932q = false;
    private int f7933r;
    private int f7934s;
    private boolean f7935t = true;
    private int f7936u = -1;

    public MenuDragListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(2, null);
        this.f7928m = (WindowManager) getContext().getSystemService("window");
    }

    private void getSpacingUpAndDownBounce() {
        this.f7932q = true;
        this.f7922g = getHeight() / 3;
        this.f7923h = (getHeight() * 2) / 3;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        ViewGroup viewGroup2 = (ViewGroup) getChildAt(1);
        if (viewGroup != null) {
            viewGroup.getLocationOnScreen(iArr);
            if (viewGroup2 != null) {
                viewGroup2.getLocationOnScreen(iArr2);
                this.f7925j = Math.abs(iArr2[1] - iArr[1]);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || this.f7930o || this.f7931p) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int y = (int) motionEvent.getY();
        int pointToPosition = pointToPosition((int) motionEvent.getX(), y);
        this.f7918c = pointToPosition;
        this.f7917b = pointToPosition;
        this.f7919d = pointToPosition;
        if (this.f7918c == -1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (!this.f7932q) {
            getSpacingUpAndDownBounce();
        }
        ViewGroup viewGroup = (ViewGroup) getChildAt(this.f7918c - getFirstVisiblePosition());
        C2209a c2209a = (C2209a) getAdapter();
        this.f7920e = y - viewGroup.getTop();
        this.f7921f = (int) (motionEvent.getRawY() - ((float) y));
        this.f7927l = viewGroup.getHeight();
        this.f7933r = this.f7921f;
        if (m11340b()) {
            this.f7934s = this.f7921f + getChildAt(getAdapter().getCount() - 1).getTop();
        } else {
            this.f7934s = (this.f7921f + getHeight()) - this.f7927l;
        }
        View findViewById = viewGroup.findViewById(e.itemhandle);
        if (findViewById != null && findViewById.getVisibility() == 0) {
            C2538c.m12677c("TAG", "===123===" + m11337a(findViewById, (int) motionEvent.getRawX(), (int) motionEvent.getRawY()));
            if (m11337a(findViewById, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                viewGroup.destroyDrawingCache();
                viewGroup.setDrawingCacheEnabled(true);
                viewGroup.setBackgroundColor(638427131);
                Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache(true));
                m11334a();
                c2209a.m11351a(this.f7917b);
                c2209a.notifyDataSetChanged();
                m11336a(createBitmap, y);
                this.f7930o = false;
                c2209a.m11350a();
            }
        }
        return false;
    }

    private boolean m11337a(View view, int i, int i2) {
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int measuredWidth = view.getMeasuredWidth() + i3;
        int measuredHeight = view.getMeasuredHeight() + i4;
        if (i2 < i4 || i2 > measuredHeight || i < i3 || i > measuredWidth) {
            return false;
        }
        return true;
    }

    private void m11334a() {
        ((C2209a) getAdapter()).m11354a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f7916a == null || this.f7918c == -1) {
            return super.onTouchEvent(motionEvent);
        }
        int y;
        switch (motionEvent.getAction()) {
            case 1:
                y = (int) motionEvent.getY();
                m11341c();
                m11346e(y);
                break;
            case 2:
                y = (int) motionEvent.getY();
                m11342c(y);
                m11335a(y);
                break;
        }
        return true;
    }

    private void m11339b(int i, int i2) {
        C2209a c2209a = (C2209a) getAdapter();
        if (i != i2) {
            c2209a.m11352a(i, i2);
        }
    }

    private void m11335a(int i) {
        C2209a c2209a = (C2209a) getAdapter();
        int pointToPosition = pointToPosition(0, i);
        if (pointToPosition != -1 && pointToPosition != this.f7919d) {
            this.f7918c = pointToPosition;
            m11339b(this.f7919d, this.f7918c);
            int i2 = pointToPosition - this.f7919d;
            int abs = Math.abs(i2);
            for (int i3 = 1; i3 <= abs; i3++) {
                int i4;
                Animation a;
                int i5;
                if (i2 > 0) {
                    if (this.f7936u == -1) {
                        this.f7936u = 0;
                        this.f7935t = true;
                    }
                    if (this.f7936u == 1) {
                        this.f7936u = 0;
                        this.f7935t = !this.f7935t;
                    }
                    if (this.f7935t) {
                        this.f7926k = this.f7919d + 1;
                    } else if (this.f7917b < pointToPosition) {
                        this.f7926k = this.f7919d + 1;
                        this.f7935t = true;
                    } else {
                        this.f7926k = this.f7919d;
                    }
                    i5 = -this.f7925j;
                    this.f7919d++;
                    i4 = i5;
                } else {
                    if (this.f7936u == -1) {
                        this.f7936u = 1;
                        this.f7935t = true;
                    }
                    if (this.f7936u == 0) {
                        this.f7936u = 1;
                        this.f7935t = !this.f7935t;
                    }
                    if (this.f7935t) {
                        this.f7926k = this.f7919d - 1;
                    } else if (this.f7917b > pointToPosition) {
                        this.f7926k = this.f7919d - 1;
                        this.f7935t = true;
                    } else {
                        this.f7926k = this.f7919d;
                    }
                    i5 = this.f7925j;
                    this.f7919d--;
                    i4 = i5;
                }
                c2209a.m11358d(this.f7925j);
                c2209a.m11357c(this.f7936u);
                ViewGroup viewGroup = (ViewGroup) getChildAt(this.f7926k - getFirstVisiblePosition());
                if (this.f7935t) {
                    a = m11347a(0, i4);
                } else {
                    a = m11344d(0, -i4);
                }
                viewGroup.startAnimation(a);
            }
        }
    }

    private void m11343c(int i, int i2) {
        C2209a c2209a = (C2209a) getAdapter();
        c2209a.m11351a(-1);
        c2209a.m11354a(true);
        c2209a.notifyDataSetChanged();
    }

    private void m11336a(Bitmap bitmap, int i) {
        this.f7929n = new LayoutParams();
        this.f7929n.gravity = 48;
        this.f7929n.x = 0;
        this.f7929n.y = m11338b((i - this.f7920e) + this.f7921f);
        this.f7929n.width = -2;
        this.f7929n.height = -2;
        this.f7929n.flags = 408;
        this.f7929n.windowAnimations = 0;
        this.f7929n.alpha = 0.8f;
        this.f7929n.format = -3;
        View imageView = new ImageView(getContext());
        imageView.setImageBitmap(bitmap);
        this.f7928m.addView(imageView, this.f7929n);
        this.f7916a = imageView;
    }

    private int m11338b(int i) {
        if (i < this.f7933r) {
            return this.f7933r;
        }
        if (i > this.f7934s) {
            return this.f7934s;
        }
        return i;
    }

    private boolean m11340b() {
        if (getChildCount() == 0) {
            return true;
        }
        View childAt = getChildAt(0);
        if (((childAt.getBottom() - childAt.getTop()) + getDividerHeight()) * getAdapter().getCount() >= getHeight()) {
            return false;
        }
        return true;
    }

    private void m11342c(int i) {
        int i2 = i - this.f7920e;
        if (this.f7916a != null && i2 >= 0) {
            this.f7929n.alpha = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            this.f7929n.y = m11338b((i - this.f7920e) + this.f7921f);
            this.f7928m.updateViewLayout(this.f7916a, this.f7929n);
        }
        m11345d(i);
    }

    private void m11345d(int i) {
        if (i < this.f7922g) {
            this.f7924i = ((this.f7922g - i) / 10) + 1;
        } else if (i > this.f7923h) {
            this.f7924i = (-((i - this.f7923h) + 1)) / 10;
        } else {
            this.f7924i = 0;
        }
        setSelectionFromTop(this.f7918c, getChildAt(this.f7918c - getFirstVisiblePosition()).getTop() + this.f7924i);
    }

    private void m11341c() {
        this.f7930o = false;
        if (this.f7916a != null) {
            this.f7928m.removeView(this.f7916a);
            this.f7916a = null;
        }
        this.f7935t = true;
        this.f7936u = -1;
        C2209a c2209a = (C2209a) getAdapter();
        c2209a.m11357c(this.f7936u);
        c2209a.m11356b();
    }

    private void m11346e(int i) {
        m11343c(0, i);
    }

    public Animation m11347a(int i, int i2) {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 0, (float) i, 1, 0.0f, 0, (float) i2);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        return translateAnimation;
    }

    private Animation m11344d(int i, int i2) {
        Animation translateAnimation = new TranslateAnimation(0, (float) i, 1, 0.0f, 0, (float) i2, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        return translateAnimation;
    }
}
