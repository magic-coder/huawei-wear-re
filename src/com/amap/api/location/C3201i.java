package com.amap.api.location;

/* compiled from: RequestLocationEntity */
public class C3201i {
    long f10724a;
    public AMapLocationListener f10725b;
    Boolean f10726c;

    public C3201i(long j, float f, AMapLocationListener aMapLocationListener, String str, boolean z) {
        this.f10724a = j;
        this.f10725b = aMapLocationListener;
        this.f10726c = Boolean.valueOf(z);
    }

    public int hashCode() {
        return (this.f10725b == null ? 0 : this.f10725b.hashCode()) + 31;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C3201i c3201i = (C3201i) obj;
        if (this.f10725b == null) {
            if (c3201i.f10725b != null) {
                return false;
            }
            return true;
        } else if (this.f10725b.equals(c3201i.f10725b)) {
            return true;
        } else {
            return false;
        }
    }
}
