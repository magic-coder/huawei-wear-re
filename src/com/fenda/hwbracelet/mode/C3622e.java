package com.fenda.hwbracelet.mode;

import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3602e;

/* compiled from: CameraSwitch */
public class C3622e {
    public boolean f13878a;

    public C3622e(boolean z) {
        this.f13878a = z;
    }

    public byte[] m18153a() {
        C3602e c3602e = C3602e.CHAOS;
        if (this.f13878a) {
            c3602e = C3602e.CAMERA_OPEN;
        } else {
            c3602e = C3602e.CAMERA_CLOSE;
        }
        return new C3600c(c3602e).mo4217b();
    }
}
