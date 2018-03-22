package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RouteResult */
final class C3481l implements Creator<RouteResult> {
    C3481l() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17143a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17144a(i);
    }

    public RouteResult m17143a(Parcel parcel) {
        return new RouteResult(parcel);
    }

    public RouteResult[] m17144a(int i) {
        return new RouteResult[i];
    }
}
