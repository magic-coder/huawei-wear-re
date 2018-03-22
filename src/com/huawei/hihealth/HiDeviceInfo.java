package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiDeviceInfo implements Parcelable {
    public static final Creator<HiDeviceInfo> CREATOR = new C4565h();
    private int deviceID;
    private String deviceMac;
    private String deviceName;
    private String deviceSN;
    private int deviceType = 1;
    private String deviceUniqueCode;
    private String firmwareVersion;
    private String hardwareVersion;
    private String manufacturer;
    private String model;
    private int priority;
    private String softwareVersion;

    protected HiDeviceInfo(Parcel parcel) {
        this.deviceID = parcel.readInt();
        this.deviceUniqueCode = parcel.readString();
        this.deviceName = parcel.readString();
        this.deviceType = parcel.readInt();
        this.firmwareVersion = parcel.readString();
        this.hardwareVersion = parcel.readString();
        this.softwareVersion = parcel.readString();
        this.manufacturer = parcel.readString();
        this.model = parcel.readString();
        this.deviceSN = parcel.readString();
        this.deviceMac = parcel.readString();
        this.priority = parcel.readInt();
    }

    public int getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(int i) {
        this.deviceID = i;
    }

    public String getDeviceUniqueCode() {
        return this.deviceUniqueCode;
    }

    public void setDeviceUniqueCode(String str) {
        this.deviceUniqueCode = str;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        if (i >= 1) {
            this.deviceType = i;
        }
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public void setFirmwareVersion(String str) {
        this.firmwareVersion = str;
    }

    public String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public void setHardwareVersion(String str) {
        this.hardwareVersion = str;
    }

    public String getSoftwareVersion() {
        return this.softwareVersion;
    }

    public void setSoftwareVersion(String str) {
        this.softwareVersion = str;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String str) {
        this.manufacturer = str;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public String getDeviceSN() {
        return this.deviceSN;
    }

    public void setDeviceSN(String str) {
        this.deviceSN = str;
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiDeviceInfo{");
        stringBuffer.append(", deviceName='").append(this.deviceName).append('\'');
        stringBuffer.append(", deviceType=").append(this.deviceType);
        stringBuffer.append(", priority=").append(this.priority);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.deviceID);
        parcel.writeString(this.deviceUniqueCode);
        parcel.writeString(this.deviceName);
        parcel.writeInt(this.deviceType);
        parcel.writeString(this.firmwareVersion);
        parcel.writeString(this.hardwareVersion);
        parcel.writeString(this.softwareVersion);
        parcel.writeString(this.manufacturer);
        parcel.writeString(this.model);
        parcel.writeString(this.deviceSN);
        parcel.writeString(this.deviceMac);
        parcel.writeInt(this.priority);
    }
}
