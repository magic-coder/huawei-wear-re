package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.amap.api.services.route.RouteSearch.DriveRouteQuery;

/* compiled from: RouteSearch */
final class C3483n implements Creator<DriveRouteQuery> {
    C3483n() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17147a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17148a(i);
    }

    public DriveRouteQuery m17147a(Parcel parcel) {
        return new DriveRouteQuery(parcel);
    }

    public DriveRouteQuery[] m17148a(int i) {
        return new DriveRouteQuery[i];
    }
}
