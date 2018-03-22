package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: RegeocodeAddress */
final class C3447c implements Creator<RegeocodeAddress> {
    C3447c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17052a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17053a(i);
    }

    public RegeocodeAddress m17052a(Parcel parcel) {
        return new RegeocodeAddress(parcel);
    }

    public RegeocodeAddress[] m17053a(int i) {
        return null;
    }
}
