package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.huawei.pluginkidwatch.C1617f;

/* compiled from: HighlightView */
class C1554o {
    View f3716a;
    boolean f3717b;
    boolean f3718c;
    Rect f3719d;
    RectF f3720e;
    Matrix f3721f;
    private C1555p f3722g = C1555p.None;
    private RectF f3723h;
    private boolean f3724i = false;
    private float f3725j;
    private boolean f3726k = false;
    private Drawable f3727l;
    private Drawable f3728m;
    private Drawable f3729n;
    private final Paint f3730o = new Paint();
    private final Paint f3731p = new Paint();
    private final Paint f3732q = new Paint();

    public C1554o(View view) {
        this.f3716a = view;
    }

    private void m7144d() {
        Resources resources = this.f3716a.getResources();
        this.f3727l = resources.getDrawable(C1617f.camera_crop_width);
        this.f3728m = resources.getDrawable(C1617f.camera_crop_height);
        this.f3729n = resources.getDrawable(C1617f.indicator_autocrop);
    }

    public boolean m7153a() {
        return this.f3717b;
    }

    public void m7152a(boolean z) {
        this.f3717b = z;
    }

    public void m7156b(boolean z) {
        this.f3718c = z;
    }

    protected void m7149a(Canvas canvas) {
        if (!this.f3718c) {
            Path path = new Path();
            if (m7153a()) {
                m7139a(canvas, path);
                return;
            }
            this.f3732q.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawRect(this.f3719d, this.f3732q);
        }
    }

    private void m7139a(Canvas canvas, Path path) {
        Rect rect = new Rect();
        this.f3716a.getDrawingRect(rect);
        if (this.f3726k) {
            m7142b(canvas, path, rect);
        } else {
            m7140a(canvas, path, rect);
        }
        canvas.drawPath(path, this.f3732q);
        if (this.f3722g == C1555p.Grow) {
            m7141b(canvas);
        }
    }

    private void m7141b(Canvas canvas) {
        if (this.f3726k) {
            int intrinsicWidth = this.f3729n.getIntrinsicWidth();
            int round = (int) Math.round(Math.cos(0.7853981633974483d) * (((double) this.f3719d.width()) / 2.0d));
            intrinsicWidth = ((this.f3719d.left + (this.f3719d.width() / 2)) + round) - (intrinsicWidth / 2);
            int height = ((this.f3719d.top + (this.f3719d.height() / 2)) - round) - (this.f3729n.getIntrinsicHeight() / 2);
            this.f3729n.setBounds(intrinsicWidth, height, this.f3729n.getIntrinsicWidth() + intrinsicWidth, this.f3729n.getIntrinsicHeight() + height);
            this.f3729n.draw(canvas);
            return;
        }
        intrinsicWidth = this.f3719d.left + 1;
        height = this.f3719d.right + 1;
        round = this.f3719d.top + 4;
        int i = this.f3719d.bottom + 3;
        int intrinsicWidth2 = this.f3727l.getIntrinsicWidth() / 2;
        int intrinsicHeight = this.f3727l.getIntrinsicHeight() / 2;
        int intrinsicHeight2 = this.f3728m.getIntrinsicHeight() / 2;
        int intrinsicWidth3 = this.f3728m.getIntrinsicWidth() / 2;
        int i2 = this.f3719d.left + ((this.f3719d.right - this.f3719d.left) / 2);
        int i3 = this.f3719d.top + ((this.f3719d.bottom - this.f3719d.top) / 2);
        this.f3727l.setBounds(intrinsicWidth - intrinsicWidth2, i3 - intrinsicHeight, intrinsicWidth + intrinsicWidth2, i3 + intrinsicHeight);
        this.f3727l.draw(canvas);
        this.f3727l.setBounds(height - intrinsicWidth2, i3 - intrinsicHeight, height + intrinsicWidth2, i3 + intrinsicHeight);
        this.f3727l.draw(canvas);
        this.f3728m.setBounds(i2 - intrinsicWidth3, round - intrinsicHeight2, i2 + intrinsicWidth3, round + intrinsicHeight2);
        this.f3728m.draw(canvas);
        this.f3728m.setBounds(i2 - intrinsicWidth3, i - intrinsicHeight2, i2 + intrinsicWidth3, i + intrinsicHeight2);
        this.f3728m.draw(canvas);
    }

    private void m7140a(Canvas canvas, Path path, Rect rect) {
        Rect rect2 = new Rect(rect.left, rect.top, rect.right, this.f3719d.top);
        if (rect2.width() > 0 && rect2.height() > 0) {
            canvas.drawRect(rect2, m7153a() ? this.f3730o : this.f3731p);
        }
        Rect rect3 = new Rect(rect.left, this.f3719d.bottom, rect.right, rect.bottom);
        if (rect3.width() > 0 && rect3.height() > 0) {
            canvas.drawRect(rect3, m7153a() ? this.f3730o : this.f3731p);
        }
        Rect rect4 = new Rect(rect.left, rect2.bottom, this.f3719d.left, rect3.top);
        if (rect4.width() > 0 && rect4.height() > 0) {
            canvas.drawRect(rect4, m7153a() ? this.f3730o : this.f3731p);
        }
        rect4 = new Rect(this.f3719d.right, rect2.bottom, rect.right, rect3.top);
        if (rect4.width() > 0 && rect4.height() > 0) {
            canvas.drawRect(rect4, m7153a() ? this.f3730o : this.f3731p);
        }
        path.addRect(new RectF(this.f3719d), Direction.CW);
        this.f3732q.setColor(-30208);
    }

    private void m7142b(Canvas canvas, Path path, Rect rect) {
        canvas.save();
        float width = (float) this.f3719d.width();
        path.addCircle(((float) this.f3719d.left) + (width / 2.0f), (((float) this.f3719d.height()) / 2.0f) + ((float) this.f3719d.top), width / 2.0f, Direction.CW);
        this.f3732q.setColor(-1112874);
        canvas.clipPath(path, Op.DIFFERENCE);
        canvas.drawRect(rect, m7153a() ? this.f3730o : this.f3731p);
        canvas.restore();
    }

    public void m7151a(C1555p c1555p) {
        if (c1555p != this.f3722g) {
            this.f3722g = c1555p;
            this.f3716a.invalidate();
        }
    }

    public int m7147a(float f, float f2) {
        Rect e = m7145e();
        if (this.f3726k) {
            float centerX = f - ((float) e.centerX());
            float centerY = f2 - ((float) e.centerY());
            int sqrt = (int) Math.sqrt((double) ((centerX * centerX) + (centerY * centerY)));
            int width = this.f3719d.width() / 2;
            if (((float) Math.abs(sqrt - width)) <= 20.0f) {
                return m7143d(centerX, centerY);
            }
            if (sqrt < width) {
                return 32;
            }
            return 1;
        }
        boolean z;
        boolean z2 = f2 >= ((float) e.top) - 20.0f && f2 < ((float) e.bottom) + 20.0f;
        if (f < ((float) e.left) - 20.0f || f >= ((float) e.right) + 20.0f) {
            z = false;
        } else {
            z = true;
        }
        int a = m7138a(f, f2, e, 20.0f, 1, z2, z);
        if (a == 1 && e.contains((int) f, (int) f2)) {
            return 32;
        }
        return a;
    }

    private int m7138a(float f, float f2, Rect rect, float f3, int i, boolean z, boolean z2) {
        if (Math.abs(((float) rect.left) - f) < f3 && z) {
            i |= 2;
        }
        if (Math.abs(((float) rect.right) - f) < f3 && z) {
            i |= 4;
        }
        if (Math.abs(((float) rect.top) - f2) < f3 && z2) {
            i |= 8;
        }
        if (Math.abs(((float) rect.bottom) - f2) >= f3 || !z2) {
            return i;
        }
        return i | 16;
    }

    private int m7143d(float f, float f2) {
        if (Math.abs(f2) > Math.abs(f)) {
            if (f2 < 0.0f) {
                return 8;
            }
            return 16;
        } else if (f < 0.0f) {
            return 2;
        } else {
            return 4;
        }
    }

    void m7148a(int i, float f, float f2) {
        Rect e = m7145e();
        if (i != 1) {
            if (i == 32) {
                m7155b((this.f3720e.width() / ((float) e.width())) * f, (this.f3720e.height() / ((float) e.height())) * f2);
                return;
            }
            if ((i & 6) == 0) {
                f = 0.0f;
            }
            if ((i & 24) == 0) {
                f2 = 0.0f;
            }
            m7158c((f * (this.f3720e.width() / ((float) e.width()))) * ((float) ((i & 2) != 0 ? -1 : 1)), ((float) ((i & 8) != 0 ? -1 : 1)) * (f2 * (this.f3720e.height() / ((float) e.height()))));
        }
    }

    void m7155b(float f, float f2) {
        Rect rect = new Rect(this.f3719d);
        this.f3720e.offset(f, f2);
        this.f3720e.offset(Math.max(0.0f, this.f3723h.left - this.f3720e.left), Math.max(0.0f, this.f3723h.top - this.f3720e.top));
        this.f3720e.offset(Math.min(0.0f, this.f3723h.right - this.f3720e.right), Math.min(0.0f, this.f3723h.bottom - this.f3720e.bottom));
        this.f3719d = m7145e();
        rect.union(this.f3719d);
        rect.inset(-10, -10);
        this.f3716a.invalidate(rect);
    }

    void m7158c(float f, float f2) {
        if (this.f3724i) {
            if (f != 0.0f) {
                f2 = f / this.f3725j;
            } else if (f2 != 0.0f) {
                f = f2 * this.f3725j;
            }
        }
        this.f3720e.set(m7146e(f, f2));
        this.f3719d = m7145e();
        this.f3716a.invalidate();
    }

    @NonNull
    private RectF m7146e(float f, float f2) {
        float f3;
        float f4;
        RectF rectF = new RectF(this.f3720e);
        if (f > 0.0f && rectF.width() + (2.0f * f) > this.f3723h.width()) {
            f = (this.f3723h.width() - rectF.width()) / 2.0f;
            if (this.f3724i) {
                f3 = f / this.f3725j;
                f4 = f;
                if (f3 > 0.0f && rectF.height() + (2.0f * f3) > this.f3723h.height()) {
                    f3 = (this.f3723h.height() - rectF.height()) / 2.0f;
                    if (this.f3724i) {
                        f4 = this.f3725j * f3;
                    }
                }
                rectF.inset(-f4, -f3);
                if (rectF.width() < 25.0f) {
                    rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
                }
                f3 = this.f3724i ? 25.0f / this.f3725j : 25.0f;
                if (rectF.height() < f3) {
                    rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
                }
                if (rectF.left < this.f3723h.left) {
                    rectF.offset(this.f3723h.left - rectF.left, 0.0f);
                } else if (rectF.right > this.f3723h.right) {
                    rectF.offset(-(rectF.right - this.f3723h.right), 0.0f);
                }
                if (rectF.top < this.f3723h.top) {
                    rectF.offset(0.0f, this.f3723h.top - rectF.top);
                } else if (rectF.bottom > this.f3723h.bottom) {
                    rectF.offset(0.0f, -(rectF.bottom - this.f3723h.bottom));
                }
                return rectF;
            }
        }
        f3 = f2;
        f4 = f;
        f3 = (this.f3723h.height() - rectF.height()) / 2.0f;
        if (this.f3724i) {
            f4 = this.f3725j * f3;
        }
        rectF.inset(-f4, -f3);
        if (rectF.width() < 25.0f) {
            rectF.inset((-(25.0f - rectF.width())) / 2.0f, 0.0f);
        }
        if (this.f3724i) {
        }
        if (rectF.height() < f3) {
            rectF.inset(0.0f, (-(f3 - rectF.height())) / 2.0f);
        }
        if (rectF.left < this.f3723h.left) {
            rectF.offset(this.f3723h.left - rectF.left, 0.0f);
        } else if (rectF.right > this.f3723h.right) {
            rectF.offset(-(rectF.right - this.f3723h.right), 0.0f);
        }
        if (rectF.top < this.f3723h.top) {
            rectF.offset(0.0f, this.f3723h.top - rectF.top);
        } else if (rectF.bottom > this.f3723h.bottom) {
            rectF.offset(0.0f, -(rectF.bottom - this.f3723h.bottom));
        }
        return rectF;
    }

    public Rect m7154b() {
        return new Rect((int) this.f3720e.left, (int) this.f3720e.top, (int) this.f3720e.right, (int) this.f3720e.bottom);
    }

    private Rect m7145e() {
        RectF rectF = new RectF(this.f3720e.left, this.f3720e.top, this.f3720e.right, this.f3720e.bottom);
        this.f3721f.mapRect(rectF);
        return new Rect(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public void m7157c() {
        this.f3719d = m7145e();
    }

    public void m7150a(Matrix matrix, Rect rect, RectF rectF, boolean z, boolean z2) {
        if (z) {
            z2 = true;
        }
        this.f3721f = new Matrix(matrix);
        this.f3720e = rectF;
        this.f3723h = new RectF(rect);
        this.f3724i = z2;
        this.f3726k = z;
        this.f3725j = this.f3720e.width() / this.f3720e.height();
        this.f3719d = m7145e();
        this.f3730o.setARGB(125, 50, 50, 50);
        this.f3731p.setARGB(125, 50, 50, 50);
        this.f3732q.setStrokeWidth(3.0f);
        this.f3732q.setStyle(Style.STROKE);
        this.f3732q.setAntiAlias(true);
        this.f3722g = C1555p.None;
        m7144d();
    }
}
