package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: ImageViewTouchBase */
abstract class C1539q extends ImageView {
    private final Matrix f3670a;
    private final float[] f3671b;
    private C1558t f3672c;
    private Runnable f3673d;
    protected Matrix f3674f;
    protected Matrix f3675g;
    protected final C1561x f3676h;
    int f3677i;
    int f3678j;
    float f3679k;
    int f3680l;
    int f3681m;
    int f3682n;
    int f3683o;
    protected Handler f3684p;

    public void setRecycler(C1558t c1558t) {
        this.f3672c = c1558t;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f3680l = i;
        this.f3681m = i3;
        this.f3682n = i2;
        this.f3683o = i4;
        this.f3677i = i3 - i;
        this.f3678j = i4 - i2;
        Runnable runnable = this.f3673d;
        if (runnable != null) {
            this.f3673d = null;
            runnable.run();
        }
        if (this.f3676h.m7171b() != null) {
            m7102a(this.f3676h, this.f3674f);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || getScale() <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
            return super.onKeyDown(i, keyEvent);
        }
        m7107a((float) DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        return true;
    }

    public void setImageBitmap(Bitmap bitmap) {
        m7101a(bitmap, 0);
    }

    private void m7101a(Bitmap bitmap, int i) {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null) {
            drawable.setDither(true);
        }
        Bitmap b = this.f3676h.m7171b();
        this.f3676h.m7170a(bitmap);
        this.f3676h.m7169a(i);
        if (b != null && b != bitmap && this.f3672c != null) {
            this.f3672c.m7159a(b);
        }
    }

    public void mo2535a(Bitmap bitmap, boolean z) {
        mo2536a(new C1561x(bitmap), z);
    }

    public void mo2536a(C1561x c1561x, boolean z) {
        if (getWidth() <= 0) {
            this.f3673d = new C1556r(this, c1561x, z);
            return;
        }
        if (c1561x.m7171b() != null) {
            m7102a(c1561x, this.f3674f);
            m7101a(c1561x.m7171b(), c1561x.m7168a());
        } else {
            this.f3674f.reset();
            setImageBitmap(null);
        }
        if (z) {
            this.f3675g.reset();
        }
        setImageMatrix(getImageViewMatrix());
        this.f3679k = m7104a();
    }

    protected void m7113a(boolean z, boolean z2) {
        float f = 0.0f;
        if (this.f3676h.m7171b() != null) {
            int height;
            Matrix imageViewMatrix = getImageViewMatrix();
            RectF rectF = new RectF(0.0f, 0.0f, (float) this.f3676h.m7171b().getWidth(), (float) this.f3676h.m7171b().getHeight());
            imageViewMatrix.mapRect(rectF);
            float height2 = rectF.height();
            float width = rectF.width();
            if (z2) {
                height = getHeight();
                if (height2 < ((float) height)) {
                    height2 = ((((float) height) - height2) / 2.0f) - rectF.top;
                } else if (rectF.top > 0.0f) {
                    height2 = -rectF.top;
                } else if (rectF.bottom < ((float) height)) {
                    height2 = ((float) getHeight()) - rectF.bottom;
                }
                if (z) {
                    height = getWidth();
                    if (width < ((float) height)) {
                        f = ((((float) height) - width) / 2.0f) - rectF.left;
                    } else if (rectF.left > 0.0f) {
                        f = -rectF.left;
                    } else if (rectF.right < ((float) height)) {
                        f = ((float) height) - rectF.right;
                    }
                }
                mo2533a(f, height2);
                setImageMatrix(getImageViewMatrix());
            }
            height2 = 0.0f;
            if (z) {
                height = getWidth();
                if (width < ((float) height)) {
                    f = ((((float) height) - width) / 2.0f) - rectF.left;
                } else if (rectF.left > 0.0f) {
                    f = -rectF.left;
                } else if (rectF.right < ((float) height)) {
                    f = ((float) height) - rectF.right;
                }
            }
            mo2533a(f, height2);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public C1539q(Context context) {
        super(context);
        this.f3674f = new Matrix();
        this.f3675g = new Matrix();
        this.f3670a = new Matrix();
        this.f3671b = new float[9];
        this.f3676h = new C1561x(null);
        this.f3677i = -1;
        this.f3678j = -1;
        this.f3684p = new Handler();
        this.f3673d = null;
        m7103b();
    }

    public C1539q(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3674f = new Matrix();
        this.f3675g = new Matrix();
        this.f3670a = new Matrix();
        this.f3671b = new float[9];
        this.f3676h = new C1561x(null);
        this.f3677i = -1;
        this.f3678j = -1;
        this.f3684p = new Handler();
        this.f3673d = null;
        m7103b();
    }

    private void m7103b() {
        setScaleType(ScaleType.MATRIX);
    }

    protected float m7106a(Matrix matrix, int i) {
        matrix.getValues(this.f3671b);
        return this.f3671b[i];
    }

    protected float m7105a(Matrix matrix) {
        return m7106a(matrix, 0);
    }

    protected float getScale() {
        return m7105a(this.f3675g);
    }

    private void m7102a(C1561x c1561x, Matrix matrix) {
        float width = (float) getWidth();
        float height = (float) getHeight();
        float f = (float) c1561x.m7175f();
        float e = (float) c1561x.m7174e();
        matrix.reset();
        float min = Math.min(Math.min(width / f, 2.0f), Math.min(height / e, 2.0f));
        matrix.postConcat(c1561x.m7172c());
        matrix.postScale(min, min);
        matrix.postTranslate((width - (f * min)) / 2.0f, (height - (e * min)) / 2.0f);
    }

    protected Matrix getImageViewMatrix() {
        this.f3670a.set(this.f3674f);
        this.f3670a.postConcat(this.f3675g);
        return this.f3670a;
    }

    protected float m7104a() {
        if (this.f3676h.m7171b() == null) {
            return DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        }
        return Math.max(((float) this.f3676h.m7175f()) / ((float) this.f3677i), ((float) this.f3676h.m7174e()) / ((float) this.f3678j)) * 4.0f;
    }

    protected void mo2534a(float f, float f2, float f3) {
        if (f > this.f3679k) {
            f = this.f3679k;
        }
        float scale = f / getScale();
        this.f3675g.postScale(scale, scale, f2, f3);
        setImageMatrix(getImageViewMatrix());
        m7113a(true, true);
    }

    protected void m7110a(float f, float f2, float f3, float f4) {
        float scale = (f - getScale()) / f4;
        float scale2 = getScale();
        this.f3684p.post(new C1557s(this, f4, System.currentTimeMillis(), scale2, scale, f2, f3));
    }

    protected void m7107a(float f) {
        mo2534a(f, ((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f);
    }

    protected void mo2533a(float f, float f2) {
        this.f3675g.postTranslate(f, f2);
    }

    protected void m7114b(float f, float f2) {
        mo2533a(f, f2);
        setImageMatrix(getImageViewMatrix());
    }
}
