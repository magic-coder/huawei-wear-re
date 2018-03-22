package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hwcommonmodel.p064d.C0978h;
import com.huawei.p190v.C2538c;

public class DeviceInfo implements Parcelable {
    public static final Creator<DeviceInfo> CREATOR = new i();
    private static final String TAG = "DeviceInfo";
    private String UUID = "";
    private int mDeviceActiveState = 0;
    private int mDeviceBTType = -1;
    private int mDeviceConnectState = 0;
    private String mDeviceIdentify = "";
    private String mDeviceModelName = "";
    private String mDeviceName = "";
    private int mDeviceProtocol = -1;
    private int mEncryptType = 0;
    private int mProductType = -1;
    private String mfirstConnectTime = "";

    public String getUUID() {
        return (String) C0978h.m3579a(this.UUID);
    }

    public void setUUID(String str) {
        this.UUID = (String) C0978h.m3579a(str);
    }

    public void setDeviceName(String str) {
        this.mDeviceName = (String) C0978h.m3579a(str);
    }

    public String getDeviceName() {
        return (String) C0978h.m3579a(this.mDeviceName);
    }

    public void setDeviceIdentify(String str) {
        this.mDeviceIdentify = (String) C0978h.m3579a(str);
    }

    public String getDeviceIdentify() {
        return (String) C0978h.m3579a(this.mDeviceIdentify);
    }

    public void setDeviceProtocol(int i) {
        this.mDeviceProtocol = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceProtocol() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mDeviceProtocol))).intValue();
    }

    public void setProductType(int i) {
        this.mProductType = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getProductType() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mProductType))).intValue();
    }

    public void setDeviceModel(String str) {
        this.mDeviceModelName = (String) C0978h.m3579a(str);
    }

    public String getDeviceModel() {
        return (String) C0978h.m3579a(this.mDeviceModelName);
    }

    public void setDeviceActiveState(int i) {
        this.mDeviceActiveState = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceActiveState() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mDeviceActiveState))).intValue();
    }

    public void setDeviceConnectState(int i) {
        this.mDeviceConnectState = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceConnectState() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mDeviceConnectState))).intValue();
    }

    public int getEncryptType() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mEncryptType))).intValue();
    }

    public void setEncryptType(int i) {
        this.mEncryptType = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceBTType() {
        return ((Integer) C0978h.m3579a(Integer.valueOf(this.mDeviceBTType))).intValue();
    }

    public void setDeviceBTType(int i) {
        this.mDeviceBTType = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }

    public String getFirstConnectTime() {
        return this.mfirstConnectTime;
    }

    public void setFirstConnectTime(String str) {
        this.mfirstConnectTime = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDeviceName);
        parcel.writeString(this.mDeviceIdentify);
        parcel.writeInt(this.mDeviceProtocol);
        parcel.writeInt(this.mProductType);
        parcel.writeInt(this.mDeviceActiveState);
        parcel.writeInt(this.mDeviceConnectState);
        parcel.writeInt(this.mEncryptType);
        parcel.writeInt(this.mDeviceBTType);
        parcel.writeString(this.UUID);
        parcel.writeString(this.mDeviceModelName);
        parcel.writeString(this.mfirstConnectTime);
    }

    public String toString() {
        return "[mDeviceName = " + this.mDeviceName + ",mProductType = " + this.mProductType + ",mDeviceConnectState = " + this.mDeviceConnectState + "]";
    }

    public void resetDeviceInfo(DeviceInfo deviceInfo, String str) {
        if (deviceInfo != null && str != null) {
            if (deviceInfo.getDeviceIdentify().equalsIgnoreCase(str)) {
                deviceInfo.setDeviceActiveState(1);
                C2538c.m12677c(TAG, "更新DeviceActiveState为enable,设备为：" + deviceInfo.getDeviceIdentify() + ",name = " + deviceInfo.getDeviceName());
                return;
            }
            deviceInfo.setDeviceActiveState(0);
            C2538c.m12677c(TAG, "更新DeviceActiveState为disable,设备为：" + deviceInfo.getDeviceIdentify() + ",name = " + deviceInfo.getDeviceName());
        }
    }

    public void initDeviceInfo1() {
    }

    public void initDeviceInfo2() {
    }

    public void initDeviceInfo3() {
    }

    public void initDeviceInfo4() {
    }

    public void initDeviceInfo5() {
    }

    public void initDeviceInfo6() {
    }

    public void initDeviceInfo7() {
    }

    public void initDeviceInfo8() {
    }

    public void initDeviceInfo9() {
    }

    public void initDeviceInfo10() {
    }

    public void initDeviceInfo11() {
    }

    public void initDeviceInfo12() {
    }

    public void initDeviceInfo13() {
    }

    public void initDeviceInfo14() {
    }

    public void initDeviceInfo15() {
    }

    public void configureDeviceIdentify(String str) {
        this.mDeviceIdentify = (String) C0978h.m3579a(str);
    }

    public void configureDeviceName(String str) {
        this.mDeviceName = (String) C0978h.m3579a(str);
    }

    public void configureDeviceBTType(int i) {
        this.mDeviceBTType = ((Integer) C0978h.m3579a(Integer.valueOf(i))).intValue();
    }
}
