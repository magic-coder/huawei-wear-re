package com.huawei.hwservicesmgr.datetype;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.p064d.C0978h;

public class DeviceInfo implements Parcelable {
    public static final Creator<DeviceInfo> CREATOR = new C5360b();
    private String UUID = "";
    private int mDeviceActiveState = 0;
    private int mDeviceBTType = -1;
    private int mDeviceConnectState = 0;
    private String mDeviceIdentify = "";
    private String mDeviceName = "";
    private int mDeviceProtocol = -1;
    private int mEncryptType = 0;
    private int mProductType = -1;

    public String getUUID() {
        return (String) C0978h.a(this.UUID);
    }

    public void setUUID(String str) {
        this.UUID = (String) C0978h.a(str);
    }

    public void setDeviceName(String str) {
        this.mDeviceName = (String) C0978h.a(str);
    }

    public String getDeviceName() {
        return (String) C0978h.a(this.mDeviceName);
    }

    public void setDeviceIdentify(String str) {
        this.mDeviceIdentify = (String) C0978h.a(str);
    }

    public String getDeviceIdentify() {
        return (String) C0978h.a(this.mDeviceIdentify);
    }

    public void setDeviceProtocol(int i) {
        this.mDeviceProtocol = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceProtocol() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mDeviceProtocol))).intValue();
    }

    public void setProductType(int i) {
        this.mProductType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getProductType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mProductType))).intValue();
    }

    public void setDeviceActiveState(int i) {
        this.mDeviceActiveState = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceActiveState() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mDeviceActiveState))).intValue();
    }

    public void setDeviceConnectState(int i) {
        this.mDeviceConnectState = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceConnectState() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mDeviceConnectState))).intValue();
    }

    public int getEncryptType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mEncryptType))).intValue();
    }

    public void setEncryptType(int i) {
        this.mEncryptType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int getDeviceBTType() {
        return ((Integer) C0978h.a(Integer.valueOf(this.mDeviceBTType))).intValue();
    }

    public void setDeviceBTType(int i) {
        this.mDeviceBTType = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
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
    }

    public String toString() {
        return "[mDeviceName = " + this.mDeviceName + ",mProductType = " + this.mProductType + ",mDeviceConnectState = " + this.mDeviceConnectState + "]";
    }

    public void procDeviceInfo1() {
    }

    public void procDeviceInfo2() {
    }

    public void procDeviceInfo3() {
    }

    public void procDeviceInfo4() {
    }

    public void procDeviceInfo5() {
    }

    public void procDeviceInfo6() {
    }

    public void procDeviceInfo7() {
    }

    public void procDeviceInfo8() {
    }

    public void procDeviceInfo9() {
    }

    public void procDeviceInfo10() {
    }

    public void procDeviceInfo11() {
    }
}
