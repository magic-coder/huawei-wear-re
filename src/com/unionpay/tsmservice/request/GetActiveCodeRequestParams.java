package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class GetActiveCodeRequestParams extends RequestParams {
    public static final Creator<GetActiveCodeRequestParams> CREATOR = new C65891();
    private String mActiveType;
    private String mPanId;

    final class C65891 implements Creator<GetActiveCodeRequestParams> {
        C65891() {
        }

        public GetActiveCodeRequestParams createFromParcel(Parcel parcel) {
            return new GetActiveCodeRequestParams(parcel);
        }

        public GetActiveCodeRequestParams[] newArray(int i) {
            return new GetActiveCodeRequestParams[i];
        }
    }

    public GetActiveCodeRequestParams(Parcel parcel) {
        this.mPanId = parcel.readString();
        this.mActiveType = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mPanId);
        parcel.writeString(this.mActiveType);
    }

    public String getMPanId() {
        return this.mPanId;
    }

    public void setMPanId(String str) {
        this.mPanId = str;
    }

    public String getActiveType() {
        return this.mActiveType;
    }

    public void setActiveType(String str) {
        this.mActiveType = str;
    }
}
