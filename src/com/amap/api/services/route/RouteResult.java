package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class RouteResult implements Parcelable {
    public static final Creator<RouteResult> CREATOR = new C3481l();
    private LatLonPoint f12756a;
    private LatLonPoint f12757b;

    public LatLonPoint getStartPos() {
        return this.f12756a;
    }

    public void setStartPos(LatLonPoint latLonPoint) {
        this.f12756a = latLonPoint;
    }

    public LatLonPoint getTargetPos() {
        return this.f12757b;
    }

    public void setTargetPos(LatLonPoint latLonPoint) {
        this.f12757b = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12756a, i);
        parcel.writeParcelable(this.f12757b, i);
    }

    public RouteResult(Parcel parcel) {
        this.f12756a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f12757b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
