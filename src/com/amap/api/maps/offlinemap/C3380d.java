package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Province */
final class C3380d implements Creator<Province> {
    C3380d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16495a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16496a(i);
    }

    public Province m16495a(Parcel parcel) {
        return new Province(parcel);
    }

    public Province[] m16496a(int i) {
        return new Province[i];
    }
}
