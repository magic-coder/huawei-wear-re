package com.huawei.hwdatamigrate.p407a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: MultAlarmClockTable */
public class ad {
    public int f17383a;
    public int f17384b;
    public int f17385c;
    public String f17386d;
    public boolean f17387e;
    public int f17388f;

    public int m22785a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17384b))).intValue();
    }

    public int m22786b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17385c))).intValue();
    }

    public String m22787c() {
        return (String) C0978h.a(this.f17386d);
    }

    public boolean m22788d() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.f17387e))).booleanValue();
    }

    public String toString() {
        return "MultAlarmClockTable [id=" + this.f17383a + ", time=" + this.f17384b + ", week=" + Integer.toBinaryString(this.f17385c) + ", info=" + this.f17386d + ", open=" + this.f17387e + ", infoSize=" + this.f17388f + "]";
    }
}
