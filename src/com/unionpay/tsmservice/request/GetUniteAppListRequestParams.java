package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetUniteAppListRequestParams extends RequestParams implements Parcelable {
    public static final Creator<GetUniteAppListRequestParams> CREATOR = new C65981();
    private String[] mStatus;

    final class C65981 implements Creator<GetUniteAppListRequestParams> {
        C65981() {
        }

        public GetUniteAppListRequestParams createFromParcel(Parcel parcel) {
            return new GetUniteAppListRequestParams(parcel);
        }

        public GetUniteAppListRequestParams[] newArray(int i) {
            return new GetUniteAppListRequestParams[i];
        }
    }

    public GetUniteAppListRequestParams(Parcel parcel) {
        this.mStatus = parcel.createStringArray();
    }

    public String[] getStatus() {
        return this.mStatus;
    }

    public void setStatus(String[] strArr) {
        this.mStatus = strArr;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStringArray(this.mStatus);
    }
}
