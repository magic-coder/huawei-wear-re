package com.amap.api.services.road;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Road */
final class C3466b implements Creator<Road> {
    C3466b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17117a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17118a(i);
    }

    public Road m17117a(Parcel parcel) {
        return new Road(parcel);
    }

    public Road[] m17118a(int i) {
        return null;
    }
}
