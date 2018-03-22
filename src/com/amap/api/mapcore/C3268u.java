package com.amap.api.mapcore;

import javax.microedition.khronos.opengles.GL10;

/* compiled from: GLOverlay */
public abstract class C3268u {
    private aa f11373a;

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);

    public void destroy() {
        if (this.f11373a != null) {
            this.f11373a.mo3779a(this);
        }
    }
}
