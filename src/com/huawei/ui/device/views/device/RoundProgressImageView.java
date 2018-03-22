package com.huawei.ui.device.views.device;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.util.AttributeSet;
import android.view.View;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huawei.p190v.C2538c;

public class RoundProgressImageView extends View {
    private int f7834a;
    private int f7835b;
    private int f7836c;
    private int f7837d;
    private float f7838e = 100.0f;
    private float f7839f;
    private float f7840g = 0.0f;
    private Paint f7841h;
    private Paint f7842i;
    private int f7843j;
    private int f7844k;
    private int f7845l;
    private boolean f7846m = false;

    public RoundProgressImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11280d();
    }

    private void m11280d() {
        C2538c.m12677c("ProgressBarView", "init");
        this.f7841h = new Paint();
        this.f7841h.setAntiAlias(true);
        this.f7841h.setDither(true);
        this.f7841h.setStrokeCap(Cap.ROUND);
        this.f7842i = new Paint();
        this.f7842i.setAntiAlias(true);
        this.f7842i.setDither(true);
        this.f7842i.setStrokeCap(Cap.ROUND);
    }

    private void getCircleCenter() {
        C2538c.m12677c("ProgressBarView", "getCircleCenter getWidth() : " + getWidth() + " ; getHeight() : " + getHeight());
        if (this.f7836c == 0 || this.f7837d == 0) {
            this.f7836c = getWidth();
            this.f7837d = getHeight();
            this.f7843j = (Math.min(this.f7836c, this.f7837d) / 2) - 10;
            this.f7834a = this.f7843j / 8;
            this.f7835b = this.f7834a / 6;
            this.f7844k = this.f7836c / 2;
            this.f7845l = this.f7837d / 2;
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        C2538c.m12677c("ProgressBarView", "onDraw");
        getCircleCenter();
        C2538c.m12677c("ProgressBarView", "onDraw sweep : " + (360.0f * (this.f7839f / this.f7838e)));
        float f;
        double d;
        float sin;
        float cos;
        if (this.f7846m) {
            C2538c.m12677c("ProgressBarView", "onDraw arc_to :" + this.f7840g);
            float f2 = this.f7840g - 50.0f;
            this.f7842i.setColor(Color.parseColor("#0c0D9FFB"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g - 50.0f) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            f2 = this.f7840g - BitmapDescriptorFactory.HUE_ORANGE;
            this.f7842i.setColor(Color.parseColor("#330D9FFB"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g - BitmapDescriptorFactory.HUE_ORANGE) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            f2 = this.f7840g - 10.0f;
            this.f7842i.setColor(Color.parseColor("#660D9FFB"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g - 10.0f) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            f2 = this.f7840g + 10.0f;
            this.f7842i.setColor(Color.parseColor("#920D9FFB"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g + 10.0f) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            f2 = this.f7840g + BitmapDescriptorFactory.HUE_ORANGE;
            this.f7842i.setColor(Color.parseColor("#CC0D9FFB"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g + BitmapDescriptorFactory.HUE_ORANGE) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            f2 = this.f7840g + 50.0f;
            this.f7842i.setColor(Color.parseColor("#FF0D9FFB"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g + 50.0f) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            f2 = this.f7840g + 70.0f;
            this.f7842i.setColor(Color.parseColor("#000000"));
            this.f7842i.setStrokeWidth((float) this.f7835b);
            for (f = f2; f <= (this.f7840g + 70.0f) + 17.0f; f = 5.0f + f) {
                d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
                sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
                cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
                canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
            }
            return;
        }
        this.f7841h.setColor(Color.parseColor("#33ffffff"));
        this.f7841h.setStrokeWidth((float) this.f7835b);
        this.f7841h.setStrokeCap(Cap.ROUND);
        for (f = 1.6f; f <= 360.0f; f = 5.0f + f) {
            d = ((double) ((0.0f + f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
            sin = ((float) this.f7844k) - (((float) this.f7843j) * ((float) Math.sin(d)));
            cos = (((float) this.f7843j) * ((float) Math.cos(d))) + ((float) this.f7845l);
            canvas.drawLine(sin, cos, sin + (((float) this.f7834a) * ((float) Math.sin(d))), cos - (((float) this.f7834a) * ((float) Math.cos(d))), this.f7841h);
        }
        this.f7842i.setColor(Color.parseColor("#FF0D9FFB"));
        this.f7842i.setStrokeWidth((float) this.f7835b);
        this.f7842i.setStrokeCap(Cap.ROUND);
        for (f = 0.0f; f < r7; f = 5.0f + f) {
            d = ((double) ((f + 1.6f) / BitmapDescriptorFactory.HUE_CYAN)) * 3.141592653589793d;
            sin = (((float) this.f7843j) * ((float) Math.sin(d))) + ((float) this.f7844k);
            cos = ((float) this.f7845l) - (((float) this.f7843j) * ((float) Math.cos(d)));
            canvas.drawLine(sin, cos, sin - (((float) this.f7834a) * ((float) Math.sin(d))), cos + (((float) this.f7834a) * ((float) Math.cos(d))), this.f7842i);
        }
    }

    public void m11282a(float f) {
        this.f7839f = f;
        invalidate();
    }

    public void m11281a() {
        this.f7846m = true;
        C2538c.m12677c("ProgressBarView", "start!!!!!!start");
        C2205l c2205l = new C2205l(this);
    }

    public boolean m11283b() {
        return this.f7846m;
    }

    public void m11284c() {
        this.f7846m = false;
        this.f7840g = 0.0f;
        postInvalidate();
    }
}
