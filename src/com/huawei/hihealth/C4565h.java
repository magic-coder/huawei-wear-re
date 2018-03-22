package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiDeviceInfo */
final class C4565h implements Creator<HiDeviceInfo> {
    C4565h() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21822a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21823a(i);
    }

    public HiDeviceInfo m21822a(Parcel parcel) {
        return new HiDeviceInfo(parcel);
    }

    public HiDeviceInfo[] m21823a(int i) {
        return new HiDeviceInfo[i];
    }
}
