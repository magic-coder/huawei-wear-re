package com.amap.api.mapcore.util;

import android.content.Context;
import android.view.MotionEvent;
import java.lang.reflect.Method;

/* compiled from: MultiTouchSupport */
public class C3300c {
    protected Method f11568a;
    protected Method f11569b;
    protected Method f11570c;
    private boolean f11571d = false;
    private final C3213a f11572e;
    private long f11573f = 0;
    private boolean f11574g = false;

    /* compiled from: MultiTouchSupport */
    public interface C3213a {
        void mo3730a();

        void mo3731a(float f, float f2, float f3, float f4, float f5);

        boolean mo3732a(MotionEvent motionEvent, float f, float f2, float f3, float f4);
    }

    public C3300c(Context context, C3213a c3213a) {
        this.f11572e = c3213a;
        m15819c();
    }

    public boolean m15820a() {
        return this.f11574g;
    }

    public long m15822b() {
        return this.f11573f;
    }

    private void m15819c() {
        try {
            this.f11568a = MotionEvent.class.getMethod("getPointerCount", new Class[0]);
            this.f11569b = MotionEvent.class.getMethod("getX", new Class[]{Integer.TYPE});
            this.f11570c = MotionEvent.class.getMethod("getY", new Class[]{Integer.TYPE});
            this.f11571d = true;
        } catch (Throwable th) {
            this.f11571d = false;
            ca.m15831a(th, "MultiTouchSupport", "initMethods");
            th.printStackTrace();
        }
    }

    public boolean m15821a(MotionEvent motionEvent) {
        if (!this.f11571d) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        try {
            if (((Integer) this.f11568a.invoke(motionEvent, new Object[0])).intValue() < 2) {
                this.f11573f = 0;
                this.f11574g = false;
                return false;
            }
            Float f = (Float) this.f11569b.invoke(motionEvent, new Object[]{Integer.valueOf(0)});
            Float f2 = (Float) this.f11569b.invoke(motionEvent, new Object[]{Integer.valueOf(1)});
            Float f3 = (Float) this.f11570c.invoke(motionEvent, new Object[]{Integer.valueOf(0)});
            Float f4 = (Float) this.f11570c.invoke(motionEvent, new Object[]{Integer.valueOf(1)});
            float sqrt = (float) Math.sqrt((double) (((f2.floatValue() - f.floatValue()) * (f2.floatValue() - f.floatValue())) + ((f4.floatValue() - f3.floatValue()) * (f4.floatValue() - f3.floatValue()))));
            if (action == 5) {
                this.f11572e.mo3731a(sqrt, f.floatValue(), f3.floatValue(), f2.floatValue(), f4.floatValue());
                this.f11574g = true;
                return true;
            } else if (action == 6) {
                this.f11573f = motionEvent.getEventTime();
                if (motionEvent.getPointerCount() == 2 && this.f11573f - motionEvent.getDownTime() < 100) {
                    this.f11572e.mo3730a();
                }
                if (this.f11574g) {
                    this.f11574g = false;
                }
                return false;
            } else {
                if (this.f11574g && action == 2) {
                    return this.f11572e.mo3732a(motionEvent, f.floatValue(), f3.floatValue(), f2.floatValue(), f4.floatValue());
                }
                return false;
            }
        } catch (Throwable th) {
            ca.m15831a(th, "MultiTouchSupport", "onTouchEvent");
            th.printStackTrace();
        }
    }
}
