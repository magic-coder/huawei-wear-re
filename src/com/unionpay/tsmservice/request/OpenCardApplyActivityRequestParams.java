package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class OpenCardApplyActivityRequestParams extends RequestParams {
    public static final Creator<OpenCardApplyActivityRequestParams> CREATOR = new C66001();
    private AppID mAppID;
    private String mTransType;

    final class C66001 implements Creator<OpenCardApplyActivityRequestParams> {
        C66001() {
        }

        public OpenCardApplyActivityRequestParams createFromParcel(Parcel parcel) {
            return new OpenCardApplyActivityRequestParams(parcel);
        }

        public OpenCardApplyActivityRequestParams[] newArray(int i) {
            return new OpenCardApplyActivityRequestParams[i];
        }
    }

    public OpenCardApplyActivityRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mTransType = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mTransType);
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
