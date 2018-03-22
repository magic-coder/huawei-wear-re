package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.p394c.C4540b;

public class HiGoalInfo implements Parcelable {
    public static final Creator<HiGoalInfo> CREATOR = new C4566i();
    private int dealLine;
    private int goalType;
    private int goalUnit;
    private double goalValue;
    private int ownerId = 0;
    private int targetType;

    protected HiGoalInfo(Parcel parcel) {
        this.goalType = parcel.readInt();
        this.goalValue = parcel.readDouble();
        this.goalUnit = parcel.readInt();
        this.ownerId = parcel.readInt();
        this.targetType = parcel.readInt();
        this.dealLine = parcel.readInt();
    }

    public int getGoalType() {
        return this.goalType;
    }

    public void setGoalType(int i) {
        this.goalType = i;
    }

    public double getGoalValue() {
        return this.goalValue;
    }

    public void setGoalValue(double d) {
        this.goalValue = d;
    }

    public int getGoalUnit() {
        return this.goalUnit;
    }

    public void setGoalUnit(int i) {
        this.goalUnit = i;
    }

    public void setTargetType(int i) {
        this.targetType = i;
    }

    public void setDealLine(int i) {
        this.dealLine = i;
    }

    public void setOwnerId(int i) {
        this.ownerId = i;
    }

    public int getOwnerId() {
        return this.ownerId;
    }

    public int getTargetType() {
        return this.targetType;
    }

    public int getDealLine() {
        return this.dealLine;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.goalType);
        parcel.writeDouble(this.goalValue);
        parcel.writeInt(this.goalUnit);
        parcel.writeInt(this.ownerId);
        parcel.writeInt(this.targetType);
        parcel.writeInt(this.dealLine);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiGoalInfo{");
        stringBuffer.append("goalType=").append(this.goalType);
        stringBuffer.append(", goalValue=").append(this.goalValue);
        stringBuffer.append(", goalUnit=").append(this.goalUnit);
        stringBuffer.append(", ownerId=").append(this.ownerId);
        stringBuffer.append(", targetType=").append(this.targetType);
        stringBuffer.append(", dealLine=").append(C4540b.m21764l((long) this.dealLine));
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
