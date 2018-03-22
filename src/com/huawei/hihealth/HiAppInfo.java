package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiAppInfo implements Parcelable {
    public static final Creator<HiAppInfo> CREATOR = new C4546c();
    private int appID;
    private String appName;
    private long cloudCode;
    private String packageName;
    private String signature;
    private String version;

    protected HiAppInfo(Parcel parcel) {
        this.appID = parcel.readInt();
        this.packageName = parcel.readString();
        this.appName = parcel.readString();
        this.version = parcel.readString();
        this.signature = parcel.readString();
        this.cloudCode = parcel.readLong();
    }

    public int getAppID() {
        return this.appID;
    }

    public void setAppID(int i) {
        this.appID = i;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String getAppName() {
        return this.appName;
    }

    public void setAppName(String str) {
        this.appName = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }

    public long getCloudCode() {
        return this.cloudCode;
    }

    public void setCloudCode(long j) {
        this.cloudCode = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiAppInfo{");
        stringBuffer.append("app=").append(this.appID);
        stringBuffer.append(", packageName='").append(this.packageName).append('\'');
        stringBuffer.append(", appName='").append(this.appName).append('\'');
        stringBuffer.append(", version='").append(this.version).append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.appID);
        parcel.writeString(this.packageName);
        parcel.writeString(this.appName);
        parcel.writeString(this.version);
        parcel.writeString(this.signature);
        parcel.writeLong(this.cloudCode);
    }
}
