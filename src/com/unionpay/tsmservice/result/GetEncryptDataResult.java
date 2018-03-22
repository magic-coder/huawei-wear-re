package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetEncryptDataResult implements Parcelable {
    public static final Creator<GetEncryptDataResult> CREATOR = new C66231();
    private String mData;

    final class C66231 implements Creator<GetEncryptDataResult> {
        C66231() {
        }

        public GetEncryptDataResult createFromParcel(Parcel parcel) {
            return new GetEncryptDataResult(parcel);
        }

        public GetEncryptDataResult[] newArray(int i) {
            return new GetEncryptDataResult[i];
        }
    }

    public GetEncryptDataResult(Parcel parcel) {
        this.mData = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mData);
    }

    public String getData() {
        return this.mData;
    }

    public void setData(String str) {
        this.mData = str;
    }
}
