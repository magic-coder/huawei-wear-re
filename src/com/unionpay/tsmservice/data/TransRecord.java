package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class TransRecord implements Parcelable {
    public static final Creator<TransRecord> CREATOR = new C65701();
    private String mMerchantName;
    private String mTransAmount;
    private String mTransTime;
    private String mTransType;

    final class C65701 implements Creator<TransRecord> {
        C65701() {
        }

        public TransRecord createFromParcel(Parcel parcel) {
            return new TransRecord(parcel);
        }

        public TransRecord[] newArray(int i) {
            return new TransRecord[i];
        }
    }

    public TransRecord(Parcel parcel) {
        this.mTransTime = parcel.readString();
        this.mMerchantName = parcel.readString();
        this.mTransType = parcel.readString();
        this.mTransAmount = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mTransTime);
        parcel.writeString(this.mMerchantName);
        parcel.writeString(this.mTransType);
        parcel.writeString(this.mTransAmount);
    }

    public String getTransTime() {
        return this.mTransTime;
    }

    public void setTransTime(String str) {
        this.mTransTime = str;
    }

    public String getMerchantName() {
        return this.mMerchantName;
    }

    public void setMerchantName(String str) {
        this.mMerchantName = str;
    }

    public String getTransType() {
        return this.mTransType;
    }

    public void setTransType(String str) {
        this.mTransType = str;
    }

    public String getTransAmount() {
        return this.mTransAmount;
    }

    public void setTransAmount(String str) {
        this.mTransAmount = str;
    }
}
