package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.BusRouteQuery;

/* compiled from: RouteSearch */
final class C3482m implements Creator<BusRouteQuery> {
    C3482m() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17145a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17146a(i);
    }

    public BusRouteQuery m17145a(Parcel parcel) {
        return new BusRouteQuery(parcel);
    }

    public BusRouteQuery[] m17146a(int i) {
        return new BusRouteQuery[i];
    }
}
