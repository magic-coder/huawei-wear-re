package com.huawei.account.aidl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AccountAidlInfo implements Parcelable {
    public static final Creator<AccountAidlInfo> CREATOR = new a();
    private String accessToken;
    private String countyeCode;
    private byte[] headPicByts;
    private String huid;
    private String photoPath;
    private String serveToken;
    private String sitId;
    private String stType;
    private String userName;

    public String toString() {
        return "AccountAidlInfo{userName='" + this.userName + '\'' + ", huid='" + this.huid + '\'' + ", serveToken='" + this.serveToken + '\'' + ", accessToken='" + this.accessToken + '\'' + ", photoPath='" + this.photoPath + '\'' + ", sitId='" + this.sitId + '\'' + ", countyeCode='" + this.countyeCode + '\'' + ", stType='" + this.stType + '\'' + '}';
    }

    public AccountAidlInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, byte[] bArr) {
        this.userName = str;
        this.huid = str2;
        this.serveToken = str3;
        this.accessToken = str4;
        this.photoPath = str5;
        this.sitId = str6;
        this.countyeCode = str7;
        this.stType = str8;
        if (bArr != null && bArr.length > 0) {
            this.headPicByts = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.headPicByts, 0, bArr.length);
        }
    }

    public String getStType() {
        return this.stType;
    }

    public void setStType(String str) {
        this.stType = str;
    }

    public String getCountyeCode() {
        return this.countyeCode;
    }

    public void setCountyeCode(String str) {
        this.countyeCode = str;
    }

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String getServeToken() {
        return this.serveToken;
    }

    public void setServeToken(String str) {
        this.serveToken = str;
    }

    public String getPhotoPath() {
        return this.photoPath;
    }

    public void setPhotoPath(String str) {
        this.photoPath = str;
    }

    public String getSitId() {
        return this.sitId;
    }

    public void setSitId(String str) {
        this.sitId = str;
    }

    public byte[] getHeadPicByts() {
        if (this.headPicByts == null || this.headPicByts.length <= 0) {
            return null;
        }
        Object obj = new byte[this.headPicByts.length];
        System.arraycopy(this.headPicByts, 0, obj, 0, this.headPicByts.length);
        return obj;
    }

    public void setHeadPicByts(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            this.headPicByts = new byte[bArr.length];
            System.arraycopy(bArr, 0, this.headPicByts, 0, bArr.length);
        }
    }

    protected AccountAidlInfo(Parcel parcel) {
        this.userName = parcel.readString();
        this.huid = parcel.readString();
        this.serveToken = parcel.readString();
        this.accessToken = parcel.readString();
        this.photoPath = parcel.readString();
        this.sitId = parcel.readString();
        this.countyeCode = parcel.readString();
        this.stType = parcel.readString();
        this.headPicByts = parcel.createByteArray();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.userName);
        parcel.writeString(this.huid);
        parcel.writeString(this.serveToken);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.photoPath);
        parcel.writeString(this.sitId);
        parcel.writeString(this.countyeCode);
        parcel.writeString(this.stType);
        parcel.writeByteArray(this.headPicByts);
    }

    public int describeContents() {
        return 0;
    }
}
