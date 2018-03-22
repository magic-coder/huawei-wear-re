package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.data.CheckBinCodeInfo;

public class CheckBinCodeResult implements Parcelable {
    public static final Creator<CheckBinCodeResult> CREATOR = new C66101();
    private CheckBinCodeInfo mCheckBinCodeInfo;

    final class C66101 implements Creator<CheckBinCodeResult> {
        C66101() {
        }

        public CheckBinCodeResult createFromParcel(Parcel parcel) {
            return new CheckBinCodeResult(parcel);
        }

        public CheckBinCodeResult[] newArray(int i) {
            return new CheckBinCodeResult[i];
        }
    }

    public CheckBinCodeResult(Parcel parcel) {
        this.mCheckBinCodeInfo = (CheckBinCodeInfo) parcel.readParcelable(CheckBinCodeInfo.class.getClassLoader());
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.mCheckBinCodeInfo, i);
    }

    public CheckBinCodeInfo getCheckBinCodeInfo() {
        return this.mCheckBinCodeInfo;
    }

    public void setCheckBinCodeInfo(CheckBinCodeInfo checkBinCodeInfo) {
        this.mCheckBinCodeInfo = checkBinCodeInfo;
    }
}
