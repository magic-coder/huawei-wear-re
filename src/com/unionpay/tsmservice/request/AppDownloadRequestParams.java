package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class AppDownloadRequestParams extends RequestParams {
    public static final Creator<AppDownloadRequestParams> CREATOR = new C65781();
    private AppID mAppID;
    private String mAppName;

    final class C65781 implements Creator<AppDownloadRequestParams> {
        C65781() {
        }

        public AppDownloadRequestParams createFromParcel(Parcel parcel) {
            return new AppDownloadRequestParams(parcel);
        }

        public AppDownloadRequestParams[] newArray(int i) {
            return new AppDownloadRequestParams[i];
        }
    }

    public AppDownloadRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mAppName = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mAppName);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public void setAppName(String str) {
        this.mAppName = str;
    }
}
