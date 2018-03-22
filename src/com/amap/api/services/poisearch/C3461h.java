package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: PoiItemDetail */
final class C3461h implements Creator<PoiItemDetail> {
    C3461h() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17093a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17094a(i);
    }

    public PoiItemDetail m17093a(Parcel parcel) {
        return new PoiItemDetail(parcel);
    }

    public PoiItemDetail[] m17094a(int i) {
        return new PoiItemDetail[i];
    }
}
