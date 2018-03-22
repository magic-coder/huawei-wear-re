package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class UniteCardActiveRequestParams extends RequestParams {
    public static final Creator<UniteCardActiveRequestParams> CREATOR = new C66071();
    private String mActiveCode;
    private String mPanId;

    final class C66071 implements Creator<UniteCardActiveRequestParams> {
        C66071() {
        }

        public UniteCardActiveRequestParams createFromParcel(Parcel parcel) {
            return new UniteCardActiveRequestParams(parcel);
        }

        public UniteCardActiveRequestParams[] newArray(int i) {
            return new UniteCardActiveRequestParams[i];
        }
    }

    public UniteCardActiveRequestParams(Parcel parcel) {
        this.mPanId = parcel.readString();
        this.mActiveCode = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mPanId);
        parcel.writeString(this.mActiveCode);
    }

    public String getMPanId() {
        return this.mPanId;
    }

    public void setMPanId(String str) {
        this.mPanId = str;
    }

    public String getActiveCode() {
        return this.mActiveCode;
    }

    public void setActiveCode(String str) {
        this.mActiveCode = str;
    }
}
