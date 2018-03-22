package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class RegeocodeRoad implements Parcelable {
    public static final Creator<RegeocodeRoad> CREATOR = new C3448d();
    private String f12595a;
    private String f12596b;
    private float f12597c;
    private String f12598d;
    private LatLonPoint f12599e;

    public String getId() {
        return this.f12595a;
    }

    public void setId(String str) {
        this.f12595a = str;
    }

    public String getName() {
        return this.f12596b;
    }

    public void setName(String str) {
        this.f12596b = str;
    }

    public float getDistance() {
        return this.f12597c;
    }

    public void setDistance(float f) {
        this.f12597c = f;
    }

    public String getDirection() {
        return this.f12598d;
    }

    public void setDirection(String str) {
        this.f12598d = str;
    }

    public LatLonPoint getLatLngPoint() {
        return this.f12599e;
    }

    public void setLatLngPoint(LatLonPoint latLonPoint) {
        this.f12599e = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12595a);
        parcel.writeString(this.f12596b);
        parcel.writeFloat(this.f12597c);
        parcel.writeString(this.f12598d);
        parcel.writeValue(this.f12599e);
    }

    private RegeocodeRoad(Parcel parcel) {
        this.f12595a = parcel.readString();
        this.f12596b = parcel.readString();
        this.f12597c = parcel.readFloat();
        this.f12598d = parcel.readString();
        this.f12599e = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
