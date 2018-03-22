package com.huawei.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SimInfo implements Parcelable {
    public static final Creator<SimInfo> CREATOR = new C1203h();
    private boolean mActive = false;
    private String mICCID = "";
    private String mIMSI = "";

    public SimInfo(Parcel parcel) {
        boolean z = false;
        this.mIMSI = parcel.readString();
        this.mICCID = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        }
        this.mActive = z;
    }

    public SimInfo(String str, String str2, boolean z) {
        this.mIMSI = str;
        this.mICCID = str2;
        this.mActive = z;
    }

    public String getIMSI() {
        return this.mIMSI;
    }

    public void setIMSI(String str) {
        this.mIMSI = str;
    }

    public String getICCID() {
        return this.mICCID;
    }

    public void setICCID(String str) {
        this.mICCID = str;
    }

    public boolean isActive() {
        return this.mActive;
    }

    public void setActive(boolean z) {
        this.mActive = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mIMSI);
        parcel.writeString(this.mICCID);
        parcel.writeByte((byte) (this.mActive ? 1 : 0));
    }

    public SimInfo clone() throws CloneNotSupportedException {
        return (SimInfo) super.clone();
    }
}
