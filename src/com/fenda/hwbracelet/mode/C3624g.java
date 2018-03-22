package com.fenda.hwbracelet.mode;

import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3602e;

/* compiled from: DisplayType */
public class C3624g {
    public boolean f13883a;

    public C3624g(boolean z) {
        this.f13883a = z;
    }

    public byte[] m18162a() {
        C3600c c3600c;
        if (this.f13883a) {
            c3600c = new C3600c(C3602e.DISPLAY_HIGHTLIGHT);
        } else {
            c3600c = new C3600c(C3602e.DISPLAY_NORMAL);
        }
        return c3600c.mo4217b();
    }
}
