package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class Road implements Parcelable {
    public static final Creator<Road> CREATOR = new C3466b();
    private String f12737a;
    private String f12738b;
    private String f12739c;
    private float f12740d;
    private String f12741e;
    private LatLonPoint f12742f;

    public Road(String str, String str2) {
        this.f12737a = str;
        this.f12738b = str2;
    }

    public void setId(String str) {
        this.f12737a = str;
    }

    public void setName(String str) {
        this.f12738b = str;
    }

    public String getCityCode() {
        return this.f12739c;
    }

    public void setCityCode(String str) {
        this.f12739c = str;
    }

    public float getRoadWidth() {
        return this.f12740d;
    }

    public void setRoadWidth(float f) {
        this.f12740d = f;
    }

    public String getType() {
        return this.f12741e;
    }

    public void setType(String str) {
        this.f12741e = str;
    }

    public LatLonPoint getCenterPoint() {
        return this.f12742f;
    }

    public void setCenterPoint(LatLonPoint latLonPoint) {
        this.f12742f = latLonPoint;
    }

    public String getId() {
        return this.f12737a;
    }

    public String getName() {
        return this.f12738b;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12737a);
        parcel.writeString(this.f12738b);
        parcel.writeString(this.f12739c);
        parcel.writeFloat(this.f12740d);
        parcel.writeString(this.f12741e);
        parcel.writeValue(this.f12742f);
    }

    private Road(Parcel parcel) {
        this.f12737a = parcel.readString();
        this.f12738b = parcel.readString();
        this.f12739c = parcel.readString();
        this.f12740d = parcel.readFloat();
        this.f12741e = parcel.readString();
        this.f12742f = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
    }
}
