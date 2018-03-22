package com.amap.api.mapcore;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* compiled from: AMapGLSurfaceView */
public class C3252j extends GLSurfaceView implements ad {
    private aa f11228a;

    public C3252j(Context context) {
        this(context, null);
    }

    public C3252j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11228a = null;
        this.f11228a = new AMapDelegateImp(this, context, attributeSet);
    }

    public aa m15265a() {
        return this.f11228a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.f11228a.mo3799a(motionEvent);
    }
}
