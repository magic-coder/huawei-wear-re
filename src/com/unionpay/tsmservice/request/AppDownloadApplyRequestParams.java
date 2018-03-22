package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;
import java.util.HashMap;
import java.util.Map;

public class AppDownloadApplyRequestParams extends RequestParams {
    public static final Creator<AppDownloadApplyRequestParams> CREATOR = new C65771();
    private AppID mAppID;
    private HashMap<String, String> mParams;

    final class C65771 implements Creator<AppDownloadApplyRequestParams> {
        C65771() {
        }

        public AppDownloadApplyRequestParams createFromParcel(Parcel parcel) {
            return new AppDownloadApplyRequestParams(parcel);
        }

        public AppDownloadApplyRequestParams[] newArray(int i) {
            return new AppDownloadApplyRequestParams[i];
        }
    }

    public AppDownloadApplyRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mParams = parcel.readHashMap(HashMap.class.getClassLoader());
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeMap(this.mParams);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public Map<String, String> getParams() {
        return this.mParams;
    }

    public void setParams(HashMap<String, String> hashMap) {
        this.mParams = hashMap;
    }
}
