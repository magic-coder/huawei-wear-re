package com.huawei.ui.device.views.selectcontact.dragsortlistview;

import android.annotation.SuppressLint;
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
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.ui.device.e;

@SuppressLint({"NewApi", "HandlerLeak"})
public class DragListView extends ListView {
    private ImageView f7960a;
    private int f7961b;
    private int f7962c;
    private int f7963d;
    private int f7964e;
    private int f7965f;
    private int f7966g;
    private int f7967h;
    private int f7968i;
    private int f7969j = 0;
    private int f7970k;
    private WindowManager f7971l;
    private LayoutParams f7972m;
    private boolean f7973n;
    private boolean f7974o = false;
    private boolean f7975p = false;
    private boolean f7976q = false;
    private boolean f7977r = true;
    private int f7978s = -1;

    public DragListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLayerType(2, null);
        m11366b();
    }

    private void m11366b() {
        this.f7971l = (WindowManager) getContext().getSystemService("window");
    }

    private void getSpacing() {
        this.f7976q = true;
        this.f7966g = getHeight() / 3;
        this.f7967h = (getHeight() * 2) / 3;
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        ViewGroup viewGroup = (ViewGroup) getChildAt(0);
        ViewGroup viewGroup2 = (ViewGroup) getChildAt(1);
        if (viewGroup != null) {
            viewGroup.getLocationOnScreen(iArr);
            if (viewGroup2 != null) {
                viewGroup2.getLocationOnScreen(iArr2);
                this.f7969j = Math.abs(iArr2[1] - iArr[1]);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0 || this.f7973n || this.f7974o || this.f7975p) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int pointToPosition = pointToPosition(x, y);
        this.f7962c = pointToPosition;
        this.f7961b = pointToPosition;
        this.f7963d = pointToPosition;
        if (this.f7962c == -1) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (!this.f7976q) {
            getSpacing();
        }
        ViewGroup viewGroup = (ViewGroup) getChildAt(this.f7962c - getFirstVisiblePosition());
        C2215a c2215a = (C2215a) getAdapter();
        this.f7964e = y - viewGroup.getTop();
        this.f7965f = (int) (motionEvent.getRawY() - ((float) y));
        View findViewById = viewGroup.findViewById(e.drag_item_image);
        if (findViewById != null && findViewById.getVisibility() == 0 && x > findViewById.getLeft() - 20) {
            viewGroup.destroyDrawingCache();
            viewGroup.setDrawingCacheEnabled(true);
            viewGroup.setBackgroundColor(638427131);
            Bitmap createBitmap = Bitmap.createBitmap(viewGroup.getDrawingCache(true));
            m11369c();
            c2215a.m11379a(this.f7961b);
            c2215a.notifyDataSetChanged();
            m11365a(createBitmap, y);
            this.f7974o = false;
            c2215a.m11378a();
        }
        return false;
    }

    public Animation getScaleAnimation() {
        Animation scaleAnimation = new ScaleAnimation(0.0f, 0.0f, 0.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setFillAfter(true);
        return scaleAnimation;
    }

    private void m11369c() {
        ((C2215a) getAdapter()).m11381a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f7960a == null || this.f7962c == -1 || this.f7973n) {
            return super.onTouchEvent(motionEvent);
        }
        int y;
        switch (motionEvent.getAction()) {
            case 1:
                y = (int) motionEvent.getY();
                m11372a();
                m11375c(y);
                break;
            case 2:
                y = (int) motionEvent.getY();
                m11373a(y);
                m11371d(y);
                break;
        }
        return true;
    }

    private void m11364a(int i, int i2) {
        C2215a c2215a = (C2215a) getAdapter();
        if (i != i2) {
            c2215a.m11380a(i, i2);
        }
    }

    private void m11371d(int i) {
        C2215a c2215a = (C2215a) getAdapter();
        int pointToPosition = pointToPosition(0, i);
        if (pointToPosition != -1 && pointToPosition != this.f7963d) {
            this.f7962c = pointToPosition;
            m11364a(this.f7963d, this.f7962c);
            int i2 = pointToPosition - this.f7963d;
            int abs = Math.abs(i2);
            for (int i3 = 1; i3 <= abs; i3++) {
                int i4;
                Animation c;
                int i5;
                if (i2 > 0) {
                    if (this.f7978s == -1) {
                        this.f7978s = 0;
                        this.f7977r = true;
                    }
                    if (this.f7978s == 1) {
                        this.f7978s = 0;
                        this.f7977r = !this.f7977r;
                    }
                    if (this.f7977r) {
                        this.f7970k = this.f7963d + 1;
                    } else if (this.f7961b < pointToPosition) {
                        this.f7970k = this.f7963d + 1;
                        this.f7977r = true;
                    } else {
                        this.f7970k = this.f7963d;
                    }
                    i5 = -this.f7969j;
                    this.f7963d++;
                    i4 = i5;
                } else {
                    if (this.f7978s == -1) {
                        this.f7978s = 1;
                        this.f7977r = true;
                    }
                    if (this.f7978s == 0) {
                        this.f7978s = 1;
                        this.f7977r = !this.f7977r;
                    }
                    if (this.f7977r) {
                        this.f7970k = this.f7963d - 1;
                    } else if (this.f7961b > pointToPosition) {
                        this.f7970k = this.f7963d - 1;
                        this.f7977r = true;
                    } else {
                        this.f7970k = this.f7963d;
                    }
                    i5 = this.f7969j;
                    this.f7963d--;
                    i4 = i5;
                }
                c2215a.m11385d(this.f7969j);
                c2215a.m11384c(this.f7978s);
                ViewGroup viewGroup = (ViewGroup) getChildAt(this.f7970k - getFirstVisiblePosition());
                if (this.f7977r) {
                    c = m11368c(0, i4);
                } else {
                    c = m11370d(0, -i4);
                }
                viewGroup.startAnimation(c);
            }
        }
    }

    private void m11367b(int i, int i2) {
        C2215a c2215a = (C2215a) getAdapter();
        c2215a.m11379a(-1);
        c2215a.m11381a(true);
        c2215a.notifyDataSetChanged();
    }

    private void m11365a(Bitmap bitmap, int i) {
        this.f7972m = new LayoutParams();
        this.f7972m.gravity = 48;
        this.f7972m.x = 0;
        this.f7972m.y = (i - this.f7964e) + this.f7965f;
        this.f7972m.width = -2;
        this.f7972m.height = -2;
        this.f7972m.flags = 408;
        this.f7972m.windowAnimations = 0;
        this.f7972m.alpha = 0.8f;
        this.f7972m.format = -3;
        View imageView = new ImageView(getContext());
        imageView.setImageBitmap(bitmap);
        this.f7971l.addView(imageView, this.f7972m);
        this.f7960a = imageView;
    }

    public void m11373a(int i) {
        int i2 = i - this.f7964e;
        if (this.f7960a != null && i2 >= 0) {
            this.f7972m.alpha = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            this.f7972m.y = (i - this.f7964e) + this.f7965f;
            this.f7971l.updateViewLayout(this.f7960a, this.f7972m);
        }
        m11374b(i);
    }

    public void m11374b(int i) {
        if (i < this.f7966g) {
            this.f7968i = ((this.f7966g - i) / 10) + 1;
        } else if (i > this.f7967h) {
            this.f7968i = (-((i - this.f7967h) + 1)) / 10;
        } else {
            this.f7968i = 0;
        }
        setSelectionFromTop(this.f7962c, getChildAt(this.f7962c - getFirstVisiblePosition()).getTop() + this.f7968i);
    }

    public void m11372a() {
        this.f7974o = false;
        if (this.f7960a != null) {
            this.f7971l.removeView(this.f7960a);
            this.f7960a = null;
        }
        this.f7977r = true;
        this.f7978s = -1;
        C2215a c2215a = (C2215a) getAdapter();
        c2215a.m11384c(this.f7978s);
        c2215a.m11383b();
    }

    public void m11375c(int i) {
        m11367b(0, i);
    }

    private Animation m11368c(int i, int i2) {
        Animation translateAnimation = new TranslateAnimation(1, 0.0f, 0, (float) i, 1, 0.0f, 0, (float) i2);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        return translateAnimation;
    }

    private Animation m11370d(int i, int i2) {
        Animation translateAnimation = new TranslateAnimation(0, (float) i, 1, 0.0f, 0, (float) i2, 1, 0.0f);
        translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        return translateAnimation;
    }
}
