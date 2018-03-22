package com.amap.api.services.help;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Tip implements Parcelable {
    public static final Creator<Tip> CREATOR = new C3451a();
    private String f12611a;
    private String f12612b;
    private String f12613c;

    public String getName() {
        return this.f12611a;
    }

    public void setName(String str) {
        this.f12611a = str;
    }

    public String getDistrict() {
        return this.f12612b;
    }

    public void setDistrict(String str) {
        this.f12612b = str;
    }

    public String getAdcode() {
        return this.f12613c;
    }

    public void setAdcode(String str) {
        this.f12613c = str;
    }

    public String toString() {
        return "name:" + this.f12611a + " district:" + this.f12612b + " adcode:" + this.f12613c;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12611a);
        parcel.writeString(this.f12613c);
        parcel.writeString(this.f12612b);
    }

    private Tip(Parcel parcel) {
        this.f12611a = parcel.readString();
        this.f12613c = parcel.readString();
        this.f12612b = parcel.readString();
    }
}
