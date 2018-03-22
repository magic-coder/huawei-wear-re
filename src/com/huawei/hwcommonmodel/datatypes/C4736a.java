package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: CoreSleepDataInfo */
final class C4736a implements Creator<CoreSleepDataInfo> {
    C4736a() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m22652a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m22653a(i);
    }

    public CoreSleepDataInfo m22652a(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        CoreSleepDataInfo coreSleepDataInfo = new CoreSleepDataInfo();
        coreSleepDataInfo.setInfo(createByteArray);
        return coreSleepDataInfo;
    }

    public CoreSleepDataInfo[] m22653a(int i) {
        return new CoreSleepDataInfo[i];
    }
}
