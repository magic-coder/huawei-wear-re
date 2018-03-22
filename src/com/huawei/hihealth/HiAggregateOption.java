package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Arrays;

public class HiAggregateOption implements Parcelable {
    public static final Creator<HiAggregateOption> CREATOR = new C4538b();
    private int aggregateType;
    private int alignType;
    private int anchor;
    private String[] constantsKey;
    private int count;
    private String deviceUUID;
    private long endTime;
    private String filter;
    private int groupUnitSize;
    private int groupUnitType;
    private int ownerID;
    private int readType;
    private String sortName;
    private int sortOrder;
    private long startTime;
    private int[] type;

    protected HiAggregateOption(Parcel parcel) {
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.type = parcel.createIntArray();
        this.constantsKey = parcel.createStringArray();
        this.alignType = parcel.readInt();
        this.aggregateType = parcel.readInt();
        this.filter = parcel.readString();
        this.deviceUUID = parcel.readString();
        this.ownerID = parcel.readInt();
        this.sortName = parcel.readString();
        this.sortOrder = parcel.readInt();
        this.groupUnitSize = parcel.readInt();
        this.groupUnitType = parcel.readInt();
        this.readType = parcel.readInt();
        this.anchor = parcel.readInt();
        this.count = parcel.readInt();
    }

    public int getGroupUnitSize() {
        return this.groupUnitSize;
    }

    public void setGroupUnitSize(int i) {
        this.groupUnitSize = i;
    }

    public int getGroupUnitType() {
        return this.groupUnitType;
    }

    public void setGroupUnitType(int i) {
        this.groupUnitType = i;
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

    public int getAnchor() {
        return this.anchor;
    }

    public void setAnchor(int i) {
        this.anchor = i;
    }

    public int getCount() {
        return this.count;
    }

    public void setCount(int i) {
        this.count = i;
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

    public int getAlignType() {
        return this.alignType;
    }

    public void setAlignType(int i) {
        this.alignType = i;
    }

    public int getAggregateType() {
        return this.aggregateType;
    }

    public void setAggregateType(int i) {
        this.aggregateType = i;
    }

    private String getFilter() {
        return this.filter;
    }

    private void setFilter(String str) {
        this.filter = str;
    }

    public String getDeviceUUID() {
        return this.deviceUUID;
    }

    public void setDeviceUUID(String str) {
        this.deviceUUID = str;
    }

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int i) {
        this.ownerID = i;
    }

    public String getSortName() {
        return this.sortName;
    }

    public void setSortName(String str) {
        this.sortName = str;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public void setSortOrder(int i) {
        this.sortOrder = i;
    }

    public int getReadType() {
        return this.readType;
    }

    public void setReadType(int i) {
        this.readType = i;
    }

    public void setSort(String str, int i) {
        this.sortName = str;
        this.sortOrder = i;
    }

    public void setTimeRange(long j, long j2) {
        this.startTime = j;
        this.endTime = j2;
    }

    public void setTimeGroup(long j, long j2, int i, int i2) {
        this.startTime = j;
        this.endTime = j2;
        this.groupUnitSize = i;
        this.groupUnitType = i2;
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
        parcel.writeInt(this.aggregateType);
        parcel.writeString(this.filter);
        parcel.writeString(this.deviceUUID);
        parcel.writeInt(this.ownerID);
        parcel.writeString(this.sortName);
        parcel.writeInt(this.sortOrder);
        parcel.writeInt(this.groupUnitSize);
        parcel.writeInt(this.groupUnitType);
        parcel.writeInt(this.readType);
        parcel.writeInt(this.anchor);
        parcel.writeInt(this.count);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiAggregateOption{");
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
        stringBuffer.append(", constantsKey=").append(this.constantsKey == null ? "null" : Arrays.asList(this.constantsKey).toString());
        stringBuffer.append(", alignType=").append(this.alignType);
        stringBuffer.append(", aggregateType=").append(this.aggregateType);
        stringBuffer.append(", groupUnitSize=").append(this.groupUnitSize);
        stringBuffer.append(", groupUnitType=").append(this.groupUnitType);
        stringBuffer.append(", filter='").append(this.filter).append('\'');
        stringBuffer.append(", readType=").append(this.readType);
        stringBuffer.append(", sortName='").append(this.sortName).append('\'');
        stringBuffer.append(", sortOrder=").append(this.sortOrder);
        stringBuffer.append(", anchor=").append(this.anchor);
        stringBuffer.append(", count=").append(this.count);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
