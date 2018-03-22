package com.huawei.hihealth.data.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: HiTrackMetaData */
final class C4561a implements Creator<HiTrackMetaData> {
    C4561a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m21814a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m21815a(i);
    }

    public HiTrackMetaData m21814a(Parcel parcel) {
        return new HiTrackMetaData(parcel);
    }

    public HiTrackMetaData[] m21815a(int i) {
        return new HiTrackMetaData[i];
    }
}
