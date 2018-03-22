package com.huawei.ui.commonui.seekbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huawei.ui.commonui.C6032i;
import com.huawei.ui.commonui.C6036m;
import com.huawei.ui.commonui.p514d.C5999c;
import java.util.ArrayList;
import java.util.List;

public class KRangeSeekBar extends View {
    Context f20758a;
    private int f20759b;
    private int f20760c;
    private int f20761d;
    private int f20762e;
    private int f20763f;
    private float f20764g;
    private float f20765h;
    private Bitmap f20766i;
    private Bitmap f20767j;
    private List<C6038b> f20768k;
    private int f20769l = 5;
    private int f20770m = 30;
    private int f20771n = 100;
    private int f20772o = 50;
    private int f20773p = 40;
    private boolean f20774q = false;
    private boolean f20775r = true;
    private List<C6037a> f20776s;
    private C6038b f20777t;
    private int f20778u;
    private float f20779v = 0.0f;
    private float f20780w = 0.0f;

    public KRangeSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m27604a(context, attributeSet);
        this.f20758a = context;
        m27602a();
    }

    private void m27602a() {
        this.f20767j = BitmapFactory.decodeResource(getResources(), C6032i.seekbar_di_scale);
        this.f20766i = BitmapFactory.decodeResource(getResources(), C6032i.seekbar_btn_drag);
        this.f20765h = ((float) this.f20766i.getWidth()) / 2.0f;
        this.f20763f = C5999c.m27451a(this.f20758a, 45.0f);
        this.f20776s = new ArrayList();
        this.f20768k = new ArrayList();
        for (int i = 0; i < this.f20769l; i++) {
            this.f20768k.add(new C6038b());
        }
    }

    private void m27604a(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C6036m.KRangeSeekBar_Style);
            this.f20770m = obtainStyledAttributes.getInt(C6036m.KRangeSeekBar_Style_startScale, this.f20770m);
            this.f20771n = obtainStyledAttributes.getInt(C6036m.KRangeSeekBar_Style_endScale, this.f20771n);
            obtainStyledAttributes.recycle();
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m27605a(canvas);
        m27608b(canvas);
        m27610c(canvas);
        m27611d(canvas);
        m27612e(canvas);
    }

    private void m27605a(Canvas canvas) {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C6032i.seekbar_di_bar);
        NinePatch ninePatch = new NinePatch(decodeResource, decodeResource.getNinePatchChunk(), null);
        this.f20762e = decodeResource.getHeight() / 2;
        float f = (((float) this.f20763f) + this.f20765h) - ((float) this.f20762e);
        float f2 = (((float) this.f20763f) + this.f20765h) + ((float) this.f20762e);
        RectF rectF = new RectF();
        rectF.set((float) this.f20759b, f, (float) this.f20760c, f2);
        ninePatch.draw(canvas, rectF);
    }

    private void m27608b(Canvas canvas) {
        float f = ((float) this.f20762e) + (((float) this.f20763f) + this.f20765h);
        float f2 = this.f20765h + ((float) this.f20759b);
        Paint paint = new Paint();
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint.setTextSize((float) C5999c.m27451a(this.f20758a, 12.0f));
        paint.setAntiAlias(true);
        float a = C5999c.m27448a(paint) + (((float) this.f20767j.getHeight()) + f);
        int i = (this.f20771n - this.f20770m) / 10;
        for (int i2 = 0; i2 <= i; i2++) {
            canvas.drawBitmap(this.f20767j, (((float) (i2 * 10)) * this.f20764g) + f2, f, null);
            String str;
            if (i2 == i) {
                str = this.f20771n + "%";
                canvas.drawText(str, ((float) this.f20760c) - C5999c.m27449a(paint, str), a, paint);
            } else if (i2 != (this.f20773p - this.f20770m) / 10) {
                str = String.valueOf((i2 * 10) + this.f20770m);
                canvas.drawText(str, ((((float) (i2 * 10)) * this.f20764g) + f2) - (C5999c.m27449a(paint, str) / 2.0f), a, paint);
            }
        }
    }

    private void m27610c(Canvas canvas) {
        if (!this.f20768k.isEmpty() && this.f20768k.size() > 1) {
            int a;
            float f = (((float) this.f20763f) + this.f20765h) - ((float) this.f20762e);
            float f2 = ((float) this.f20762e) + (((float) this.f20763f) + this.f20765h);
            for (int i = 1; i < this.f20768k.size(); i++) {
                a = m27601a(i);
                Paint paint = new Paint();
                paint.setColor(a);
                RectF rectF = new RectF();
                rectF.set(((C6038b) this.f20768k.get(i - 1)).f20781a, f, ((C6038b) this.f20768k.get(i)).f20781a, f2);
                canvas.drawRect(rectF, paint);
            }
            a = m27601a(this.f20768k.size());
            Paint paint2 = new Paint();
            paint2.setColor(a);
            RectF rectF2 = new RectF();
            rectF2.set(((C6038b) this.f20768k.get(this.f20768k.size() - 1)).f20781a, f, (float) (this.f20760c - 8), f2);
            canvas.drawRect(rectF2, paint2);
        }
    }

    private int m27601a(int i) {
        switch (i) {
            case 1:
                return -16723112;
            case 2:
                return -2557355;
            case 3:
                return -17893;
            case 4:
                return -564447;
            case 5:
                return -314849;
            default:
                return 0;
        }
    }

    private void m27611d(Canvas canvas) {
        for (int i = 0; i < this.f20769l; i++) {
            canvas.drawBitmap(this.f20766i, ((C6038b) this.f20768k.get(i)).f20781a - this.f20765h, (float) this.f20763f, null);
        }
    }

    private void m27612e(Canvas canvas) {
        if (!this.f20768k.isEmpty() && this.f20774q) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C6032i.seekbar_pop);
            float a = (float) C5999c.m27451a(this.f20758a, 6.0f);
            canvas.drawBitmap(decodeResource, ((C6038b) this.f20768k.get(this.f20778u)).f20781a - (((float) decodeResource.getWidth()) / 2.0f), a, null);
            Paint paint = new Paint();
            paint.setTextSize((float) C5999c.m27451a(this.f20758a, 13.0f));
            paint.setColor(-1);
            paint.setAntiAlias(true);
            String valueOf = String.valueOf((int) ((C6038b) this.f20768k.get(this.f20778u)).f20782b);
            canvas.drawText(valueOf, ((C6038b) this.f20768k.get(this.f20778u)).f20781a - (C5999c.m27449a(paint, valueOf) / 2.0f), ((((float) decodeResource.getHeight()) / 2.0f) + a) + ((float) C5999c.m27451a(this.f20758a, 3.0f)), paint);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f20759b = getPaddingLeft();
        this.f20760c = getMeasuredWidth() - getPaddingRight();
        this.f20761d = this.f20760c - this.f20759b;
        if (this.f20775r) {
            m27607b();
            this.f20775r = false;
        }
    }

    private void m27607b() {
        this.f20764g = (((float) this.f20761d) - (this.f20765h * 2.0f)) / ((float) ((this.f20771n - this.f20770m) - 1));
        for (int i = 0; i < this.f20769l; i++) {
            C6038b c6038b = (C6038b) this.f20768k.get(i);
            c6038b.f20782b = (float) (this.f20772o + (i * 10));
            c6038b.f20781a = (((c6038b.f20782b - ((float) this.f20770m)) * this.f20764g) + this.f20765h) + ((float) this.f20759b);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f20768k.isEmpty()) {
            return false;
        }
        float x = motionEvent.getX();
        if (motionEvent.getAction() == 0) {
            this.f20774q = true;
            int i = 0;
            while (i < this.f20768k.size()) {
                if (x > ((C6038b) this.f20768k.get(i)).f20781a - this.f20765h && x < ((C6038b) this.f20768k.get(i)).f20781a + this.f20765h) {
                    this.f20777t = (C6038b) this.f20768k.get(0);
                    this.f20778u = i;
                    this.f20779v = m27606b(this.f20778u);
                    this.f20780w = m27609c(this.f20778u);
                    break;
                }
                this.f20777t = null;
                i++;
            }
            invalidate();
        }
        if (motionEvent.getAction() == 2 && this.f20777t != null) {
            this.f20774q = true;
            if (x <= this.f20779v) {
                m27603a(this.f20778u, this.f20779v);
            } else if (x >= this.f20780w) {
                m27603a(this.f20778u, this.f20780w);
            } else {
                m27603a(this.f20778u, x);
            }
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            this.f20774q = false;
            invalidate();
            if (this.f20776s != null && this.f20776s.size() > 0) {
                for (C6037a a : this.f20776s) {
                    a.m27613a(this.f20778u, ((C6038b) this.f20768k.get(this.f20778u)).f20782b);
                }
            }
        }
        return true;
    }

    private float m27606b(int i) {
        if (i == 0) {
            return ((float) this.f20759b) + this.f20765h;
        }
        return ((C6038b) this.f20768k.get(i - 1)).f20781a + (this.f20765h * 2.0f);
    }

    private float m27609c(int i) {
        if (i == this.f20768k.size() - 1) {
            return ((float) this.f20760c) - this.f20765h;
        }
        return ((C6038b) this.f20768k.get(i + 1)).f20781a - (this.f20765h * 2.0f);
    }

    private void m27603a(int i, float f) {
        ((C6038b) this.f20768k.get(i)).f20781a = f;
        ((C6038b) this.f20768k.get(i)).f20782b = (((f - ((float) this.f20759b)) / this.f20764g) - 2.0f) + ((float) this.f20770m);
        invalidate();
    }
}
