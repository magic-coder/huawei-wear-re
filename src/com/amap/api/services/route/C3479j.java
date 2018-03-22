package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RouteBusLineItem */
final class C3479j implements Creator<RouteBusLineItem> {
    C3479j() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17139a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17140a(i);
    }

    public RouteBusLineItem m17139a(Parcel parcel) {
        return new RouteBusLineItem(parcel);
    }

    public RouteBusLineItem[] m17140a(int i) {
        return null;
    }
}
