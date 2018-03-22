package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: ProGuard */
public class C6260m extends ImageView {
    final String f21770a = "TouchView";
    public boolean f21771b = false;
    private Matrix f21772c = new Matrix();
    private Matrix f21773d = new Matrix();
    private int f21774e = 0;
    private float f21775f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f21776g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private Bitmap f21777h;
    private boolean f21778i = false;
    private float f21779j;
    private float f21780k;
    private PointF f21781l = new PointF();
    private PointF f21782m = new PointF();
    private float f21783n = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f21784o = 0.0f;
    private Rect f21785p = new Rect();

    public C6260m(Context context) {
        super(context);
        getDrawingRect(this.f21785p);
        m28770a();
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        this.f21777h = bitmap;
        if (bitmap != null) {
            this.f21777h = bitmap;
        }
    }

    private float m28769a(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() < 2) {
            return 0.0f;
        }
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return FloatMath.sqrt((x * x) + (y * y));
    }

    private void m28770a() {
    }

    public void m28776a(Rect rect) {
        this.f21785p = rect;
        if (this.f21777h != null) {
            m28775c();
        }
    }

    private void m28771a(PointF pointF) {
        float f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        if (this.f21777h != null) {
            float[] fArr = new float[9];
            this.f21772c.getValues(fArr);
            float f2 = fArr[2];
            float f3 = fArr[5];
            float f4 = fArr[0];
            float width = ((float) this.f21777h.getWidth()) * f4;
            float height = ((float) this.f21777h.getHeight()) * f4;
            f4 = ((float) this.f21785p.left) - f2;
            if (f4 <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                f4 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            }
            f2 = (f2 + width) - ((float) this.f21785p.right);
            if (f2 <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            }
            width = ((f4 * ((float) this.f21785p.width())) / (f2 + f4)) + ((float) this.f21785p.left);
            f2 = ((float) this.f21785p.top) - f3;
            f4 = (f3 + height) - ((float) this.f21785p.bottom);
            if (f2 <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                f2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
            }
            if (f4 > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                f = f4;
            }
            pointF.set(width, ((((float) this.f21785p.height()) * f2) / (f2 + f)) + ((float) this.f21785p.top));
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f21778i) {
            switch (motionEvent.getAction() & 255) {
                case 0:
                    this.f21772c.set(getImageMatrix());
                    this.f21773d.set(this.f21772c);
                    this.f21781l.set(motionEvent.getX(), motionEvent.getY());
                    this.f21774e = 1;
                    break;
                case 1:
                case 6:
                    m28774b();
                    this.f21774e = 0;
                    break;
                case 2:
                    if (this.f21774e != 1) {
                        if (this.f21774e == 2) {
                            this.f21772c.set(this.f21772c);
                            float a = m28769a(motionEvent);
                            if (a > 10.0f) {
                                this.f21772c.set(this.f21773d);
                                a /= this.f21783n;
                                this.f21772c.postScale(a, a, this.f21782m.x, this.f21782m.y);
                            }
                            setImageMatrix(this.f21772c);
                            break;
                        }
                    }
                    this.f21772c.set(this.f21773d);
                    this.f21772c.postTranslate(motionEvent.getX() - this.f21781l.x, motionEvent.getY() - this.f21781l.y);
                    setImageMatrix(this.f21772c);
                    break;
                    break;
                case 5:
                    this.f21783n = m28769a(motionEvent);
                    if (this.f21783n > 10.0f) {
                        this.f21773d.set(this.f21772c);
                        m28771a(this.f21782m);
                        this.f21774e = 2;
                        break;
                    }
                    break;
            }
            this.f21771b = true;
        }
        return true;
    }

    private void m28774b() {
        if (this.f21777h != null) {
            float width = (float) this.f21785p.width();
            float height = (float) this.f21785p.height();
            float[] fArr = new float[9];
            this.f21772c.getValues(fArr);
            float f = fArr[2];
            float f2 = fArr[5];
            float f3 = fArr[0];
            Animation animation = null;
            if (f3 > this.f21775f) {
                this.f21784o = this.f21775f / f3;
                this.f21772c.postScale(this.f21784o, this.f21784o, this.f21782m.x, this.f21782m.y);
                setImageMatrix(this.f21772c);
                animation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / this.f21784o, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT / this.f21784o, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f21782m.x, this.f21782m.y);
            } else if (f3 < this.f21776g) {
                this.f21784o = this.f21776g / f3;
                this.f21772c.postScale(this.f21784o, this.f21784o, this.f21782m.x, this.f21782m.y);
                animation = new ScaleAnimation(DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f21784o, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT, this.f21784o, this.f21782m.x, this.f21782m.y);
            } else {
                Object obj = null;
                float width2 = ((float) this.f21777h.getWidth()) * f3;
                f3 *= (float) this.f21777h.getHeight();
                float f4 = ((float) this.f21785p.left) - f;
                float f5 = ((float) this.f21785p.top) - f2;
                if (f4 < 0.0f) {
                    f = (float) this.f21785p.left;
                    obj = 1;
                }
                if (f5 < 0.0f) {
                    f2 = (float) this.f21785p.top;
                    obj = 1;
                }
                f5 = f3 - f5;
                if (width2 - f4 < width) {
                    f = ((float) this.f21785p.left) - (width2 - width);
                    obj = 1;
                }
                if (f5 < height) {
                    f2 = ((float) this.f21785p.top) - (f3 - height);
                    obj = 1;
                }
                if (obj != null) {
                    float f6 = fArr[2] - f;
                    width = fArr[5] - f2;
                    fArr[2] = f;
                    fArr[5] = f2;
                    this.f21772c.setValues(fArr);
                    setImageMatrix(this.f21772c);
                    animation = new TranslateAnimation(f6, 0.0f, width, 0.0f);
                } else {
                    setImageMatrix(this.f21772c);
                }
            }
            if (animation != null) {
                this.f21778i = true;
                animation.setDuration(300);
                startAnimation(animation);
                new Thread(new C6261n(this)).start();
            }
        }
    }

    private void m28775c() {
        if (this.f21777h != null) {
            float[] fArr = new float[9];
            this.f21772c.getValues(fArr);
            float max = Math.max(((float) this.f21785p.width()) / ((float) this.f21777h.getWidth()), ((float) this.f21785p.height()) / ((float) this.f21777h.getHeight()));
            this.f21779j = ((float) this.f21785p.left) - (((((float) this.f21777h.getWidth()) * max) - ((float) this.f21785p.width())) / 2.0f);
            this.f21780k = ((float) this.f21785p.top) - (((((float) this.f21777h.getHeight()) * max) - ((float) this.f21785p.height())) / 2.0f);
            fArr[2] = this.f21779j;
            fArr[5] = this.f21780k;
            fArr[4] = max;
            fArr[0] = max;
            this.f21772c.setValues(fArr);
            this.f21775f = Math.min(2048.0f / ((float) this.f21777h.getWidth()), 2048.0f / ((float) this.f21777h.getHeight()));
            this.f21776g = max;
            if (this.f21775f < this.f21776g) {
                this.f21775f = this.f21776g;
            }
            setImageMatrix(this.f21772c);
        }
    }
}
