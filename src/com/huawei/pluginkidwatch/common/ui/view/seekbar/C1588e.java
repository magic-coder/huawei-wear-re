package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;

/* compiled from: DrawLayer */
public final class C1588e extends C1585a {
    private C1592h f3962b;

    public C1588e(Resources resources, int i) {
        this.f3962b = new C1592h(resources, i);
    }

    public void m7313a(Canvas canvas) {
        this.f3962b.m7332c().draw(canvas, this.f3962b.m7329d());
    }

    public RectF m7310a() {
        return this.f3962b.m7329d();
    }

    public void m7314a(RectF rectF) {
        this.f3962b.m7328a(rectF);
    }

    public void m7311a(float f, float f2, float f3, float f4) {
        this.f3962b.m7327a(f, f2, f3, f4);
    }

    public int m7316b() {
        return this.f3962b.m7305b();
    }

    public void m7315a(C1590g c1590g, int i, int i2) {
        if (m7310a() == null) {
            m7314a(new RectF());
        }
        m7310a().left = (float) i;
        m7310a().right = (c1590g.m7320a().right + c1590g.m7320a().left) / 2.0f;
        m7310a().top = ((float) (i2 - m7316b())) / 2.0f;
        m7310a().bottom = ((float) (m7316b() + i2)) / 2.0f;
    }

    public void m7312a(int i, int i2, int i3, int i4) {
        m7311a((float) i3, ((float) (i2 - m7316b())) / 2.0f, (float) (i - i4), ((float) (m7316b() + i2)) / 2.0f);
    }
}
