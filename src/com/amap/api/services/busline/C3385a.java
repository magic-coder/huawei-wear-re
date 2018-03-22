package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusLineItem */
final class C3385a implements Creator<BusLineItem> {
    C3385a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16558a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16559a(i);
    }

    public BusLineItem m16558a(Parcel parcel) {
        return new BusLineItem(parcel);
    }

    public BusLineItem[] m16559a(int i) {
        return null;
    }
}
