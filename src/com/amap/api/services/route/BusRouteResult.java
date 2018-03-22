package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;
import java.util.ArrayList;
import java.util.List;

public class BusRouteResult extends RouteResult implements Parcelable {
    public static final Creator<BusRouteResult> CREATOR = new C3471b();
    private float f12758a;
    private List<BusPath> f12759b = new ArrayList();
    private BusRouteQuery f12760c;

    public float getTaxiCost() {
        return this.f12758a;
    }

    public void setTaxiCost(float f) {
        this.f12758a = f;
    }

    public List<BusPath> getPaths() {
        return this.f12759b;
    }

    public void setPaths(List<BusPath> list) {
        this.f12759b = list;
    }

    public BusRouteQuery getBusQuery() {
        return this.f12760c;
    }

    public void setBusQuery(BusRouteQuery busRouteQuery) {
        this.f12760c = busRouteQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f12758a);
        parcel.writeTypedList(this.f12759b);
        parcel.writeParcelable(this.f12760c, i);
    }

    public BusRouteResult(Parcel parcel) {
        super(parcel);
        this.f12758a = parcel.readFloat();
        this.f12759b = parcel.createTypedArrayList(BusPath.CREATOR);
        this.f12760c = (BusRouteQuery) parcel.readParcelable(BusRouteQuery.class.getClassLoader());
    }
}
