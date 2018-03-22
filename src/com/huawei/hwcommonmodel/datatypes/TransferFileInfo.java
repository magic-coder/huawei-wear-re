package com.huawei.hwcommonmodel.datatypes;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class TransferFileInfo implements Parcelable {
    public static final Creator<TransferFileInfo> CREATOR = new y();
    private Object callback;
    private String deviceMac;
    private int deviceType;
    private String deviceVersion;
    private int dfxLogType = 0;
    private int endTime;
    private int gpsType;
    private int level;
    private int[] recordId;
    private int startTime;
    private int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public List<Integer> getRecordId() {
        List<Integer> arrayList = new ArrayList();
        for (int valueOf : this.recordId) {
            arrayList.add(Integer.valueOf(valueOf));
        }
        return arrayList;
    }

    public void setRecordId(List<Integer> list) {
        int[] iArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        this.recordId = iArr;
    }

    public int getGpsType() {
        return this.gpsType;
    }

    public void setGpsType(int i) {
        this.gpsType = i;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public void setStartTime(int i) {
        this.startTime = i;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public void setEndTime(int i) {
        this.endTime = i;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public String getDeviceMac() {
        return this.deviceMac;
    }

    public void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public String getDeviceVersion() {
        return this.deviceVersion;
    }

    public void setDeviceVersion(String str) {
        this.deviceVersion = str;
    }

    public int getDeviceType() {
        return this.deviceType;
    }

    public void setDeviceType(int i) {
        this.deviceType = i;
    }

    public int getDfxLogType() {
        return this.dfxLogType;
    }

    public void setDfxLogType(int i) {
        this.dfxLogType = i;
    }

    public Object getCallback() {
        return this.callback;
    }

    public void setCallback(Object obj) {
        this.callback = obj;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeIntArray(this.recordId);
        parcel.writeInt(this.gpsType);
        parcel.writeInt(this.startTime);
        parcel.writeInt(this.endTime);
        parcel.writeInt(this.level);
        parcel.writeString(this.deviceMac);
        parcel.writeString(this.deviceVersion);
        parcel.writeInt(this.deviceType);
        parcel.writeInt(this.dfxLogType);
    }
}
