package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: LatLonPoint */
final class C3416k implements Creator<LatLonPoint> {
    C3416k() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16956a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16957a(i);
    }

    public LatLonPoint m16956a(Parcel parcel) {
        return new LatLonPoint(parcel);
    }

    public LatLonPoint[] m16957a(int i) {
        return new LatLonPoint[i];
    }
}
