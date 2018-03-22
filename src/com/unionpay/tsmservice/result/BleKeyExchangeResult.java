package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class BleKeyExchangeResult implements Parcelable {
    public static final Creator<BleKeyExchangeResult> CREATOR = new C66091();

    final class C66091 implements Creator<BleKeyExchangeResult> {
        C66091() {
        }

        public BleKeyExchangeResult createFromParcel(Parcel parcel) {
            return new BleKeyExchangeResult(parcel);
        }

        public BleKeyExchangeResult[] newArray(int i) {
            return new BleKeyExchangeResult[i];
        }
    }

    public BleKeyExchangeResult(Parcel parcel) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
