package com.huawei.hwdatamigrate.p407a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: AlarmClockTable */
public class C4771d {
    public int f17604a;
    public String f17605b;
    public String f17606c;
    public int f17607d;
    public int f17608e;
    public int f17609f;
    public int f17610g;
    public boolean f17611h;

    public int m22852a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17609f))).intValue();
    }

    public int m22853b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17608e))).intValue();
    }

    public int m22854c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f17607d))).intValue();
    }

    public boolean m22855d() {
        return ((Boolean) C0978h.a(Boolean.valueOf(this.f17611h))).booleanValue();
    }

    public String toString() {
        return "AlarmClockTable [id=" + this.f17604a + ", time=" + this.f17607d + ", week=" + Integer.toBinaryString(this.f17608e) + ", check_interval=" + this.f17609f + ", check_open=" + this.f17610g + ", open=" + this.f17611h + "]";
    }
}
