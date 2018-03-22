package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: DeviceInfo */
final class C4742i implements Creator<DeviceInfo> {
    C4742i() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m22684a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m22685a(i);
    }

    public DeviceInfo[] m22685a(int i) {
        return new DeviceInfo[i];
    }

    public DeviceInfo m22684a(Parcel parcel) {
        String readString = parcel.readString();
        String readString2 = parcel.readString();
        int readInt = parcel.readInt();
        int readInt2 = parcel.readInt();
        int readInt3 = parcel.readInt();
        int readInt4 = parcel.readInt();
        int readInt5 = parcel.readInt();
        int readInt6 = parcel.readInt();
        String readString3 = parcel.readString();
        String readString4 = parcel.readString();
        String readString5 = parcel.readString();
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
        deviceInfo.setDeviceModel(readString4);
        deviceInfo.setFirstConnectTime(readString5);
        return deviceInfo;
    }
}
