package com.amap.api.services.core;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PoiItem */
final class C3429q implements Creator<PoiItem> {
    C3429q() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16977a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16978a(i);
    }

    public PoiItem m16977a(Parcel parcel) {
        return new PoiItem(parcel);
    }

    public PoiItem[] m16978a(int i) {
        return new PoiItem[i];
    }
}
