package com.amap.api.maps.model;

import com.amap.api.mapcore.util.ay;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: PointQuadTree */
class C3369c {
    private final ay f12149a;
    private final int f12150b;
    private List<WeightedLatLng> f12151c;
    private List<C3369c> f12152d;

    protected C3369c(ay ayVar) {
        this(ayVar, 0);
    }

    private C3369c(double d, double d2, double d3, double d4, int i) {
        this(new ay(d, d2, d3, d4), i);
    }

    private C3369c(ay ayVar, int i) {
        this.f12152d = null;
        this.f12149a = ayVar;
        this.f12150b = i;
    }

    protected void m16476a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.f12149a.m15525a(point.f13250x, point.f13251y)) {
            m16473a(point.f13250x, point.f13251y, weightedLatLng);
        }
    }

    private void m16473a(double d, double d2, WeightedLatLng weightedLatLng) {
        if (this.f12152d == null) {
            if (this.f12151c == null) {
                this.f12151c = new ArrayList();
            }
            this.f12151c.add(weightedLatLng);
            if (this.f12151c.size() > 50 && this.f12150b < 40) {
                m16472a();
            }
        } else if (d2 < this.f12149a.f11444f) {
            if (d < this.f12149a.f11443e) {
                ((C3369c) this.f12152d.get(0)).m16473a(d, d2, weightedLatLng);
            } else {
                ((C3369c) this.f12152d.get(1)).m16473a(d, d2, weightedLatLng);
            }
        } else if (d < this.f12149a.f11443e) {
            ((C3369c) this.f12152d.get(2)).m16473a(d, d2, weightedLatLng);
        } else {
            ((C3369c) this.f12152d.get(3)).m16473a(d, d2, weightedLatLng);
        }
    }

    private void m16472a() {
        this.f12152d = new ArrayList(4);
        this.f12152d.add(new C3369c(this.f12149a.f11439a, this.f12149a.f11443e, this.f12149a.f11440b, this.f12149a.f11444f, this.f12150b + 1));
        this.f12152d.add(new C3369c(this.f12149a.f11443e, this.f12149a.f11441c, this.f12149a.f11440b, this.f12149a.f11444f, this.f12150b + 1));
        this.f12152d.add(new C3369c(this.f12149a.f11439a, this.f12149a.f11443e, this.f12149a.f11444f, this.f12149a.f11442d, this.f12150b + 1));
        this.f12152d.add(new C3369c(this.f12149a.f11443e, this.f12149a.f11441c, this.f12149a.f11444f, this.f12149a.f11442d, this.f12150b + 1));
        List<WeightedLatLng> list = this.f12151c;
        this.f12151c = null;
        for (WeightedLatLng weightedLatLng : list) {
            m16473a(weightedLatLng.getPoint().f13250x, weightedLatLng.getPoint().f13251y, weightedLatLng);
        }
    }

    protected Collection<WeightedLatLng> m16475a(ay ayVar) {
        Collection<WeightedLatLng> arrayList = new ArrayList();
        m16474a(ayVar, arrayList);
        return arrayList;
    }

    private void m16474a(ay ayVar, Collection<WeightedLatLng> collection) {
        if (!this.f12149a.m15527a(ayVar)) {
            return;
        }
        if (this.f12152d != null) {
            for (C3369c a : this.f12152d) {
                a.m16474a(ayVar, collection);
            }
        } else if (this.f12151c == null) {
        } else {
            if (ayVar.m15529b(this.f12149a)) {
                collection.addAll(this.f12151c);
                return;
            }
            for (WeightedLatLng weightedLatLng : this.f12151c) {
                if (ayVar.m15528a(weightedLatLng.getPoint())) {
                    collection.add(weightedLatLng);
                }
            }
        }
    }
}
