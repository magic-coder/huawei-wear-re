package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiTimeInterval */
final class C4572o implements Creator<HiTimeInterval> {
    C4572o() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21836a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21837a(i);
    }

    public HiTimeInterval m21836a(Parcel parcel) {
        return new HiTimeInterval(parcel);
    }

    public HiTimeInterval[] m21837a(int i) {
        return new HiTimeInterval[i];
    }
}
