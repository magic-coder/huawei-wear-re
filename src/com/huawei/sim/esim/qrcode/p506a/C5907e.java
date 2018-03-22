package com.huawei.sim.esim.qrcode.p506a;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import com.huawei.p190v.C2538c;

/* compiled from: PreviewCallback */
final class C5907e implements PreviewCallback {
    private static final String f20249a = C5907e.class.getSimpleName();
    private final C5904b f20250b;
    private Handler f20251c;
    private int f20252d;
    private final boolean f20253e;

    C5907e(C5904b c5904b, boolean z) {
        this.f20250b = c5904b;
        this.f20253e = z;
    }

    void m27174a(Handler handler, int i) {
        this.f20252d = i;
        this.f20251c = handler;
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Point a = this.f20250b.m27152a();
        if (!this.f20253e) {
            camera.setPreviewCallback(null);
        }
        if (this.f20251c != null) {
            this.f20251c.obtainMessage(this.f20252d, a.x, a.y, bArr).sendToTarget();
            this.f20251c = null;
            return;
        }
        C2538c.c(f20249a, new Object[]{"Got preview callback, but no handler for it"});
    }
}
