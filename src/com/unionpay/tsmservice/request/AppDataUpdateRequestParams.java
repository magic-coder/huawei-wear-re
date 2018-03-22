package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppDataUpdateRequestParams extends RequestParams {
    public static final Creator<AppDataUpdateRequestParams> CREATOR = new C65751();
    private AppID mAppID;

    final class C65751 implements Creator<AppDataUpdateRequestParams> {
        C65751() {
        }

        public AppDataUpdateRequestParams createFromParcel(Parcel parcel) {
            return new AppDataUpdateRequestParams(parcel);
        }

        public AppDataUpdateRequestParams[] newArray(int i) {
            return new AppDataUpdateRequestParams[i];
        }
    }

    public AppDataUpdateRequestParams(Parcel parcel) {
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
