package com.autonavi.amap.mapcore;

public class FPoint {
    public float f13252x;
    public float f13253y;

    public FPoint(float f, float f2) {
        this.f13252x = f;
        this.f13253y = f2;
    }

    public boolean equals(Object obj) {
        FPoint fPoint = (FPoint) obj;
        if (fPoint != null && this.f13252x == fPoint.f13252x && this.f13253y == fPoint.f13253y) {
            return true;
        }
        return false;
    }
}
