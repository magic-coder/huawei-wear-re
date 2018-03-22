package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.content.res.Resources;
import android.graphics.RectF;

/* compiled from: RectBitmap */
public class C1591i extends C1586c {
    private RectF f3966b;

    public C1591i(Resources resources, int i) {
        super(resources, i);
    }

    public RectF m7329d() {
        return this.f3966b;
    }

    public void m7328a(RectF rectF) {
        this.f3966b = rectF;
    }

    public void m7327a(float f, float f2, float f3, float f4) {
        this.f3966b = null;
        this.f3966b = new RectF(f, f2, f3, f4);
    }

    public void m7326a(float f, float f2) {
        m7327a(f, f2, ((float) m7304a()) + f, ((float) m7305b()) + f2);
    }
}
