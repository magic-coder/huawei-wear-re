package android.support.graphics.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Region.Op;
import android.support.v4.util.ArrayMap;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: VectorDrawableCompat */
class C0013n {
    private static final Matrix f72j = new Matrix();
    float f73a;
    float f74b;
    float f75c;
    float f76d;
    int f77e;
    String f78f;
    final ArrayMap<String, Object> f79g;
    private final Path f80h;
    private final Path f81i;
    private final Matrix f82k;
    private Paint f83l;
    private Paint f84m;
    private PathMeasure f85n;
    private int f86o;
    private final C0012l f87p;

    public C0013n() {
        this.f82k = new Matrix();
        this.f73a = 0.0f;
        this.f74b = 0.0f;
        this.f75c = 0.0f;
        this.f76d = 0.0f;
        this.f77e = 255;
        this.f78f = null;
        this.f79g = new ArrayMap();
        this.f87p = new C0012l();
        this.f80h = new Path();
        this.f81i = new Path();
    }

    public void m54a(int i) {
        this.f77e = i;
    }

    public int m52a() {
        return this.f77e;
    }

    public void m53a(float f) {
        m54a((int) (255.0f * f));
    }

    public float m56b() {
        return ((float) m52a()) / 255.0f;
    }

    public C0013n(C0013n c0013n) {
        this.f82k = new Matrix();
        this.f73a = 0.0f;
        this.f74b = 0.0f;
        this.f75c = 0.0f;
        this.f76d = 0.0f;
        this.f77e = 255;
        this.f78f = null;
        this.f79g = new ArrayMap();
        this.f87p = new C0012l(c0013n.f87p, this.f79g);
        this.f80h = new Path(c0013n.f80h);
        this.f81i = new Path(c0013n.f81i);
        this.f73a = c0013n.f73a;
        this.f74b = c0013n.f74b;
        this.f75c = c0013n.f75c;
        this.f76d = c0013n.f76d;
        this.f86o = c0013n.f86o;
        this.f77e = c0013n.f77e;
        this.f78f = c0013n.f78f;
        if (c0013n.f78f != null) {
            this.f79g.put(c0013n.f78f, this);
        }
    }

    private void m47a(C0012l c0012l, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        c0012l.f60b.set(matrix);
        c0012l.f60b.preConcat(c0012l.f68j);
        for (int i3 = 0; i3 < c0012l.f59a.size(); i3++) {
            Object obj = c0012l.f59a.get(i3);
            if (obj instanceof C0012l) {
                m47a((C0012l) obj, c0012l.f60b, canvas, i, i2, colorFilter);
            } else if (obj instanceof C0009m) {
                m48a(c0012l, (C0009m) obj, canvas, i, i2, colorFilter);
            }
        }
    }

    public void m55a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        m47a(this.f87p, f72j, canvas, i, i2, colorFilter);
    }

    private void m48a(C0012l c0012l, C0009m c0009m, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
        float f = ((float) i) / this.f75c;
        float f2 = ((float) i2) / this.f76d;
        float min = Math.min(f, f2);
        Matrix c = c0012l.f60b;
        this.f82k.set(c);
        this.f82k.postScale(f, f2);
        f = m44a(c);
        if (f != 0.0f) {
            c0009m.m24a(this.f80h);
            Path path = this.f80h;
            this.f81i.reset();
            if (c0009m.mo22a()) {
                this.f81i.addPath(path, this.f82k);
                canvas.clipPath(this.f81i, Op.REPLACE);
                return;
            }
            Paint paint;
            C0011k c0011k = (C0011k) c0009m;
            if (!(c0011k.f52g == 0.0f && c0011k.f53h == DefaultRetryPolicy.DEFAULT_BACKOFF_MULT)) {
                float f3 = (c0011k.f52g + c0011k.f54i) % DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                float f4 = (c0011k.f53h + c0011k.f54i) % DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
                if (this.f85n == null) {
                    this.f85n = new PathMeasure();
                }
                this.f85n.setPath(this.f80h, false);
                float length = this.f85n.getLength();
                f3 *= length;
                f4 *= length;
                path.reset();
                if (f3 > f4) {
                    this.f85n.getSegment(f3, length, path, true);
                    this.f85n.getSegment(0.0f, f4, path, true);
                } else {
                    this.f85n.getSegment(f3, f4, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f81i.addPath(path, this.f82k);
            if (c0011k.f48c != 0) {
                if (this.f84m == null) {
                    this.f84m = new Paint();
                    this.f84m.setStyle(Style.FILL);
                    this.f84m.setAntiAlias(true);
                }
                paint = this.f84m;
                paint.setColor(VectorDrawableCompat.applyAlpha(c0011k.f48c, c0011k.f51f));
                paint.setColorFilter(colorFilter);
                canvas.drawPath(this.f81i, paint);
            }
            if (c0011k.f46a != 0) {
                if (this.f83l == null) {
                    this.f83l = new Paint();
                    this.f83l.setStyle(Style.STROKE);
                    this.f83l.setAntiAlias(true);
                }
                paint = this.f83l;
                if (c0011k.f56k != null) {
                    paint.setStrokeJoin(c0011k.f56k);
                }
                if (c0011k.f55j != null) {
                    paint.setStrokeCap(c0011k.f55j);
                }
                paint.setStrokeMiter(c0011k.f57l);
                paint.setColor(VectorDrawableCompat.applyAlpha(c0011k.f46a, c0011k.f49d));
                paint.setColorFilter(colorFilter);
                paint.setStrokeWidth((f * min) * c0011k.f47b);
                canvas.drawPath(this.f81i, paint);
            }
        }
    }

    private static float m43a(float f, float f2, float f3, float f4) {
        return (f * f4) - (f2 * f3);
    }

    private float m44a(Matrix matrix) {
        float[] fArr = new float[]{0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, 0.0f};
        matrix.mapVectors(fArr);
        float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
        float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
        float a = C0013n.m43a(fArr[0], fArr[1], fArr[2], fArr[3]);
        hypot = Math.max(hypot, hypot2);
        if (hypot > 0.0f) {
            return Math.abs(a) / hypot;
        }
        return 0.0f;
    }
}
