package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class HiDataInsertOption implements Parcelable {
    public static final Creator<HiDataInsertOption> CREATOR = new C4562e();
    private List<HiHealthData> datas;
    private int writeStatType;

    public HiDataInsertOption() {
        this.datas = new ArrayList();
    }

    public HiDataInsertOption(List<HiHealthData> list) {
        this.datas = list;
    }

    protected HiDataInsertOption(Parcel parcel) {
        this.writeStatType = parcel.readInt();
        this.datas = parcel.createTypedArrayList(HiHealthData.CREATOR);
    }

    public void addData(HiHealthData hiHealthData) {
        this.datas.add(hiHealthData);
    }

    public List<HiHealthData> getDatas() {
        return this.datas;
    }

    public void setDatas(List<HiHealthData> list) {
        this.datas = list;
    }

    public int getWriteStatType() {
        return this.writeStatType;
    }

    public void setWriteStatType(int i) {
        this.writeStatType = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.writeStatType);
        parcel.writeTypedList(this.datas);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiDataInsertOption{");
        stringBuffer.append("writeStatType=").append(this.writeStatType);
        stringBuffer.append(", datas=").append(this.datas);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
