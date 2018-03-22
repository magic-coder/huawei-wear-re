package com.huawei.nfc.carrera.ui.swipe.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.wallet.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WaveView extends View {
    private int f19426i;
    private List<Circle> mCircleList;
    private Context mContext;
    private Runnable mCreateCircle;
    private long mDuration;
    private float mInitialRadius;
    private Interpolator mInterpolator;
    private boolean mIsRunning;
    private long mLastCreateTime;
    private float mMaxRadius;
    private float mMaxRadiusRate;
    private boolean mMaxRadiusSet;
    private Paint mPaint;
    private int mSpeed;

    class C56751 implements Runnable {
        C56751() {
        }

        public void run() {
            if (!WaveView.this.mIsRunning) {
                return;
            }
            if (WaveView.this.f19426i < 1) {
                WaveView.this.f19426i = WaveView.this.f19426i + 1;
                WaveView.this.newCircle();
                WaveView.this.postDelayed(WaveView.this.mCreateCircle, (long) WaveView.this.mSpeed);
                return;
            }
            WaveView.this.f19426i = 0;
            WaveView.this.stop();
        }
    }

    class Circle {
        private long mCreateTime = System.currentTimeMillis();

        public float getAlpha() {
            return ((DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - WaveView.this.mInterpolator.getInterpolation((((float) (System.currentTimeMillis() - this.mCreateTime)) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) WaveView.this.mDuration))) * 255.0f) * 0.75f;
        }

        public float getCurrentRadius() {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - this.mCreateTime)) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) WaveView.this.mDuration);
            return (WaveView.this.mInterpolator.getInterpolation(currentTimeMillis) * (WaveView.this.mMaxRadius - WaveView.this.mInitialRadius)) + WaveView.this.mInitialRadius;
        }
    }

    public WaveView(Context context) {
        this(context, null);
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMaxRadiusRate = 0.35f;
        this.mDuration = 1;
        this.mSpeed = 100;
        this.mInterpolator = new LinearInterpolator();
        this.mCircleList = new ArrayList();
        this.f19426i = 0;
        this.mCreateCircle = new C56751();
        this.mContext = context;
        this.mPaint = new Paint(1);
        setStyleConstructor(Style.FILL);
    }

    private void setStyleConstructor(Style style) {
        setStyle(style);
    }

    public void setStyle(Style style) {
        this.mPaint.setStyle(style);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        if (!this.mMaxRadiusSet) {
            this.mMaxRadius = (((float) Math.min(i, i2)) * this.mMaxRadiusRate) / 2.0f;
        }
    }

    public void setMaxRadiusRate(float f) {
        this.mMaxRadiusRate = f;
    }

    public void setColor(int i) {
        this.mPaint.setColor(i);
    }

    public void start() {
        if (!this.mIsRunning) {
            this.mIsRunning = true;
            this.mCreateCircle.run();
        }
    }

    public void stop() {
        this.mIsRunning = false;
    }

    protected void onDraw(Canvas canvas) {
        Iterator it = this.mCircleList.iterator();
        while (it.hasNext()) {
            Circle circle = (Circle) it.next();
            if (System.currentTimeMillis() - circle.mCreateTime <= this.mDuration) {
                int dimension = (int) this.mContext.getResources().getDimension(R.dimen.nfc_waiting_circle_top);
                this.mPaint.setAlpha((int) circle.getAlpha());
                canvas.drawCircle(((float) getWidth()) / 2.0f, (float) dimension, circle.getCurrentRadius(), this.mPaint);
            } else {
                it.remove();
            }
        }
        if (this.mCircleList.size() > 0) {
            postInvalidateDelayed(3);
        }
    }

    public void setInitialRadius(float f) {
        this.mInitialRadius = f;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }

    public void setMaxRadius(float f) {
        this.mMaxRadius = f;
        this.mMaxRadiusSet = true;
    }

    public void setSpeed(int i) {
        this.mSpeed = i;
    }

    private void newCircle() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.mLastCreateTime >= ((long) this.mSpeed)) {
            this.mCircleList.add(new Circle());
            invalidate();
            this.mLastCreateTime = currentTimeMillis;
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
        if (this.mInterpolator == null) {
            this.mInterpolator = new AccelerateDecelerateInterpolator();
        }
    }
}
