package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetPubKeyResult implements Parcelable {
    public static final Creator<GetPubKeyResult> CREATOR = new C66241();
    private String key;

    final class C66241 implements Creator<GetPubKeyResult> {
        C66241() {
        }

        public GetPubKeyResult createFromParcel(Parcel parcel) {
            return new GetPubKeyResult(parcel);
        }

        public GetPubKeyResult[] newArray(int i) {
            return new GetPubKeyResult[i];
        }
    }

    public GetPubKeyResult(Parcel parcel) {
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
