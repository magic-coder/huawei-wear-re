package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DriveRouteResult */
final class C3476g implements Creator<DriveRouteResult> {
    C3476g() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17133a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17134a(i);
    }

    public DriveRouteResult m17133a(Parcel parcel) {
        return new DriveRouteResult(parcel);
    }

    public DriveRouteResult[] m17134a(int i) {
        return new DriveRouteResult[i];
    }
}
