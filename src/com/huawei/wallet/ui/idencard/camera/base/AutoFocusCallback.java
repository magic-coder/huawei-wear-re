package com.huawei.wallet.ui.idencard.camera.base;

import android.hardware.Camera;
import android.os.Handler;
import com.huawei.wallet.utils.log.LogC;

public class AutoFocusCallback implements android.hardware.Camera.AutoFocusCallback {
    private Handler f21555a;
    private int f21556b;

    void m28394a(Handler handler, int i) {
        this.f21555a = handler;
        this.f21556b = i;
    }

    public void onAutoFocus(boolean z, Camera camera) {
        if (this.f21555a != null) {
            LogC.m28530b("Got auto-focus result: " + z, false);
            this.f21555a.sendMessage(this.f21555a.obtainMessage(this.f21556b, Boolean.valueOf(z)));
            this.f21555a = null;
            return;
        }
        LogC.m28530b("Got auto-focus callback, but no handler for it", false);
    }
}
