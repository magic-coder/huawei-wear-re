package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Province implements Parcelable {
    public static final Creator<Province> CREATOR = new C3380d();
    private String f12171a;
    private String f12172b;
    private String f12173c;
    private String f12174d;

    public String getProvinceName() {
        return this.f12171a;
    }

    public String getJianpin() {
        return this.f12172b;
    }

    public String getPinyin() {
        return this.f12173c;
    }

    public void setProvinceName(String str) {
        this.f12171a = str;
    }

    public void setJianpin(String str) {
        this.f12172b = str;
    }

    public void setPinyin(String str) {
        this.f12173c = str;
    }

    public void setProvinceCode(String str) {
        this.f12174d = str;
    }

    public String getProvinceCode() {
        return this.f12174d;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12171a);
        parcel.writeString(this.f12172b);
        parcel.writeString(this.f12173c);
        parcel.writeString(this.f12174d);
    }

    public Province(Parcel parcel) {
        this.f12171a = parcel.readString();
        this.f12172b = parcel.readString();
        this.f12173c = parcel.readString();
        this.f12174d = parcel.readString();
    }
}
