package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiHealthData */
final class C4568k implements Creator<HiHealthData> {
    C4568k() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21828a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21829a(i);
    }

    public HiHealthData m21828a(Parcel parcel) {
        return new HiHealthData(parcel);
    }

    public HiHealthData[] m21829a(int i) {
        return new HiHealthData[i];
    }
}
