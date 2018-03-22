package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class District implements Parcelable {
    public static final Creator<District> CREATOR = new C3473d();
    private String f12765a;
    private String f12766b;

    public String getDistrictName() {
        return this.f12765a;
    }

    public void setDistrictName(String str) {
        this.f12765a = str;
    }

    public String getDistrictAdcode() {
        return this.f12766b;
    }

    public void setDistrictAdcode(String str) {
        this.f12766b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12765a);
        parcel.writeString(this.f12766b);
    }

    public District(Parcel parcel) {
        this.f12765a = parcel.readString();
        this.f12766b = parcel.readString();
    }
}
