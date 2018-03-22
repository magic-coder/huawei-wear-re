package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

/* compiled from: VectorDrawableCompat */
class C0014o extends ConstantState {
    int f88a;
    C0013n f89b;
    ColorStateList f90c;
    Mode f91d;
    boolean f92e;
    Bitmap f93f;
    ColorStateList f94g;
    Mode f95h;
    int f96i;
    boolean f97j;
    boolean f98k;
    Paint f99l;

    public C0014o(C0014o c0014o) {
        this.f90c = null;
        this.f91d = VectorDrawableCompat.DEFAULT_TINT_MODE;
        if (c0014o != null) {
            this.f88a = c0014o.f88a;
            this.f89b = new C0013n(c0014o.f89b);
            if (c0014o.f89b.f84m != null) {
                this.f89b.f84m = new Paint(c0014o.f89b.f84m);
            }
            if (c0014o.f89b.f83l != null) {
                this.f89b.f83l = new Paint(c0014o.f89b.f83l);
            }
            this.f90c = c0014o.f90c;
            this.f91d = c0014o.f91d;
            this.f92e = c0014o.f92e;
        }
    }

    public void m59a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        canvas.drawBitmap(this.f93f, null, rect, m57a(colorFilter));
    }

    public boolean m60a() {
        return this.f89b.m52a() < 255;
    }

    public Paint m57a(ColorFilter colorFilter) {
        if (!m60a() && colorFilter == null) {
            return null;
        }
        if (this.f99l == null) {
            this.f99l = new Paint();
            this.f99l.setFilterBitmap(true);
        }
        this.f99l.setAlpha(this.f89b.m52a());
        this.f99l.setColorFilter(colorFilter);
        return this.f99l;
    }

    public void m58a(int i, int i2) {
        this.f93f.eraseColor(0);
        this.f89b.m55a(new Canvas(this.f93f), i, i2, null);
    }

    public void m61b(int i, int i2) {
        if (this.f93f == null || !m64c(i, i2)) {
            this.f93f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
            this.f98k = true;
        }
    }

    public boolean m64c(int i, int i2) {
        if (i == this.f93f.getWidth() && i2 == this.f93f.getHeight()) {
            return true;
        }
        return false;
    }

    public boolean m62b() {
        if (!this.f98k && this.f94g == this.f90c && this.f95h == this.f91d && this.f97j == this.f92e && this.f96i == this.f89b.m52a()) {
            return true;
        }
        return false;
    }

    public void m63c() {
        this.f94g = this.f90c;
        this.f95h = this.f91d;
        this.f96i = this.f89b.m52a();
        this.f97j = this.f92e;
        this.f98k = false;
    }

    public C0014o() {
        this.f90c = null;
        this.f91d = VectorDrawableCompat.DEFAULT_TINT_MODE;
        this.f89b = new C0013n();
    }

    public Drawable newDrawable() {
        return new VectorDrawableCompat();
    }

    public Drawable newDrawable(Resources resources) {
        return new VectorDrawableCompat();
    }

    public int getChangingConfigurations() {
        return this.f88a;
    }
}
