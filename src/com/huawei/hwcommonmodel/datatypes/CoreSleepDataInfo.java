package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CoreSleepDataInfo implements Parcelable {
    public static final Creator<CoreSleepDataInfo> CREATOR = new C4736a();
    private byte[] info;

    public byte[] getInfo() {
        return (byte[]) this.info.clone();
    }

    public void setInfo(byte[] bArr) {
        this.info = (byte[]) bArr.clone();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.info);
    }
}
