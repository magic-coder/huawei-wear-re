package com.fenda.hwbracelet.mode;

import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3601d;

/* compiled from: SportReminder */
public class C3628k {
    public boolean f13901a;
    public int f13902b;
    public int f13903c;
    public int f13904d;
    public int f13905e;
    public byte f13906f;
    public byte f13907g;

    public C3628k(boolean z, int i, int i2, int i3, int i4, byte b, byte b2) {
        this.f13901a = z;
        this.f13902b = i;
        this.f13903c = i2;
        this.f13904d = i3;
        this.f13905e = i4;
        this.f13906f = b;
        this.f13907g = b2;
    }

    public byte[] m18197a() {
        return ((C3600c) C3601d.m18065a().m18068a(new C3628k(this.f13901a, this.f13902b, this.f13903c, this.f13904d, this.f13905e, this.f13906f, this.f13907g))).mo4217b();
    }
}
