package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAccountInfoRequestParams extends RequestParams {
    public static final Creator<GetAccountInfoRequestParams> CREATOR = new C65881();
    private AppID mAppID;

    final class C65881 implements Creator<GetAccountInfoRequestParams> {
        C65881() {
        }

        public GetAccountInfoRequestParams createFromParcel(Parcel parcel) {
            return new GetAccountInfoRequestParams(parcel);
        }

        public GetAccountInfoRequestParams[] newArray(int i) {
            return new GetAccountInfoRequestParams[i];
        }
    }

    public GetAccountInfoRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }
}
