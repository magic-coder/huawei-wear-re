package com.huawei.pluginkidwatch.plugin.setting.qrcode.p168a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.huawei.p190v.C2538c;

/* compiled from: PreviewCallback */
final class C1949f implements PreviewCallback {
    private static final String f6778a = C1949f.class.getSimpleName();
    private final C1946c f6779b;
    private final boolean f6780c;
    private Handler f6781d;
    private int f6782e;

    C1949f(C1946c c1946c, boolean z) {
        this.f6779b = c1946c;
        this.f6780c = z;
    }

    void m10208a(Handler handler, int i) {
        this.f6781d = handler;
        this.f6782e = i;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.f6779b.m10186a();
        if (!this.f6780c) {
            camera.setPreviewCallback(null);
        }
        if (this.f6781d != null) {
            this.f6781d.obtainMessage(this.f6782e, a.x, a.y, bArr).sendToTarget();
            this.f6781d = null;
            return;
        }
        C2538c.m12674b(f6778a, "Got preview callback, but no handler for it");
    }
}
