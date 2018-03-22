package com.fenda.hwbracelet.mode;

import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3602e;

/* compiled from: GestureType */
public class C3625h {
    public boolean f13884a;

    public C3625h(boolean z) {
        this.f13884a = z;
    }

    public byte[] m18163a() {
        C3600c c3600c;
        if (this.f13884a) {
            c3600c = new C3600c(C3602e.GESTURE_ACTIVE);
        } else {
            c3600c = new C3600c(C3602e.GESTURE_OFF);
        }
        return c3600c.mo4217b();
    }
}
