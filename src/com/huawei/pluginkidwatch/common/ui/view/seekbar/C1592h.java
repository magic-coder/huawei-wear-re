package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.NinePatch;

/* compiled from: NinePathBitmap */
public final class C1592h extends C1591i {
    private NinePatch f3967b;

    public C1592h(Resources resources, int i) {
        super(resources, i);
        m7331e();
    }

    private void m7331e() {
        this.f3967b = C1592h.m7330a(this.a);
    }

    public static NinePatch m7330a(Bitmap bitmap) {
        return new NinePatch(bitmap, bitmap.getNinePatchChunk(), null);
    }

    public NinePatch m7332c() {
        return this.f3967b;
    }
}
