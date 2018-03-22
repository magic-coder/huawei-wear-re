package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiSubscribeTrigger */
final class C4570m implements Creator<HiSubscribeTrigger> {
    C4570m() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21832a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21833a(i);
    }

    public HiSubscribeTrigger m21832a(Parcel parcel) {
        return new HiSubscribeTrigger(parcel);
    }

    public HiSubscribeTrigger[] m21833a(int i) {
        return new HiSubscribeTrigger[i];
    }
}
