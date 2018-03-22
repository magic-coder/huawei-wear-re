package com.unionpay.tsmservice.result;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class ECashTopUpResult implements Parcelable {
    public static final Creator<ECashTopUpResult> CREATOR = new C66111();
    private String balance;
    private String overdraw;

    final class C66111 implements Creator<ECashTopUpResult> {
        C66111() {
        }

        public ECashTopUpResult createFromParcel(Parcel parcel) {
            return new ECashTopUpResult(parcel);
        }

        public ECashTopUpResult[] newArray(int i) {
            return new ECashTopUpResult[i];
        }
    }

    @SuppressLint({"NewApi"})
    public ECashTopUpResult(Parcel parcel) {
        this.balance = parcel.readString();
        this.overdraw = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.balance);
        parcel.writeString(this.overdraw);
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public String getOverdraw() {
        return this.overdraw;
    }

    public void setOverdraw(String str) {
        this.overdraw = str;
    }
}
