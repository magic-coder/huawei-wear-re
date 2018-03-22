package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;

/* compiled from: DrawText */
public final class C1589f extends C1584b {
    protected String f3963b;
    protected PointF f3964c;

    public C1589f(Paint paint) {
        this.a = paint;
    }

    public void m7317a(Canvas canvas) {
        if (this.f3964c != null) {
            canvas.drawText(this.f3963b, this.f3964c.x, this.f3964c.y, this.a);
        }
    }

    public void m7319a(Canvas canvas, C1590g c1590g, int i, int i2, int i3) {
        float f = (c1590g.m7320a().left + c1590g.m7320a().right) / 2.0f;
        float f2 = c1590g.m7320a().top - ((float) i);
        if (this.f3964c == null) {
            this.f3964c = new PointF(f, f2);
        } else {
            this.f3964c.x = f;
            this.f3964c.y = f2;
        }
        this.f3963b = String.valueOf(i2 + i3) + "m";
        m7317a(canvas);
    }

    public void m7318a(Canvas canvas, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, C1590g c1590g) {
        float f = ((float) ((i - i3) - i4)) / ((float) i5);
        int i9 = i6 / i5;
        int c = ((c1590g.m7325c() + i2) / 2) + i8;
        for (int i10 = 0; i10 <= i5; i10++) {
            float f2 = ((float) i3) + (((float) i10) * f);
            String str = String.valueOf((i9 * i10) + i7) + "m";
            float measureText = this.a.measureText(str) / 2.0f;
            if (i10 == 0) {
                f2 += measureText;
            }
            if (i10 == i5) {
                f2 -= measureText;
            }
            if (this.f3964c == null) {
                this.f3964c = new PointF(f2, (float) c);
            } else {
                this.f3964c.x = f2;
                this.f3964c.y = (float) c;
            }
            this.f3963b = str;
            if (i10 % 2 == 0) {
                m7317a(canvas);
            }
        }
    }
}
