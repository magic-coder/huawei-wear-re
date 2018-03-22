package com.amap.api.mapcore.util;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.amap.api.maps.model.GroundOverlayOptions;

/* compiled from: TwoFingerGestureDetector */
public abstract class C3309e extends C3286b {
    protected float f11658h;
    protected float f11659i;
    protected float f11660j;
    protected float f11661k;
    private final float f11662l;
    private float f11663m;
    private float f11664n;
    private float f11665o;
    private float f11666p;

    public C3309e(Context context) {
        super(context);
        this.f11662l = (float) ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    protected void mo4038b(MotionEvent motionEvent) {
        super.mo4038b(motionEvent);
        if (this.c != null) {
            MotionEvent motionEvent2 = this.c;
            this.f11665o = GroundOverlayOptions.NO_DIMENSION;
            this.f11666p = GroundOverlayOptions.NO_DIMENSION;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1) - y;
            this.f11658h = x2 - x;
            this.f11659i = y2;
            y2 = motionEvent.getX(0);
            x = motionEvent.getY(0);
            x = motionEvent.getY(1) - x;
            this.f11660j = motionEvent.getX(1) - y2;
            this.f11661k = x;
        }
    }

    public float m15980c() {
        if (this.f11665o == GroundOverlayOptions.NO_DIMENSION) {
            float f = this.f11660j;
            float f2 = this.f11661k;
            this.f11665o = (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
        }
        return this.f11665o;
    }

    protected static float m15977a(MotionEvent motionEvent, int i) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        if (i < motionEvent.getPointerCount()) {
            return rawX + motionEvent.getX(i);
        }
        return 0.0f;
    }

    protected static float m15978b(MotionEvent motionEvent, int i) {
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        if (i < motionEvent.getPointerCount()) {
            return rawY + motionEvent.getY(i);
        }
        return 0.0f;
    }

    protected boolean m15981d(MotionEvent motionEvent) {
        DisplayMetrics displayMetrics = this.a.getResources().getDisplayMetrics();
        this.f11663m = ((float) displayMetrics.widthPixels) - this.f11662l;
        this.f11664n = ((float) displayMetrics.heightPixels) - this.f11662l;
        float f = this.f11662l;
        float f2 = this.f11663m;
        float f3 = this.f11664n;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float a = C3309e.m15977a(motionEvent, 1);
        float b = C3309e.m15978b(motionEvent, 1);
        boolean z = rawX < f || rawY < f || rawX > f2 || rawY > f3;
        boolean z2;
        if (a < f || b < f || a > f2 || b > f3) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z || r2) {
            return true;
        }
        return false;
    }
}
