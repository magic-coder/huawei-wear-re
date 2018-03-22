package com.huawei.pluginkidwatch.common.ui.circleimageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.huawei.pluginkidwatch.n;

public class CircleImageView extends ImageView {
    private static final ScaleType f3569a = ScaleType.CENTER_CROP;
    private static final Config f3570b = Config.ARGB_8888;
    private final RectF f3571c;
    private final RectF f3572d;
    private final Matrix f3573e;
    private final Paint f3574f;
    private final Paint f3575g;
    private int f3576h;
    private int f3577i;
    private Bitmap f3578j;
    private BitmapShader f3579k;
    private int f3580l;
    private int f3581m;
    private float f3582n;
    private float f3583o;
    private boolean f3584p;
    private boolean f3585q;

    public CircleImageView(Context context) {
        super(context);
        this.f3571c = new RectF();
        this.f3572d = new RectF();
        this.f3573e = new Matrix();
        this.f3574f = new Paint();
        this.f3575g = new Paint();
        this.f3576h = ViewCompat.MEASURED_STATE_MASK;
        this.f3577i = 0;
    }

    public CircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3571c = new RectF();
        this.f3572d = new RectF();
        this.f3573e = new Matrix();
        this.f3574f = new Paint();
        this.f3575g = new Paint();
        this.f3576h = ViewCompat.MEASURED_STATE_MASK;
        this.f3577i = 0;
        super.setScaleType(f3569a);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.CircleImageView, i, 0);
        this.f3577i = obtainStyledAttributes.getDimensionPixelSize(n.CircleImageView_border_width, 0);
        this.f3576h = obtainStyledAttributes.getColor(n.CircleImageView_border_color, ViewCompat.MEASURED_STATE_MASK);
        obtainStyledAttributes.recycle();
        this.f3584p = true;
        if (this.f3585q) {
            m7016a();
            this.f3585q = false;
        }
    }

    public ScaleType getScaleType() {
        return f3569a;
    }

    public void setScaleType(ScaleType scaleType) {
        if (scaleType != f3569a) {
            throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[]{scaleType}));
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getDrawable() != null) {
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f3582n, this.f3574f);
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, this.f3583o, this.f3575g);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m7016a();
    }

    public int getBorderColor() {
        return this.f3576h;
    }

    public void setBorderColor(int i) {
        if (i != this.f3576h) {
            this.f3576h = i;
            this.f3575g.setColor(this.f3576h);
            invalidate();
        }
    }

    public int getBorderWidth() {
        return this.f3577i;
    }

    public void setBorderWidth(int i) {
        if (i != this.f3577i) {
            this.f3577i = i;
            m7016a();
        }
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f3578j = bitmap;
        m7016a();
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        this.f3578j = m7015a(drawable);
        m7016a();
    }

    public void setImageResource(int i) {
        super.setImageResource(i);
        this.f3578j = m7015a(getDrawable());
        m7016a();
    }

    private Bitmap m7015a(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        try {
            Bitmap createBitmap;
            if (drawable instanceof ColorDrawable) {
                createBitmap = Bitmap.createBitmap(1, 1, f3570b);
            } else {
                createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), f3570b);
            }
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            return null;
        }
    }

    private void m7016a() {
        if (!this.f3584p) {
            this.f3585q = true;
        } else if (this.f3578j != null) {
            this.f3579k = new BitmapShader(this.f3578j, TileMode.CLAMP, TileMode.CLAMP);
            this.f3574f.setAntiAlias(true);
            this.f3574f.setShader(this.f3579k);
            this.f3575g.setStyle(Style.STROKE);
            this.f3575g.setAntiAlias(true);
            this.f3575g.setColor(this.f3576h);
            this.f3575g.setStrokeWidth((float) this.f3577i);
            this.f3581m = this.f3578j.getHeight();
            this.f3580l = this.f3578j.getWidth();
            this.f3572d.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.f3583o = Math.min((this.f3572d.height() - ((float) this.f3577i)) / 2.0f, (this.f3572d.width() - ((float) this.f3577i)) / 2.0f);
            this.f3571c.set((float) this.f3577i, (float) this.f3577i, this.f3572d.width() - ((float) this.f3577i), this.f3572d.height() - ((float) this.f3577i));
            this.f3582n = Math.min(this.f3571c.height() / 2.0f, this.f3571c.width() / 2.0f);
            m7017b();
            invalidate();
        }
    }

    private void m7017b() {
        float height;
        float width;
        float f = 0.0f;
        this.f3573e.set(null);
        if (((float) this.f3580l) * this.f3571c.height() > this.f3571c.width() * ((float) this.f3581m)) {
            height = this.f3571c.height() / ((float) this.f3581m);
            width = (this.f3571c.width() - (((float) this.f3580l) * height)) * 0.5f;
        } else {
            height = this.f3571c.width() / ((float) this.f3580l);
            width = 0.0f;
            f = (this.f3571c.height() - (((float) this.f3581m) * height)) * 0.5f;
        }
        this.f3573e.setScale(height, height);
        this.f3573e.postTranslate((float) (((int) (width + 0.5f)) + this.f3577i), (float) (((int) (f + 0.5f)) + this.f3577i));
        this.f3579k.setLocalMatrix(this.f3573e);
    }
}
