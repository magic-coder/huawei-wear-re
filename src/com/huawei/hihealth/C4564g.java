package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiDataUpdateOption */
final class C4564g implements Creator<HiDataUpdateOption> {
    C4564g() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21820a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21821a(i);
    }

    public HiDataUpdateOption m21820a(Parcel parcel) {
        return new HiDataUpdateOption(parcel);
    }

    public HiDataUpdateOption[] m21821a(int i) {
        return new HiDataUpdateOption[i];
    }
}
