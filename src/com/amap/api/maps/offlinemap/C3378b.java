package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: OfflineMapCity */
final class C3378b implements Creator<OfflineMapCity> {
    C3378b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16491a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16492a(i);
    }

    public OfflineMapCity m16491a(Parcel parcel) {
        return new OfflineMapCity(parcel);
    }

    public OfflineMapCity[] m16492a(int i) {
        return new OfflineMapCity[i];
    }
}
