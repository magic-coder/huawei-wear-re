package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RouteBusWalkItem */
final class C3480k implements Creator<RouteBusWalkItem> {
    C3480k() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17141a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17142a(i);
    }

    public RouteBusWalkItem m17141a(Parcel parcel) {
        return new RouteBusWalkItem(parcel);
    }

    public RouteBusWalkItem[] m17142a(int i) {
        return null;
    }
}
