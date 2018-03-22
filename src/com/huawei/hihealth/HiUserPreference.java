package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiUserPreference implements Parcelable {
    public static final Creator<HiUserPreference> CREATOR = new C4574q();
    private long createTime;
    private int id;
    private String key;
    private long modifiedTime = System.currentTimeMillis();
    private int syncStatus;
    private int userId;
    private String value;

    public HiUserPreference(String str, String str2) {
        this.key = str;
        this.value = str2;
    }

    protected HiUserPreference(Parcel parcel) {
        this.id = parcel.readInt();
        this.key = parcel.readString();
        this.value = parcel.readString();
        this.userId = parcel.readInt();
        this.syncStatus = parcel.readInt();
        this.createTime = parcel.readLong();
        this.modifiedTime = parcel.readLong();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int i) {
        this.id = i;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int i) {
        this.userId = i;
    }

    public int getSyncStatus() {
        return this.syncStatus;
    }

    public void setSyncStatus(int i) {
        this.syncStatus = i;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public long getModifiedTime() {
        return this.modifiedTime;
    }

    public void setModifiedTime(long j) {
        if (j > 0) {
            this.modifiedTime = j;
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiUserPreference{");
        stringBuffer.append("id=").append(this.id);
        stringBuffer.append(", key='").append(this.key).append('\'');
        stringBuffer.append(", value='").append(this.value).append('\'');
        stringBuffer.append(", userId='").append(this.userId).append('\'');
        stringBuffer.append(", syncStatus=").append(this.syncStatus);
        stringBuffer.append(", createTime=").append(this.createTime);
        stringBuffer.append(", modifiedTime=").append(this.modifiedTime);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.key);
        parcel.writeString(this.value);
        parcel.writeInt(this.userId);
        parcel.writeInt(this.syncStatus);
        parcel.writeLong(this.createTime);
        parcel.writeLong(this.modifiedTime);
    }
}
