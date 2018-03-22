package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiDataDeleteOption */
final class C4547d implements Creator<HiDataDeleteOption> {
    C4547d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21794a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21795a(i);
    }

    public HiDataDeleteOption m21794a(Parcel parcel) {
        return new HiDataDeleteOption(parcel);
    }

    public HiDataDeleteOption[] m21795a(int i) {
        return new HiDataDeleteOption[i];
    }
}
