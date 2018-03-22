package com.huawei.crowdtestsdk.bases;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class FeedbackParams implements Parcelable {
    public static final Creator<FeedbackParams> CREATOR = new C06761();
    private String deviceId;
    private String hardwareVersion;
    private String productName;
    private String productVersion;
    private String routerBrand;

    final class C06761 implements Creator<FeedbackParams> {
        C06761() {
        }

        public FeedbackParams createFromParcel(Parcel parcel) {
            return new FeedbackParams(parcel);
        }

        public FeedbackParams[] newArray(int i) {
            return new FeedbackParams[i];
        }
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getProductName() {
        return this.productName;
    }

    public String getProductVersion() {
        return this.productVersion;
    }

    public String getRouterBrand() {
        return this.routerBrand;
    }

    public String getHardwareVersion() {
        return this.hardwareVersion;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setProductName(String str) {
        this.productName = str;
    }

    public void setProductVersion(String str) {
        this.productVersion = str;
    }

    public void setRouterBrand(String str) {
        this.routerBrand = str;
    }

    public void setHardwareVersion(String str) {
        this.hardwareVersion = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.deviceId);
        parcel.writeString(this.productName);
        parcel.writeString(this.productVersion);
        parcel.writeString(this.routerBrand);
        parcel.writeString(this.hardwareVersion);
    }

    protected FeedbackParams(Parcel parcel) {
        this.deviceId = parcel.readString();
        this.productName = parcel.readString();
        this.productVersion = parcel.readString();
        this.routerBrand = parcel.readString();
        this.hardwareVersion = parcel.readString();
    }
}
