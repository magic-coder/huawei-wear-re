package com.huawei.pluginkidwatch.common.ui.listview;

/* compiled from: PairedDeviceInfo */
public class C1522b {
    private String f3601a = "";
    private int f3602b = 1;
    private boolean f3603c = false;
    private boolean f3604d = false;
    private int f3605e = 1;
    private int f3606f = -1;

    public String m7034a() {
        return this.f3601a;
    }

    public void m7036a(String str) {
        this.f3601a = str;
    }

    public int m7038b() {
        return this.f3602b;
    }

    public void m7035a(int i) {
        this.f3602b = i;
    }

    public boolean m7040c() {
        return this.f3603c;
    }

    public int m7041d() {
        return this.f3606f;
    }

    public void m7039b(int i) {
        this.f3606f = i;
    }

    public boolean m7042e() {
        return this.f3604d;
    }

    public void m7037a(boolean z) {
        this.f3604d = z;
    }

    public String toString() {
        return "PairedDeviceInfo{deviceName='" + this.f3601a + '\'' + ", deviceType=" + this.f3602b + ", connectStatus=" + this.f3603c + ", isSelect=" + this.f3604d + ", batteryValue=" + this.f3605e + ", deviceCode=" + this.f3606f + '}';
    }
}
