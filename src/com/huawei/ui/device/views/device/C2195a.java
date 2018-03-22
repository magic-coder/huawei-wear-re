package com.huawei.ui.device.views.device;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnItemTouchListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.d.c;
import java.util.List;

/* compiled from: DeviceItemSlideHelper */
public class C2195a implements OnItemTouchListener, OnGestureListener {
    List<C2202h> f7847a;
    private View f7848b;
    private int f7849c;
    private int f7850d;
    private int f7851e;
    private int f7852f;
    private int f7853g;
    private boolean f7854h;
    private Animator f7855i;
    private GestureDetectorCompat f7856j;
    private C2197c f7857k;
    private Context f7858l;
    private int f7859m = -1;
    private int f7860n = -1;

    public C2195a(Context context, C2197c c2197c, List<C2202h> list) {
        this.f7857k = c2197c;
        this.f7847a = list;
        this.f7856j = new GestureDetectorCompat(context, this);
        this.f7858l = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f7849c = viewConfiguration.getScaledTouchSlop();
        this.f7850d = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7851e = viewConfiguration.getScaledMinimumFlingVelocity();
    }

    public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        boolean z = true;
        boolean z2 = false;
        C2538c.m12677c("DeviceItemSlideHelper", "onInterceptTouchEvent: e=" + motionEvent.getAction());
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        this.f7860n = recyclerView.getChildCount();
        C2538c.m12677c("DeviceItemSlideHelper", "onInterceptTouchEvent(): x=" + x + ", y=" + y + "count = " + this.f7860n);
        if (recyclerView.getScrollState() != 0) {
            if (this.f7848b == null) {
                return false;
            }
            if (c.e(this.f7858l)) {
                m11288a(-100.0f);
            } else {
                m11288a(100.0f);
            }
            this.f7848b = null;
            return false;
        } else if (this.f7855i != null && this.f7855i.isRunning()) {
            return true;
        } else {
            switch (actionMasked) {
                case 0:
                    this.f7852f = (int) motionEvent.getX();
                    this.f7853g = (int) motionEvent.getY();
                    if (this.f7848b != null) {
                        if (m11289a(x, y)) {
                            z = false;
                        }
                        return z;
                    }
                    this.f7848b = this.f7857k.mo2640a((float) x, (float) y);
                    return false;
                case 1:
                case 3:
                    if (m11291b()) {
                        if (!m11289a(x, y)) {
                            z2 = true;
                        }
                        if (c.e(this.f7858l)) {
                            m11288a(-100.0f);
                        } else {
                            m11288a(100.0f);
                        }
                    }
                    this.f7848b = null;
                    return z2;
                case 2:
                    if (this.f7859m == this.f7860n - 1) {
                        return false;
                    }
                    actionMasked = x - this.f7852f;
                    x = y - this.f7853g;
                    if (Math.abs(x) > Math.abs(actionMasked) || Math.abs(x) > Math.abs(actionMasked / 2)) {
                        return false;
                    }
                    if (this.f7848b == null || Math.abs(actionMasked) < this.f7849c) {
                        z = false;
                    }
                    this.f7854h = z;
                    return z;
                default:
                    return false;
            }
        }
    }

    private boolean m11291b() {
        C2538c.m12677c("DeviceItemSlideHelper", "enter isExpanded()");
        if (this.f7848b == null || Math.abs(this.f7848b.getScrollX()) != m11293a()) {
            return false;
        }
        return true;
    }

    private boolean m11292c() {
        return this.f7848b != null && this.f7848b.getScrollX() == 0;
    }

    private boolean m11289a(int i, int i2) {
        int i3 = 0;
        if (this.f7848b == null) {
            return false;
        }
        int a;
        int bottom;
        int i4;
        if (c.e(this.f7858l)) {
            a = m11293a();
            bottom = this.f7848b.getBottom();
            i4 = 0;
        } else {
            i4 = this.f7848b.getWidth() - this.f7848b.getScrollX();
            i3 = this.f7848b.getTop();
            a = i4 + m11293a();
            bottom = this.f7848b.getBottom();
        }
        return new Rect(i4, i3, a, bottom).contains(i, i2);
    }

    public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
        C2538c.m12677c("DeviceItemSlideHelper", "onInterceptTouchEvent onTouchEvent(): e=" + motionEvent.getAction());
        if ((this.f7855i != null && this.f7855i.isRunning()) || this.f7848b == null) {
            return;
        }
        if (this.f7856j.onTouchEvent(motionEvent)) {
            this.f7854h = false;
            return;
        }
        int x = (int) motionEvent.getX();
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                return;
            case 1:
            case 3:
                if (this.f7854h) {
                    if (!m11288a(0.0f) && m11292c()) {
                        this.f7848b = null;
                    }
                    this.f7854h = false;
                    return;
                }
                return;
            case 2:
                int b = this.f7857k.mo2641b(this.f7848b);
                C2538c.m12677c("DeviceItemSlideHelper", "onInterceptTouchEvent onTouchEvent(): position = " + b);
                if (this.f7859m == b || this.f7847a == null || this.f7847a.size() == 0) {
                    this.f7848b = null;
                    if (this.f7854h) {
                        this.f7854h = false;
                        return;
                    }
                    return;
                }
                C2538c.m12677c("DeviceItemSlideHelper", "onInterceptTouchEvent onTouchEvent(): itemType = " + ((C2202h) this.f7847a.get(b)).m11325d());
                if (5 == ((C2202h) this.f7847a.get(b)).m11325d()) {
                    this.f7848b = null;
                    if (this.f7854h) {
                        this.f7854h = false;
                        return;
                    }
                    return;
                }
                b = (int) (((float) this.f7852f) - motionEvent.getX());
                if (this.f7854h) {
                    m11287a(b);
                }
                this.f7852f = x;
                return;
            default:
                return;
        }
    }

    public void onRequestDisallowInterceptTouchEvent(boolean z) {
    }

    private void m11287a(int i) {
        int scrollX = this.f7848b.getScrollX();
        int scrollY = this.f7848b.getScrollY();
        int a;
        if (c.e(this.f7858l)) {
            if (scrollX + i <= 0) {
                a = m11293a();
                scrollX += i;
                if (Math.abs(scrollX) < a) {
                    this.f7848b.scrollTo(scrollX, scrollY);
                    return;
                } else {
                    this.f7848b.scrollTo(-a, scrollY);
                    return;
                }
            }
            this.f7848b.scrollTo(0, scrollY);
        } else if (scrollX + i <= 0) {
            this.f7848b.scrollTo(0, scrollY);
        } else {
            a = m11293a();
            scrollX += i;
            if (Math.abs(scrollX) < a) {
                this.f7848b.scrollTo(scrollX, scrollY);
            } else {
                this.f7848b.scrollTo(a, scrollY);
            }
        }
    }

    private boolean m11288a(float f) {
        int scrollX = this.f7848b.getScrollX();
        int a = m11293a();
        if (this.f7855i != null) {
            return false;
        }
        int i;
        if (f == 0.0f) {
            if (scrollX > a / 2) {
                i = a;
            } else {
                boolean z = false;
            }
            if (!c.e(this.f7858l) || Math.abs(scrollX) <= a / 2) {
                a = i;
                i = 200;
            } else {
                a = -a;
                i = 200;
            }
        } else {
            if (c.e(this.f7858l)) {
                if (f > 0.0f) {
                    a = -a;
                } else {
                    a = 0;
                }
            } else if (f > 0.0f) {
                a = 0;
            }
            i = (int) ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - (Math.abs(f) / ((float) this.f7850d))) * 200.0f);
        }
        if (a == scrollX) {
            return false;
        }
        this.f7855i = ObjectAnimator.ofInt(this.f7848b, "scrollX", new int[]{a});
        this.f7855i.setDuration((long) i);
        this.f7855i.addListener(new C2196b(this));
        this.f7855i.start();
        return true;
    }

    public int m11293a() {
        return this.f7857k.mo2638a(this.f7857k.mo2639a(this.f7848b));
    }

    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (Math.abs(f) <= ((float) this.f7851e) || Math.abs(f) >= ((float) this.f7850d) || m11288a(f)) {
            return false;
        }
        if (m11292c()) {
            this.f7848b = null;
        }
        return true;
    }
}
