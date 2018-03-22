package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAppStatusRequestParams extends RequestParams {
    public static final Creator<GetAppStatusRequestParams> CREATOR = new C65921();
    private AppID mAppID;

    final class C65921 implements Creator<GetAppStatusRequestParams> {
        C65921() {
        }

        public GetAppStatusRequestParams createFromParcel(Parcel parcel) {
            return new GetAppStatusRequestParams(parcel);
        }

        public GetAppStatusRequestParams[] newArray(int i) {
            return new GetAppStatusRequestParams[i];
        }
    }

    public GetAppStatusRequestParams(Parcel parcel) {
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }
}
