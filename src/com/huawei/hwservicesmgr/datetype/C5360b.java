package com.huawei.hwservicesmgr.datetype;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DeviceInfo */
final class C5360b implements Creator<DeviceInfo> {
    C5360b() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m25820a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m25821a(i);
    }

    public DeviceInfo[] m25821a(int i) {
        return new DeviceInfo[i];
    }

    public DeviceInfo m25820a(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        String readString3 = parcel.readString();
        DeviceInfo deviceInfo = new DeviceInfo();
        deviceInfo.setDeviceName(readString);
        deviceInfo.setDeviceIdentify(readString2);
        deviceInfo.setDeviceProtocol(readInt);
        deviceInfo.setProductType(readInt2);
        deviceInfo.setDeviceActiveState(readInt3);
        deviceInfo.setDeviceConnectState(readInt4);
        deviceInfo.setEncryptType(readInt5);
        deviceInfo.setDeviceBTType(readInt6);
        deviceInfo.setUUID(readString3);
        return deviceInfo;
    }
}
