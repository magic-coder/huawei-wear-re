package com.fenda.hwbracelet.mode;

import com.fenda.hwbracelet.p262e.C3600c;
import com.fenda.hwbracelet.p262e.C3601d;

/* compiled from: AutoSleepTime */
public class C3621d {
    public boolean f13875a;
    public int f13876b;
    public int f13877c;

    public C3621d(boolean z, int i, int i2) {
        this.f13875a = z;
        this.f13876b = i;
        this.f13877c = i2;
    }

    public byte[] m18152a() {
        byte b = (byte) 0;
        if (this.f13875a) {
            b = (byte) 1;
        }
        return ((C3600c) C3601d.m18065a().m18067a(b, (byte) (this.f13876b / 60), (byte) (this.f13876b % 60), (byte) (this.f13877c / 60), (byte) (this.f13877c % 60))).mo4217b();
    }
}
