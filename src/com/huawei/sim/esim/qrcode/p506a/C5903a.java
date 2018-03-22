package com.huawei.sim.esim.qrcode.p506a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.huawei.p190v.C2538c;

/* compiled from: AutoFocusCallback */
final class C5903a implements AutoFocusCallback {
    private static final String f20221a = C5903a.class.getSimpleName();
    private int f20222b;
    private Handler f20223c;

    C5903a() {
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (this.f20223c != null) {
            this.f20223c.sendMessageDelayed(this.f20223c.obtainMessage(this.f20222b, Boolean.valueOf(z)), 1500);
            this.f20223c = null;
            return;
        }
        C2538c.c(f20221a, new Object[]{"Got auto-focus callback, but no handler for it"});
    }

    void m27146a(Handler handler, int i) {
        this.f20223c = handler;
        this.f20222b = i;
    }
}
