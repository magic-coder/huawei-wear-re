package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiGoalInfo */
final class C4566i implements Creator<HiGoalInfo> {
    C4566i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21824a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21825a(i);
    }

    public HiGoalInfo m21824a(Parcel parcel) {
        return new HiGoalInfo(parcel);
    }

    public HiGoalInfo[] m21825a(int i) {
        return new HiGoalInfo[i];
    }
}
