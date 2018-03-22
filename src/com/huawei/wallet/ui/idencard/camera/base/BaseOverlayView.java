package com.huawei.wallet.ui.idencard.camera.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.wallet.utils.log.LogC;

public abstract class BaseOverlayView extends View {
    static BaseOverlayView f21537f;
    private static final int[] f21538n = new int[]{0, 64, 128, 192, 255, 192, 128, 64};
    protected int f21539a;
    protected int f21540b;
    protected int f21541c;
    protected int f21542d;
    protected float f21543e;
    private float f21544g = 0.06666667f;
    private Rect f21545h;
    private Paint f21546i;
    private Rect f21547j;
    private Rect f21548k;
    private int f21549l = 1610612736;
    private int f21550m;
    private int f21551o;
    private IEventListener f21552p;
    private PorterDuffXfermode f21553q;
    private RectF f21554r;

    public interface IEventListener {
        void mo5182a();
    }

    protected abstract Rect mo5180a(int i, int i2);

    public static void setBaseOverlayView(BaseOverlayView baseOverlayView) {
        f21537f = baseOverlayView;
    }

    public BaseOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        mo5181a();
        this.f21546i = new Paint(1);
        this.f21553q = new PorterDuffXfermode(Mode.CLEAR);
        this.f21554r = new RectF();
        this.f21551o = 4;
        this.f21552p = null;
        setBaseOverlayView(this);
    }

    protected void mo5181a() {
        this.f21539a = m28386a(getContext(), 2.0f);
        this.f21540b = m28386a(getContext(), 24.0f);
        this.f21541c = m28386a(getContext(), 8.0f);
        this.f21542d = m28386a(getContext(), 2.0f);
        this.f21543e = 0.6f;
    }

    public void m28389a(int i, int i2, int i3, int i4, int i5) {
        if (i3 > i4) {
            i2 = i;
        }
        Rect a = mo5180a(i3, i4);
        a.offset(0, 0);
        this.f21548k = a;
        setGuideAndRotation(this.f21548k);
        this.f21547j = new Rect(a);
        this.f21547j.top += i5;
        this.f21547j.bottom += i5;
        float f = (DefaultRetryPolicy.DEFAULT_BACKOFF_MULT * ((float) i2)) / ((float) i3);
        this.f21547j.left = (int) (((float) this.f21547j.left) * f);
        this.f21547j.top = (int) (((float) this.f21547j.top) * f);
        this.f21547j.right = (int) (((float) this.f21547j.right) * f);
        this.f21547j.bottom = (int) (f * ((float) this.f21547j.bottom));
    }

    public static Rect m28384a(boolean z) {
        if (z) {
            return f21537f.f21547j;
        }
        return f21537f.f21548k;
    }

    private void setGuideAndRotation(Rect rect) {
        LogC.m28530b("setGuideAndRotation: " + rect, false);
        this.f21545h = rect;
        invalidate();
    }

    private Rect m28383a(int i, int i2, int i3, int i4) {
        int i5 = this.f21539a / 2;
        Rect rect = new Rect();
        rect.left = Math.min(i, i3) - i5;
        rect.right = Math.max(i, i3) + i5;
        rect.top = Math.min(i2, i4) - i5;
        rect.bottom = i5 + Math.max(i2, i4);
        return rect;
    }

    private RectF m28385b(int i, int i2, int i3, int i4) {
        int i5 = this.f21539a / 2;
        RectF rectF = new RectF();
        rectF.left = (float) (Math.min(i, i3) - i5);
        rectF.right = (float) (Math.max(i, i3) + i5);
        rectF.top = (float) (Math.min(i2, i4) - i5);
        rectF.bottom = (float) (i5 + Math.max(i2, i4));
        return rectF;
    }

    public void onDraw(Canvas canvas) {
        if (this.f21545h != null) {
            int i;
            int i2 = this.f21540b;
            canvas.save();
            canvas.drawColor(this.f21549l);
            this.f21546i.clearShadowLayer();
            this.f21546i.setColor(0);
            this.f21546i.setStyle(Style.FILL);
            this.f21546i.setXfermode(this.f21553q);
            this.f21554r.set((float) this.f21545h.left, (float) this.f21545h.top, (float) this.f21545h.right, (float) this.f21545h.bottom);
            canvas.drawRoundRect(this.f21554r, (float) this.f21541c, (float) this.f21541c, this.f21546i);
            this.f21546i.setXfermode(null);
            if (this.f21541c != 0) {
                this.f21546i.clearShadowLayer();
                this.f21546i.setColor(this.f21550m);
                this.f21546i.setStyle(Style.STROKE);
                this.f21546i.setStrokeWidth((float) this.f21539a);
                i = this.f21541c - (this.f21539a / 2);
                int i3 = this.f21545h.left + this.f21541c;
                int i4 = this.f21545h.top + this.f21541c;
                canvas.drawArc(m28385b(i3 - i, i4 - i, i3 + i, i4 + i), BitmapDescriptorFactory.HUE_CYAN, 90.0f, false, this.f21546i);
                i3 = this.f21545h.left + this.f21541c;
                i4 = this.f21545h.bottom - this.f21541c;
                canvas.drawArc(m28385b(i3 - i, i4 + i, i3 + i, i4 - i), 90.0f, 90.0f, false, this.f21546i);
                i3 = this.f21545h.right - this.f21541c;
                i4 = this.f21545h.top + this.f21541c;
                canvas.drawArc(m28385b(i3 - i, i4 + i, i3 + i, i4 - i), BitmapDescriptorFactory.HUE_VIOLET, 90.0f, false, this.f21546i);
                i3 = this.f21545h.right - this.f21541c;
                i4 = this.f21545h.bottom - this.f21541c;
                canvas.drawArc(m28385b(i3 - i, i4 + i, i3 + i, i4 - i), 0.0f, 90.0f, false, this.f21546i);
            }
            this.f21546i.clearShadowLayer();
            this.f21546i.setColor(this.f21550m);
            this.f21546i.setStyle(Style.FILL);
            canvas.drawRect(m28383a(this.f21545h.left + this.f21541c, this.f21545h.top, this.f21545h.left + i2, this.f21545h.top), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.left, this.f21545h.top + i2, this.f21545h.left, this.f21545h.top + this.f21541c), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.left + this.f21541c, this.f21545h.bottom, this.f21545h.left + i2, this.f21545h.bottom), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.left, this.f21545h.bottom - i2, this.f21545h.left, this.f21545h.bottom - this.f21541c), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.right - this.f21541c, this.f21545h.top, this.f21545h.right - i2, this.f21545h.top), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.right, this.f21545h.top + i2, this.f21545h.right, this.f21545h.top + this.f21541c), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.right - this.f21541c, this.f21545h.bottom, this.f21545h.right - i2, this.f21545h.bottom), this.f21546i);
            canvas.drawRect(m28383a(this.f21545h.right, this.f21545h.bottom - i2, this.f21545h.right, this.f21545h.bottom - this.f21541c), this.f21546i);
            this.f21546i.setStyle(Style.FILL);
            this.f21546i.setColor(this.f21550m);
            this.f21546i.setAlpha(f21538n[this.f21551o]);
            this.f21551o = (this.f21551o + 1) % f21538n.length;
            int i5 = this.f21545h.left;
            i2 = this.f21545h.right;
            int height = (((int) (((float) this.f21545h.height()) * this.f21543e)) + this.f21545h.top) - (this.f21542d / 2);
            i = height + this.f21542d;
            canvas.drawRect((float) i5, (float) height, (float) i2, (float) i, this.f21546i);
            postInvalidateDelayed(100, i5, height, i2, i);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & 255) == 0 && this.f21552p != null) {
            this.f21552p.mo5182a();
        }
        return false;
    }

    protected int m28386a(Context context, float f) {
        return (int) (TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public int getGuideColor() {
        return this.f21550m;
    }

    public void setGuideColor(int i) {
        this.f21550m = i;
    }

    public void setScannerAlpha(int i) {
        this.f21551o = i;
        this.f21551o = (this.f21551o + 1) % f21538n.length;
    }

    public void m28390a(IEventListener iEventListener) {
        this.f21552p = iEventListener;
    }

    public void m28391b() {
        this.f21552p = null;
    }
}
