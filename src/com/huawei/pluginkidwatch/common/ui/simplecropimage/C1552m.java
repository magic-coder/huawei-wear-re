package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: CropImage */
class C1552m implements Runnable {
    float f3710a = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    Matrix f3711b;
    Face[] f3712c = new Face[3];
    int f3713d;
    final /* synthetic */ CropImage f3714e;

    C1552m(CropImage cropImage) {
        this.f3714e = cropImage;
    }

    private void m7133a(Face face) {
        boolean z = false;
        PointF pointF = new PointF();
        int eyesDistance = ((int) (face.eyesDistance() * this.f3710a)) * 2;
        face.getMidPoint(pointF);
        pointF.x *= this.f3710a;
        pointF.y *= this.f3710a;
        int i = (int) pointF.x;
        int i2 = (int) pointF.y;
        C1554o c1554o = new C1554o(this.f3714e.f3664o);
        Rect rect = new Rect(0, 0, this.f3714e.f3666q.getWidth(), this.f3714e.f3666q.getHeight());
        RectF rectF = new RectF((float) i, (float) i2, (float) i, (float) i2);
        rectF.inset((float) (-eyesDistance), (float) (-eyesDistance));
        if (rectF.left < 0.0f) {
            rectF.inset(-rectF.left, -rectF.left);
        }
        if (rectF.top < 0.0f) {
            rectF.inset(-rectF.top, -rectF.top);
        }
        if (rectF.right > ((float) rect.right)) {
            rectF.inset(rectF.right - ((float) rect.right), rectF.right - ((float) rect.right));
        }
        if (rectF.bottom > ((float) rect.bottom)) {
            rectF.inset(rectF.bottom - ((float) rect.bottom), rectF.bottom - ((float) rect.bottom));
        }
        Matrix matrix = this.f3711b;
        boolean e = this.f3714e.f3657h;
        if (!(this.f3714e.f3659j == 0 || this.f3714e.f3660k == 0)) {
            z = true;
        }
        c1554o.m7150a(matrix, rect, rectF, e, z);
        this.f3714e.f3664o.m7126a(c1554o);
    }

    private void m7132a() {
        int i;
        int i2;
        boolean z = false;
        C1554o c1554o = new C1554o(this.f3714e.f3664o);
        int width = this.f3714e.f3666q.getWidth();
        int height = this.f3714e.f3666q.getHeight();
        Rect rect = new Rect(0, 0, width, height);
        int min = (Math.min(width, height) * 4) / 5;
        if (this.f3714e.f3659j == 0 || this.f3714e.f3660k == 0) {
            i = min;
            i2 = min;
        } else if (this.f3714e.f3659j > this.f3714e.f3660k) {
            i = (this.f3714e.f3660k * min) / this.f3714e.f3659j;
            i2 = min;
        } else {
            i2 = (this.f3714e.f3659j * min) / this.f3714e.f3660k;
            i = min;
        }
        width = (width - i2) / 2;
        height = (height - i) / 2;
        RectF rectF = new RectF((float) width, (float) height, (float) (i2 + width), (float) (i + height));
        Matrix matrix = this.f3711b;
        boolean e = this.f3714e.f3657h;
        if (!(this.f3714e.f3659j == 0 || this.f3714e.f3660k == 0)) {
            z = true;
        }
        c1554o.m7150a(matrix, rect, rectF, e, z);
        this.f3714e.f3664o.f3685a.clear();
        this.f3714e.f3664o.m7126a(c1554o);
    }

    private Bitmap m7136b() {
        if (this.f3714e.f3666q == null) {
            return null;
        }
        if (this.f3714e.f3666q.getWidth() > 256) {
            this.f3710a = 256.0f / ((float) this.f3714e.f3666q.getWidth());
        }
        Matrix matrix = new Matrix();
        matrix.setScale(this.f3710a, this.f3710a);
        return Bitmap.createBitmap(this.f3714e.f3666q, 0, 0, this.f3714e.f3666q.getWidth(), this.f3714e.f3666q.getHeight(), matrix, true);
    }

    public void run() {
        this.f3711b = this.f3714e.f3664o.getImageMatrix();
        Bitmap b = m7136b();
        this.f3710a = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / this.f3710a;
        if (b != null && this.f3714e.f3656g) {
            this.f3713d = new FaceDetector(b.getWidth(), b.getHeight(), this.f3712c.length).findFaces(b, this.f3712c);
        }
        if (!(b == null || b == this.f3714e.f3666q)) {
            b.recycle();
        }
        m7137c();
    }

    private void m7137c() {
        this.f3714e.f3658i.post(new C1553n(this));
    }
}
