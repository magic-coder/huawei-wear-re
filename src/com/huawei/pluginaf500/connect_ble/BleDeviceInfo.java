package com.huawei.pluginaf500.connect_ble;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BleDeviceInfo implements Parcelable {
    public static final Creator<BleDeviceInfo> CREATOR = new C5781g();
    public static final int DEVICE_TYPE_BLE = 2;
    public static final int DEVICE_TYPE_CLASSIC = 1;
    public static final int DEVICE_TYPE_UNKNOWN = 0;
    public String address;
    public String deviceName;
    public int rssi;
    public int type;

    public BleDeviceInfo(String str, String str2, int i, int i2) {
        this.deviceName = str;
        this.address = str2;
        this.rssi = i2;
        this.type = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceName);
        parcel.writeString(this.address);
        parcel.writeInt(this.type);
        parcel.writeInt(this.rssi);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{deviceType: " + this.type);
        stringBuilder.append(" name: " + this.deviceName);
        stringBuilder.append(" address: " + this.address);
        stringBuilder.append(" rssi: " + this.rssi);
        return stringBuilder.toString();
    }
}
