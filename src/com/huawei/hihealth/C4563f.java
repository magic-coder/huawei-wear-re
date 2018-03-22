package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiDataReadOption */
final class C4563f implements Creator<HiDataReadOption> {
    C4563f() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21818a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21819a(i);
    }

    public HiDataReadOption m21818a(Parcel parcel) {
        return new HiDataReadOption(parcel);
    }

    public HiDataReadOption[] m21819a(int i) {
        return new HiDataReadOption[i];
    }
}
