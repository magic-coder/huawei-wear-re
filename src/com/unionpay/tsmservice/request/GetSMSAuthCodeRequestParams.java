package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.unionpay.tsmservice.AppID;

public class GetSMSAuthCodeRequestParams extends RequestParams {
    public static final Creator<GetSMSAuthCodeRequestParams> CREATOR = new C65951();
    private AppID mAppID;
    private String mPan;
    private String mSisdn;

    final class C65951 implements Creator<GetSMSAuthCodeRequestParams> {
        C65951() {
        }

        public GetSMSAuthCodeRequestParams createFromParcel(Parcel parcel) {
            return new GetSMSAuthCodeRequestParams(parcel);
        }

        public GetSMSAuthCodeRequestParams[] newArray(int i) {
            return new GetSMSAuthCodeRequestParams[i];
        }
    }

    public GetSMSAuthCodeRequestParams(Parcel parcel) {
        this.mAppID = (AppID) parcel.readParcelable(AppID.class.getClassLoader());
        this.mPan = parcel.readString();
        this.mSisdn = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.mAppID, i);
        parcel.writeString(this.mPan);
        parcel.writeString(this.mSisdn);
    }

    public AppID getAppID() {
        return this.mAppID;
    }

    public void setAppID(AppID appID) {
        this.mAppID = appID;
    }

    public String getPan() {
        return this.mPan;
    }

    public void setPan(String str) {
        this.mPan = str;
    }

    public String getMsisdn() {
        return this.mSisdn;
    }

    public void setMsisdn(String str) {
        this.mSisdn = str;
    }
}
