package com.huawei.multisimservice.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class MultiSimDeviceInfo implements Parcelable {
    public static final Creator<MultiSimDeviceInfo> CREATOR = new C1202g();
    public static final int DEVICE_TYPE_ESIM = 2;
    public static final int DEVICE_TYPE_INVALID = 0;
    public static final int DEVICE_TYPE_NO_MODEM = 3;
    public static final int DEVICE_TYPE_SIM = 1;
    public static final int RESULT_CODE_NOT_CONNECT = -2;
    public static final int RESULT_CODE_NOT_SUPPORT = -3;
    public static final int RESULT_CODE_SUCCESS = 1;
    public static final int RESULT_CODE_UNKNOW = 0;
    public static final int RESULT_CODE_USER_REJECT = -1;
    private String mDeviceIMEI = "";
    private String mDeviceSerialNumber = "";
    private int mDeviceType = 0;
    private String mEID = "";
    private String mProductName = "";
    private int mResultCode;
    private List<SimInfo> mSimInfoList = new ArrayList();

    public MultiSimDeviceInfo(Parcel parcel) {
        this.mResultCode = parcel.readInt();
        this.mDeviceType = parcel.readInt();
        this.mDeviceIMEI = parcel.readString();
        this.mDeviceSerialNumber = parcel.readString();
        this.mProductName = parcel.readString();
        this.mEID = parcel.readString();
        if (this.mSimInfoList == null) {
            this.mSimInfoList = new ArrayList();
        }
        parcel.readTypedList(this.mSimInfoList, SimInfo.CREATOR);
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public void setResultCode(int i) {
        this.mResultCode = i;
    }

    public int getDeviceType() {
        return this.mDeviceType;
    }

    public void setDeviceType(int i) {
        this.mDeviceType = i;
    }

    public String getDeviceIMEI() {
        return this.mDeviceIMEI;
    }

    public void setDeviceIMEI(String str) {
        this.mDeviceIMEI = str;
    }

    public String getDeviceSerialNumber() {
        return this.mDeviceSerialNumber;
    }

    public void setDeviceSerialNumber(String str) {
        this.mDeviceSerialNumber = str;
    }

    public String getProductName() {
        return this.mProductName;
    }

    public void setProductName(String str) {
        this.mProductName = str;
    }

    public String getEID() {
        return this.mEID;
    }

    public void setEID(String str) {
        this.mEID = str;
    }

    public List<SimInfo> getSimInfoList() {
        return this.mSimInfoList;
    }

    public void setSimInfoList(List<SimInfo> list) {
        this.mSimInfoList = list;
    }

    public String getDeviceID() {
        if (2 == this.mDeviceType || 1 == this.mDeviceType) {
            return this.mDeviceIMEI;
        }
        if (3 == this.mDeviceType) {
            return this.mDeviceSerialNumber;
        }
        return null;
    }

    public SimInfo getActiveSimProfileInfo() {
        if (this.mSimInfoList != null) {
            for (SimInfo simInfo : this.mSimInfoList) {
                if (simInfo.isActive()) {
                    try {
                        return simInfo.clone();
                    } catch (CloneNotSupportedException e) {
                        return new SimInfo(simInfo.getIMSI(), simInfo.getICCID(), simInfo.isActive());
                    }
                }
            }
        }
        return null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mResultCode);
        parcel.writeInt(this.mDeviceType);
        parcel.writeString(this.mDeviceIMEI);
        parcel.writeString(this.mDeviceSerialNumber);
        parcel.writeString(this.mProductName);
        parcel.writeString(this.mEID);
        parcel.writeTypedList(this.mSimInfoList);
    }
}
