package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CardTypeListItem implements Parcelable {
    public static final Creator<CardTypeListItem> CREATOR = new C65621();
    private String mBankLogoUrl = "";
    private String mBankName = "";
    private String mCardType = "";

    final class C65621 implements Creator<CardTypeListItem> {
        C65621() {
        }

        public CardTypeListItem createFromParcel(Parcel parcel) {
            return new CardTypeListItem(parcel);
        }

        public CardTypeListItem[] newArray(int i) {
            return new CardTypeListItem[i];
        }
    }

    public CardTypeListItem(Parcel parcel) {
        this.mCardType = parcel.readString();
        this.mBankName = parcel.readString();
        this.mBankLogoUrl = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mCardType);
        parcel.writeString(this.mBankName);
        parcel.writeString(this.mBankLogoUrl);
    }

    public String getCardType() {
        return this.mCardType;
    }

    public void setCardType(String str) {
        this.mCardType = str;
    }

    public String getBankName() {
        return this.mBankName;
    }

    public void setBankName(String str) {
        this.mBankName = str;
    }

    public String getBankLogoUrl() {
        return this.mBankLogoUrl;
    }

    public void setBankLogoUrl(String str) {
        this.mBankLogoUrl = str;
    }
}
