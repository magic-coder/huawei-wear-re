package com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.os.Handler;
import com.huawei.p190v.C2538c;

/* compiled from: AutoFocusCallback */
final class C1944a implements AutoFocusCallback {
    private static final String f6750a = C1944a.class.getSimpleName();
    private Handler f6751b;
    private int f6752c;

    C1944a() {
    }

    void m10178a(Handler handler, int i) {
        this.f6751b = handler;
        this.f6752c = i;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (this.f6751b != null) {
            this.f6751b.sendMessageDelayed(this.f6751b.obtainMessage(this.f6752c, Boolean.valueOf(z)), 1500);
            this.f6751b = null;
            return;
        }
        C2538c.m12674b(f6750a, "Got auto-focus callback, but no handler for it");
    }
}
