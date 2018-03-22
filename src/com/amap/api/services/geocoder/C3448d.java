package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RegeocodeRoad */
final class C3448d implements Creator<RegeocodeRoad> {
    C3448d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17054a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17055a(i);
    }

    public RegeocodeRoad m17054a(Parcel parcel) {
        return new RegeocodeRoad(parcel);
    }

    public RegeocodeRoad[] m17055a(int i) {
        return null;
    }
}
