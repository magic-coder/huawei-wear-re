package com.huawei.wallet.ui.idencard.camera.base;

import android.hardware.Camera;
import android.os.Handler;
import com.huawei.wallet.utils.log.LogC;

public class PreviewCallback implements android.hardware.Camera.PreviewCallback {
    private Handler f21585a;
    private int f21586b;

    void m28428a(Handler handler, int i) {
        this.f21585a = handler;
        this.f21586b = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (camera != null) {
            camera.addCallbackBuffer(bArr);
        }
        if (this.f21585a != null) {
            this.f21585a.obtainMessage(this.f21586b, bArr).sendToTarget();
            this.f21585a = null;
            return;
        }
        LogC.m28530b("Got preview callback, but no handler for it", false);
    }
}
