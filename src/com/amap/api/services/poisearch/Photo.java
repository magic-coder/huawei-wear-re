package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Photo implements Parcelable {
    public static final Creator<Photo> CREATOR = new C3459f();
    private String f12677a;
    private String f12678b;

    public Photo(String str, String str2) {
        this.f12677a = str;
        this.f12678b = str2;
    }

    public String getTitle() {
        return this.f12677a;
    }

    public void setTitle(String str) {
        this.f12677a = str;
    }

    public String getUrl() {
        return this.f12678b;
    }

    public void setUrl(String str) {
        this.f12678b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12677a);
        parcel.writeString(this.f12678b);
    }

    public Photo(Parcel parcel) {
        this.f12677a = parcel.readString();
        this.f12678b = parcel.readString();
    }
}
