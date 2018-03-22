package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public final class GeocodeAddress implements Parcelable {
    public static final Creator<GeocodeAddress> CREATOR = new C3446b();
    private String f12555a;
    private String f12556b;
    private String f12557c;
    private String f12558d;
    private String f12559e;
    private String f12560f;
    private String f12561g;
    private String f12562h;
    private LatLonPoint f12563i;
    private String f12564j;

    public String getFormatAddress() {
        return this.f12555a;
    }

    public void setFormatAddress(String str) {
        this.f12555a = str;
    }

    public String getProvince() {
        return this.f12556b;
    }

    public void setProvince(String str) {
        this.f12556b = str;
    }

    public String getCity() {
        return this.f12557c;
    }

    public void setCity(String str) {
        this.f12557c = str;
    }

    public String getDistrict() {
        return this.f12558d;
    }

    public void setDistrict(String str) {
        this.f12558d = str;
    }

    public String getTownship() {
        return this.f12559e;
    }

    public void setTownship(String str) {
        this.f12559e = str;
    }

    public String getNeighborhood() {
        return this.f12560f;
    }

    public void setNeighborhood(String str) {
        this.f12560f = str;
    }

    public String getBuilding() {
        return this.f12561g;
    }

    public void setBuilding(String str) {
        this.f12561g = str;
    }

    public String getAdcode() {
        return this.f12562h;
    }

    public void setAdcode(String str) {
        this.f12562h = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f12563i;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f12563i = latLonPoint;
    }

    public String getLevel() {
        return this.f12564j;
    }

    public void setLevel(String str) {
        this.f12564j = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12555a);
        parcel.writeString(this.f12556b);
        parcel.writeString(this.f12557c);
        parcel.writeString(this.f12558d);
        parcel.writeString(this.f12559e);
        parcel.writeString(this.f12560f);
        parcel.writeString(this.f12561g);
        parcel.writeString(this.f12562h);
        parcel.writeValue(this.f12563i);
        parcel.writeString(this.f12564j);
    }

    private GeocodeAddress(Parcel parcel) {
        this.f12555a = parcel.readString();
        this.f12556b = parcel.readString();
        this.f12557c = parcel.readString();
        this.f12558d = parcel.readString();
        this.f12559e = parcel.readString();
        this.f12560f = parcel.readString();
        this.f12561g = parcel.readString();
        this.f12562h = parcel.readString();
        this.f12563i = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f12564j = parcel.readString();
    }
}
