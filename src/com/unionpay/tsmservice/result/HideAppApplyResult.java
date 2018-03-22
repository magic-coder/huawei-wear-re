package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HideAppApplyResult implements Parcelable {
    public static final Creator<HideAppApplyResult> CREATOR = new C66321();
    private boolean isSuccess;

    final class C66321 implements Creator<HideAppApplyResult> {
        C66321() {
        }

        public HideAppApplyResult createFromParcel(Parcel parcel) {
            return new HideAppApplyResult(parcel);
        }

        public HideAppApplyResult[] newArray(int i) {
            return new HideAppApplyResult[i];
        }
    }

    public HideAppApplyResult(Parcel parcel) {
        this.isSuccess = parcel.readByte() != (byte) 0;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (this.isSuccess ? 1 : 0));
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setSuccess(boolean z) {
        this.isSuccess = z;
    }
}
