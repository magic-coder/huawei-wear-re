package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class UniteAppDeleteRequestParams extends RequestParams {
    public static final Creator<UniteAppDeleteRequestParams> CREATOR = new C66051();
    private String mPanID;

    final class C66051 implements Creator<UniteAppDeleteRequestParams> {
        C66051() {
        }

        public UniteAppDeleteRequestParams createFromParcel(Parcel parcel) {
            return new UniteAppDeleteRequestParams(parcel);
        }

        public UniteAppDeleteRequestParams[] newArray(int i) {
            return new UniteAppDeleteRequestParams[i];
        }
    }

    public UniteAppDeleteRequestParams(Parcel parcel) {
        this.mPanID = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mPanID);
    }

    public String getMPanId() {
        return this.mPanID;
    }

    public void setMPanId(String str) {
        this.mPanID = str;
    }
}
