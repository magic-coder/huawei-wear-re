package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiAggregateOption */
final class C4538b implements Creator<HiAggregateOption> {
    C4538b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21743a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21744a(i);
    }

    public HiAggregateOption m21743a(Parcel parcel) {
        return new HiAggregateOption(parcel);
    }

    public HiAggregateOption[] m21744a(int i) {
        return new HiAggregateOption[i];
    }
}
