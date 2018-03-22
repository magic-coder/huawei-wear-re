package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiSyncOption */
final class C4571n implements Creator<HiSyncOption> {
    C4571n() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21834a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21835a(i);
    }

    public HiSyncOption m21834a(Parcel parcel) {
        return new HiSyncOption(parcel);
    }

    public HiSyncOption[] m21835a(int i) {
        return new HiSyncOption[i];
    }
}
