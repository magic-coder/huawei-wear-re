package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/* compiled from: DrawCircle */
public class C1587d extends C1584b {
    private boolean f3958b = true;
    private boolean f3959c = true;
    private PointF f3960d;
    private float f3961e;

    public C1587d(Paint paint) {
        this.a = paint;
    }

    public void m7306a(Canvas canvas) {
        canvas.drawCircle(this.f3960d.x, this.f3960d.y, this.f3961e, this.a);
    }

    public void m7307a(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, float f) {
        this.f3961e = f;
        float f2 = ((float) ((i - i3) - i4)) / ((float) i5);
        int i7 = i2 / 2;
        for (int i8 = 0; i8 <= i5; i8++) {
            float f3 = ((float) i3) + (((float) i8) * f2);
            if (this.f3960d == null) {
                this.f3960d = new PointF(f3, (float) i7);
            } else {
                this.f3960d.x = f3;
                this.f3960d.y = (float) i7;
            }
            if (i8 != 0 || this.f3958b) {
                if (i8 != i5 || this.f3959c) {
                    m7306a(canvas);
                } else {
                    return;
                }
            }
        }
    }

    public void m7308a(boolean z) {
        this.f3958b = z;
    }

    public void m7309b(boolean z) {
        this.f3959c = z;
    }
}
