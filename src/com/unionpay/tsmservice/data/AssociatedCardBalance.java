package com.unionpay.tsmservice.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AssociatedCardBalance implements Parcelable {
    public static final Creator<AssociatedCardBalance> CREATOR = new C65601();
    private String mBalance;

    final class C65601 implements Creator<AssociatedCardBalance> {
        C65601() {
        }

        public AssociatedCardBalance createFromParcel(Parcel parcel) {
            return new AssociatedCardBalance(parcel);
        }

        public AssociatedCardBalance[] newArray(int i) {
            return new AssociatedCardBalance[i];
        }
    }

    public AssociatedCardBalance(Parcel parcel) {
        this.mBalance = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mBalance);
    }

    public String getBalance() {
        return this.mBalance;
    }

    public void setBalance(String str) {
        this.mBalance = str;
    }
}
