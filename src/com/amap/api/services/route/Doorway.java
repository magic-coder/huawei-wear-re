package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class Doorway implements Parcelable {
    public static final Creator<Doorway> CREATOR = new C3474e();
    private String f12767a;
    private LatLonPoint f12768b;

    public String getName() {
        return this.f12767a;
    }

    public void setName(String str) {
        this.f12767a = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f12768b;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f12768b = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12767a);
        parcel.writeParcelable(this.f12768b, i);
    }

    public Doorway(Parcel parcel) {
        this.f12767a = parcel.readString();
        this.f12768b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
