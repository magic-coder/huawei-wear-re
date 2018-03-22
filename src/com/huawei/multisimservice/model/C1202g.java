package com.huawei.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: MultiSimDeviceInfo */
final class C1202g implements Creator<MultiSimDeviceInfo> {
    C1202g() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5346a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5347a(i);
    }

    public MultiSimDeviceInfo m5346a(Parcel parcel) {
        return new MultiSimDeviceInfo(parcel);
    }

    public MultiSimDeviceInfo[] m5347a(int i) {
        return new MultiSimDeviceInfo[i];
    }
}
