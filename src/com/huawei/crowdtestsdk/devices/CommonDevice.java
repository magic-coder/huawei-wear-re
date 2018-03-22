package com.huawei.crowdtestsdk.devices;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CommonDevice implements Parcelable {
    public static final Creator<CommonDevice> CREATOR = new C06811();
    private DeviceHelper deviceHelper;
    private String deviceId;
    private String productName;
    private String versionName;

    final class C06811 implements Creator<CommonDevice> {
        C06811() {
        }

        public CommonDevice createFromParcel(Parcel parcel) {
            return new CommonDevice(parcel);
        }

        public CommonDevice[] newArray(int i) {
            return new CommonDevice[i];
        }
    }

    public CommonDevice(DeviceHelper deviceHelper) {
        this.deviceHelper = deviceHelper;
    }

    public DeviceHelper getDeviceHelper() {
        return this.deviceHelper;
    }

    protected CommonDevice(Parcel parcel) {
        this.productName = parcel.readString();
        this.versionName = parcel.readString();
        this.deviceId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.productName);
        parcel.writeString(this.versionName);
        parcel.writeString(this.deviceId);
    }

    public String getProductName() {
        return this.productName;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setVersionName(String str) {
        this.versionName = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }
}
