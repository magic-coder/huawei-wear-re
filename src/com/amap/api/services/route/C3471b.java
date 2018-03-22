package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusRouteResult */
final class C3471b implements Creator<BusRouteResult> {
    C3471b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17123a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17124a(i);
    }

    public BusRouteResult m17123a(Parcel parcel) {
        return new BusRouteResult(parcel);
    }

    public BusRouteResult[] m17124a(int i) {
        return new BusRouteResult[i];
    }
}
