package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;

/* compiled from: RotateGestureDetector */
public class C3310d extends C3309e {
    private final C3223a f11667l;
    private boolean f11668m;

    /* compiled from: RotateGestureDetector */
    public interface C3223a {
        boolean mo3734a(C3310d c3310d);

        boolean mo3735b(C3310d c3310d);

        void mo3736c(C3310d c3310d);
    }

    public C3310d(Context context, C3223a c3223a) {
        super(context);
        this.f11667l = c3223a;
    }

    protected void mo4040a(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                if (this.f11668m) {
                    this.f11668m = m15981d(motionEvent);
                    if (!this.f11668m) {
                        this.b = this.f11667l.mo3735b(this);
                        return;
                    }
                    return;
                }
                return;
            case 5:
                mo4039a();
                this.c = MotionEvent.obtain(motionEvent);
                this.g = 0;
                mo4038b(motionEvent);
                this.f11668m = m15981d(motionEvent);
                if (!this.f11668m) {
                    this.b = this.f11667l.mo3735b(this);
                    return;
                }
                return;
            case 6:
                if (!this.f11668m) {
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected void mo4041b(int i, MotionEvent motionEvent) {
        switch (i) {
            case 2:
                mo4038b(motionEvent);
                if (this.e / this.f > 0.67f && this.f11667l.mo3734a(this) && this.c != null) {
                    this.c.recycle();
                    this.c = MotionEvent.obtain(motionEvent);
                    return;
                }
                return;
            case 3:
                if (!this.f11668m) {
                    this.f11667l.mo3736c(this);
                }
                mo4039a();
                return;
            case 6:
                mo4038b(motionEvent);
                if (!this.f11668m) {
                    this.f11667l.mo3736c(this);
                }
                mo4039a();
                return;
            default:
                return;
        }
    }

    protected void mo4039a() {
        super.mo4039a();
        this.f11668m = false;
    }

    public float m15984b() {
        return (float) (((Math.atan2((double) this.i, (double) this.h) - Math.atan2((double) this.k, (double) this.j)) * 180.0d) / 3.141592653589793d);
    }
}
