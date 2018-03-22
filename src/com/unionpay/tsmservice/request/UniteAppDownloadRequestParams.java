package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class UniteAppDownloadRequestParams extends RequestParams {
    public static final Creator<UniteAppDownloadRequestParams> CREATOR = new C66061();
    private String mPanId;

    final class C66061 implements Creator<UniteAppDownloadRequestParams> {
        C66061() {
        }

        public UniteAppDownloadRequestParams createFromParcel(Parcel parcel) {
            return new UniteAppDownloadRequestParams(parcel);
        }

        public UniteAppDownloadRequestParams[] newArray(int i) {
            return new UniteAppDownloadRequestParams[i];
        }
    }

    public UniteAppDownloadRequestParams(Parcel parcel) {
        this.mPanId = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mPanId);
    }

    public String getMPanId() {
        return this.mPanId;
    }

    public void setMPanId(String str) {
        this.mPanId = str;
    }
}
