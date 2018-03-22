package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiAccountInfo */
final class C4535a implements Creator<HiAccountInfo> {
    C4535a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21644a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21645a(i);
    }

    public HiAccountInfo m21644a(Parcel parcel) {
        return new HiAccountInfo(parcel);
    }

    public HiAccountInfo[] m21645a(int i) {
        return new HiAccountInfo[i];
    }
}
