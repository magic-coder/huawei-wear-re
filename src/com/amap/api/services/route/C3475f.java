package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DrivePath */
final class C3475f implements Creator<DrivePath> {
    C3475f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17131a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17132a(i);
    }

    public DrivePath m17131a(Parcel parcel) {
        return new DrivePath(parcel);
    }

    public DrivePath[] m17132a(int i) {
        return null;
    }
}
