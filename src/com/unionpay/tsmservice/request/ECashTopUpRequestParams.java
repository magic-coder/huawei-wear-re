package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class ECashTopUpRequestParams extends RequestParams {
    public static final Creator<ECashTopUpRequestParams> CREATOR = new C65831();
    private String mAmount;
    private AppID mAppID;
    private String mEncrpytPin;
    private String mType = "0";

    final class C65831 implements Creator<ECashTopUpRequestParams> {
        C65831() {
        }

        public ECashTopUpRequestParams createFromParcel(Parcel parcel) {
            return new ECashTopUpRequestParams(parcel);
        }

        public ECashTopUpRequestParams[] newArray(int i) {
            return new ECashTopUpRequestParams[i];
        }
    }

    public ECashTopUpRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mType = parcel.readString();
        this.mAmount = parcel.readString();
        this.mEncrpytPin = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mType);
        parcel.writeString(this.mAmount);
        parcel.writeString(this.mEncrpytPin);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getType() {
        return this.mType;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public String getAmount() {
        return this.mAmount;
    }

    public void setAmount(String str) {
        this.mAmount = str;
    }

    public String getEncrpytPin() {
        return this.mEncrpytPin;
    }

    public void setEncrpytPin(String str) {
        this.mEncrpytPin = str;
    }
}
