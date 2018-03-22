package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetDefaultCardResult implements Parcelable {
    public static final Creator<GetDefaultCardResult> CREATOR = new C66221();
    private String mDefaultCard;

    final class C66221 implements Creator<GetDefaultCardResult> {
        C66221() {
        }

        public GetDefaultCardResult createFromParcel(Parcel parcel) {
            return new GetDefaultCardResult(parcel);
        }

        public GetDefaultCardResult[] newArray(int i) {
            return new GetDefaultCardResult[i];
        }
    }

    public GetDefaultCardResult(Parcel parcel) {
        this.mDefaultCard = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mDefaultCard);
    }

    public String getDefaultCard() {
        return this.mDefaultCard;
    }

    public void setDefaultCard(String str) {
        this.mDefaultCard = str;
    }
}
