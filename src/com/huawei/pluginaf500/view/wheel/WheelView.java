package com.huawei.pluginaf500.view.wheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.p190v.C2538c;
import com.huawei.pluginaf500.c;
import com.huawei.pluginaf500.d;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
    private static Typeface f20038O = null;
    private static final int[] f20039g = new int[]{1118481, 11184810, 11184810};
    private int f20040A;
    private GestureDetector f20041B;
    private Scroller f20042C;
    private int f20043D;
    private List<C5791c> f20044E = new LinkedList();
    private List<C5833d> f20045F = new LinkedList();
    private int f20046G = ViewCompat.MEASURED_STATE_MASK;
    private int f20047H = ViewCompat.MEASURED_STATE_MASK;
    private int f20048I = -48794;
    private Drawable f20049J;
    private int f20050K = d.wheel_bg;
    private int f20051L = d.wheel_val;
    private int f20052M = d.wheel_color_bg;
    private int f20053N = c.wheelview_text_size_item;
    private SimpleOnGestureListener f20054P = new C5841m(this);
    private Handler f20055Q = new C5842n(this);
    public float f20056a = 5.0f;
    boolean f20057b = false;
    boolean f20058c = false;
    Context f20059d;
    float f20060e = 24.0f;
    float f20061f = 17.0f;
    private int f20062h = 55;
    private final float f20063i = this.f20056a;
    private int f20064j = 4;
    private boolean f20065k = false;
    private C5830e f20066l = null;
    private int f20067m = 0;
    private int f20068n = 0;
    private int f20069o = 0;
    private int f20070p = 3;
    private int f20071q = 0;
    private TextPaint f20072r;
    private TextPaint f20073s;
    private StaticLayout f20074t;
    private StaticLayout f20075u;
    private StaticLayout f20076v;
    private String f20077w;
    private GradientDrawable f20078x;
    private GradientDrawable f20079y;
    private boolean f20080z;

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20062h = m26933a(context, 35.0f);
        this.f20064j = m26933a(context, 2.0f);
        this.f20059d = context;
        m26937a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20062h = m26933a(context, 35.0f);
        this.f20064j = m26933a(context, 2.0f);
        this.f20059d = context;
        m26937a(context);
    }

    public WheelView(Context context) {
        super(context);
        this.f20062h = m26933a(context, 35.0f);
        this.f20064j = m26933a(context, 2.0f);
        this.f20059d = context;
        m26937a(context);
    }

    private void m26937a(Context context) {
        this.f20041B = new GestureDetector(context, this.f20054P);
        this.f20041B.setIsLongpressEnabled(false);
        this.f20042C = new Scroller(context);
        this.f20060e = (float) getResources().getDimensionPixelSize(this.f20053N);
        this.f20061f = (float) getResources().getDimensionPixelSize(this.f20053N);
        C2538c.b("WheelView", new Object[]{"valueTextSize=" + this.f20060e + ",itemTextSize=" + this.f20061f});
    }

    public C5830e getAdapter() {
        return this.f20066l;
    }

    public void setAdapter(C5830e c5830e) {
        this.f20066l = c5830e;
        m26949d();
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f20042C.forceFinished(true);
        this.f20042C = new Scroller(getContext(), interpolator);
    }

    public int getVisibleItems() {
        return this.f20070p;
    }

    public void setVisibleItems(int i) {
        this.f20070p = i;
        invalidate();
    }

    public String getLabel() {
        return this.f20077w;
    }

    public void setLabel(String str) {
        if (this.f20077w == null || !this.f20077w.equals(str)) {
            this.f20077w = str;
            this.f20075u = null;
            invalidate();
        }
    }

    public void m26967a(C5791c c5791c) {
        this.f20044E.add(c5791c);
    }

    protected void m26965a(int i, int i2) {
        for (C5791c a : this.f20044E) {
            a.mo5113a(this, i, i2);
        }
    }

    protected void m26964a() {
        for (C5833d a : this.f20045F) {
            a.m26980a(this);
        }
    }

    protected void m26968b() {
        for (C5833d b : this.f20045F) {
            b.m26981b(this);
        }
    }

    public int getCurrentItem() {
        return this.f20067m;
    }

    public void m26966a(int i, boolean z) {
        if (this.f20066l != null && this.f20066l.mo5120a() != 0) {
            if (i < 0 || i >= this.f20066l.mo5120a()) {
                if (this.f20057b) {
                    while (i < 0) {
                    }
                    i %= this.f20066l.mo5120a();
                } else {
                    return;
                }
            }
            if (i == this.f20067m) {
                return;
            }
            if (z) {
                m26969b(i - this.f20067m, (int) HttpStatus.SC_BAD_REQUEST);
                return;
            }
            m26949d();
            int i2 = this.f20067m;
            this.f20067m = i;
            m26965a(i2, this.f20067m);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        m26966a(i, false);
    }

    public void setCyclic(boolean z) {
        this.f20057b = z;
        invalidate();
        m26949d();
    }

    public void setHanziFontFlag(boolean z) {
        this.f20058c = z;
    }

    private void m26949d() {
        this.f20074t = null;
        this.f20076v = null;
        this.f20040A = 0;
    }

    private void m26954e() {
        if (this.f20072r == null) {
            if (this.f20058c) {
                this.f20072r = new TextPaint(1);
                this.f20072r.density = getResources().getDisplayMetrics().density;
                this.f20072r.setTextSize((float) m26933a(this.f20059d, 20.0f));
            } else {
                this.f20072r = new TextPaint(33);
                this.f20072r.density = getResources().getDisplayMetrics().density;
                this.f20072r.setTextSize(this.f20061f);
                this.f20072r.setTypeface(f20038O);
            }
        }
        if (this.f20073s == null) {
            if (this.f20058c) {
                this.f20073s = new TextPaint(1);
                this.f20073s.density = getResources().getDisplayMetrics().density;
                this.f20073s.setTextSize((float) m26933a(this.f20059d, 22.0f));
            } else {
                this.f20073s = new TextPaint(37);
                this.f20073s.density = getResources().getDisplayMetrics().density;
                this.f20073s.setTextSize(this.f20060e);
                this.f20073s.setShadowLayer(0.1f, 0.0f, 0.1f, -4144960);
                this.f20073s.setTypeface(f20038O);
            }
        }
        if (this.f20049J == null) {
            this.f20049J = getContext().getResources().getDrawable(this.f20051L);
        }
        if (this.f20078x == null) {
            this.f20078x = new GradientDrawable(Orientation.TOP_BOTTOM, f20039g);
        }
        if (this.f20079y == null) {
            this.f20079y = new GradientDrawable(Orientation.BOTTOM_TOP, f20039g);
        }
        setBackgroundResource(this.f20050K);
    }

    private int m26934a(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return Math.max((int) ((((float) (getItemHeight() * this.f20070p)) - (this.f20063i * 2.0f)) - ((float) this.f20062h)), getSuggestedMinimumHeight());
    }

    private String m26935a(int i) {
        if (this.f20066l == null || this.f20066l.mo5120a() == 0) {
            return null;
        }
        int a = this.f20066l.mo5120a();
        if ((i < 0 || i >= a) && !this.f20057b) {
            return null;
        }
        while (i < 0) {
            i += a;
        }
        return this.f20066l.mo5121a(i % a);
    }

    private String m26936a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = (this.f20070p / 2) + 1;
        int i2 = this.f20067m - i;
        while (i2 <= this.f20067m + i) {
            if (z || i2 != this.f20067m) {
                String a = m26935a(i2);
                if (a != null) {
                    stringBuilder.append(a);
                }
            }
            if (i2 < this.f20067m + i) {
                stringBuilder.append("\n");
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    private int getMaxTextLength() {
        C5830e adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int b = adapter.mo5122b();
        if (b > 0) {
            return b;
        }
        String str = null;
        for (int max = Math.max(this.f20067m - (this.f20070p / 2), 0); max < Math.min(this.f20067m + this.f20070p, adapter.mo5120a()); max++) {
            String a = adapter.mo5121a(max);
            if (a != null && (str == null || str.length() < a.length())) {
                str = a;
            }
        }
        return str != null ? str.length() : 0;
    }

    private int getItemHeight() {
        if (this.f20071q != 0) {
            return this.f20071q;
        }
        if (this.f20074t == null || this.f20074t.getLineCount() <= 2) {
            return getHeight() / this.f20070p;
        }
        this.f20071q = this.f20074t.getLineTop(2) - this.f20074t.getLineTop(1);
        return this.f20071q;
    }

    private int m26945c(int i, int i2) {
        m26954e();
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            this.f20068n = (int) (((float) maxTextLength) * ((float) Math.ceil((double) Layout.getDesiredWidth("0", this.f20072r))));
        } else {
            this.f20068n = 0;
        }
        this.f20068n += 10;
        this.f20069o = 0;
        if (this.f20077w != null && this.f20077w.length() > 0) {
            this.f20069o = (int) Math.ceil((double) Layout.getDesiredWidth(this.f20077w, this.f20073s));
        }
        if (i2 == 1073741824) {
            maxTextLength = 1;
        } else {
            maxTextLength = (this.f20068n + this.f20069o) + 0;
            if (this.f20069o > 0) {
                maxTextLength += this.f20064j;
            }
            maxTextLength = Math.max(maxTextLength, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= maxTextLength) {
                i = maxTextLength;
                maxTextLength = 0;
            } else {
                maxTextLength = 1;
            }
        }
        if (maxTextLength != 0) {
            maxTextLength = (i - this.f20064j) + 0;
            if (maxTextLength <= 0) {
                this.f20069o = 0;
                this.f20068n = 0;
            }
            if (this.f20069o > 0) {
                this.f20068n = (int) ((((double) this.f20068n) * ((double) maxTextLength)) / ((double) (this.f20068n + this.f20069o)));
                this.f20069o = maxTextLength - this.f20068n;
            } else {
                this.f20068n = maxTextLength + this.f20064j;
            }
        }
        if (this.f20068n > 0) {
            m26950d(this.f20068n, this.f20069o);
        }
        return i;
    }

    private void m26950d(int i, int i2) {
        if (this.f20074t == null || this.f20074t.getWidth() > i) {
            this.f20074t = new StaticLayout(m26936a(this.f20080z), this.f20072r, i, i2 > 0 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f20062h, false);
        } else {
            this.f20074t.increaseWidthTo(i);
        }
        if (!this.f20080z && (this.f20076v == null || this.f20076v.getWidth() > i)) {
            CharSequence a;
            Alignment alignment;
            if (getAdapter() != null) {
                a = getAdapter().mo5121a(this.f20067m);
            } else {
                a = null;
            }
            if (a == null) {
                a = "";
            }
            TextPaint textPaint = this.f20073s;
            if (i2 > 0) {
                alignment = Alignment.ALIGN_OPPOSITE;
            } else {
                alignment = Alignment.ALIGN_CENTER;
            }
            this.f20076v = new StaticLayout(a, textPaint, i, alignment, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f20062h, false);
        } else if (this.f20080z) {
            this.f20076v = null;
        } else {
            this.f20076v.increaseWidthTo(i);
        }
        if (i2 <= 0) {
            return;
        }
        if (this.f20075u == null || this.f20075u.getWidth() > i2) {
            this.f20075u = new StaticLayout(this.f20077w, this.f20073s, i2, Alignment.ALIGN_NORMAL, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f20062h, false);
        } else {
            this.f20075u.increaseWidthTo(i2);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        size = m26945c(size, mode);
        if (mode2 != 1073741824) {
            mode = m26934a(this.f20074t);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(mode, size2) : mode;
        }
        setMeasuredDimension(size, size2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20074t == null) {
            if (this.f20068n == 0) {
                m26945c(getWidth(), 1073741824);
            } else {
                m26950d(this.f20068n, this.f20069o);
            }
        }
        m26951d(canvas);
        if (this.f20068n > 0) {
            canvas.save();
            canvas.translate(0.0f, -this.f20063i);
            m26946c(canvas);
            m26944b(canvas);
            canvas.restore();
        }
        m26938a(canvas);
    }

    private void m26938a(Canvas canvas) {
        this.f20078x.setBounds(0, 0, getWidth(), getHeight() / this.f20070p);
        this.f20078x.draw(canvas);
        this.f20079y.setBounds(0, getHeight() - (getHeight() / this.f20070p), getWidth(), getHeight());
        this.f20079y.draw(canvas);
    }

    public void setColor(boolean z) {
        if (z) {
            this.f20046G = this.f20048I;
            this.f20049J = getContext().getResources().getDrawable(this.f20052M);
            invalidate();
            return;
        }
        this.f20046G = this.f20047H;
        this.f20049J = getContext().getResources().getDrawable(this.f20051L);
        invalidate();
    }

    private void m26944b(Canvas canvas) {
        if (this.f20065k) {
            this.f20073s.setTextSize((float) m26933a(this.f20059d, 24.0f));
        }
        this.f20073s.setColor(this.f20046G);
        this.f20073s.drawableState = getDrawableState();
        Rect rect = new Rect();
        this.f20074t.getLineBounds(this.f20070p / 2, rect);
        int i = ((int) (this.f20060e - this.f20061f)) / 2;
        if (this.f20076v != null) {
            canvas.save();
            canvas.translate(0.0f, (float) ((rect.top - i) + this.f20040A));
            this.f20076v.draw(canvas);
            canvas.restore();
        }
        if (this.f20075u != null) {
            canvas.save();
            canvas.translate((float) (this.f20074t.getWidth() + this.f20064j), (float) rect.top);
            this.f20075u.draw(canvas);
            canvas.restore();
        }
    }

    private void m26946c(Canvas canvas) {
        canvas.save();
        int lineTop = this.f20074t.getLineTop(1);
        if (this.f20065k) {
            this.f20072r.setTextSize((float) m26933a(this.f20059d, 22.0f));
        }
        canvas.translate(0.0f, (float) ((-lineTop) + this.f20040A));
        this.f20072r.setColor(-4144960);
        this.f20072r.drawableState = getDrawableState();
        this.f20074t.draw(canvas);
        canvas.restore();
    }

    private void m26951d(Canvas canvas) {
        int height = getHeight() / 2;
        this.f20049J.setBounds((getWidth() / 12) + 0, height - ((getWidth() * 5) / 12), getWidth() - (getWidth() / 12), height + ((getWidth() * 5) / 12));
        this.f20049J.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getAdapter() == null || this.f20041B.onTouchEvent(motionEvent) || motionEvent.getAction() != 1)) {
            m26958g();
        }
        return true;
    }

    private void m26943b(int i) {
        this.f20040A += i;
        int itemHeight = this.f20040A / getItemHeight();
        int i2 = this.f20067m - itemHeight;
        if (this.f20057b && this.f20066l.mo5120a() > 0) {
            while (i2 < 0) {
                i2 += this.f20066l.mo5120a();
            }
            i2 %= this.f20066l.mo5120a();
        } else if (!this.f20080z) {
            i2 = Math.min(Math.max(i2, 0), this.f20066l.mo5120a() - 1);
        } else if (i2 < 0) {
            itemHeight = this.f20067m;
            i2 = 0;
        } else if (i2 >= this.f20066l.mo5120a()) {
            itemHeight = (this.f20067m - this.f20066l.mo5120a()) + 1;
            i2 = this.f20066l.mo5120a() - 1;
        }
        int i3 = this.f20040A;
        if (i2 != this.f20067m) {
            m26966a(i2, false);
        } else {
            invalidate();
        }
        this.f20040A = i3 - (getItemHeight() * itemHeight);
        if (this.f20040A > getHeight()) {
            this.f20040A = (this.f20040A % getHeight()) + getHeight();
        }
    }

    private void setNextMessage(int i) {
        m26956f();
        this.f20055Q.sendEmptyMessage(i);
    }

    private void m26956f() {
        this.f20055Q.removeMessages(0);
        this.f20055Q.removeMessages(1);
    }

    private void m26958g() {
        if (this.f20066l != null) {
            this.f20043D = 0;
            int i = this.f20040A;
            int itemHeight = getItemHeight();
            int i2 = i > 0 ? this.f20067m < this.f20066l.mo5120a() ? 1 : 0 : this.f20067m > 0 ? 1 : 0;
            if ((this.f20057b || r0 != 0) && Math.abs((float) i) > ((float) itemHeight) / 2.0f) {
                i = i < 0 ? i + (itemHeight + 1) : i - (itemHeight + 1);
            }
            if (Math.abs(i) > 1) {
                this.f20042C.startScroll(0, 0, 0, i, HttpStatus.SC_BAD_REQUEST);
                setNextMessage(1);
                return;
            }
            m26970c();
        }
    }

    private void m26960h() {
        if (!this.f20080z) {
            this.f20080z = true;
            m26964a();
        }
    }

    void m26970c() {
        if (this.f20080z) {
            m26968b();
            this.f20080z = false;
        }
        m26949d();
        invalidate();
    }

    public void m26969b(int i, int i2) {
        this.f20042C.forceFinished(true);
        this.f20043D = this.f20040A;
        int itemHeight = i * getItemHeight();
        this.f20042C.startScroll(0, this.f20043D, 0, itemHeight - this.f20043D, i2);
        setNextMessage(0);
        m26960h();
    }

    private static int m26933a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
