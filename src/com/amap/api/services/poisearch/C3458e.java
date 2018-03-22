package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Hotel */
final class C3458e implements Creator<Hotel> {
    C3458e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17088a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17089a(i);
    }

    public Hotel m17088a(Parcel parcel) {
        return new Hotel(parcel);
    }

    public Hotel[] m17089a(int i) {
        return null;
    }
}
