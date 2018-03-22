package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusPath */
final class C3470a implements Creator<BusPath> {
    C3470a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17121a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17122a(i);
    }

    public BusPath m17121a(Parcel parcel) {
        return new BusPath(parcel);
    }

    public BusPath[] m17122a(int i) {
        return null;
    }
}
