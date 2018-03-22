package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiAccountInfo implements Parcelable {
    public static final Creator<HiAccountInfo> CREATOR = new a();
    private String accessToken;
    private int appId;
    private int expiresIn;
    private String huid;
    private int isLogin = 0;
    private String serviceToken;
    private int siteId;
    private String thirdOpenId;
    private String thirdToken;
    private int type;
    private String userName;

    public void setAppId(int i) {
        this.appId = i;
    }

    public int getAppId() {
        return this.appId;
    }

    public String getThirdOpenId() {
        return this.thirdOpenId;
    }

    public void setThirdOpenId(String str) {
        this.thirdOpenId = str;
    }

    public String getThirdToken() {
        return this.thirdToken;
    }

    public void setThirdToken(String str) {
        this.thirdToken = str;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int i) {
        this.siteId = i;
    }

    public String getServiceToken() {
        return this.serviceToken;
    }

    public void setServiceToken(String str) {
        this.serviceToken = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public String getHuid() {
        return this.huid;
    }

    public void setHuid(String str) {
        this.huid = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public int getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(int i) {
        this.expiresIn = i;
    }

    public int getIsLogin() {
        return this.isLogin;
    }

    public void setLogin(int i) {
        this.isLogin = i;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiAccountInfo{");
        stringBuffer.append("huid='").append(this.huid).append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    protected HiAccountInfo(Parcel parcel) {
        this.huid = parcel.readString();
        this.userName = parcel.readString();
        this.accessToken = parcel.readString();
        this.serviceToken = parcel.readString();
        this.thirdOpenId = parcel.readString();
        this.thirdToken = parcel.readString();
        this.siteId = parcel.readInt();
        this.expiresIn = parcel.readInt();
        this.isLogin = parcel.readInt();
        this.type = parcel.readInt();
        this.appId = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.huid);
        parcel.writeString(this.userName);
        parcel.writeString(this.accessToken);
        parcel.writeString(this.serviceToken);
        parcel.writeString(this.thirdOpenId);
        parcel.writeString(this.thirdToken);
        parcel.writeInt(this.siteId);
        parcel.writeInt(this.expiresIn);
        parcel.writeInt(this.isLogin);
        parcel.writeInt(this.type);
        parcel.writeInt(this.appId);
    }
}
