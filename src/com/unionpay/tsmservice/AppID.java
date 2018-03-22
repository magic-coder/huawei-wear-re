package com.unionpay.tsmservice;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppID implements Parcelable {
    public static final Creator<AppID> CREATOR = new C65511();
    String mAppAid = "";
    String mAppVersion = "";

    final class C65511 implements Creator<AppID> {
        C65511() {
        }

        public AppID createFromParcel(Parcel parcel) {
            return new AppID(parcel);
        }

        public AppID[] newArray(int i) {
            return new AppID[i];
        }
    }

    public AppID(String str, String str2) {
        this.mAppAid = str;
        this.mAppVersion = str2;
    }

    public AppID(Parcel parcel) {
        this.mAppAid = parcel.readString();
        this.mAppVersion = parcel.readString();
    }

    public String getAppAid() {
        return this.mAppAid;
    }

    public void setAppAid(String str) {
        this.mAppAid = str;
    }

    public String getAppVersion() {
        return this.mAppVersion;
    }

    public void setAppVersion(String str) {
        this.mAppVersion = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mAppAid);
        parcel.writeString(this.mAppVersion);
    }
}
