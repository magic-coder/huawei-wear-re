package com.amap.api.mapcore.util;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.view.MotionEvent;

/* compiled from: BaseGestureDetector */
public abstract class C3286b {
    protected final Context f11451a;
    protected boolean f11452b;
    protected MotionEvent f11453c;
    protected MotionEvent f11454d;
    protected float f11455e;
    protected float f11456f;
    protected long f11457g;

    protected abstract void mo4040a(int i, MotionEvent motionEvent);

    protected abstract void mo4041b(int i, MotionEvent motionEvent);

    public C3286b(Context context) {
        this.f11451a = context;
    }

    public boolean m15543a(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (this.f11452b) {
            mo4041b(action, motionEvent);
        } else {
            mo4040a(action, motionEvent);
        }
        return true;
    }

    protected void mo4038b(MotionEvent motionEvent) {
        if (this.f11453c != null) {
            MotionEvent motionEvent2 = this.f11453c;
            if (this.f11454d != null) {
                this.f11454d.recycle();
                this.f11454d = null;
            }
            this.f11454d = MotionEvent.obtain(motionEvent);
            this.f11457g = motionEvent.getEventTime() - motionEvent2.getEventTime();
            this.f11455e = motionEvent.getPressure(m15546c(motionEvent));
            this.f11456f = motionEvent2.getPressure(m15546c(motionEvent2));
        }
    }

    public final int m15546c(MotionEvent motionEvent) {
        return (motionEvent.getAction() & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
    }

    protected void mo4039a() {
        if (this.f11453c != null) {
            this.f11453c.recycle();
            this.f11453c = null;
        }
        if (this.f11454d != null) {
            this.f11454d.recycle();
            this.f11454d = null;
        }
        this.f11452b = false;
    }
}
