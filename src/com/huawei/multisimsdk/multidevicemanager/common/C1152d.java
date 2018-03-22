package com.huawei.multisimsdk.multidevicemanager.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: InProgressData */
final class C1152d implements Creator<InProgressData> {
    C1152d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m5132a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m5133a(i);
    }

    public InProgressData m5132a(Parcel parcel) {
        return new InProgressData(parcel);
    }

    public InProgressData[] m5133a(int i) {
        return new InProgressData[i];
    }
}
