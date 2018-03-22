package com.huawei.wallet.ui.carddisplay;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.android.volley.DefaultRetryPolicy;

public final class AnimUtil {
    private static int f21346a = 0;

    final class C61521 implements AnimatorUpdateListener {
        final /* synthetic */ View f21342a;
        final /* synthetic */ int f21343b;
        final /* synthetic */ int f21344c;

        C61521(View view, int i, int i2) {
            this.f21342a = view;
            this.f21343b = i;
            this.f21344c = i2;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            LayoutParams layoutParams = this.f21342a.getLayoutParams();
            layoutParams.height = intValue;
            this.f21342a.setLayoutParams(layoutParams);
            if (this.f21343b > this.f21344c) {
                this.f21342a.setAlpha((((float) intValue) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) this.f21343b));
            } else {
                this.f21342a.setAlpha((((float) intValue) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) this.f21344c));
            }
        }
    }

    final class C61532 extends AnimatorListenerAdapter {
        final /* synthetic */ View f21345a;

        C61532(View view) {
            this.f21345a = view;
        }

        public void onAnimationEnd(Animator animator) {
            this.f21345a.setVisibility(8);
            super.onAnimationEnd(animator);
        }
    }

    public static void m28156a(int i) {
        f21346a = i;
    }

    public static ObjectAnimator m28152a(View view, int i, int i2, float f, int i3, int i4, float f2) {
        if (i == i2) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), 0.0f});
            return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat}).setDuration(500);
        }
        float f3;
        int abs = Math.abs((i3 - 1) - (i > i2 ? i : i + 1));
        if (abs == 0) {
            f3 = (((float) i4) - (20.0f * f)) + f2;
        } else {
            f3 = ((((float) i4) - (20.0f * f)) - (((float) (abs * 6)) * f)) + f2;
        }
        if (((float) f21346a) < f3) {
            f21346a = (int) f3;
        }
        int i5 = 500 - (i * 40);
        if (i5 < 0) {
            i5 = 500;
        }
        ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), f3});
        float abs2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((((float) Math.abs(abs)) * (4.0f * f)) / ((float) view.getWidth()));
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{view.getScaleX(), abs2});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat2, ofFloat}).setDuration((long) i5);
    }

    public static ObjectAnimator m28160b(View view, int i, int i2, float f, int i3, int i4, float f2) {
        if (i <= i2) {
            PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), 0.0f});
            return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat}).setDuration(500);
        }
        float f3;
        int abs = Math.abs((i3 - 1) - i);
        if (abs == 0) {
            f3 = (((float) i4) - (20.0f * f)) + f2;
        } else {
            f3 = ((((float) i4) - (20.0f * f)) - (((float) (abs * 6)) * f)) + f2;
        }
        if (((float) f21346a) < f3) {
            f21346a = (int) f3;
        }
        int i5 = 500 - (i * 40);
        if (i5 < 0) {
            i5 = 500;
        }
        ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), f3});
        float abs2 = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT - ((((float) Math.abs(abs)) * (4.0f * f)) / ((float) view.getWidth()));
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{view.getScaleX(), abs2});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat2, ofFloat}).setDuration((long) i5);
    }

    public static ObjectAnimator m28153a(View view, int i, int i2, int i3, float f) {
        float f2 = f * ((float) i);
        if (((float) f21346a) < f2) {
            f21346a = (int) f2;
        }
        int i4 = 500 - (i * 40);
        if (i4 < 0) {
            i4 = 500;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), f2});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{view.getScaleX(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", new float[]{view.getScaleY(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("alpha", new float[]{view.getAlpha(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4}).setDuration((long) i4);
    }

    public static ObjectAnimator m28154a(View view, int i, int i2, int i3, float f, float f2) {
        float f3 = f2 + (((float) i) * f);
        if (((float) f21346a) < f3) {
            f21346a = (int) f3;
        }
        int i4 = 500 - ((i2 - i) * 40);
        if (i4 < 0) {
            i4 = 500;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), f3});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{view.getScaleX(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", new float[]{view.getScaleY(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("alpha", new float[]{view.getAlpha(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4}).setDuration((long) i4);
    }

    public static ObjectAnimator m28150a(View view, int i, float f) {
        return m28148a(view, view.getY(), ((float) i) * f, 50);
    }

    public static ObjectAnimator m28148a(View view, float f, float f2, int i) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{f, f2});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{view.getScaleX(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", new float[]{view.getScaleY(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("alpha", new float[]{view.getAlpha(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4}).setDuration((long) i);
    }

    public static ObjectAnimator m28151a(View view, int i, int i2, float f) {
        float f2 = ((float) i2) * f;
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{(float) i, f2});
        PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("scaleX", new float[]{view.getScaleX(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat3 = PropertyValuesHolder.ofFloat("scaleY", new float[]{view.getScaleY(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        PropertyValuesHolder ofFloat4 = PropertyValuesHolder.ofFloat("alpha", new float[]{view.getAlpha(), DefaultRetryPolicy.DEFAULT_BACKOFF_MULT});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat, ofFloat2, ofFloat3, ofFloat4}).setDuration((long) 500);
    }

    public static ValueAnimator m28155a(View view, int i, int i2) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new C61521(view, i, i2));
        return ofInt;
    }

    public static void m28157a(View view) {
        ValueAnimator a = m28155a(view, view.getHeight(), 0);
        a.addListener(new C61532(view));
        a.start();
    }

    public static void m28158a(View view, int i) {
        view.setVisibility(0);
        m28155a(view, 0, i).start();
    }

    public static ObjectAnimator m28149a(View view, float f, int i) {
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("alpha", new float[]{view.getAlpha(), f});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat}).setDuration((long) i);
    }

    public static ObjectAnimator m28159b(View view, int i, int i2, float f) {
        float f2 = ((float) i2) + f;
        int i3 = 500 - (i * 40);
        if (i3 < 0) {
            i3 = 500;
        }
        PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("translationY", new float[]{view.getY(), f2});
        return ObjectAnimator.ofPropertyValuesHolder(view, new PropertyValuesHolder[]{ofFloat}).setDuration((long) i3);
    }
}
