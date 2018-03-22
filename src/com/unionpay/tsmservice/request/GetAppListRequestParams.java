package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class GetAppListRequestParams extends RequestParams implements Parcelable {
    public static final Creator<GetAppListRequestParams> CREATOR = new C65911();
    private String mKeyword;
    private String[] mStatus;

    final class C65911 implements Creator<GetAppListRequestParams> {
        C65911() {
        }

        public GetAppListRequestParams createFromParcel(Parcel parcel) {
            return new GetAppListRequestParams(parcel);
        }

        public GetAppListRequestParams[] newArray(int i) {
            return new GetAppListRequestParams[i];
        }
    }

    public GetAppListRequestParams(Parcel parcel) {
        this.mKeyword = parcel.readString();
        this.mStatus = parcel.createStringArray();
    }

    public String getKeyword() {
        return this.mKeyword;
    }

    public void setKeyword(String str) {
        this.mKeyword = str;
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
        parcel.writeString(this.mKeyword);
        parcel.writeStringArray(this.mStatus);
    }
}
