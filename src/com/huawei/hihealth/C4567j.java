package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiHealthClient */
final class C4567j implements Creator<HiHealthClient> {
    C4567j() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21826a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21827a(i);
    }

    public HiHealthClient m21826a(Parcel parcel) {
        return new HiHealthClient(parcel);
    }

    public HiHealthClient[] m21827a(int i) {
        return new HiHealthClient[i];
    }
}
