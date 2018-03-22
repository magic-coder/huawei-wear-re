package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;
import java.util.HashMap;
import java.util.Map;

public class AppDeleteRequestParams extends RequestParams {
    public static final Creator<AppDeleteRequestParams> CREATOR = new C65761();
    private AppID mAppID;
    private HashMap<String, String> mParams;

    final class C65761 implements Creator<AppDeleteRequestParams> {
        C65761() {
        }

        public AppDeleteRequestParams createFromParcel(Parcel parcel) {
            return new AppDeleteRequestParams(parcel);
        }

        public AppDeleteRequestParams[] newArray(int i) {
            return new AppDeleteRequestParams[i];
        }
    }

    public AppDeleteRequestParams(Parcel parcel) {
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
