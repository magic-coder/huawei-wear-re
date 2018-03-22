package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppLockRequestParams extends RequestParams {
    public static final Creator<AppLockRequestParams> CREATOR = new C65791();
    private AppID mAppID;

    final class C65791 implements Creator<AppLockRequestParams> {
        C65791() {
        }

        public AppLockRequestParams createFromParcel(Parcel parcel) {
            return new AppLockRequestParams(parcel);
        }

        public AppLockRequestParams[] newArray(int i) {
            return new AppLockRequestParams[i];
        }
    }

    public AppLockRequestParams(Parcel parcel) {
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
