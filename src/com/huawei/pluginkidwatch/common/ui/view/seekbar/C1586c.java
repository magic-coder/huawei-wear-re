package com.huawei.pluginkidwatch.common.ui.view.seekbar;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/* compiled from: CustomBitmap */
public class C1586c {
    protected Bitmap f3957a;

    public C1586c(Resources resources, int i) {
        this.f3957a = BitmapFactory.decodeResource(resources, i);
    }

    public int m7304a() {
        if (this.f3957a == null) {
            return 0;
        }
        return this.f3957a.getWidth();
    }

    public int m7305b() {
        if (this.f3957a == null) {
            return 0;
        }
        return this.f3957a.getHeight();
    }
}
