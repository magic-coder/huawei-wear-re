package com.amap.api.maps;

import android.content.Context;
import com.amap.api.mapcore.util.C3269a;
import com.amap.api.mapcore.util.ca;
import com.amap.api.maps.model.LatLng;

public class CoordinateConverter {
    private Context f11974a;
    private CoordType f11975b = null;
    private LatLng f11976c = null;

    public enum CoordType {
        BAIDU,
        MAPBAR,
        GPS,
        MAPABC,
        SOSOMAP,
        ALIYUN,
        GOOGLE
    }

    public CoordinateConverter(Context context) {
        this.f11974a = context;
    }

    public CoordinateConverter from(CoordType coordType) {
        this.f11975b = coordType;
        return this;
    }

    public CoordinateConverter coord(LatLng latLng) {
        this.f11976c = latLng;
        return this;
    }

    public LatLng convert() {
        if (this.f11975b == null || this.f11976c == null) {
            return null;
        }
        try {
            switch (C3365a.f11993a[this.f11975b.ordinal()]) {
                case 1:
                    return C3269a.m15380a(this.f11976c);
                case 2:
                    return C3269a.m15386b(this.f11974a, this.f11976c);
                case 3:
                case 4:
                case 5:
                case 6:
                    return this.f11976c;
                case 7:
                    return C3269a.m15379a(this.f11974a, this.f11976c);
                default:
                    return null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
            ca.m15831a(th, "CoordinateConverter", "convert");
            return this.f11976c;
        }
    }
}
