package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiDataInsertOption */
final class C4562e implements Creator<HiDataInsertOption> {
    C4562e() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21816a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21817a(i);
    }

    public HiDataInsertOption m21816a(Parcel parcel) {
        return new HiDataInsertOption(parcel);
    }

    public HiDataInsertOption[] m21817a(int i) {
        return new HiDataInsertOption[i];
    }
}
