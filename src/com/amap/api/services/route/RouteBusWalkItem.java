package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;

public class RouteBusWalkItem extends WalkPath implements Parcelable {
    public static final Creator<RouteBusWalkItem> CREATOR = new C3480k();
    private LatLonPoint f12795a;
    private LatLonPoint f12796b;

    public LatLonPoint getOrigin() {
        return this.f12795a;
    }

    public void setOrigin(LatLonPoint latLonPoint) {
        this.f12795a = latLonPoint;
    }

    public LatLonPoint getDestination() {
        return this.f12796b;
    }

    public void setDestination(LatLonPoint latLonPoint) {
        this.f12796b = latLonPoint;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f12795a, i);
        parcel.writeParcelable(this.f12796b, i);
    }

    public RouteBusWalkItem(Parcel parcel) {
        super(parcel);
        this.f12795a = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f12796b = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
    }
}
