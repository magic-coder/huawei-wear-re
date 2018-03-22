package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GeoPoint implements Parcelable {
    public static final Creator<GeoPoint> CREATOR = new C3194f();
    private long f10676a;
    private long f10677b;
    private double f10678c;
    private double f10679d;

    public GeoPoint() {
        this.f10676a = Long.MIN_VALUE;
        this.f10677b = Long.MIN_VALUE;
        this.f10678c = Double.MIN_VALUE;
        this.f10679d = Double.MIN_VALUE;
        this.f10676a = 0;
        this.f10677b = 0;
    }

    public GeoPoint(int i, int i2) {
        this.f10676a = Long.MIN_VALUE;
        this.f10677b = Long.MIN_VALUE;
        this.f10678c = Double.MIN_VALUE;
        this.f10679d = Double.MIN_VALUE;
        this.f10676a = (long) i;
        this.f10677b = (long) i2;
    }

    public GeoPoint(long j, long j2) {
        this.f10676a = Long.MIN_VALUE;
        this.f10677b = Long.MIN_VALUE;
        this.f10678c = Double.MIN_VALUE;
        this.f10679d = Double.MIN_VALUE;
        this.f10676a = j;
        this.f10677b = j2;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f10678c == geoPoint.f10678c && this.f10679d == geoPoint.f10679d && this.f10676a == geoPoint.f10676a && this.f10677b == geoPoint.f10677b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) ((this.f10679d * 7.0d) + (this.f10678c * 11.0d));
    }

    public String toString() {
        return "" + this.f10676a + "," + this.f10677b;
    }

    public int getLongitudeE6() {
        return (int) this.f10677b;
    }

    public int getLatitudeE6() {
        return (int) this.f10676a;
    }

    private GeoPoint(Parcel parcel) {
        this.f10676a = Long.MIN_VALUE;
        this.f10677b = Long.MIN_VALUE;
        this.f10678c = Double.MIN_VALUE;
        this.f10679d = Double.MIN_VALUE;
        this.f10676a = parcel.readLong();
        this.f10677b = parcel.readLong();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f10676a);
        parcel.writeLong(this.f10677b);
    }
}
