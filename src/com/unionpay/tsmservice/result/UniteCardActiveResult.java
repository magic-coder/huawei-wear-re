package com.unionpay.tsmservice.result;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class UniteCardActiveResult implements Parcelable {
    public static final Creator<UniteCardActiveResult> CREATOR = new C66361();
    private String mActiveResult;

    final class C66361 implements Creator<UniteCardActiveResult> {
        C66361() {
        }

        public UniteCardActiveResult createFromParcel(Parcel parcel) {
            return new UniteCardActiveResult(parcel);
        }

        public UniteCardActiveResult[] newArray(int i) {
            return new UniteCardActiveResult[i];
        }
    }

    public UniteCardActiveResult(Parcel parcel) {
        this.mActiveResult = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mActiveResult);
    }

    public String getActiveResult() {
        return this.mActiveResult;
    }

    public void setActiveResult(String str) {
        this.mActiveResult = str;
    }
}
