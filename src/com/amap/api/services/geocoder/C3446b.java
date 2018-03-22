package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: GeocodeAddress */
final class C3446b implements Creator<GeocodeAddress> {
    C3446b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17050a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17051a(i);
    }

    public GeocodeAddress[] m17051a(int i) {
        return null;
    }

    public GeocodeAddress m17050a(Parcel parcel) {
        return new GeocodeAddress(parcel);
    }
}
