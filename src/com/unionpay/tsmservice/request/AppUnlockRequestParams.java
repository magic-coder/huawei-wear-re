package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppUnlockRequestParams extends RequestParams {
    public static final Creator<AppUnlockRequestParams> CREATOR = new C65801();
    private AppID mAppID;

    final class C65801 implements Creator<AppUnlockRequestParams> {
        C65801() {
        }

        public AppUnlockRequestParams createFromParcel(Parcel parcel) {
            return new AppUnlockRequestParams(parcel);
        }

        public AppUnlockRequestParams[] newArray(int i) {
            return new AppUnlockRequestParams[i];
        }
    }

    public AppUnlockRequestParams(Parcel parcel) {
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
