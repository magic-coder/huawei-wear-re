package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;
import java.util.ArrayList;
import java.util.List;

public class WalkRouteResult extends RouteResult implements Parcelable {
    public static final Creator<WalkRouteResult> CREATOR = new C3489t();
    private List<WalkPath> f12825a = new ArrayList();
    private WalkRouteQuery f12826b;

    public List<WalkPath> getPaths() {
        return this.f12825a;
    }

    public void setPaths(List<WalkPath> list) {
        this.f12825a = list;
    }

    public WalkRouteQuery getWalkQuery() {
        return this.f12826b;
    }

    public void setWalkQuery(WalkRouteQuery walkRouteQuery) {
        this.f12826b = walkRouteQuery;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeTypedList(this.f12825a);
        parcel.writeParcelable(this.f12826b, i);
    }

    public WalkRouteResult(Parcel parcel) {
        super(parcel);
        this.f12825a = parcel.createTypedArrayList(WalkPath.CREATOR);
        this.f12826b = (WalkRouteQuery) parcel.readParcelable(WalkRouteQuery.class.getClassLoader());
    }
}
