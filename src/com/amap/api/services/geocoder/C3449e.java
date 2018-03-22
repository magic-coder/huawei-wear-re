package com.amap.api.services.geocoder;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: StreetNumber */
final class C3449e implements Creator<StreetNumber> {
    C3449e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17056a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17057a(i);
    }

    public StreetNumber m17056a(Parcel parcel) {
        return new StreetNumber(parcel);
    }

    public StreetNumber[] m17057a(int i) {
        return null;
    }
}
