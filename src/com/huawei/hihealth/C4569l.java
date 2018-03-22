package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiHealthUnit */
final class C4569l implements Creator<HiHealthUnit> {
    C4569l() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21830a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21831a(i);
    }

    public HiHealthUnit m21830a(Parcel parcel) {
        return new HiHealthUnit(parcel);
    }

    public HiHealthUnit[] m21831a(int i) {
        return new HiHealthUnit[i];
    }
}
