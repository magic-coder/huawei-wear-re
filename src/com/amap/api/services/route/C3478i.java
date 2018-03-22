package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: Path */
final class C3478i implements Creator<Path> {
    C3478i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17137a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17138a(i);
    }

    public Path m17137a(Parcel parcel) {
        return new Path(parcel);
    }

    public Path[] m17138a(int i) {
        return null;
    }
}
