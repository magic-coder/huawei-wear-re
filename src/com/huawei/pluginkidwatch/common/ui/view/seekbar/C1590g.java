package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;

/* compiled from: DrawThumb */
public final class C1590g extends C1585a {
    private C1591i f3965b;

    public C1590g(Resources resources, int i) {
        this.f3965b = new C1591i(resources, i);
    }

    public void m7323a(Canvas canvas) {
        canvas.drawBitmap(this.f3965b.a, this.f3965b.m7329d().left, this.f3965b.m7329d().top, this.a);
    }

    public void m7322a(int i, int i2, int i3, int i4, int i5, int i6) {
        m7321a((float) ((((((i - i5) - i6) * i4) / i3) + i5) - (m7324b() / 2)), ((float) (i2 - m7325c())) / 2.0f);
    }

    public RectF m7320a() {
        return this.f3965b.m7329d();
    }

    public void m7321a(float f, float f2) {
        this.f3965b.m7326a(f, f2);
    }

    public int m7324b() {
        return this.f3965b.m7304a();
    }

    public int m7325c() {
        return this.f3965b.m7305b();
    }
}
