package com.autonavi.amap.mapcore;

public class IPoint {
    public int f13273x;
    public int f13274y;

    public IPoint(int i, int i2) {
        this.f13273x = i;
        this.f13274y = i2;
    }

    public Object clone() {
        try {
            return (IPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
