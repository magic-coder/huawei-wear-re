package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class VirtualCardInfo implements Parcelable {
    public static final Creator<VirtualCardInfo> CREATOR = new C65741();
    private AppID mAppID;
    private String mBalance = "";
    private String mCVN2 = "";
    private String mCardNo = "";
    private String mReferenceID = "";
    private String mValidDate = "";

    final class C65741 implements Creator<VirtualCardInfo> {
        C65741() {
        }

        public VirtualCardInfo createFromParcel(Parcel parcel) {
            return new VirtualCardInfo(parcel);
        }

        public VirtualCardInfo[] newArray(int i) {
            return new VirtualCardInfo[i];
        }
    }

    public VirtualCardInfo(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mReferenceID = parcel.readString();
        this.mCardNo = parcel.readString();
        this.mValidDate = parcel.readString();
        this.mCVN2 = parcel.readString();
        this.mBalance = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mReferenceID);
        parcel.writeString(this.mCardNo);
        parcel.writeString(this.mValidDate);
        parcel.writeString(this.mCVN2);
        parcel.writeString(this.mBalance);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getReferenceID() {
        return this.mReferenceID;
    }

    public void setReferenceID(String str) {
        this.mReferenceID = str;
    }

    public String getCardNo() {
        return this.mCardNo;
    }

    public void setCardNo(String str) {
        this.mCardNo = str;
    }

    public String getValidDate() {
        return this.mValidDate;
    }

    public void setValidDate(String str) {
        this.mValidDate = str;
    }

    public String getCVN2() {
        return this.mCVN2;
    }

    public void setCVN2(String str) {
        this.mCVN2 = str;
    }

    public String getBalance() {
        return this.mBalance;
    }

    public void setBalance(String str) {
        this.mBalance = str;
    }
}
