package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UniteAppDetail implements Parcelable {
    public static final Creator<UniteAppDetail> CREATOR = new C65711();
    private String mApkDownloadUrl = "";
    private String mApkIcon = "";
    private String mApkName = "";
    private String mApkPackageName = "";
    private String mApkSign = "";
    private String mAppID = "";
    private String mAppIcon = "";
    private String mAppName = "";
    private String mAppProviderName = "";
    private String mCallCenterNumber = "";
    private String mCardType = "";
    private String mEmail = "";
    private String mPan = "";
    private String mPanId = "";
    private UniteAppStatus mStatus;
    private String mWebsite = "";
    private String sPan = "";

    final class C65711 implements Creator<UniteAppDetail> {
        C65711() {
        }

        public UniteAppDetail createFromParcel(Parcel parcel) {
            return new UniteAppDetail(parcel);
        }

        public UniteAppDetail[] newArray(int i) {
            return new UniteAppDetail[i];
        }
    }

    public UniteAppDetail(Parcel parcel) {
        this.mAppID = parcel.readString();
        this.mAppName = parcel.readString();
        this.mAppIcon = parcel.readString();
        this.mAppProviderName = parcel.readString();
        this.mStatus = (UniteAppStatus) parcel.readParcelable(UniteAppStatus.class.getClassLoader());
        this.mPanId = parcel.readString();
        this.mPan = parcel.readString();
        this.sPan = parcel.readString();
        this.mCardType = parcel.readString();
        this.mCallCenterNumber = parcel.readString();
        this.mEmail = parcel.readString();
        this.mWebsite = parcel.readString();
        this.mApkIcon = parcel.readString();
        this.mApkName = parcel.readString();
        this.mApkPackageName = parcel.readString();
        this.mApkDownloadUrl = parcel.readString();
        this.mApkSign = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppID);
        parcel.writeString(this.mAppName);
        parcel.writeString(this.mAppIcon);
        parcel.writeString(this.mAppProviderName);
        parcel.writeParcelable(this.mStatus, i);
        parcel.writeString(this.mPanId);
        parcel.writeString(this.mPan);
        parcel.writeString(this.sPan);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mCallCenterNumber);
        parcel.writeString(this.mEmail);
        parcel.writeString(this.mWebsite);
        parcel.writeString(this.mApkIcon);
        parcel.writeString(this.mApkName);
        parcel.writeString(this.mApkPackageName);
        parcel.writeString(this.mApkDownloadUrl);
        parcel.writeString(this.mApkSign);
    }

    public String getAppID() {
        return this.mAppID;
    }

    public void setAppID(String str) {
        this.mAppID = str;
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

    public String getAppProviderName() {
        return this.mAppProviderName;
    }

    public void setAppProviderName(String str) {
        this.mAppProviderName = str;
    }

    public UniteAppStatus getStatus() {
        return this.mStatus;
    }

    public void setStatus(UniteAppStatus uniteAppStatus) {
        this.mStatus = uniteAppStatus;
    }

    public String getMPanId() {
        return this.mPanId;
    }

    public void setMPanId(String str) {
        this.mPanId = str;
    }

    public String getMPan() {
        return this.mPan;
    }

    public void setMPan(String str) {
        this.mPan = str;
    }

    public String getSPan() {
        return this.sPan;
    }

    public void setSPan(String str) {
        this.sPan = str;
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public void setEmail(String str) {
        this.mEmail = str;
    }

    public String getCallCenterNumber() {
        return this.mCallCenterNumber;
    }

    public void setCallCenterNumber(String str) {
        this.mCallCenterNumber = str;
    }

    public String getWebsite() {
        return this.mWebsite;
    }

    public void setWebsite(String str) {
        this.mWebsite = str;
    }

    public String getApkIcon() {
        return this.mApkIcon;
    }

    public void setApkIcon(String str) {
        this.mApkIcon = str;
    }

    public String getApkName() {
        return this.mApkName;
    }

    public void setApkName(String str) {
        this.mApkName = str;
    }

    public String getApkPackageName() {
        return this.mApkPackageName;
    }

    public void setApkPackageName(String str) {
        this.mApkPackageName = str;
    }

    public String getApkDownloadUrl() {
        return this.mApkDownloadUrl;
    }

    public void setApkDownloadUrl(String str) {
        this.mApkDownloadUrl = str;
    }

    public String getApkSign() {
        return this.mApkSign;
    }

    public void setApkSign(String str) {
        this.mApkSign = str;
    }
}
