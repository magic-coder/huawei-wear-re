package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Handler;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.e;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
    private static Typeface f4011W = null;
    private static final int[] f4012i = new int[]{1118481, 11184810, 11184810};
    private static int f4013j = 55;
    private static int f4014l = 4;
    private GradientDrawable f4015A;
    private boolean f4016B;
    private int f4017C;
    private GestureDetector f4018D;
    private Scroller f4019E;
    private int f4020F;
    private List<C1603c> f4021G = new LinkedList();
    private List<C1604d> f4022H = new LinkedList();
    private int f4023I = -13421773;
    private int f4024J = -1;
    private int f4025K = -13421773;
    private int f4026L = -1711276033;
    private int f4027M = -12599099;
    private int f4028N = -16713985;
    private Drawable f4029O;
    private int f4030P = C1617f.wheel_bg;
    private int f4031Q = C1617f.wheel_val;
    private int f4032R = C1617f.wheel_val_1;
    private int f4033S = C1617f.wheel_color_bg;
    private int f4034T = C1617f.wheel_color_bg_1;
    private int f4035U = e.wheelview_text_size_item;
    private int f4036V = e.wheelview_text_size_value;
    public float f4037a = 5.0f;
    private boolean aa = true;
    private SimpleOnGestureListener ab = new C1615p(this);
    private Handler ac = new C1616q(this);
    boolean f4038b = false;
    boolean f4039c = false;
    Context f4040d;
    float f4041e = 24.0f;
    float f4042f = 17.0f;
    private int f4043g = -4144960;
    private int f4044h = -637534209;
    private final float f4045k = this.f4037a;
    private boolean f4046m = false;
    private C1600h f4047n = null;
    private int f4048o = 0;
    private int f4049p = 0;
    private int f4050q = 0;
    private int f4051r = 3;
    private int f4052s = 0;
    private TextPaint f4053t;
    private TextPaint f4054u;
    private StaticLayout f4055v;
    private StaticLayout f4056w;
    private StaticLayout f4057x;
    private String f4058y;
    private GradientDrawable f4059z;

    private static int getADDITIONAL_ITEM_HEIGHT() {
        return f4013j;
    }

    private static void setADDITIONAL_ITEM_HEIGHT(int i) {
        f4013j = i;
    }

    private static void setLABEL_OFFSET(int i) {
        f4014l = i;
    }

    public void setUseDefaultTextColur(boolean z) {
        this.aa = z;
        this.f4024J = this.f4023I;
    }

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setADDITIONAL_ITEM_HEIGHT(m7370a(context, 35.0f));
        setLABEL_OFFSET(m7370a(context, 2.0f));
        this.f4040d = context;
        m7374a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setADDITIONAL_ITEM_HEIGHT(m7370a(context, 35.0f));
        setLABEL_OFFSET(m7370a(context, 2.0f));
        this.f4040d = context;
        m7374a(context);
    }

    public WheelView(Context context) {
        super(context);
        setADDITIONAL_ITEM_HEIGHT(m7370a(context, 35.0f));
        setLABEL_OFFSET(m7370a(context, 2.0f));
        this.f4040d = context;
        m7374a(context);
    }

    private void m7374a(Context context) {
        this.f4018D = new GestureDetector(context, this.ab);
        this.f4018D.setIsLongpressEnabled(false);
        this.f4019E = new Scroller(context);
        this.f4041e = (float) getResources().getDimensionPixelSize(this.f4036V);
        this.f4042f = (float) getResources().getDimensionPixelSize(this.f4035U);
    }

    public C1600h getAdapter() {
        return this.f4047n;
    }

    public void setAdapter(C1600h c1600h) {
        this.f4047n = c1600h;
        m7386d();
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f4019E.forceFinished(true);
        this.f4019E = new Scroller(getContext(), interpolator);
    }

    public int getVisibleItems() {
        return this.f4051r;
    }

    public void setVisibleItems(int i) {
        this.f4051r = i;
        invalidate();
    }

    public String getLabel() {
        return this.f4058y;
    }

    public void setLabel(String str) {
        if (this.f4058y == null || !this.f4058y.equals(str)) {
            this.f4058y = str;
            this.f4056w = null;
            invalidate();
        }
    }

    public void m7404a(C1603c c1603c) {
        this.f4021G.add(c1603c);
    }

    protected void m7402a(int i, int i2) {
        for (C1603c a : this.f4021G) {
            a.mo2553a(this, i, i2);
        }
    }

    protected void m7401a() {
        for (C1604d a : this.f4022H) {
            a.m7419a(this);
        }
    }

    protected void m7406b() {
        for (C1604d b : this.f4022H) {
            b.m7420b(this);
        }
    }

    public int getCurrentItem() {
        return this.f4048o;
    }

    public void m7403a(int i, boolean z) {
        if (this.f4047n != null && this.f4047n.mo2550a() != 0) {
            if (i < 0 || i >= this.f4047n.mo2550a()) {
                if (this.f4038b) {
                    while (i < 0) {
                    }
                    i %= this.f4047n.mo2550a();
                } else {
                    return;
                }
            }
            if (i == this.f4048o) {
                return;
            }
            if (z) {
                m7407b(i - this.f4048o, (int) HttpStatus.SC_BAD_REQUEST);
                return;
            }
            m7386d();
            int i2 = this.f4048o;
            this.f4048o = i;
            m7402a(i2, this.f4048o);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        m7403a(i, false);
    }

    public void setCyclic(boolean z) {
        this.f4038b = z;
        invalidate();
        m7386d();
    }

    public void setHanziFontFlag(boolean z) {
        this.f4039c = z;
    }

    private void m7386d() {
        this.f4055v = null;
        this.f4057x = null;
        this.f4017C = 0;
    }

    private void m7391e() {
        if (this.f4053t == null) {
            if (this.f4039c) {
                this.f4053t = new TextPaint(1);
                this.f4053t.density = getResources().getDisplayMetrics().density;
                this.f4053t.setTextSize((float) m7370a(this.f4040d, 20.0f));
            } else {
                this.f4053t = new TextPaint(33);
                this.f4053t.density = getResources().getDisplayMetrics().density;
                this.f4053t.setTextSize(this.f4042f);
                this.f4053t.setTypeface(f4011W);
            }
        }
        if (this.f4054u == null) {
            if (this.f4039c) {
                this.f4054u = new TextPaint(1);
                this.f4054u.density = getResources().getDisplayMetrics().density;
                this.f4054u.setTextSize((float) m7370a(this.f4040d, 22.0f));
            } else {
                this.f4054u = new TextPaint(37);
                this.f4054u.density = getResources().getDisplayMetrics().density;
                this.f4054u.setTextSize(this.f4041e);
                this.f4054u.setShadowLayer(0.1f, 0.0f, 0.1f, -4144960);
                this.f4054u.setTypeface(f4011W);
            }
        }
        if (this.f4029O == null) {
            if (this.aa) {
                this.f4029O = getContext().getResources().getDrawable(this.f4032R);
            } else {
                this.f4029O = getContext().getResources().getDrawable(this.f4031Q);
            }
        }
        if (this.f4059z == null) {
            this.f4059z = new GradientDrawable(Orientation.TOP_BOTTOM, f4012i);
        }
        if (this.f4015A == null) {
            this.f4015A = new GradientDrawable(Orientation.BOTTOM_TOP, f4012i);
        }
        setBackgroundResource(this.f4030P);
    }

    private int m7371a(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return Math.max((int) ((((float) (getItemHeight() * this.f4051r)) - (this.f4045k * 2.0f)) - ((float) f4013j)), getSuggestedMinimumHeight());
    }

    private String m7372a(int i) {
        if (this.f4047n == null || this.f4047n.mo2550a() == 0) {
            return null;
        }
        int a = this.f4047n.mo2550a();
        if ((i < 0 || i >= a) && !this.f4038b) {
            return null;
        }
        while (i < 0) {
            i += a;
        }
        return this.f4047n.mo2551a(i % a);
    }

    private String m7373a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = (this.f4051r / 2) + 1;
        int i2 = this.f4048o - i;
        while (i2 <= this.f4048o + i) {
            if (z || i2 != this.f4048o) {
                String a = m7372a(i2);
                if (a != null) {
                    stringBuilder.append(a);
                }
            }
            if (i2 < this.f4048o + i) {
                stringBuilder.append("\n");
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    private int getMaxTextLength() {
        C1600h adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int b = adapter.mo2552b();
        if (b > 0) {
            return b;
        }
        String str = null;
        for (int max = Math.max(this.f4048o - (this.f4051r / 2), 0); max < Math.min(this.f4048o + this.f4051r, adapter.mo2550a()); max++) {
            String a = adapter.mo2551a(max);
            if (a != null && (str == null || str.length() < a.length())) {
                str = a;
            }
        }
        return str != null ? str.length() : 0;
    }

    private int getItemHeight() {
        if (this.f4052s != 0) {
            return this.f4052s;
        }
        if (this.f4055v == null || this.f4055v.getLineCount() <= 2) {
            return getHeight() / this.f4051r;
        }
        this.f4052s = this.f4055v.getLineTop(2) - this.f4055v.getLineTop(1);
        return this.f4052s;
    }

    private int m7382c(int i, int i2) {
        m7391e();
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            this.f4049p = (int) (Math.ceil((double) Layout.getDesiredWidth("0", this.f4053t)) * ((double) maxTextLength));
        } else {
            this.f4049p = 0;
        }
        this.f4049p += 10;
        this.f4050q = 0;
        if (this.f4058y != null && this.f4058y.length() > 0) {
            this.f4050q = (int) Math.ceil((double) Layout.getDesiredWidth(this.f4058y, this.f4054u));
        }
        if (i2 == 1073741824) {
            maxTextLength = 1;
        } else {
            maxTextLength = (this.f4049p + this.f4050q) + 0;
            if (this.f4050q > 0) {
                maxTextLength += f4014l;
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
            maxTextLength = (i - f4014l) + 0;
            if (maxTextLength <= 0) {
                this.f4050q = 0;
                this.f4049p = 0;
            }
            if (this.f4050q > 0) {
                this.f4049p = (int) ((((double) this.f4049p) * ((double) maxTextLength)) / ((double) (this.f4049p + this.f4050q)));
                this.f4050q = maxTextLength - this.f4049p;
            } else {
                this.f4049p = maxTextLength + f4014l;
            }
        }
        if (this.f4049p > 0) {
            m7387d(this.f4049p, this.f4050q);
        }
        return i;
    }

    private void m7387d(int i, int i2) {
        if (this.f4055v == null || this.f4055v.getWidth() > i) {
            this.f4055v = new StaticLayout(m7373a(this.f4016B), this.f4053t, i, i2 > 0 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) f4013j, false);
        } else {
            this.f4055v.increaseWidthTo(i);
        }
        if (!this.f4016B && (this.f4057x == null || this.f4057x.getWidth() > i)) {
            CharSequence a;
            if (getAdapter() != null) {
                a = getAdapter().mo2551a(this.f4048o);
            } else {
                a = null;
            }
            if (a == null) {
                a = "";
            }
            this.f4057x = new StaticLayout(a, this.f4054u, i, i2 > 0 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) f4013j, false);
        } else if (this.f4016B) {
            this.f4057x = null;
        } else {
            this.f4057x.increaseWidthTo(i);
        }
        if (i2 <= 0) {
            return;
        }
        if (this.f4056w == null || this.f4056w.getWidth() > i2) {
            this.f4056w = new StaticLayout(this.f4058y, this.f4054u, i2, Alignment.ALIGN_NORMAL, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) f4013j, false);
        } else {
            this.f4056w.increaseWidthTo(i2);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        size = m7382c(size, mode);
        if (mode2 != 1073741824) {
            mode = m7371a(this.f4055v);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(mode, size2) : mode;
        }
        setMeasuredDimension(size, size2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f4055v == null) {
            if (this.f4049p == 0) {
                m7382c(getWidth(), 1073741824);
            } else {
                m7387d(this.f4049p, this.f4050q);
            }
        }
        m7388d(canvas);
        if (this.f4049p > 0) {
            canvas.save();
            canvas.translate(0.0f, -this.f4045k);
            m7383c(canvas);
            m7381b(canvas);
            canvas.restore();
        }
        m7375a(canvas);
    }

    private void m7375a(Canvas canvas) {
        this.f4059z.setBounds(0, 0, getWidth(), getHeight() / this.f4051r);
        this.f4059z.draw(canvas);
        this.f4015A.setBounds(0, getHeight() - (getHeight() / this.f4051r), getWidth(), getHeight());
        this.f4015A.draw(canvas);
    }

    public void setColor(boolean z) {
        if (z) {
            if (this.aa) {
                this.f4024J = this.f4028N;
            } else {
                this.f4024J = this.f4027M;
            }
            if (this.aa) {
                this.f4029O = getContext().getResources().getDrawable(this.f4034T);
            } else {
                this.f4029O = getContext().getResources().getDrawable(this.f4033S);
            }
            invalidate();
            return;
        }
        if (this.aa) {
            this.f4024J = this.f4026L;
        } else {
            this.f4024J = this.f4025K;
        }
        if (this.aa) {
            this.f4029O = getContext().getResources().getDrawable(this.f4032R);
        } else {
            this.f4029O = getContext().getResources().getDrawable(this.f4031Q);
        }
        invalidate();
    }

    public void m7405a(boolean z, boolean z2) {
        if (z) {
            if (this.aa) {
                this.f4024J = this.f4028N;
            } else {
                this.f4024J = this.f4027M;
            }
            if (z2) {
                this.f4029O = getContext().getResources().getDrawable(this.f4034T);
            } else {
                this.f4029O = getContext().getResources().getDrawable(this.f4031Q);
            }
            invalidate();
        }
    }

    private void m7381b(Canvas canvas) {
        if (this.f4046m) {
            this.f4054u.setTextSize((float) m7370a(this.f4040d, 24.0f));
        }
        this.f4054u.setColor(this.f4024J);
        this.f4054u.drawableState = getDrawableState();
        Rect rect = new Rect();
        this.f4055v.getLineBounds(this.f4051r / 2, rect);
        int i = ((int) (this.f4041e - this.f4042f)) / 2;
        if (this.f4057x != null) {
            canvas.save();
            canvas.translate(0.0f, (float) ((rect.top - i) + this.f4017C));
            this.f4057x.draw(canvas);
            canvas.restore();
        }
        if (this.f4056w != null) {
            canvas.save();
            canvas.translate((float) (this.f4055v.getWidth() + f4014l), (float) rect.top);
            this.f4056w.draw(canvas);
            canvas.restore();
        }
    }

    private void m7383c(Canvas canvas) {
        canvas.save();
        int lineTop = this.f4055v.getLineTop(1);
        if (this.f4046m) {
            this.f4053t.setTextSize((float) m7370a(this.f4040d, 22.0f));
        }
        canvas.translate(0.0f, (float) ((-lineTop) + this.f4017C));
        if (this.aa) {
            this.f4053t.setColor(this.f4044h);
        } else {
            this.f4053t.setColor(this.f4043g);
        }
        this.f4053t.drawableState = getDrawableState();
        this.f4055v.draw(canvas);
        canvas.restore();
    }

    private void m7388d(Canvas canvas) {
        int height = getHeight() / 2;
        this.f4029O.setBounds((getWidth() / 12) + 0, height - ((getWidth() * 5) / 12), getWidth() - (getWidth() / 12), height + ((getWidth() * 5) / 12));
        this.f4029O.draw(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getAdapter() == null || this.f4018D.onTouchEvent(motionEvent) || motionEvent.getAction() != 1)) {
            m7395g();
        }
        return true;
    }

    private void m7380b(int i) {
        this.f4017C += i;
        int itemHeight = this.f4017C / getItemHeight();
        int i2 = this.f4048o - itemHeight;
        if (this.f4038b && this.f4047n.mo2550a() > 0) {
            while (i2 < 0) {
                i2 += this.f4047n.mo2550a();
            }
            i2 %= this.f4047n.mo2550a();
        } else if (!this.f4016B) {
            i2 = Math.min(Math.max(i2, 0), this.f4047n.mo2550a() - 1);
        } else if (i2 < 0) {
            itemHeight = this.f4048o;
            i2 = 0;
        } else if (i2 >= this.f4047n.mo2550a()) {
            itemHeight = (this.f4048o - this.f4047n.mo2550a()) + 1;
            i2 = this.f4047n.mo2550a() - 1;
        }
        int i3 = this.f4017C;
        if (i2 != this.f4048o) {
            m7403a(i2, false);
        } else {
            invalidate();
        }
        this.f4017C = i3 - (getItemHeight() * itemHeight);
        if (this.f4017C > getHeight()) {
            this.f4017C = (this.f4017C % getHeight()) + getHeight();
        }
    }

    private void setNextMessage(int i) {
        m7393f();
        this.ac.sendEmptyMessage(i);
    }

    private void m7393f() {
        this.ac.removeMessages(0);
        this.ac.removeMessages(1);
    }

    private void m7395g() {
        if (this.f4047n != null) {
            this.f4020F = 0;
            int i = this.f4017C;
            int itemHeight = getItemHeight();
            int i2 = i > 0 ? this.f4048o < this.f4047n.mo2550a() ? 1 : 0 : this.f4048o > 0 ? 1 : 0;
            if ((this.f4038b || r0 != 0) && Math.abs((float) i) > ((float) itemHeight) / 2.0f) {
                i = i < 0 ? i + (itemHeight + 1) : i - (itemHeight + 1);
            }
            if (Math.abs(i) > 1) {
                this.f4019E.startScroll(0, 0, 0, i, HttpStatus.SC_BAD_REQUEST);
                setNextMessage(1);
                return;
            }
            m7408c();
        }
    }

    private void m7397h() {
        if (!this.f4016B) {
            this.f4016B = true;
            m7401a();
        }
    }

    void m7408c() {
        if (this.f4016B) {
            m7406b();
            this.f4016B = false;
        }
        m7386d();
        invalidate();
    }

    public void m7407b(int i, int i2) {
        this.f4019E.forceFinished(true);
        this.f4020F = this.f4017C;
        int itemHeight = i * getItemHeight();
        this.f4019E.startScroll(0, this.f4020F, 0, itemHeight - this.f4020F, i2);
        setNextMessage(0);
        m7397h();
    }

    private static int m7370a(Context context, float f) {
        return (int) ((context.getResources().getDisplayMetrics().density * f) + 0.5f);
    }
}
