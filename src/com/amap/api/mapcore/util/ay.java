package com.amap.api.mapcore.util;

import com.autonavi.amap.mapcore.DPoint;

/* compiled from: Bounds */
public class ay {
    public final double f11439a;
    public final double f11440b;
    public final double f11441c;
    public final double f11442d;
    public final double f11443e;
    public final double f11444f;

    public ay(double d, double d2, double d3, double d4) {
        this.f11439a = d;
        this.f11440b = d3;
        this.f11441c = d2;
        this.f11442d = d4;
        this.f11443e = (d + d2) / 2.0d;
        this.f11444f = (d3 + d4) / 2.0d;
    }

    public boolean m15525a(double d, double d2) {
        return this.f11439a <= d && d <= this.f11441c && this.f11440b <= d2 && d2 <= this.f11442d;
    }

    public boolean m15528a(DPoint dPoint) {
        return m15525a(dPoint.f13250x, dPoint.f13251y);
    }

    public boolean m15526a(double d, double d2, double d3, double d4) {
        return d < this.f11441c && this.f11439a < d2 && d3 < this.f11442d && this.f11440b < d4;
    }

    public boolean m15527a(ay ayVar) {
        return m15526a(ayVar.f11439a, ayVar.f11441c, ayVar.f11440b, ayVar.f11442d);
    }

    public boolean m15529b(ay ayVar) {
        return ayVar.f11439a >= this.f11439a && ayVar.f11441c <= this.f11441c && ayVar.f11440b >= this.f11440b && ayVar.f11442d <= this.f11442d;
    }
}
