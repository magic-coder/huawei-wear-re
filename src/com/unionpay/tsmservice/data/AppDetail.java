package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppDetail implements Parcelable {
    public static final Creator<AppDetail> CREATOR = new C65561();
    private String mAppApplyId;
    private String mAppDesc = "";
    private AppID mAppID;
    private String mAppIcon = "";
    private String mAppName = "";
    private String mAppProviderAgreement = "";
    private String mAppProviderLogo = "";
    private String mAppProviderName = "";
    private String mApplyMode = "";
    private long mDownloadTimes = 0;
    private String mPublishData = "";
    private String mPublishStatus = "";
    private String mRechargeLowerLimit = "";
    private String mRechargeMode = "";
    private String mServicePhone = "";
    private AppStatus mStatus;
    private String mUpAgreement = "";

    final class C65561 implements Creator<AppDetail> {
        C65561() {
        }

        public AppDetail createFromParcel(Parcel parcel) {
            return new AppDetail(parcel);
        }

        public AppDetail[] newArray(int i) {
            return new AppDetail[i];
        }
    }

    public AppDetail(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mAppName = parcel.readString();
        this.mAppIcon = parcel.readString();
        this.mAppDesc = parcel.readString();
        this.mAppProviderLogo = parcel.readString();
        this.mAppProviderName = parcel.readString();
        this.mAppProviderAgreement = parcel.readString();
        this.mUpAgreement = parcel.readString();
        this.mApplyMode = parcel.readString();
        this.mServicePhone = parcel.readString();
        this.mDownloadTimes = parcel.readLong();
        this.mPublishData = parcel.readString();
        this.mPublishStatus = parcel.readString();
        this.mRechargeMode = parcel.readString();
        this.mRechargeLowerLimit = parcel.readString();
        this.mAppApplyId = parcel.readString();
        this.mStatus = (AppStatus) parcel.readParcelable(AppStatus.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mAppIcon);
        parcel.writeString(this.mAppDesc);
        parcel.writeString(this.mAppProviderLogo);
        parcel.writeString(this.mAppProviderName);
        parcel.writeString(this.mAppProviderAgreement);
        parcel.writeString(this.mUpAgreement);
        parcel.writeString(this.mApplyMode);
        parcel.writeString(this.mServicePhone);
        parcel.writeLong(this.mDownloadTimes);
        parcel.writeString(this.mPublishData);
        parcel.writeString(this.mPublishStatus);
        parcel.writeString(this.mRechargeMode);
        parcel.writeString(this.mRechargeLowerLimit);
        parcel.writeString(this.mAppApplyId);
        parcel.writeParcelable(this.mStatus, i);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }

    public String getAppIcon() {
        return this.mAppIcon;
    }

    public void setAppIcon(String str) {
        this.mAppIcon = str;
    }

    public String getAppDesc() {
        return this.mAppDesc;
    }

    public void setAppDesc(String str) {
        this.mAppDesc = str;
    }

    public String getAppProviderLogo() {
        return this.mAppProviderLogo;
    }

    public void setAppProviderLogo(String str) {
        this.mAppProviderLogo = str;
    }

    public String getAppProviderName() {
        return this.mAppProviderName;
    }

    public void setAppProviderName(String str) {
        this.mAppProviderName = str;
    }

    public String getAppProviderAgreement() {
        return this.mAppProviderAgreement;
    }

    public void setAppProviderAgreement(String str) {
        this.mAppProviderAgreement = str;
    }

    public String getUpAgreement() {
        return this.mUpAgreement;
    }

    public void setUpAgreement(String str) {
        this.mUpAgreement = str;
    }

    public String getApplyMode() {
        return this.mApplyMode;
    }

    public void setApplyMode(String str) {
        this.mApplyMode = str;
    }

    public String getServicePhone() {
        return this.mServicePhone;
    }

    public void setServicePhone(String str) {
        this.mServicePhone = str;
    }

    public long getDownloadTimes() {
        return this.mDownloadTimes;
    }

    public void setDownloadTimes(long j) {
        this.mDownloadTimes = j;
    }

    public String getPublishData() {
        return this.mPublishData;
    }

    public void setPublishData(String str) {
        this.mPublishData = str;
    }

    public String getPublishStatus() {
        return this.mPublishStatus;
    }

    public void setPublishStatus(String str) {
        this.mPublishStatus = str;
    }

    public String getRechargeMode() {
        return this.mRechargeMode;
    }

    public void setRechargeMode(String str) {
        this.mRechargeMode = str;
    }

    public String getRechargeLowerLimit() {
        return this.mRechargeLowerLimit;
    }

    public void setRechargeLowerLimit(String str) {
        this.mRechargeLowerLimit = str;
    }

    public String getAppApplyId() {
        return this.mAppApplyId;
    }

    public void setAppApplyId(String str) {
        this.mAppApplyId = str;
    }

    public AppStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(AppStatus appStatus) {
        this.mStatus = appStatus;
    }
}
