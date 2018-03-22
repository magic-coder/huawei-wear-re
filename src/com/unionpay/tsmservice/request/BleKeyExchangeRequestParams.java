package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class BleKeyExchangeRequestParams extends RequestParams {
    public static final Creator<BleKeyExchangeRequestParams> CREATOR = new C65811();
    private AppID mAppID;

    final class C65811 implements Creator<BleKeyExchangeRequestParams> {
        C65811() {
        }

        public BleKeyExchangeRequestParams createFromParcel(Parcel parcel) {
            return new BleKeyExchangeRequestParams(parcel);
        }

        public BleKeyExchangeRequestParams[] newArray(int i) {
            return new BleKeyExchangeRequestParams[i];
        }
    }

    public BleKeyExchangeRequestParams(Parcel parcel) {
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
