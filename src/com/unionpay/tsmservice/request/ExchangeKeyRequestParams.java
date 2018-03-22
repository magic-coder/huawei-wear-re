package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class ExchangeKeyRequestParams extends RequestParams {
    public static final Creator<ExchangeKeyRequestParams> CREATOR = new C65851();
    private String mTempKey;
    private int mType;

    final class C65851 implements Creator<ExchangeKeyRequestParams> {
        C65851() {
        }

        public ExchangeKeyRequestParams createFromParcel(Parcel parcel) {
            return new ExchangeKeyRequestParams(parcel);
        }

        public ExchangeKeyRequestParams[] newArray(int i) {
            return new ExchangeKeyRequestParams[i];
        }
    }

    public ExchangeKeyRequestParams(Parcel parcel) {
        this.mType = parcel.readInt();
        this.mTempKey = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mTempKey);
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int i) {
        this.mType = i;
    }

    public String getTempKey() {
        return this.mTempKey;
    }

    public void setTempKey(String str) {
        this.mTempKey = str;
    }
}
