package com.amap.api.location.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: GeoPoint */
final class C3194f implements Creator<GeoPoint> {
    C3194f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m14161a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m14162a(i);
    }

    public GeoPoint m14161a(Parcel parcel) {
        return new GeoPoint(parcel);
    }

    public GeoPoint[] m14162a(int i) {
        return new GeoPoint[i];
    }
}
