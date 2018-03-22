package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Cinema */
final class C3454a implements Creator<Cinema> {
    C3454a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17080a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17081a(i);
    }

    public Cinema m17080a(Parcel parcel) {
        return new Cinema(parcel);
    }

    public Cinema[] m17081a(int i) {
        return null;
    }
}
