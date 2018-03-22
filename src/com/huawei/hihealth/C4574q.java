package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiUserPreference */
final class C4574q implements Creator<HiUserPreference> {
    C4574q() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21840a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21841a(i);
    }

    public HiUserPreference m21840a(Parcel parcel) {
        return new HiUserPreference(parcel);
    }

    public HiUserPreference[] m21841a(int i) {
        return new HiUserPreference[i];
    }
}
