package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: City */
final class C3377a implements Creator<City> {
    C3377a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16489a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16490a(i);
    }

    public City m16489a(Parcel parcel) {
        return new City(parcel);
    }

    public City[] m16490a(int i) {
        return new City[i];
    }
}
