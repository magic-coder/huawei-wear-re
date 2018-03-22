package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusStationItem */
final class C3386b implements Creator<BusStationItem> {
    C3386b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16560a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16561a(i);
    }

    public BusStationItem m16560a(Parcel parcel) {
        return new BusStationItem(parcel);
    }

    public BusStationItem[] m16561a(int i) {
        return null;
    }
}
