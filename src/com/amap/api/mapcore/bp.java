package com.amap.api.mapcore;

import android.os.Handler;
import android.os.Message;

/* compiled from: UiSettingsDelegateImp */
class bp extends Handler {
    final /* synthetic */ bo f11193a;

    bp(bo boVar) {
        this.f11193a = boVar;
    }

    public void handleMessage(Message message) {
        if (message != null) {
            switch (message.what) {
                case 0:
                    this.f11193a.f11182b.mo3798a(this.f11193a.f11188h);
                    return;
                case 1:
                    this.f11193a.f11182b.mo3813d(this.f11193a.f11190j);
                    return;
                case 2:
                    this.f11193a.f11182b.mo3810c(this.f11193a.f11189i);
                    return;
                case 3:
                    this.f11193a.f11182b.mo3807b(this.f11193a.f11186f);
                    return;
                default:
                    return;
            }
        }
    }
}
