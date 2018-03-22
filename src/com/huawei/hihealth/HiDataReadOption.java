package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class HiDataReadOption implements Parcelable {
    public static final Creator<HiDataReadOption> CREATOR = new C4563f();
    private int alignType;
    private int anchor;
    private String[] constantsKey;
    private int count;
    private String deviceUUID;
    private long endTime;
    private int ownerID;
    private int readType;
    private int sortOrder;
    private long startTime;
    private int[] type;

    protected HiDataReadOption(Parcel parcel) {
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.type = parcel.createIntArray();
        this.constantsKey = parcel.createStringArray();
        this.alignType = parcel.readInt();
        this.count = parcel.readInt();
        this.anchor = parcel.readInt();
        this.sortOrder = parcel.readInt();
        this.deviceUUID = parcel.readString();
        this.ownerID = parcel.readInt();
        this.readType = parcel.readInt();
    }

    public int getReadType() {
        return this.readType;
    }

    public void setReadType(int i) {
        this.readType = i;
    }

    public void setTimeInterval(long j, long j2) {
        this.startTime = j;
        this.endTime = j2;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public int[] getType() {
        if (this.type == null) {
            return null;
        }
        return (int[]) this.type.clone();
    }

    public void setType(int[] iArr) {
        if (iArr == null) {
            this.type = null;
        } else {
            this.type = (int[]) iArr.clone();
        }
    }

    public void setType(int[] iArr, String[] strArr, int i) {
        if (iArr != null) {
            this.type = (int[]) iArr.clone();
        }
        if (strArr != null) {
            this.constantsKey = (String[]) strArr.clone();
        }
        this.alignType = i;
    }

    public String getDeviceUUID() {
        return this.deviceUUID;
    }

    public void setDeviceUUID(String str) {
        this.deviceUUID = str;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public int getAnchor() {
        return this.anchor;
    }

    public void setAnchor(int i) {
        this.anchor = i;
    }

    public int getAlignType() {
        return this.alignType;
    }

    public void setAlignType(int i) {
        this.alignType = i;
    }

    public String[] getConstantsKey() {
        if (this.constantsKey == null) {
            return null;
        }
        return (String[]) this.constantsKey.clone();
    }

    public void setConstantsKey(String[] strArr) {
        if (strArr == null) {
            this.constantsKey = null;
        } else {
            this.constantsKey = (String[]) strArr.clone();
        }
    }

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int i) {
        this.ownerID = i;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(int i) {
        this.sortOrder = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiDataReadOption{");
        stringBuffer.append("startTime=").append(this.startTime);
        stringBuffer.append(", endTime=").append(this.endTime);
        stringBuffer.append(", type=");
        if (this.type == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append('[');
            int i = 0;
            while (i < this.type.length) {
                stringBuffer.append(i == 0 ? "" : ", ").append(this.type[i]);
                i++;
            }
            stringBuffer.append(']');
        }
        stringBuffer.append(", count = ").append(this.count);
        stringBuffer.append(", sortOrder=").append(this.sortOrder);
        stringBuffer.append(", readType=").append(this.readType);
        stringBuffer.append(", alignType=").append(this.alignType);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeIntArray(this.type);
        parcel.writeStringArray(this.constantsKey);
        parcel.writeInt(this.alignType);
        parcel.writeInt(this.count);
        parcel.writeInt(this.anchor);
        parcel.writeInt(this.sortOrder);
        parcel.writeString(this.deviceUUID);
        parcel.writeInt(this.ownerID);
        parcel.writeInt(this.readType);
    }
}
