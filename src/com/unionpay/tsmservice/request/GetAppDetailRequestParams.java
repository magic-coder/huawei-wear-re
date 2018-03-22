package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAppDetailRequestParams extends RequestParams {
    public static final Creator<GetAppDetailRequestParams> CREATOR = new C65901();
    private AppID mAppID;
    private String mTransType;

    final class C65901 implements Creator<GetAppDetailRequestParams> {
        C65901() {
        }

        public GetAppDetailRequestParams createFromParcel(Parcel parcel) {
            return new GetAppDetailRequestParams(parcel);
        }

        public GetAppDetailRequestParams[] newArray(int i) {
            return new GetAppDetailRequestParams[i];
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mTransType);
    }

    public GetAppDetailRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mTransType = parcel.readString();
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getTransType() {
        return this.mTransType;
    }

    public void setTransType(String str) {
        this.mTransType = str;
    }
}
