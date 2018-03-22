package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BusStep */
final class C3472c implements Creator<BusStep> {
    C3472c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17125a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17126a(i);
    }

    public BusStep m17125a(Parcel parcel) {
        return new BusStep(parcel);
    }

    public BusStep[] m17126a(int i) {
        return null;
    }
}
