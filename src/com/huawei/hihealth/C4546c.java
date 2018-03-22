package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiAppInfo */
final class C4546c implements Creator<HiAppInfo> {
    C4546c() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21792a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21793a(i);
    }

    public HiAppInfo m21792a(Parcel parcel) {
        return new HiAppInfo(parcel);
    }

    public HiAppInfo[] m21793a(int i) {
        return new HiAppInfo[i];
    }
}
