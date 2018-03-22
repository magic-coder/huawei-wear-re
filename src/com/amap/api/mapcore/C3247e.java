package com.amap.api.mapcore;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.ca;

/* compiled from: AMapDelegateImp */
class C3247e extends Handler {
    final /* synthetic */ AMapDelegateImp f11223a;

    C3247e(AMapDelegateImp aMapDelegateImp) {
        this.f11223a = aMapDelegateImp;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        try {
            if (this.f11223a.f10842V != null) {
                this.f11223a.f10842V.onTouch((MotionEvent) message.obj);
            }
        } catch (Throwable th) {
            ca.m15831a(th, "AMapDelegateImpGLSurfaceView", "onTouchHandler");
            th.printStackTrace();
        }
    }
}
