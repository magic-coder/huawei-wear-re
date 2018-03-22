package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class OpenCardDetailActivityRequestParams extends RequestParams {
    public static final Creator<OpenCardDetailActivityRequestParams> CREATOR = new C66011();
    private AppID mAppID;

    final class C66011 implements Creator<OpenCardDetailActivityRequestParams> {
        C66011() {
        }

        public OpenCardDetailActivityRequestParams createFromParcel(Parcel parcel) {
            return new OpenCardDetailActivityRequestParams(parcel);
        }

        public OpenCardDetailActivityRequestParams[] newArray(int i) {
            return new OpenCardDetailActivityRequestParams[i];
        }
    }

    public OpenCardDetailActivityRequestParams(Parcel parcel) {
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
