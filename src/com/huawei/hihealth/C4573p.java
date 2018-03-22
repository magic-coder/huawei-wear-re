package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiUserInfo */
final class C4573p implements Creator<HiUserInfo> {
    C4573p() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21838a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21839a(i);
    }

    public HiUserInfo m21838a(Parcel parcel) {
        return new HiUserInfo(parcel);
    }

    public HiUserInfo[] m21839a(int i) {
        return new HiUserInfo[i];
    }
}
