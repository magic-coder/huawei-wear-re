package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class BusinessArea implements Parcelable {
    public static final Creator<BusinessArea> CREATOR = new C3445a();
    private LatLonPoint f12553a;
    private String f12554b;

    public LatLonPoint getCenterPoint() {
        return this.f12553a;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f12553a = latLonPoint;
    }

    public String getName() {
        return this.f12554b;
    }

    public void setName(String str) {
        this.f12554b = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12553a, i);
        parcel.writeString(this.f12554b);
    }

    public BusinessArea(Parcel parcel) {
        this.f12553a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f12554b = parcel.readString();
    }
}
