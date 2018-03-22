package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class City implements Parcelable {
    public static final Creator<City> CREATOR = new C3377a();
    private String f11767a;
    private String f11768b;
    private String f11769c;
    private String f11770d;
    private String f11771e;

    public void setCity(String str) {
        this.f11767a = str;
    }

    public String getCity() {
        return this.f11767a;
    }

    public void setCode(String str) {
        this.f11768b = str;
    }

    public String getCode() {
        return this.f11768b;
    }

    public String getJianpin() {
        return this.f11769c;
    }

    public void setJianpin(String str) {
        this.f11769c = str;
    }

    public String getPinyin() {
        return this.f11770d;
    }

    public void setPinyin(String str) {
        this.f11770d = str;
    }

    public String getAdcode() {
        return this.f11771e;
    }

    public void setAdcode(String str) {
        this.f11771e = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11767a);
        parcel.writeString(this.f11768b);
        parcel.writeString(this.f11769c);
        parcel.writeString(this.f11770d);
        parcel.writeString(this.f11771e);
    }

    public City(Parcel parcel) {
        this.f11767a = parcel.readString();
        this.f11768b = parcel.readString();
        this.f11769c = parcel.readString();
        this.f11770d = parcel.readString();
        this.f11771e = parcel.readString();
    }
}
