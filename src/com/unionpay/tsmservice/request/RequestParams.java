package com.unionpay.tsmservice.request;

import android.os.Parcel;
import android.os.Parcelable;

public class RequestParams implements Parcelable {
    private String mReserve;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    protected void setReserve(String str) {
        this.mReserve = str;
    }

    protected String getReserve() {
        return this.mReserve;
    }
}
