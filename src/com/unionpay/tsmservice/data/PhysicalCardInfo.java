package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PhysicalCardInfo implements Parcelable {
    public static final Creator<PhysicalCardInfo> CREATOR = new C65661();
    public static final String TYPE_CREDIT = "02";
    public static final String TYPE_DEBIT = "01";
    private String mBankLogo = "";
    private String mBankName = "";
    private String mCardIcon = "";
    private String mCardNo = "";
    private String mCardType = "";
    private String mReferenceID = "";

    final class C65661 implements Creator<PhysicalCardInfo> {
        C65661() {
        }

        public PhysicalCardInfo createFromParcel(Parcel parcel) {
            return new PhysicalCardInfo(parcel);
        }

        public PhysicalCardInfo[] newArray(int i) {
            return new PhysicalCardInfo[i];
        }
    }

    public PhysicalCardInfo(Parcel parcel) {
        this.mReferenceID = parcel.readString();
        this.mCardNo = parcel.readString();
        this.mCardType = parcel.readString();
        this.mCardIcon = parcel.readString();
        this.mBankName = parcel.readString();
        this.mBankLogo = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mReferenceID);
        parcel.writeString(this.mCardNo);
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mCardIcon);
        parcel.writeString(this.mBankName);
        parcel.writeString(this.mBankLogo);
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

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getCardIcon() {
        return this.mCardIcon;
    }

    public void setCardIcon(String str) {
        this.mCardIcon = str;
    }

    public String getBankName() {
        return this.mBankName;
    }

    public void setBankName(String str) {
        this.mBankName = str;
    }

    public String getBankLogo() {
        return this.mBankLogo;
    }

    public void setBankLogo(String str) {
        this.mBankLogo = str;
    }
}
