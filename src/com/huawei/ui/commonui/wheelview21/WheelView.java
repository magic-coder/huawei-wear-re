package com.huawei.ui.commonui.wheelview21;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.ui.commonui.C6001d;
import com.huawei.ui.commonui.C6028e;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.ui.commonui.wheelview21.p516a.C6081b;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
    private static int f20991C = 1;
    private static int f20992D = 2;
    private int f20993A = Color.parseColor("#0D9FFB");
    private int f20994B = C6028e.wheelview_text_size_item;
    private int f20995E = 0;
    private boolean f20996F = false;
    private SimpleOnGestureListener f20997G = new C6089g(this);
    private Handler f20998H = new C6090h(this);
    public float f20999a = 5.0f;
    boolean f21000b = false;
    float f21001c = 24.0f;
    float f21002d = 17.0f;
    private int f21003e = -4144960;
    private int f21004f = 55;
    private final float f21005g = this.f20999a;
    private int f21006h = 1;
    private C6081b f21007i = null;
    private int f21008j = 0;
    private int f21009k = 0;
    private int f21010l = 5;
    private int f21011m = 0;
    private TextPaint f21012n;
    private TextPaint f21013o;
    private StaticLayout f21014p;
    private StaticLayout f21015q;
    private boolean f21016r;
    private int f21017s;
    private GestureDetector f21018t;
    private Scroller f21019u;
    private int f21020v;
    private List<C6083a> f21021w = new LinkedList();
    private List<C6084b> f21022x = new LinkedList();
    private int f21023y = Color.parseColor("#0D9FFB");
    private int f21024z = Color.parseColor("#80ffffff");

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f21004f = C5999c.m27451a(context, 35.0f);
        this.f21006h = getResources().getDimensionPixelSize(C6028e.hw_show_public_size_0_5);
        m27766a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21004f = C5999c.m27451a(context, 35.0f);
        this.f21006h = getResources().getDimensionPixelSize(C6028e.hw_show_public_size_0_5);
        m27766a(context);
    }

    public WheelView(Context context) {
        super(context);
        this.f21004f = C5999c.m27451a(context, 35.0f);
        this.f21006h = getResources().getDimensionPixelSize(C6028e.hw_show_public_size_0_5);
        m27766a(context);
    }

    private void m27766a(Context context) {
        this.f21018t = new GestureDetector(context, this.f20997G);
        this.f21018t.setIsLongpressEnabled(false);
        this.f21019u = new Scroller(context);
        this.f21001c = (float) getResources().getDimensionPixelSize(this.f20994B);
        this.f21002d = (float) getResources().getDimensionPixelSize(this.f20994B);
    }

    public C6081b getAdapter() {
        return this.f21007i;
    }

    public void setAdapter(C6081b c6081b) {
        this.f21007i = c6081b;
        m27779d();
        invalidate();
    }

    public void m27794a(int i, boolean z) {
        this.f20996F = z;
        int screenWidth = getScreenWidth() - getResources().getDimensionPixelSize(C6028e.hw_show_public_size_60);
        if (2 == i) {
            this.f20995E = screenWidth / 3;
        } else {
            this.f20995E = screenWidth / 2;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f21019u.forceFinished(true);
        this.f21019u = new Scroller(getContext(), interpolator);
    }

    public void m27795a(C6083a c6083a) {
        this.f21021w.add(c6083a);
    }

    protected void m27793a(int i, int i2) {
        for (C6083a a : this.f21021w) {
            a.m27806a(this, i, i2);
        }
    }

    protected void m27792a() {
        for (C6084b a : this.f21022x) {
            a.m27807a(this);
        }
    }

    protected void m27796b() {
        for (C6084b b : this.f21022x) {
            b.m27808b(this);
        }
    }

    public int getCurrentItem() {
        return this.f21008j;
    }

    public void m27798b(int i, boolean z) {
        if (this.f21007i != null && this.f21007i.mo5132a() != 0) {
            if (i < 0 || i >= this.f21007i.mo5132a()) {
                if (this.f21000b) {
                    while (i < 0) {
                    }
                    i %= this.f21007i.mo5132a();
                } else {
                    return;
                }
            }
            if (i == this.f21008j) {
                return;
            }
            if (z) {
                m27797b(i - this.f21008j, (int) HttpStatus.SC_BAD_REQUEST);
                return;
            }
            m27779d();
            int i2 = this.f21008j;
            this.f21008j = i;
            m27793a(i2, this.f21008j);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        m27798b(i, false);
    }

    public void setCyclic(boolean z) {
        this.f21000b = z;
        invalidate();
        m27779d();
    }

    private void m27779d() {
        this.f21014p = null;
        this.f21015q = null;
        this.f21017s = 0;
    }

    private void m27782e() {
        if (this.f21012n == null) {
            this.f21012n = new TextPaint(33);
            this.f21012n.density = getResources().getDisplayMetrics().density;
            this.f21012n.setTextSize(this.f21002d);
        }
        if (this.f21013o == null) {
            this.f21013o = new TextPaint(37);
            this.f21013o.density = getResources().getDisplayMetrics().density;
            this.f21013o.setTextSize(this.f21001c);
            this.f21013o.setShadowLayer(0.1f, 0.0f, 0.1f, -4144960);
        }
    }

    private int m27763a(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return Math.max((int) ((((float) (getItemHeight() * this.f21010l)) - (this.f21005g * 2.0f)) - ((float) this.f21004f)), getSuggestedMinimumHeight());
    }

    private String m27764a(int i) {
        if (this.f21007i == null || this.f21007i.mo5132a() == 0) {
            return null;
        }
        int a = this.f21007i.mo5132a();
        if ((i < 0 || i >= a) && !this.f21000b) {
            return null;
        }
        while (i < 0) {
            i += a;
        }
        return this.f21007i.mo5133a(i % a);
    }

    private String m27765a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = (this.f21010l / 2) + 1;
        int i2 = this.f21008j - i;
        while (i2 <= this.f21008j + i) {
            if (z || i2 != this.f21008j) {
                String a = m27764a(i2);
                if (a != null) {
                    stringBuilder.append(a);
                }
            }
            if (i2 < this.f21008j + i) {
                stringBuilder.append("\n");
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    private int getMaxTextLength() {
        C6081b adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int b = adapter.mo5134b();
        if (b > 0) {
            return b;
        }
        String str = null;
        for (int max = Math.max(this.f21008j - (this.f21010l / 2), 0); max < Math.min(this.f21008j + this.f21010l, adapter.mo5132a()); max++) {
            String a = adapter.mo5133a(max);
            if (a != null && (str == null || str.length() < a.length())) {
                str = a;
            }
        }
        return str != null ? str.length() : 0;
    }

    private int getItemHeight() {
        if (this.f21011m != 0) {
            return this.f21011m;
        }
        if (this.f21014p == null || this.f21014p.getLineCount() <= 2) {
            return getHeight() / this.f21010l;
        }
        this.f21011m = this.f21014p.getLineTop(2) - this.f21014p.getLineTop(1);
        return this.f21011m;
    }

    private int m27775c(int i, int i2) {
        int i3;
        m27782e();
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            float ceil = (float) Math.ceil((double) Layout.getDesiredWidth("0", this.f21012n));
            if (this.f20996F) {
                ceil *= 2.0f;
            }
            this.f21009k = (int) (ceil * ((float) maxTextLength));
        } else {
            this.f21009k = 0;
        }
        this.f21009k += 10;
        if (i2 == 1073741824) {
            i3 = 1;
        } else {
            i3 = Math.max(this.f21009k, getSuggestedMinimumWidth());
            if (i2 != Integer.MIN_VALUE || i >= i3) {
                i = i3;
                i3 = 0;
            } else {
                i3 = 1;
            }
        }
        if (i3 != 0) {
            this.f21009k = i;
        }
        if (this.f21009k > 0) {
            m27772b(this.f21009k);
        }
        return i;
    }

    private void m27772b(int i) {
        if (this.f21014p == null || this.f21014p.getWidth() > i) {
            this.f21014p = new StaticLayout(m27765a(this.f21016r), this.f21012n, i, Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f21004f, false);
        } else {
            this.f21014p.increaseWidthTo(i);
        }
        if (!this.f21016r && (this.f21015q == null || this.f21015q.getWidth() > i)) {
            CharSequence a;
            if (getAdapter() != null) {
                a = getAdapter().mo5133a(this.f21008j);
            } else {
                a = null;
            }
            if (a == null) {
                a = "";
            }
            this.f21015q = new StaticLayout(a, this.f21013o, i, Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f21004f, false);
        } else if (this.f21016r) {
            this.f21015q = null;
        } else {
            this.f21015q.increaseWidthTo(i);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i2);
        m27775c(this.f20995E, mode);
        if (mode2 != 1073741824) {
            mode = m27763a(this.f21014p);
            size = mode2 == Integer.MIN_VALUE ? Math.min(mode, size) : mode;
        }
        setMeasuredDimension(this.f20995E, size);
    }

    private int getScreenWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f21014p == null) {
            if (this.f21009k == 0) {
                m27775c(getWidth(), 1073741824);
            } else {
                m27772b(this.f21009k);
            }
        }
        m27768a(canvas, f20991C);
        m27768a(canvas, f20992D);
        if (this.f21009k > 0) {
            canvas.save();
            canvas.translate(0.0f, -this.f21005g);
            m27773b(canvas);
            m27767a(canvas);
            canvas.restore();
        }
    }

    private void m27768a(Canvas canvas, int i) {
        int height = getHeight() / 2;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C6001d.common_white_15alpha));
        paint.setStrokeWidth((float) this.f21006h);
        if (f20991C == i) {
            canvas.drawLine(0.0f, (float) (height - (getHeight() / 8)), (float) getWidth(), (float) (height - (getHeight() / 8)), paint);
            return;
        }
        canvas.drawLine(0.0f, (float) (((getHeight() / 8) + height) - this.f21006h), (float) getWidth(), (float) ((height + (getHeight() / 8)) - this.f21006h), paint);
    }

    public void setColor(boolean z) {
        if (z) {
            this.f21023y = this.f20993A;
            invalidate();
            return;
        }
        this.f21023y = this.f21024z;
        invalidate();
    }

    private void m27767a(Canvas canvas) {
        this.f21013o.setColor(this.f21023y);
        this.f21013o.drawableState = getDrawableState();
        Rect rect = new Rect();
        this.f21014p.getLineBounds(this.f21010l / 2, rect);
        int i = ((int) (this.f21001c - this.f21002d)) / 2;
        if (this.f21015q != null) {
            canvas.save();
            canvas.translate(0.0f, (float) ((rect.top - i) + this.f21017s));
            this.f21015q.draw(canvas);
            canvas.restore();
        }
    }

    private void m27773b(Canvas canvas) {
        canvas.save();
        if (this.f21014p != null) {
            canvas.translate(0.0f, (float) ((-this.f21014p.getLineTop(1)) + this.f21017s));
            this.f21012n.setColor(this.f21003e);
            this.f21012n.drawableState = getDrawableState();
            this.f21014p.draw(canvas);
        }
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getAdapter() == null || this.f21018t.onTouchEvent(motionEvent) || motionEvent.getAction() != 1)) {
            m27784f();
        }
        return true;
    }

    private void m27777c(int i) {
        this.f21017s += i;
        int itemHeight = this.f21017s / getItemHeight();
        int i2 = this.f21008j - itemHeight;
        if (this.f21000b && this.f21007i.mo5132a() > 0) {
            while (i2 < 0) {
                i2 += this.f21007i.mo5132a();
            }
            i2 %= this.f21007i.mo5132a();
        } else if (!this.f21016r) {
            i2 = Math.min(Math.max(i2, 0), this.f21007i.mo5132a() - 1);
        } else if (i2 < 0) {
            itemHeight = this.f21008j;
            i2 = 0;
        } else if (i2 >= this.f21007i.mo5132a()) {
            itemHeight = (this.f21008j - this.f21007i.mo5132a()) + 1;
            i2 = this.f21007i.mo5132a() - 1;
        }
        int i3 = this.f21017s;
        if (i2 != this.f21008j) {
            m27798b(i2, false);
        } else {
            invalidate();
        }
        this.f21017s = i3 - (getItemHeight() * itemHeight);
        if (this.f21017s > getHeight()) {
            this.f21017s = (this.f21017s % getHeight()) + getHeight();
        }
    }

    private void setNextMessage(int i) {
        m27786g();
        this.f20998H.sendEmptyMessage(i);
    }

    private void m27784f() {
        if (this.f21007i != null) {
            this.f21020v = 0;
            int i = this.f21017s;
            int itemHeight = getItemHeight();
            int i2 = i > 0 ? this.f21008j < this.f21007i.mo5132a() ? 1 : 0 : this.f21008j > 0 ? 1 : 0;
            if ((this.f21000b || r0 != 0) && Math.abs((float) i) > ((float) itemHeight) / 2.0f) {
                i = i < 0 ? i + (itemHeight + 1) : i - (itemHeight + 1);
            }
            if (Math.abs(i) > 1) {
                this.f21019u.startScroll(0, 0, 0, i, HttpStatus.SC_BAD_REQUEST);
                setNextMessage(1);
                return;
            }
            m27799c();
        }
    }

    private void m27786g() {
        this.f20998H.removeMessages(0);
        this.f20998H.removeMessages(1);
    }

    private void m27788h() {
        if (!this.f21016r) {
            this.f21016r = true;
            m27792a();
        }
    }

    void m27799c() {
        if (this.f21016r) {
            m27796b();
            this.f21016r = false;
        }
        m27779d();
        invalidate();
    }

    public void m27797b(int i, int i2) {
        this.f21019u.forceFinished(true);
        this.f21020v = this.f21017s;
        int itemHeight = i * getItemHeight();
        this.f21019u.startScroll(0, this.f21020v, 0, itemHeight - this.f21020v, i2);
        setNextMessage(0);
        m27788h();
    }
}
