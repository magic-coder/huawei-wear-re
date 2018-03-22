package com.huawei.pluginkidwatch.common.ui.view;

import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.v4.view.ViewCompat;

/* compiled from: CustomCircleProgress */
class C1594u {
    public RectF f3969a = new RectF();
    public boolean f3970b = true;
    public int f3971c = 0;
    public int f3972d = 0;
    public int f3973e = -13312;
    public int f3974f = -90;
    public Paint f3975g = new Paint();
    public Paint f3976h;
    public Paint f3977i;
    final /* synthetic */ CustomCircleProgress f3978j;

    public C1594u(CustomCircleProgress customCircleProgress) {
        this.f3978j = customCircleProgress;
        this.f3975g.setAntiAlias(true);
        this.f3975g.setStyle(Style.FILL);
        this.f3975g.setStrokeWidth((float) this.f3972d);
        this.f3975g.setColor(this.f3973e);
        this.f3976h = new Paint();
        this.f3976h.setAntiAlias(true);
        this.f3976h.setStyle(Style.FILL);
        this.f3976h.setStrokeWidth((float) this.f3972d);
        this.f3976h.setColor(this.f3973e);
        this.f3977i = new Paint();
        this.f3977i.setAntiAlias(true);
        this.f3977i.setStyle(Style.FILL);
        this.f3977i.setStrokeWidth((float) this.f3972d);
        this.f3977i.setColor(-7829368);
    }

    public void m7333a(int i) {
        this.f3975g.setStrokeWidth((float) i);
        this.f3976h.setStrokeWidth((float) i);
        this.f3977i.setStrokeWidth((float) i);
    }

    public void m7336b(int i) {
        this.f3975g.setColor(i);
        this.f3976h.setColor((ViewCompat.MEASURED_SIZE_MASK & i) | 1711276032);
    }

    public void m7335a(boolean z) {
        this.f3970b = z;
        if (z) {
            this.f3975g.setStyle(Style.FILL);
            this.f3976h.setStyle(Style.FILL);
            this.f3977i.setStyle(Style.FILL);
            return;
        }
        this.f3975g.setStyle(Style.STROKE);
        this.f3976h.setStyle(Style.STROKE);
        this.f3977i.setStyle(Style.STROKE);
    }

    public void m7334a(int i, int i2) {
        if (this.f3971c != 0) {
            this.f3969a.set((float) ((this.f3972d / 2) + this.f3971c), (float) ((this.f3972d / 2) + this.f3971c), (float) ((i - (this.f3972d / 2)) - this.f3971c), (float) ((i2 - (this.f3972d / 2)) - this.f3971c));
            return;
        }
        int paddingLeft = this.f3978j.getPaddingLeft();
        int paddingRight = this.f3978j.getPaddingRight();
        this.f3969a.set((float) (paddingLeft + (this.f3972d / 2)), (float) (this.f3978j.getPaddingTop() + (this.f3972d / 2)), (float) ((i - paddingRight) - (this.f3972d / 2)), (float) ((i2 - this.f3978j.getPaddingBottom()) - (this.f3972d / 2)));
    }
}
