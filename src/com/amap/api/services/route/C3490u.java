package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: WalkStep */
final class C3490u implements Creator<WalkStep> {
    C3490u() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m17161a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m17162a(i);
    }

    public WalkStep m17161a(Parcel parcel) {
        return new WalkStep(parcel);
    }

    public WalkStep[] m17162a(int i) {
        return null;
    }
}
