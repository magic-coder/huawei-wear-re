package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.p394c.C4540b;

public class HiTimeInterval implements Parcelable {
    public static final Creator<HiTimeInterval> CREATOR = new C4572o();
    private long endTime;
    private long startTime;
    private int timeZone;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiTimeInterval{");
        stringBuffer.append("startTime=").append(C4540b.m21764l(this.startTime));
        stringBuffer.append(", endTime=").append(C4540b.m21764l(this.endTime));
        stringBuffer.append(", timeZone=").append(this.timeZone);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public HiTimeInterval(long j, long j2) {
        this.startTime = j;
        this.endTime = j2;
    }

    public HiTimeInterval(int i, long j, long j2) {
        this.timeZone = i;
        this.endTime = j;
        this.startTime = j2;
    }

    protected HiTimeInterval(Parcel parcel) {
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.timeZone = parcel.readInt();
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

    public int getTimeZone() {
        return this.timeZone;
    }

    public void setTimeZone(int i) {
        this.timeZone = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.timeZone);
    }
}
