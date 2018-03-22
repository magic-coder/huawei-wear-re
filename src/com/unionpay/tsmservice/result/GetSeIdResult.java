package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetSeIdResult implements Parcelable {
    public static final Creator<GetSeIdResult> CREATOR = new C66271();
    private String mSeId;

    final class C66271 implements Creator<GetSeIdResult> {
        C66271() {
        }

        public GetSeIdResult createFromParcel(Parcel parcel) {
            return new GetSeIdResult(parcel);
        }

        public GetSeIdResult[] newArray(int i) {
            return new GetSeIdResult[i];
        }
    }

    public GetSeIdResult(Parcel parcel) {
        this.mSeId = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mSeId);
    }

    public String getSeId() {
        return this.mSeId;
    }

    public void setSeId(String str) {
        this.mSeId = str;
    }
}
