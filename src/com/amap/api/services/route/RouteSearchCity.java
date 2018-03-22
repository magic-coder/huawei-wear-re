package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class RouteSearchCity extends SearchCity implements Parcelable {
    public static final Creator<RouteSearchCity> CREATOR = new C3486q();
    List<District> f12824a = new ArrayList();

    public List<District> getDistricts() {
        return this.f12824a;
    }

    public void setDistricts(List<District> list) {
        this.f12824a = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f12824a);
    }

    public RouteSearchCity(Parcel parcel) {
        super(parcel);
        this.f12824a = parcel.createTypedArrayList(District.CREATOR);
    }
}
