package com.amap.api.mapcore.util;

/* compiled from: DTDownloadInfo */
class C3339t {
    private String f11845a = "";
    private long f11846b = 0;
    private int f11847c = 0;
    private long f11848d = 0;
    private long f11849e = 0;

    public C3339t(String str, int i, int i2, int i3, int i4) {
        this.f11845a = str;
        this.f11846b = (long) i;
        this.f11847c = i2;
        this.f11848d = (long) i3;
        this.f11849e = (long) i4;
    }

    public C3339t(String str, long j, int i, long j2, long j3) {
        this.f11845a = str;
        this.f11846b = j;
        this.f11847c = i;
        this.f11848d = j2;
        this.f11849e = j3;
    }

    public long m16274a(int i) {
        switch (i) {
            case 0:
                return m16279d();
            default:
                return 0;
        }
    }

    public long m16277b(int i) {
        switch (i) {
            case 0:
                return m16280e();
            default:
                return 0;
        }
    }

    public String m16275a() {
        return this.f11845a;
    }

    public long m16276b() {
        return this.f11846b;
    }

    public int m16278c() {
        return this.f11847c;
    }

    public long m16279d() {
        return this.f11848d;
    }

    public long m16280e() {
        return this.f11849e;
    }
}
