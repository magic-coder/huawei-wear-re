package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class CheckBinRequestParams extends RequestParams {
    public static final Creator<CheckBinRequestParams> CREATOR = new C65821();
    private String mSPan;

    final class C65821 implements Creator<CheckBinRequestParams> {
        C65821() {
        }

        public CheckBinRequestParams createFromParcel(Parcel parcel) {
            return new CheckBinRequestParams(parcel);
        }

        public CheckBinRequestParams[] newArray(int i) {
            return new CheckBinRequestParams[i];
        }
    }

    public CheckBinRequestParams(Parcel parcel) {
        this.mSPan = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSPan);
    }

    public String getSPan() {
        return this.mSPan;
    }

    public void setSPan(String str) {
        this.mSPan = str;
    }
}
