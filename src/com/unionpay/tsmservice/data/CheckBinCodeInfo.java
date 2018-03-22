package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CheckBinCodeInfo implements Parcelable {
    public static final Creator<CheckBinCodeInfo> CREATOR = new C65631();
    private String mBankName;
    private String mCardType;
    private String mIssuerUrl;
    private String mTCUrl;

    final class C65631 implements Creator<CheckBinCodeInfo> {
        C65631() {
        }

        public CheckBinCodeInfo createFromParcel(Parcel parcel) {
            return new CheckBinCodeInfo(parcel);
        }

        public CheckBinCodeInfo[] newArray(int i) {
            return new CheckBinCodeInfo[i];
        }
    }

    public CheckBinCodeInfo(Parcel parcel) {
        this.mTCUrl = parcel.readString();
        this.mBankName = parcel.readString();
        this.mCardType = parcel.readString();
        this.mIssuerUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTCUrl);
        parcel.writeString(this.mBankName);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mIssuerUrl);
    }

    public String getTCUrl() {
        return this.mTCUrl;
    }

    public void setTCUrl(String str) {
        this.mTCUrl = str;
    }

    public String getBankName() {
        return this.mBankName;
    }

    public void setBankName(String str) {
        this.mBankName = str;
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getIssuerUrl() {
        return this.mIssuerUrl;
    }

    public void setIssuerUrl(String str) {
        this.mIssuerUrl = str;
    }
}
