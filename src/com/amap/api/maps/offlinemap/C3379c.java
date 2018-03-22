package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: OfflineMapProvince */
final class C3379c implements Creator<OfflineMapProvince> {
    C3379c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16493a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16494a(i);
    }

    public OfflineMapProvince m16493a(Parcel parcel) {
        return new OfflineMapProvince(parcel);
    }

    public OfflineMapProvince[] m16494a(int i) {
        return new OfflineMapProvince[i];
    }
}
