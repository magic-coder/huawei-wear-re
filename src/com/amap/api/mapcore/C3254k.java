package com.amap.api.mapcore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* compiled from: AMapGLTextureView */
public class C3254k extends C3253x implements ad {
    private aa f11241a;

    public C3254k(Context context) {
        this(context, null);
    }

    public C3254k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11241a = null;
        this.f11241a = new AMapDelegateImp(this, context, attributeSet);
    }

    public aa mo3978a() {
        return this.f11241a;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.f11241a.mo3799a(motionEvent);
    }

    public void setZOrderOnTop(boolean z) {
    }
}
