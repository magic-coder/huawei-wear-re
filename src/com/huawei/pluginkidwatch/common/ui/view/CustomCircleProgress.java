package com.huawei.pluginkidwatch.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import com.huawei.pluginkidwatch.n;

public class CustomCircleProgress extends View {
    private C1594u f3792a;
    private int f3793b;
    private int f3794c;
    private int f3795d;
    private C1582r f3796e;
    private Drawable f3797f;
    private boolean f3798g = false;

    public CustomCircleProgress(Context context) {
        super(context);
        m7196b();
    }

    public CustomCircleProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m7196b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.CustomCircleProgress);
        this.f3793b = obtainStyledAttributes.getInteger(n.CustomCircleProgress_max_progress, 100);
        boolean z = obtainStyledAttributes.getBoolean(n.CustomCircleProgress_fill, true);
        int i = obtainStyledAttributes.getInt(n.CustomCircleProgress_Paint_Width, 10);
        this.f3792a.m7335a(z);
        if (!z) {
            this.f3792a.m7333a(i);
        }
        this.f3792a.m7336b(obtainStyledAttributes.getColor(n.CustomCircleProgress_Paint_Color, -13312));
        this.f3792a.f3971c = obtainStyledAttributes.getInt(n.CustomCircleProgress_Inside_Interval, 0);
        obtainStyledAttributes.recycle();
    }

    private void m7196b() {
        this.f3792a = new C1594u(this);
        this.f3796e = new C1582r(this);
        this.f3793b = 100;
        this.f3794c = 0;
        this.f3795d = 0;
    }

    protected void onMeasure(int i, int i2) {
        int size = MeasureSpec.getSize(i);
        this.f3797f = getBackground();
        if (this.f3797f != null) {
            size = this.f3797f.getMinimumWidth();
        }
        setMeasuredDimension(resolveSize(size, i), resolveSize(size, i2));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f3792a.m7334a(i, i);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3797f == null) {
            canvas.drawArc(this.f3792a.f3969a, 0.0f, 360.0f, this.f3792a.f3970b, this.f3792a.f3977i);
        }
        if (this.f3798g) {
            Canvas canvas2 = canvas;
            canvas2.drawArc(this.f3792a.f3969a, (float) this.f3792a.f3974f, 360.0f * (((float) this.f3795d) / ((float) this.f3793b)), this.f3792a.f3970b, this.f3792a.f3976h);
            float f = 360.0f * (((float) this.f3794c) / ((float) this.f3793b));
            canvas.drawArc(this.f3792a.f3969a, (float) this.f3792a.f3974f, f, this.f3792a.f3970b, this.f3792a.f3975g);
            return;
        }
        f = -360.0f * (((float) (this.f3793b - this.f3794c)) / ((float) this.f3793b));
        canvas.drawArc(this.f3792a.f3969a, (float) this.f3792a.f3974f, f, this.f3792a.f3970b, this.f3792a.f3975g);
    }

    public void setMainProgress(int i) {
        this.f3794c = i;
        if (this.f3794c < 0) {
            this.f3794c = 0;
        }
        if (this.f3794c > this.f3793b) {
            this.f3794c = this.f3793b;
        }
        invalidate();
    }

    public int getMainProgress() {
        return this.f3794c;
    }

    public void setSubProgress(int i) {
        this.f3795d = i;
        if (this.f3795d > this.f3793b) {
            this.f3795d = this.f3793b;
        }
        invalidate();
    }

    public int getSubProgress() {
        return this.f3795d;
    }

    public void m7199a(int i) {
        this.f3796e.m7294b(i);
    }

    public void m7198a() {
        this.f3796e.m7295c();
    }

    public boolean getCartoomState() {
        return this.f3796e.m7292a();
    }
}
