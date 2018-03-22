package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class Crossroad extends Road implements Parcelable {
    public static final Creator<Crossroad> CREATOR = new C3465a();
    private float f12743a;
    private String f12744b;
    private String f12745c;
    private String f12746d;
    private String f12747e;
    private String f12748f;

    public float getDistance() {
        return this.f12743a;
    }

    public void setDistance(float f) {
        this.f12743a = f;
    }

    public String getDirection() {
        return this.f12744b;
    }

    public void setDirection(String str) {
        this.f12744b = str;
    }

    public String getFirstRoadId() {
        return this.f12745c;
    }

    public void setFirstRoadId(String str) {
        this.f12745c = str;
    }

    public String getFirstRoadName() {
        return this.f12746d;
    }

    public void setFirstRoadName(String str) {
        this.f12746d = str;
    }

    public String getSecondRoadId() {
        return this.f12747e;
    }

    public void setSecondRoadId(String str) {
        this.f12747e = str;
    }

    public String getSecondRoadName() {
        return this.f12748f;
    }

    public void setSecondRoadName(String str) {
        this.f12748f = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f12743a);
        parcel.writeString(this.f12744b);
        parcel.writeString(this.f12745c);
        parcel.writeString(this.f12746d);
        parcel.writeString(this.f12747e);
        parcel.writeString(this.f12748f);
    }

    private Crossroad(Parcel parcel) {
        this.f12743a = parcel.readFloat();
        this.f12744b = parcel.readString();
        this.f12745c = parcel.readString();
        this.f12746d = parcel.readString();
        this.f12747e = parcel.readString();
        this.f12748f = parcel.readString();
    }
}
