package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ExecuteCmdRequestParams extends RequestParams {
    public static final Creator<ExecuteCmdRequestParams> CREATOR = new C65861();
    private String mSign;
    private String mSsid;

    final class C65861 implements Creator<ExecuteCmdRequestParams> {
        C65861() {
        }

        public ExecuteCmdRequestParams createFromParcel(Parcel parcel) {
            return new ExecuteCmdRequestParams(parcel);
        }

        public ExecuteCmdRequestParams[] newArray(int i) {
            return new ExecuteCmdRequestParams[i];
        }
    }

    public ExecuteCmdRequestParams(Parcel parcel) {
        this.mSsid = parcel.readString();
        this.mSign = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSsid);
        parcel.writeString(this.mSign);
    }

    public String getSsid() {
        return this.mSsid;
    }

    public void setSsid(String str) {
        this.mSsid = str;
    }

    public String getSign() {
        return this.mSign;
    }

    public void setSign(String str) {
        this.mSign = str;
    }
}
