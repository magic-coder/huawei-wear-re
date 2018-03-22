package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SearchCity implements Parcelable {
    public static final Creator<SearchCity> CREATOR = new C3487r();
    private String f12821a;
    private String f12822b;
    private String f12823c;

    public String getSearchCityName() {
        return this.f12821a;
    }

    public void setSearchCityName(String str) {
        this.f12821a = str;
    }

    public String getSearchCitycode() {
        return this.f12822b;
    }

    public void setSearchCitycode(String str) {
        this.f12822b = str;
    }

    public String getSearchCityAdCode() {
        return this.f12823c;
    }

    public void setSearchCityhAdCode(String str) {
        this.f12823c = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12821a);
        parcel.writeString(this.f12822b);
        parcel.writeString(this.f12823c);
    }

    public SearchCity(Parcel parcel) {
        this.f12821a = parcel.readString();
        this.f12822b = parcel.readString();
        this.f12823c = parcel.readString();
    }
}
