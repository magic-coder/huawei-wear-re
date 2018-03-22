package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LatLonPoint implements Parcelable {
    public static final Creator<LatLonPoint> CREATOR = new C3416k();
    private double f12268a;
    private double f12269b;

    public LatLonPoint(double d, double d2) {
        this.f12268a = d;
        this.f12269b = d2;
    }

    public double getLongitude() {
        return this.f12269b;
    }

    public void setLongitude(double d) {
        this.f12269b = d;
    }

    public double getLatitude() {
        return this.f12268a;
    }

    public void setLatitude(double d) {
        this.f12268a = d;
    }

    public LatLonPoint copy() {
        return new LatLonPoint(this.f12268a, this.f12269b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f12268a);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f12269b);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
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
        LatLonPoint latLonPoint = (LatLonPoint) obj;
        if (Double.doubleToLongBits(this.f12268a) != Double.doubleToLongBits(latLonPoint.f12268a)) {
            return false;
        }
        if (Double.doubleToLongBits(this.f12269b) != Double.doubleToLongBits(latLonPoint.f12269b)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "" + this.f12268a + "," + this.f12269b;
    }

    private LatLonPoint(Parcel parcel) {
        this.f12268a = parcel.readDouble();
        this.f12269b = parcel.readDouble();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f12268a);
        parcel.writeDouble(this.f12269b);
    }
}
