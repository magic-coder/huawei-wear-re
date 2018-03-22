package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetAccountBalanceRequestParams extends RequestParams {
    public static final Creator<GetAccountBalanceRequestParams> CREATOR = new C65871();
    private AppID mAppID;
    private String mEncryptPin;

    final class C65871 implements Creator<GetAccountBalanceRequestParams> {
        C65871() {
        }

        public GetAccountBalanceRequestParams createFromParcel(Parcel parcel) {
            return new GetAccountBalanceRequestParams(parcel);
        }

        public GetAccountBalanceRequestParams[] newArray(int i) {
            return new GetAccountBalanceRequestParams[i];
        }
    }

    public GetAccountBalanceRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mEncryptPin = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mEncryptPin);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getEncryptPin() {
        return this.mEncryptPin;
    }

    public void setEncryptPin(String str) {
        this.mEncryptPin = str;
    }
}
