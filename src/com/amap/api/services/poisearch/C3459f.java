package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Photo */
final class C3459f implements Creator<Photo> {
    C3459f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17090a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17091a(i);
    }

    public Photo m17090a(Parcel parcel) {
        return new Photo(parcel);
    }

    public Photo[] m17091a(int i) {
        return null;
    }
}
