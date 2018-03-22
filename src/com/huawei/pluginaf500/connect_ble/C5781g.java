package com.huawei.pluginaf500.connect_ble;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: BleDeviceInfo */
final class C5781g implements Creator<BleDeviceInfo> {
    C5781g() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m26567a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m26568a(i);
    }

    public BleDeviceInfo m26567a(Parcel parcel) {
        return new BleDeviceInfo(parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt());
    }

    public BleDeviceInfo[] m26568a(int i) {
        return new BleDeviceInfo[i];
    }
}
