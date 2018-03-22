package com.huawei.multisimsdk.multidevicemanager.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class InProgressData implements Parcelable {
    public static final Creator<InProgressData> CREATOR = new C1152d();
    private String deviceid;
    private C1153e multiSIMServiceInfo = null;
    private String nikename;
    private String primary;
    private String primaryIDtype;
    private int resultcode;
    private int rsn;
    private String secondaryID;
    private String secondarytype;
    private String serviceType;
    private int time;
    private int type;

    public String getPrimary() {
        return this.primary;
    }

    public void setPrimary(String str) {
        this.primary = str;
    }

    public String getSecondaryID() {
        return this.secondaryID;
    }

    public void setSecondaryID(String str) {
        this.secondaryID = str;
    }

    public String getSecondarytype() {
        return this.secondarytype;
    }

    public void setSecondarytype(String str) {
        this.secondarytype = str;
    }

    public String getNikename() {
        return this.nikename;
    }

    public void setNikename(String str) {
        this.nikename = str;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getRsn() {
        return this.rsn;
    }

    public void setRsn(int i) {
        this.rsn = i;
    }

    public C1153e getMultiSIMServiceInfo() {
        return this.multiSIMServiceInfo;
    }

    public void setMultiSIMServiceInfo(C1153e c1153e) {
        this.multiSIMServiceInfo = c1153e;
    }

    public int getResultcode() {
        return this.resultcode;
    }

    public void setResultcode(int i) {
        this.resultcode = i;
    }

    public String getServiceType() {
        return this.serviceType;
    }

    public void setServiceType(String str) {
        this.serviceType = str;
    }

    public String getDeviceid() {
        return this.deviceid;
    }

    public void setDeviceid(String str) {
        this.deviceid = str;
    }

    public String getPrimaryIDtype() {
        return this.primaryIDtype;
    }

    public void setPrimaryIDtype(String str) {
        this.primaryIDtype = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.primary);
        parcel.writeString(this.secondaryID);
        parcel.writeString(this.secondarytype);
        parcel.writeString(this.nikename);
        parcel.writeInt(this.type);
        parcel.writeInt(this.rsn);
        parcel.writeString(this.serviceType);
        parcel.writeString(this.deviceid);
        parcel.writeString(this.primaryIDtype);
        parcel.writeInt(this.time);
    }

    protected InProgressData(Parcel parcel) {
        this.primary = parcel.readString();
        this.secondaryID = parcel.readString();
        this.secondarytype = parcel.readString();
        this.nikename = parcel.readString();
        this.type = parcel.readInt();
        this.rsn = parcel.readInt();
        this.serviceType = parcel.readString();
        this.deviceid = parcel.readString();
        this.primaryIDtype = parcel.readString();
        this.time = parcel.readInt();
    }

    public int getTime() {
        return this.time;
    }

    public void setTime(int i) {
        this.time = i;
    }
}
