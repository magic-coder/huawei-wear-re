package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.huawei.hihealth.data.p396c.C4558e;

public class HiSubscribeTrigger implements Parcelable {
    public static final Creator<HiSubscribeTrigger> CREATOR = new C4570m();
    private C4558e change;
    private HiHealthClient client;
    private int compareType;
    private HiHealthData data;
    private double increment;
    private int intervalType;
    private long millionSecond;
    private Object threshold;

    protected HiSubscribeTrigger(Parcel parcel) {
        this.millionSecond = parcel.readLong();
        this.intervalType = parcel.readInt();
        this.compareType = parcel.readInt();
        this.increment = parcel.readDouble();
        this.client = (HiHealthClient) parcel.readParcelable(HiHealthClient.class.getClassLoader());
        this.data = (HiHealthData) parcel.readParcelable(HiHealthData.class.getClassLoader());
    }

    public void setInterval(long j) {
        this.millionSecond = j;
    }

    public void setExInterval(int i) {
        this.intervalType = i;
    }

    public void setThreshold(Object obj, int i) {
        this.threshold = obj;
        this.compareType = i;
    }

    public void setIncrement(double d) {
        this.increment = d;
    }

    public boolean check(int i, HiHealthClient hiHealthClient, C4558e c4558e, HiHealthData hiHealthData) {
        this.compareType = i;
        this.client = hiHealthClient;
        this.change = c4558e;
        this.data = hiHealthData;
        return true;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.millionSecond);
        parcel.writeInt(this.intervalType);
        parcel.writeInt(this.compareType);
        parcel.writeDouble(this.increment);
        parcel.writeParcelable(this.client, i);
        parcel.writeParcelable(this.data, i);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiSubscribeTrigger{");
        stringBuffer.append("millionSecond=").append(this.millionSecond);
        stringBuffer.append(", intervalType=").append(this.intervalType);
        stringBuffer.append(", threshold=").append(this.threshold);
        stringBuffer.append(", compareType=").append(this.compareType);
        stringBuffer.append(", increment=").append(this.increment);
        stringBuffer.append(", client=").append(this.client);
        stringBuffer.append(", change=").append(this.change);
        stringBuffer.append(", data=").append(this.data);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
