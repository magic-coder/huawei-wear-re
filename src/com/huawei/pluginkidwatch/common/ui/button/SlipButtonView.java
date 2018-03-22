package com.huawei.pluginkidwatch.common.ui.button;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.C1617f;

public class SlipButtonView extends View implements OnTouchListener {
    private boolean f3530a = false;
    private Bitmap f3531b;
    private Bitmap f3532c;
    private Bitmap f3533d;
    private Bitmap f3534e;
    private Bitmap f3535f;
    private boolean f3536g = false;
    private boolean f3537h = false;
    private float f3538i;
    private float f3539j;
    private float f3540k;
    private float f3541l;
    private float f3542m;
    private float f3543n;
    private float f3544o;
    private C1514c f3545p;
    private boolean f3546q = true;
    private boolean f3547r;
    private float f3548s;
    private int f3549t;
    private float f3550u;
    private C1515d f3551v;
    private float f3552w;
    private ViewParent f3553x;
    private Paint f3554y;
    private boolean f3555z = true;

    public SlipButtonView(Context context) {
        super(context);
        m7003a(context);
    }

    public SlipButtonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7003a(context);
    }

    private void m7003a(Context context) {
        this.f3531b = BitmapFactory.decodeResource(getResources(), C1617f.kw_switch_thumb_emui);
        this.f3532c = BitmapFactory.decodeResource(getResources(), C1617f.kw_switch_thumb_disabled_emui);
        this.f3533d = BitmapFactory.decodeResource(getResources(), C1617f.kw_switch_bg_on_emui);
        this.f3534e = BitmapFactory.decodeResource(getResources(), C1617f.kw_switch_bg_off_emui);
        this.f3535f = BitmapFactory.decodeResource(getResources(), C1617f.kw_switch_bg_on_press_emui);
        this.f3549t = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f3550u = (float) ((int) ((getResources().getDisplayMetrics().density * 1000.0f) + 0.5f));
        this.f3544o = 5.0f;
        this.f3541l = 5.0f;
        this.f3543n = (float) ((this.f3533d.getWidth() - this.f3531b.getWidth()) - 5);
        this.f3542m = this.f3530a ? this.f3543n : this.f3544o;
        setOnTouchListener(this);
        this.f3554y = new Paint();
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f3546q) {
            return false;
        }
        float abs = Math.abs(motionEvent.getX() - this.f3538i);
        float abs2 = Math.abs(motionEvent.getY() - this.f3540k);
        switch (motionEvent.getAction()) {
            case 0:
                m7009c();
                if (motionEvent.getX() <= ((float) this.f3533d.getWidth()) && motionEvent.getY() <= ((float) this.f3533d.getHeight())) {
                    this.f3538i = motionEvent.getX();
                    this.f3540k = motionEvent.getY();
                    this.f3542m = this.f3530a ? this.f3543n : this.f3544o;
                    break;
                }
                return false;
                break;
            case 1:
                if (abs2 < ((float) this.f3549t) && abs < ((float) this.f3549t)) {
                    if (this.f3551v == null) {
                        this.f3551v = new C1515d();
                    }
                    if (!post(this.f3551v)) {
                        performClick();
                    }
                    C2538c.m12674b("SlipButtonView", "----perform--click---");
                    break;
                }
                m7005a(this.f3536g);
                C2538c.m12674b("SlipButtonView", "---perform-- slip---");
                break;
                break;
            case 2:
                this.f3539j = motionEvent.getX();
                this.f3541l = (this.f3542m + this.f3539j) - this.f3538i;
                if (this.f3541l < this.f3544o) {
                    this.f3541l = this.f3544o;
                }
                if (this.f3541l > this.f3543n) {
                    this.f3541l = this.f3543n;
                }
                if (this.f3541l < ((this.f3543n - this.f3544o) / 2.0f) + this.f3544o) {
                    this.f3536g = false;
                } else {
                    this.f3536g = true;
                }
                invalidate();
                break;
        }
        return true;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean z = this.f3541l > ((this.f3543n - this.f3544o) / 2.0f) + this.f3544o;
        if (z != this.f3530a) {
            boolean z2 = this.f3530a;
            this.f3541l = this.f3530a ? this.f3543n : this.f3544o;
            z = z2;
        }
        if (!z) {
            canvas.drawBitmap(this.f3534e, 0.0f, 0.0f, this.f3554y);
            canvas.drawBitmap(this.f3531b, this.f3541l, 0.0f, this.f3554y);
        } else if (this.f3555z) {
            canvas.drawBitmap(this.f3533d, 0.0f, 0.0f, this.f3554y);
            canvas.drawBitmap(this.f3531b, this.f3541l, 0.0f, this.f3554y);
        } else {
            canvas.drawBitmap(this.f3535f, 0.0f, 0.0f, this.f3554y);
            canvas.drawBitmap(this.f3532c, this.f3541l, 0.0f, this.f3554y);
        }
    }

    public void setEnableTouch(boolean z) {
        this.f3546q = z;
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f3533d.getWidth(), this.f3533d.getHeight());
    }

    public void setOnChangedListener(C1514c c1514c) {
        this.f3545p = c1514c;
    }

    public void setChecked(boolean z) {
        C2538c.m12674b("SlipButtonView", "------------mNowIsChecked=" + this.f3530a + "-----------checked=" + z);
        if (this.f3530a != z) {
            this.f3530a = z;
            invalidate();
        }
    }

    private void setListener(boolean z) {
        if (this.f3530a != z && !this.f3547r) {
            this.f3547r = true;
            if (this.f3545p != null) {
                this.f3545p.mo2610a(z);
            }
            this.f3547r = false;
        }
    }

    public boolean getChecked() {
        return this.f3530a;
    }

    public boolean performClick() {
        m7005a(!this.f3530a);
        return true;
    }

    private void m7005a(boolean z) {
        this.f3537h = true;
        this.f3548s = this.f3541l;
        this.f3552w = z ? this.f3550u : -this.f3550u;
        new C1516e().run();
    }

    private void m7001a() {
        this.f3548s += (this.f3552w * 50.0f) / 1000.0f;
        if (this.f3548s >= this.f3543n) {
            m7007b();
            this.f3548s = this.f3543n;
            setCheckedDelayed(true);
        } else if (this.f3548s <= this.f3544o) {
            m7007b();
            this.f3548s = this.f3544o;
            setCheckedDelayed(false);
        }
        m7002a(this.f3548s);
    }

    private void m7002a(float f) {
        this.f3541l = f;
        invalidate();
    }

    private void m7007b() {
        this.f3537h = false;
    }

    private void m7009c() {
        this.f3553x = getParent();
        if (this.f3553x != null) {
            this.f3553x.requestDisallowInterceptTouchEvent(true);
        }
    }

    private void setCheckedDelayed(boolean z) {
        postDelayed(new C1513b(this, z), 10);
    }

    public void setButtonEnabled(boolean z) {
        this.f3555z = z;
    }

    public boolean getButtonEnabled() {
        return this.f3555z;
    }
}
