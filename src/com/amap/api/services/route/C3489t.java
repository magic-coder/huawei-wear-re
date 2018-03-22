package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WalkRouteResult */
final class C3489t implements Creator<WalkRouteResult> {
    C3489t() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17159a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17160a(i);
    }

    public WalkRouteResult m17159a(Parcel parcel) {
        return new WalkRouteResult(parcel);
    }

    public WalkRouteResult[] m17160a(int i) {
        return new WalkRouteResult[i];
    }
}
