package com.google.zxing.client.android.p292e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.android.volley.DefaultRetryPolicy;

/* compiled from: ScanFrameView */
public class C3802a extends ImageView {
    private Drawable f14784a;
    private Drawable f14785b;
    private int f14786c;
    private int f14787d;
    private int f14788e;
    private float f14789f;
    private float f14790g;
    private Rect f14791h;
    private Rect f14792i;
    private AnimatorSet f14793j;
    private ValueAnimator f14794k;
    private ValueAnimator f14795l;
    private boolean f14796m;
    private boolean f14797n;
    private long f14798o;
    private long f14799p;
    private long f14800q;
    private AnimatorUpdateListener f14801r;
    private AnimatorUpdateListener f14802s;

    public void m19043a(int i, int i2) {
        this.f14788e = i;
        this.f14787d = i2;
        m19041c();
    }

    private void m19041c() {
        this.f14793j = new AnimatorSet();
        this.f14794k = ValueAnimator.ofFloat(new float[]{0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        this.f14798o = 2500;
        this.f14799p = (long) (((float) (((long) this.f14787d) * 2500)) / ((float) (this.f14787d + this.f14786c)));
        this.f14800q = this.f14798o + this.f14799p;
        this.f14794k.setDuration(this.f14800q);
        this.f14794k.setRepeatMode(1);
        this.f14794k.setRepeatCount(-1);
        this.f14794k.addUpdateListener(this.f14801r);
        this.f14795l = ValueAnimator.ofFloat(new float[]{0.0f, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        this.f14795l.setDuration(this.f14800q);
        this.f14795l.setRepeatMode(1);
        this.f14795l.setRepeatCount(-1);
        this.f14795l.addUpdateListener(this.f14802s);
        this.f14795l.setStartDelay((long) ((((float) (this.f14787d + (this.f14786c / 2))) / ((float) (this.f14787d + this.f14786c))) * 2500.0f));
        this.f14793j.setStartDelay(250);
        this.f14793j.playTogether(new Animator[]{this.f14794k, this.f14795l});
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.f14792i.set(0, 0, this.f14788e, this.f14787d);
        canvas.clipRect(this.f14792i);
        if (this.f14796m) {
            this.f14784a.setBounds(m19040a(this.f14789f));
            this.f14784a.draw(canvas);
        }
        if (this.f14797n) {
            this.f14785b.setBounds(m19040a(this.f14790g));
            this.f14785b.draw(canvas);
        }
        canvas.restore();
    }

    private Rect m19040a(float f) {
        int i = (int) (((float) (-this.f14786c)) + (((float) (this.f14787d + this.f14786c)) * f));
        int i2 = this.f14788e + 0;
        this.f14791h.set(0, i, i2, this.f14786c + i);
        return this.f14791h;
    }

    public void m19042a() {
        this.f14789f = 0.0f;
        this.f14790g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        this.f14796m = false;
        this.f14797n = false;
        if (this.f14793j != null) {
            this.f14793j.cancel();
        }
        if (this.f14795l != null) {
            this.f14795l.cancel();
        }
        if (this.f14794k != null) {
            this.f14794k.cancel();
        }
        if (this.f14795l != null) {
            this.f14795l.end();
        }
    }

    public void m19044b() {
        this.f14796m = true;
        this.f14797n = true;
        this.f14789f = 0.0f;
        this.f14790g = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        if (this.f14793j != null) {
            this.f14793j.cancel();
        }
        if (this.f14793j != null) {
            this.f14793j.start();
        }
    }
}
