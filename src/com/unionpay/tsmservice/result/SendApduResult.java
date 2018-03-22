package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SendApduResult implements Parcelable {
    public static final Creator<SendApduResult> CREATOR = new C66351();
    private String outHexApdu;

    final class C66351 implements Creator<SendApduResult> {
        C66351() {
        }

        public SendApduResult createFromParcel(Parcel parcel) {
            return new SendApduResult(parcel);
        }

        public SendApduResult[] newArray(int i) {
            return new SendApduResult[i];
        }
    }

    public SendApduResult(Parcel parcel) {
        this.outHexApdu = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.outHexApdu);
    }

    public String getOutHexApdu() {
        return this.outHexApdu;
    }

    public void setOutHexApdu(String str) {
        this.outHexApdu = str;
    }
}
