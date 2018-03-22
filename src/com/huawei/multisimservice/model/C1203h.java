package com.huawei.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: SimInfo */
final class C1203h implements Creator<SimInfo> {
    C1203h() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5348a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5349a(i);
    }

    public SimInfo[] m5349a(int i) {
        return new SimInfo[i];
    }

    public SimInfo m5348a(Parcel parcel) {
        return new SimInfo(parcel);
    }
}
