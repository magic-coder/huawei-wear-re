package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/* compiled from: RotateBitmap */
public class C1561x {
    private Bitmap f3747a;
    private int f3748b = 0;

    public C1561x(Bitmap bitmap) {
        this.f3747a = bitmap;
    }

    public void m7169a(int i) {
        this.f3748b = i;
    }

    public int m7168a() {
        return this.f3748b;
    }

    public Bitmap m7171b() {
        return this.f3747a;
    }

    public void m7170a(Bitmap bitmap) {
        this.f3747a = bitmap;
    }

    public Matrix m7172c() {
        Matrix matrix = new Matrix();
        if (this.f3748b != 0) {
            matrix.preTranslate((float) (-(this.f3747a.getWidth() / 2)), (float) (-(this.f3747a.getHeight() / 2)));
            matrix.postRotate((float) this.f3748b);
            matrix.postTranslate(((float) this.f3747a.getWidth()) / 2.0f, ((float) this.f3747a.getHeight()) / 2.0f);
        }
        return matrix;
    }

    public boolean m7173d() {
        return (this.f3748b / 90) % 2 != 0;
    }

    public int m7174e() {
        if (m7173d()) {
            return this.f3747a.getWidth();
        }
        return this.f3747a.getHeight();
    }

    public int m7175f() {
        if (m7173d()) {
            return this.f3747a.getHeight();
        }
        return this.f3747a.getWidth();
    }
}
