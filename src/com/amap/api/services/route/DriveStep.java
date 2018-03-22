package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class DriveStep implements Parcelable {
    public static final Creator<DriveStep> CREATOR = new C3477h();
    private String f12776a;
    private String f12777b;
    private String f12778c;
    private float f12779d;
    private float f12780e;
    private float f12781f;
    private String f12782g;
    private float f12783h;
    private List<LatLonPoint> f12784i = new ArrayList();
    private String f12785j;
    private String f12786k;
    private List<RouteSearchCity> f12787l = new ArrayList();

    public String getInstruction() {
        return this.f12776a;
    }

    public void setInstruction(String str) {
        this.f12776a = str;
    }

    public String getOrientation() {
        return this.f12777b;
    }

    public void setOrientation(String str) {
        this.f12777b = str;
    }

    public String getRoad() {
        return this.f12778c;
    }

    public void setRoad(String str) {
        this.f12778c = str;
    }

    public float getDistance() {
        return this.f12779d;
    }

    public void setDistance(float f) {
        this.f12779d = f;
    }

    public float getTolls() {
        return this.f12780e;
    }

    public void setTolls(float f) {
        this.f12780e = f;
    }

    public float getTollDistance() {
        return this.f12781f;
    }

    public void setTollDistance(float f) {
        this.f12781f = f;
    }

    public String getTollRoad() {
        return this.f12782g;
    }

    public void setTollRoad(String str) {
        this.f12782g = str;
    }

    public float getDuration() {
        return this.f12783h;
    }

    public void setDuration(float f) {
        this.f12783h = f;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f12784i;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f12784i = list;
    }

    public String getAction() {
        return this.f12785j;
    }

    public void setAction(String str) {
        this.f12785j = str;
    }

    public String getAssistantAction() {
        return this.f12786k;
    }

    public void setAssistantAction(String str) {
        this.f12786k = str;
    }

    public List<RouteSearchCity> getRouteSearchCityList() {
        return this.f12787l;
    }

    public void setRouteSearchCityList(List<RouteSearchCity> list) {
        this.f12787l = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12776a);
        parcel.writeString(this.f12777b);
        parcel.writeString(this.f12778c);
        parcel.writeFloat(this.f12779d);
        parcel.writeFloat(this.f12780e);
        parcel.writeFloat(this.f12781f);
        parcel.writeString(this.f12782g);
        parcel.writeFloat(this.f12783h);
        parcel.writeTypedList(this.f12784i);
        parcel.writeString(this.f12785j);
        parcel.writeString(this.f12786k);
        parcel.writeTypedList(this.f12787l);
    }

    public DriveStep(Parcel parcel) {
        this.f12776a = parcel.readString();
        this.f12777b = parcel.readString();
        this.f12778c = parcel.readString();
        this.f12779d = parcel.readFloat();
        this.f12780e = parcel.readFloat();
        this.f12781f = parcel.readFloat();
        this.f12782g = parcel.readString();
        this.f12783h = parcel.readFloat();
        this.f12784i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f12785j = parcel.readString();
        this.f12786k = parcel.readString();
        this.f12787l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
    }
}
