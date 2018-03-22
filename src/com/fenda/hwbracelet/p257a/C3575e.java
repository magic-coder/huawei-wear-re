package com.fenda.hwbracelet.p257a;

import com.huawei.p190v.C2538c;

import java.util.Calendar;
import java.util.TimeZone;

/* compiled from: SyncDataTime */
public class C3575e {
    private Calendar f13683a = Calendar.getInstance();
    private int f13684b;
    private int f13685c;
    private int f13686d;
    private int f13687e;
    private int f13688f;
    private int f13689g;

    public C3575e(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f13684b = i;
        this.f13685c = i2;
        this.f13686d = i3;
        this.f13687e = i4;
        this.f13688f = i5;
        this.f13689g = i6;
    }

    public long m17944a() {
        C2538c.c("SyncDataTime", new Object[]{"year: " + this.f13684b + ", month: " + this.f13685c + ", day: " + this.f13686d + ", hour: " + this.f13687e + ", minute: " + this.f13688f + ", delta: " + this.f13689g});
        this.f13683a.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.f13683a.set(this.f13684b, this.f13685c - 1, this.f13686d, this.f13687e, this.f13688f, 0);
        this.f13683a.add(12, this.f13689g);
        C2538c.c("SyncDataTime", new Object[]{"time: " + ((this.f13683a.getTimeInMillis() / 1000) * 1000)});
        return (this.f13683a.getTimeInMillis() / 1000) * 1000;
    }
}
