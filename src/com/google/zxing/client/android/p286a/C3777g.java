package com.google.zxing.client.android.p286a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.util.Log;

/* compiled from: PreviewCallback */
final class C3777g implements PreviewCallback {
    private static final String f14711a = C3777g.class.getSimpleName();
    private final C3773c f14712b;
    private Handler f14713c;
    private int f14714d;

    C3777g(C3773c c3773c) {
        this.f14712b = c3773c;
    }

    void m19001a(Handler handler, int i) {
        this.f14713c = handler;
        this.f14714d = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.f14712b.m18981a();
        Handler handler = this.f14713c;
        if (a == null || handler == null) {
            Log.d(f14711a, "Got preview callback, but no handler or resolution available");
            return;
        }
        handler.obtainMessage(this.f14714d, a.x, a.y, bArr).sendToTarget();
        this.f14713c = null;
    }
}
