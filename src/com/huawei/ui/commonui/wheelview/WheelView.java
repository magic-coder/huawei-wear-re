package com.huawei.ui.commonui.wheelview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.huawei.ui.commonui.C6001d;
import com.huawei.ui.commonui.C6028e;
import com.huawei.ui.commonui.C6029f;
import com.huawei.ui.commonui.p514d.C5999c;
import com.huawei.ui.commonui.wheelview.p515a.C6053c;
import java.util.LinkedList;
import java.util.List;

public class WheelView extends View {
    private static int f20873k = 1;
    private static int f20874l = 2;
    private boolean f20875A;
    private int f20876B;
    private GestureDetector f20877C;
    private Scroller f20878D;
    private int f20879E;
    private List<C5691c> f20880F = new LinkedList();
    private List<C6058d> f20881G = new LinkedList();
    private int f20882H = ViewCompat.MEASURED_STATE_MASK;
    private int f20883I = ViewCompat.MEASURED_STATE_MASK;
    private int f20884J = -48794;
    private int f20885K = C6029f.commonui_wheel_bg;
    private int f20886L = C6028e.wheelview_text_size_item;
    private SimpleOnGestureListener f20887M = new C6079y(this);
    private Handler f20888N = new C6080z(this);
    public float f20889a = 5.0f;
    boolean f20890b = false;
    Context f20891c;
    float f20892d = 24.0f;
    float f20893e = 17.0f;
    private int f20894f = -4144960;
    private int f20895g = 55;
    private final float f20896h = this.f20889a;
    private int f20897i = 4;
    private int f20898j = 1;
    private C6053c f20899m = null;
    private int f20900n = 0;
    private int f20901o = 0;
    private int f20902p = 0;
    private int f20903q = 5;
    private int f20904r = 0;
    private TextPaint f20905s;
    private TextPaint f20906t;
    private TextPaint f20907u;
    private StaticLayout f20908v;
    private StaticLayout f20909w;
    private StaticLayout f20910x;
    private String f20911y;
    private String f20912z = "";

    public WheelView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f20895g = C5999c.m27451a(context, 35.0f);
        this.f20897i = C5999c.m27451a(context, 2.0f);
        this.f20891c = context;
        m27671a(context);
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20895g = C5999c.m27451a(context, 35.0f);
        this.f20897i = C5999c.m27451a(context, 2.0f);
        this.f20891c = context;
        m27671a(context);
    }

    public WheelView(Context context) {
        super(context);
        this.f20895g = C5999c.m27451a(context, 35.0f);
        this.f20897i = C5999c.m27451a(context, 2.0f);
        this.f20891c = context;
        m27671a(context);
    }

    private void m27671a(Context context) {
        this.f20877C = new GestureDetector(context, this.f20887M);
        this.f20877C.setIsLongpressEnabled(false);
        this.f20878D = new Scroller(context);
        this.f20892d = (float) getResources().getDimensionPixelSize(this.f20886L);
        this.f20893e = (float) getResources().getDimensionPixelSize(this.f20886L);
    }

    public C6053c getAdapter() {
        return this.f20899m;
    }

    public void setAdapter(C6053c c6053c) {
        this.f20899m = c6053c;
        m27685d();
        invalidate();
    }

    public void setInterpolator(Interpolator interpolator) {
        this.f20878D.forceFinished(true);
        this.f20878D = new Scroller(getContext(), interpolator);
    }

    public String getLabel() {
        return this.f20911y;
    }

    public void setLabel(String str) {
        if (this.f20911y == null || !this.f20911y.equals(str)) {
            this.f20911y = str;
            invalidate();
        }
    }

    public void m27702a(C5691c c5691c) {
        this.f20880F.add(c5691c);
    }

    protected void m27700a(int i, int i2) {
        for (C5691c onChanged : this.f20880F) {
            onChanged.onChanged(this, i, i2);
        }
    }

    protected void m27699a() {
        for (C6058d a : this.f20881G) {
            a.m27727a(this);
        }
    }

    protected void m27703b() {
        for (C6058d b : this.f20881G) {
            b.m27728b(this);
        }
    }

    public int getCurrentItem() {
        return this.f20900n;
    }

    public void m27701a(int i, boolean z) {
        if (this.f20899m != null && this.f20899m.mo5129a() != 0) {
            if (i < 0 || i >= this.f20899m.mo5129a()) {
                if (this.f20890b) {
                    while (i < 0) {
                    }
                    i %= this.f20899m.mo5129a();
                } else {
                    return;
                }
            }
            if (i == this.f20900n) {
                return;
            }
            if (z) {
                m27704b(i - this.f20900n, (int) HttpStatus.SC_BAD_REQUEST);
                return;
            }
            m27685d();
            int i2 = this.f20900n;
            this.f20900n = i;
            m27700a(i2, this.f20900n);
            invalidate();
        }
    }

    public void setCurrentItem(int i) {
        m27701a(i, false);
    }

    public void setCyclic(boolean z) {
        this.f20890b = z;
        invalidate();
        m27685d();
    }

    private void m27685d() {
        this.f20908v = null;
        this.f20909w = null;
        this.f20910x = null;
        this.f20876B = 0;
    }

    private void m27688e() {
        if (this.f20905s == null) {
            this.f20905s = new TextPaint(33);
            this.f20905s.density = getResources().getDisplayMetrics().density;
            this.f20905s.setTextSize(this.f20893e);
        }
        if (this.f20906t == null) {
            this.f20906t = new TextPaint(33);
            this.f20906t.density = getResources().getDisplayMetrics().density;
            this.f20906t.setTextSize(this.f20893e);
        }
        if (this.f20907u == null) {
            this.f20907u = new TextPaint(37);
            this.f20907u.density = getResources().getDisplayMetrics().density;
            this.f20907u.setTextSize(this.f20892d);
        }
        setBackgroundResource(this.f20885K);
    }

    private int m27668a(Layout layout) {
        if (layout == null) {
            return 0;
        }
        return Math.max((int) ((((float) (getItemHeight() * this.f20903q)) - (this.f20896h * 2.0f)) - ((float) this.f20895g)), getSuggestedMinimumHeight());
    }

    private String m27669a(int i) {
        if (this.f20899m == null || this.f20899m.mo5129a() == 0) {
            return null;
        }
        int a = this.f20899m.mo5129a();
        if ((i < 0 || i >= a) && !this.f20890b) {
            return null;
        }
        while (i < 0) {
            i += a;
        }
        return this.f20899m.mo5130a(i % a);
    }

    private String m27670a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = (this.f20903q / 2) + 1;
        int i2 = this.f20900n - i;
        while (i2 <= this.f20900n + i) {
            if (z || !(i2 == this.f20900n || i2 == this.f20900n + (i - 1) || i2 == this.f20900n - (i - 1))) {
                String a = m27669a(i2);
                if (a != null) {
                    stringBuilder.append(a);
                }
            }
            if (i2 < this.f20900n + i) {
                stringBuilder.append("\n");
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    private String m27678b(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = (this.f20903q / 2) + 1;
        int i2 = this.f20900n - i;
        while (i2 <= this.f20900n + i) {
            if (!(z || i2 == this.f20900n || i2 == this.f20900n + 1 || i2 == this.f20900n - 1)) {
                String a = m27669a(i2);
                if (a != null) {
                    stringBuilder.append(a);
                }
            }
            if (i2 < this.f20900n + i) {
                stringBuilder.append("\n");
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    private int getMaxTextLength() {
        C6053c adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        int b = adapter.mo5131b();
        if (b > 0) {
            return b;
        }
        String str = null;
        for (int max = Math.max(this.f20900n - (this.f20903q / 2), 0); max < Math.min(this.f20900n + this.f20903q, adapter.mo5129a()); max++) {
            String a = adapter.mo5130a(max);
            if (a != null && (str == null || str.length() < a.length())) {
                str = a;
            }
        }
        return str != null ? str.length() : 0;
    }

    private int getItemHeight() {
        if (this.f20904r != 0) {
            return this.f20904r;
        }
        if (this.f20908v == null || this.f20908v.getLineCount() <= 2) {
            return getHeight() / this.f20903q;
        }
        this.f20904r = this.f20908v.getLineTop(2) - this.f20908v.getLineTop(1);
        return this.f20904r;
    }

    private int m27684d(int i, int i2) {
        m27688e();
        int maxTextLength = getMaxTextLength();
        if (maxTextLength > 0) {
            this.f20901o = (int) (((float) maxTextLength) * ((float) Math.ceil((double) Layout.getDesiredWidth("0", this.f20905s))));
        } else {
            this.f20901o = 0;
        }
        this.f20901o += 10;
        this.f20902p = 0;
        if (this.f20911y != null && this.f20911y.length() > 0) {
            this.f20902p = (int) Math.ceil((double) Layout.getDesiredWidth(this.f20911y, this.f20907u));
        }
        if (i2 == 1073741824) {
            maxTextLength = 1;
        } else {
            maxTextLength = (this.f20901o + this.f20902p) + 0;
            if (this.f20902p > 0) {
                maxTextLength += this.f20897i;
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
            maxTextLength = (i - this.f20897i) + 0;
            if (maxTextLength <= 0) {
                this.f20902p = 0;
                this.f20901o = 0;
            }
            if (this.f20902p > 0) {
                this.f20901o = (int) ((((double) this.f20901o) * ((double) maxTextLength)) / ((double) (this.f20901o + this.f20902p)));
                this.f20902p = maxTextLength - this.f20901o;
            } else {
                this.f20901o = maxTextLength + this.f20897i;
            }
        }
        if (this.f20901o > 0) {
            m27689e(this.f20901o, this.f20902p);
        }
        return i;
    }

    private void m27689e(int i, int i2) {
        if (this.f20908v == null || this.f20908v.getWidth() > i) {
            this.f20908v = new StaticLayout(m27670a(this.f20875A), this.f20905s, i, i2 > 0 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f20895g, false);
            if (this.f20909w == null || this.f20909w.getWidth() > i) {
                this.f20909w = new StaticLayout(m27678b(this.f20875A), this.f20906t, i, i2 > 0 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f20895g, false);
            }
        } else {
            this.f20908v.increaseWidthTo(i);
        }
        if (!this.f20875A && (this.f20910x == null || this.f20910x.getWidth() > i)) {
            CharSequence a;
            if (getAdapter() != null) {
                a = getAdapter().mo5130a(this.f20900n);
            } else {
                a = null;
            }
            if (a == null) {
                a = "";
            }
            this.f20910x = new StaticLayout(a, this.f20907u, i, i2 > 0 ? Alignment.ALIGN_OPPOSITE : Alignment.ALIGN_CENTER, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, (float) this.f20895g, false);
        } else if (this.f20875A) {
            this.f20910x = null;
        } else {
            this.f20910x.increaseWidthTo(i);
        }
    }

    protected void onMeasure(int i, int i2) {
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        size = m27684d(size, mode);
        if (mode2 != 1073741824) {
            mode = m27668a(this.f20908v);
            size2 = mode2 == Integer.MIN_VALUE ? Math.min(mode, size2) : mode;
        }
        setMeasuredDimension(size, size2);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f20908v == null) {
            if (this.f20901o == 0) {
                m27684d(getWidth(), 1073741824);
            } else {
                m27689e(this.f20901o, this.f20902p);
            }
        }
        m27673a(canvas, f20873k);
        m27673a(canvas, f20874l);
        if (this.f20901o > 0) {
            canvas.save();
            canvas.translate(0.0f, -this.f20896h);
            m27680b(canvas);
            m27681c(canvas);
            m27672a(canvas);
            canvas.restore();
        }
    }

    private void m27673a(Canvas canvas, int i) {
        int height = getHeight() / 2;
        this.f20898j = getResources().getDimensionPixelSize(C6028e.hw_show_public_size_0_5);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(C6001d.common_white_15alpha));
        paint.setStrokeWidth((float) this.f20898j);
        if (f20873k == i) {
            canvas.drawLine(0.0f, (float) (height - (getHeight() / 8)), (float) getWidth(), (float) (height - (getHeight() / 8)), paint);
        } else {
            canvas.drawLine(0.0f, (float) (((getHeight() / 8) + height) - this.f20898j), (float) getWidth(), (float) (((getHeight() / 8) + height) - this.f20898j), paint);
        }
        if (!TextUtils.isEmpty(this.f20912z)) {
            Rect rect = new Rect(getWidth() / 2, height - (getHeight() / 8), getWidth(), (getHeight() / 8) + height);
            Paint paint2 = new Paint();
            paint2.setColor(this.f20884J);
            paint2.setTextSize((float) C5999c.m27451a(this.f20891c, 11.0f));
            FontMetricsInt fontMetricsInt = paint2.getFontMetricsInt();
            int i2 = (((rect.bottom + rect.top) - fontMetricsInt.bottom) - fontMetricsInt.top) / 2;
            paint2.setTextAlign(Align.CENTER);
            canvas.drawText(this.f20912z, (float) rect.centerX(), (float) i2, paint2);
        }
    }

    public void setColor(boolean z) {
        if (z) {
            this.f20882H = this.f20884J;
            invalidate();
            return;
        }
        this.f20882H = this.f20883I;
        invalidate();
    }

    private void m27672a(Canvas canvas) {
        this.f20907u.setColor(this.f20882H);
        this.f20907u.setTextSize(this.f20892d);
        this.f20907u.drawableState = getDrawableState();
        Rect rect = new Rect();
        this.f20908v.getLineBounds(this.f20903q / 2, rect);
        int i = ((int) (this.f20892d - this.f20893e)) / 2;
        if (this.f20910x != null) {
            canvas.save();
            canvas.translate(0.0f, (float) ((rect.top - i) + this.f20876B));
            this.f20910x.draw(canvas);
            canvas.restore();
        }
    }

    private void m27680b(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) ((-this.f20908v.getLineTop(1)) + this.f20876B));
        this.f20905s.setTextSize(this.f20893e);
        this.f20905s.setColor(this.f20894f);
        this.f20905s.drawableState = getDrawableState();
        this.f20908v.draw(canvas);
        canvas.restore();
    }

    private void m27681c(Canvas canvas) {
        canvas.save();
        canvas.translate(0.0f, (float) ((-this.f20909w.getLineTop(1)) + this.f20876B));
        this.f20906t.setTextSize(this.f20893e);
        this.f20906t.setColor(872415231);
        this.f20906t.drawableState = getDrawableState();
        this.f20909w.draw(canvas);
        canvas.restore();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!(getAdapter() == null || this.f20877C.onTouchEvent(motionEvent) || motionEvent.getAction() != 1)) {
            m27691f();
        }
        return true;
    }

    private void m27679b(int i) {
        this.f20876B += i;
        int itemHeight = this.f20876B / getItemHeight();
        int i2 = this.f20900n - itemHeight;
        if (this.f20890b && this.f20899m.mo5129a() > 0) {
            while (i2 < 0) {
                i2 += this.f20899m.mo5129a();
            }
            i2 %= this.f20899m.mo5129a();
        } else if (!this.f20875A) {
            i2 = Math.min(Math.max(i2, 0), this.f20899m.mo5129a() - 1);
        } else if (i2 < 0) {
            itemHeight = this.f20900n;
            i2 = 0;
        } else if (i2 >= this.f20899m.mo5129a()) {
            itemHeight = (this.f20900n - this.f20899m.mo5129a()) + 1;
            i2 = this.f20899m.mo5129a() - 1;
        }
        int i3 = this.f20876B;
        if (i2 != this.f20900n) {
            m27701a(i2, false);
        } else {
            invalidate();
        }
        this.f20876B = i3 - (getItemHeight() * itemHeight);
        if (this.f20876B > getHeight()) {
            this.f20876B = (this.f20876B % getHeight()) + getHeight();
        }
    }

    private void setNextMessage(int i) {
        m27693g();
        this.f20888N.sendEmptyMessage(i);
    }

    private void m27691f() {
        if (this.f20899m != null) {
            this.f20879E = 0;
            int i = this.f20876B;
            int itemHeight = getItemHeight();
            int i2 = i > 0 ? this.f20900n < this.f20899m.mo5129a() ? 1 : 0 : this.f20900n > 0 ? 1 : 0;
            if ((this.f20890b || r0 != 0) && Math.abs((float) i) > ((float) itemHeight) / 2.0f) {
                i = i < 0 ? i + (itemHeight + 1) : i - (itemHeight + 1);
            }
            if (Math.abs(i) > 1) {
                this.f20878D.startScroll(0, 0, 0, i, HttpStatus.SC_BAD_REQUEST);
                setNextMessage(1);
                return;
            }
            m27705c();
        }
    }

    private void m27693g() {
        this.f20888N.removeMessages(0);
        this.f20888N.removeMessages(1);
    }

    private void m27695h() {
        if (!this.f20875A) {
            this.f20875A = true;
            m27699a();
        }
    }

    void m27705c() {
        if (this.f20875A) {
            m27703b();
            this.f20875A = false;
        }
        m27685d();
        invalidate();
    }

    public void m27704b(int i, int i2) {
        this.f20878D.forceFinished(true);
        this.f20879E = this.f20876B;
        int itemHeight = i * getItemHeight();
        this.f20878D.startScroll(0, this.f20879E, 0, itemHeight - this.f20879E, i2);
        setNextMessage(0);
        m27695h();
    }

    public void m27706c(int i, int i2) {
        this.f20882H = i2;
        this.f20883I = i2;
        this.f20884J = i2;
        this.f20894f = i;
        this.f20893e = (float) C5999c.m27451a(this.f20891c, 15.0f);
        this.f20892d = (float) C5999c.m27451a(this.f20891c, 18.0f);
    }

    public void setUnit(String str) {
        this.f20912z = str;
    }
}
