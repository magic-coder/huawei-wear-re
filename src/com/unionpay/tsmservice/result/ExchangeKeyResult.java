package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ExchangeKeyResult implements Parcelable {
    public static final Creator<ExchangeKeyResult> CREATOR = new C66131();
    private String key;

    final class C66131 implements Creator<ExchangeKeyResult> {
        C66131() {
        }

        public ExchangeKeyResult createFromParcel(Parcel parcel) {
            return new ExchangeKeyResult(parcel);
        }

        public ExchangeKeyResult[] newArray(int i) {
            return new ExchangeKeyResult[i];
        }
    }

    public ExchangeKeyResult(Parcel parcel) {
        this.key = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }
}
