package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.WalkRouteQuery;

/* compiled from: RouteSearch */
final class C3485p implements Creator<WalkRouteQuery> {
    C3485p() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17151a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17152a(i);
    }

    public WalkRouteQuery m17151a(Parcel parcel) {
        return new WalkRouteQuery(parcel);
    }

    public WalkRouteQuery[] m17152a(int i) {
        return new WalkRouteQuery[i];
    }
}
