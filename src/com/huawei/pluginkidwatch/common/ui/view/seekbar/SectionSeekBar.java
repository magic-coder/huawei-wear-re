package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.pluginkidwatch.C1617f;
import com.huawei.pluginkidwatch.common.lib.utils.C1489i;
import com.huawei.pluginkidwatch.common.ui.view.ad;
import com.huawei.pluginkidwatch.n;

public class SectionSeekBar extends View {
    public int f3930a = 40;
    public int f3931b = 40;
    private C1589f f3932c;
    private C1589f f3933d;
    private C1590g f3934e;
    private C1588e f3935f;
    private C1588e f3936g;
    private C1587d f3937h;
    private int f3938i = 480;
    private int f3939j = 800;
    private int f3940k = 200;
    private int f3941l = 50;
    private int f3942m = 300;
    private float f3943n = 6.0f;
    private int f3944o = 4;
    private int f3945p = 5;
    private int f3946q = 15;
    private float f3947r = 22.0f;
    private int f3948s = ViewCompat.MEASURED_STATE_MASK;
    private int f3949t = -12727424;
    private float f3950u = 16.0f;
    private int f3951v = 1291845632;
    private int f3952w = C1617f.kw_pic_bottonbar_brag;
    private int f3953x = C1617f.kw_pic_bottonbar_track_bg;
    private int f3954y = C1617f.kw_pic_bottonbar_track;
    private ad f3955z;

    public void setOnChangeProgessListener(ad adVar) {
        this.f3955z = (ad) C1489i.m6887a(adVar);
    }

    public SectionSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m7301b(context, attributeSet);
    }

    public SectionSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7301b(context, attributeSet);
    }

    public SectionSeekBar(Context context) {
        super(context);
        m7301b(context, null);
    }

    @SuppressLint({"Recycle"})
    private void m7297a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.SeekBar_PopStyle);
            this.f3949t = obtainStyledAttributes.getColor(n.SeekBar_PopStyle_textPopColorSeekBar, this.f3949t);
            this.f3950u = obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_textPopSizeSeekBar, this.f3950u);
            this.f3948s = obtainStyledAttributes.getColor(n.SeekBar_PopStyle_textColorSeekBar, this.f3948s);
            this.f3947r = obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_textSizeSeekBar, this.f3947r);
            this.f3951v = obtainStyledAttributes.getColor(n.SeekBar_PopStyle_circleColorSeekBar, this.f3951v);
            this.f3943n = obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_radiusSeekBar, this.f3943n);
            this.f3944o = obtainStyledAttributes.getInt(n.SeekBar_PopStyle_sectionSeekBar, this.f3944o);
            this.f3952w = obtainStyledAttributes.getResourceId(n.SeekBar_PopStyle_thumbResSeekBar, this.f3952w);
            this.f3953x = obtainStyledAttributes.getResourceId(n.SeekBar_PopStyle_layerBackgroundResSeekBar, this.f3953x);
            this.f3954y = obtainStyledAttributes.getResourceId(n.SeekBar_PopStyle_layerProgressResSeekBar, this.f3954y);
            this.f3945p = (int) obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_offsetTopSeekBar, (float) this.f3945p);
            this.f3946q = (int) obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_offsetPopTopSeekBar, (float) this.f3946q);
            this.f3930a = (int) obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_marginLeftSeekBar, (float) this.f3930a);
            this.f3931b = (int) obtainStyledAttributes.getDimension(n.SeekBar_PopStyle_marginRightSeekBar, (float) this.f3931b);
            obtainStyledAttributes.recycle();
        }
    }

    private void m7301b(Context context, AttributeSet attributeSet) {
        m7297a(context, attributeSet);
        this.f3934e = new C1590g(getResources(), this.f3952w);
        this.f3935f = new C1588e(getResources(), this.f3953x);
        this.f3936g = new C1588e(getResources(), this.f3954y);
        Paint paint = new Paint();
        paint.setTextSize(this.f3947r);
        paint.setColor(this.f3948s);
        paint.setAntiAlias(true);
        paint.setTextAlign(Align.CENTER);
        this.f3932c = new C1589f(paint);
        paint = new Paint();
        paint.setColor(this.f3949t);
        paint.setTextSize(this.f3950u);
        paint.setAntiAlias(true);
        paint.setTextAlign(Align.CENTER);
        this.f3933d = new C1589f(paint);
        paint = new Paint();
        paint.setColor(this.f3951v);
        this.f3937h = new C1587d(paint);
        this.f3937h.m7308a(false);
        this.f3937h.m7309b(false);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f3938i = getMeasuredWidth();
        this.f3939j = getMeasuredHeight();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f3938i = getMeasuredWidth();
        this.f3939j = getMeasuredHeight();
        this.f3935f.m7312a(this.f3938i, this.f3939j, this.f3930a, this.f3931b);
        this.f3934e.m7322a(this.f3938i, this.f3939j, this.f3940k, this.f3941l, this.f3930a, this.f3931b);
        this.f3936g.m7315a(this.f3934e, this.f3930a, this.f3939j);
        this.f3935f.m7313a(canvas);
        this.f3936g.m7313a(canvas);
        this.f3937h.m7307a(canvas, this.f3938i, this.f3939j, this.f3930a, this.f3931b, this.f3944o, this.f3941l, this.f3943n);
        this.f3934e.m7323a(canvas);
        this.f3933d.m7319a(canvas, this.f3934e, this.f3946q, this.f3941l, this.f3942m);
        this.f3932c.m7318a(canvas, this.f3938i, this.f3939j, this.f3930a, this.f3931b, this.f3944o, this.f3940k, this.f3942m, this.f3945p, this.f3934e);
    }

    private void m7296a(float f) {
        if (f >= ((float) this.f3930a) && f <= ((float) (this.f3938i - this.f3931b))) {
            setProgress((int) ((((float) this.f3940k) * (f - ((float) this.f3930a))) / ((float) ((this.f3938i - this.f3930a) - this.f3931b))));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                m7296a(motionEvent.getX());
                invalidate();
                break;
            case 1:
            case 3:
                m7300b(motionEvent.getX());
                invalidate();
                break;
            case 2:
                m7296a(motionEvent.getX());
                invalidate();
                break;
        }
        return true;
    }

    private void m7300b(float f) {
        setProgress(m7299b(m7302c(f)));
    }

    private int m7299b(int i) {
        return (this.f3940k * i) / this.f3944o;
    }

    private boolean m7298a(float f, float f2, float f3) {
        return f3 >= (f + f2) / 2.0f;
    }

    private int m7302c(float f) {
        float f2 = ((float) ((this.f3938i - this.f3930a) - this.f3931b)) / ((float) this.f3944o);
        for (int i = 0; i <= this.f3944o; i++) {
            if (f <= ((float) this.f3930a) + (((float) i) * f2)) {
                if (i == 0) {
                    return i;
                }
                if (f > ((float) this.f3930a) + (((float) (i - 1)) * f2)) {
                    if (m7298a(((float) this.f3930a) + (((float) (i - 1)) * f2), (f2 * ((float) i)) + ((float) this.f3930a), f)) {
                        return i;
                    }
                    return i - 1;
                }
            }
            if (i == this.f3944o) {
                return i;
            }
        }
        return 0;
    }

    public int getMax() {
        return this.f3940k;
    }

    public void setMax(int i) {
        this.f3940k = i;
        invalidate();
    }

    public int getProgress() {
        return this.f3941l;
    }

    public void setProgress(int i) {
        this.f3941l = i;
        invalidate();
        if (this.f3955z != null) {
            this.f3955z.mo2624a(i);
        }
    }

    public void setMarginLeft(int i) {
        this.f3930a = i;
        invalidate();
    }

    public void setMarginRight(int i) {
        this.f3931b = i;
        invalidate();
    }

    public void setSection(int i) {
        this.f3944o = i;
        invalidate();
    }

    public void setOffsetTop(int i) {
        this.f3945p = i;
        invalidate();
    }

    public void setOffsetPopTop(int i) {
        this.f3946q = i;
        invalidate();
    }

    public void setRadius(int i) {
        this.f3943n = (float) i;
        invalidate();
    }

    public int m7303a(int i) {
        return this.f3942m + i;
    }

    public void setRealProgess(int i) {
        setProgress(i - this.f3942m);
    }
}
