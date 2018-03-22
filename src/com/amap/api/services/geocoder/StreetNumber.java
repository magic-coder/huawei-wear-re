package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class StreetNumber implements Parcelable {
    public static final Creator<StreetNumber> CREATOR = new C3449e();
    private String f12600a;
    private String f12601b;
    private LatLonPoint f12602c;
    private String f12603d;
    private float f12604e;

    public String getStreet() {
        return this.f12600a;
    }

    public void setStreet(String str) {
        this.f12600a = str;
    }

    public String getNumber() {
        return this.f12601b;
    }

    public void setNumber(String str) {
        this.f12601b = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f12602c;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f12602c = latLonPoint;
    }

    public String getDirection() {
        return this.f12603d;
    }

    public void setDirection(String str) {
        this.f12603d = str;
    }

    public float getDistance() {
        return this.f12604e;
    }

    public void setDistance(float f) {
        this.f12604e = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12600a);
        parcel.writeString(this.f12601b);
        parcel.writeValue(this.f12602c);
        parcel.writeString(this.f12603d);
        parcel.writeFloat(this.f12604e);
    }

    private StreetNumber(Parcel parcel) {
        this.f12600a = parcel.readString();
        this.f12601b = parcel.readString();
        this.f12602c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f12603d = parcel.readString();
        this.f12604e = parcel.readFloat();
    }
}
