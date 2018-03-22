package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;
import java.util.ArrayList;
import java.util.List;

public class DriveRouteResult extends RouteResult implements Parcelable {
    public static final Creator<DriveRouteResult> CREATOR = new C3476g();
    private float f12773a;
    private List<DrivePath> f12774b = new ArrayList();
    private DriveRouteQuery f12775c;

    public float getTaxiCost() {
        return this.f12773a;
    }

    public void setTaxiCost(float f) {
        this.f12773a = f;
    }

    public List<DrivePath> getPaths() {
        return this.f12774b;
    }

    public void setPaths(List<DrivePath> list) {
        this.f12774b = list;
    }

    public DriveRouteQuery getDriveQuery() {
        return this.f12775c;
    }

    public void setDriveQuery(DriveRouteQuery driveRouteQuery) {
        this.f12775c = driveRouteQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f12773a);
        parcel.writeTypedList(this.f12774b);
        parcel.writeParcelable(this.f12775c, i);
    }

    public DriveRouteResult(Parcel parcel) {
        super(parcel);
        this.f12773a = parcel.readFloat();
        this.f12774b = parcel.createTypedArrayList(DrivePath.CREATOR);
        this.f12775c = (DriveRouteQuery) parcel.readParcelable(DriveRouteQuery.class.getClassLoader());
    }
}
