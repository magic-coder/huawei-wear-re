package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WalkPath */
final class C3488s implements Creator<WalkPath> {
    C3488s() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17157a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17158a(i);
    }

    public WalkPath m17157a(Parcel parcel) {
        return new WalkPath(parcel);
    }

    public WalkPath[] m17158a(int i) {
        return null;
    }
}
