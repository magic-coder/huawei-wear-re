package com.huawei.hihealth;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class HiDataDeleteOption implements Parcelable {
    public static final Creator<HiDataDeleteOption> CREATOR = new C4547d();
    private int ownerID;
    private List<HiTimeInterval> times;
    private int[] types;

    public HiDataDeleteOption() {
        this.times = new ArrayList();
    }

    public HiDataDeleteOption(int[] iArr) {
        this.times = new ArrayList();
        setTypes(iArr);
    }

    protected HiDataDeleteOption(Parcel parcel) {
        this.times = parcel.createTypedArrayList(HiTimeInterval.CREATOR);
        this.types = parcel.createIntArray();
        this.ownerID = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.times);
        parcel.writeIntArray(this.types);
        parcel.writeInt(this.ownerID);
    }

    public int describeContents() {
        return 0;
    }

    public void setTimeInterval(long j, long j2) {
        addTimeInterval(new HiTimeInterval(j, j2));
    }

    public void addTimeInterval(HiTimeInterval hiTimeInterval) {
        this.times.add(hiTimeInterval);
    }

    public int[] getTypes() {
        if (this.types == null) {
            return null;
        }
        return (int[]) this.types.clone();
    }

    public void setTypes(int[] iArr) {
        if (iArr == null) {
            this.types = null;
        } else {
            this.types = (int[]) iArr.clone();
        }
    }

    public int getOwnerID() {
        return this.ownerID;
    }

    public void setOwnerID(int i) {
        this.ownerID = i;
    }

    public List<HiTimeInterval> getTimes() {
        return this.times;
    }

    public void setTimes(List<HiTimeInterval> list) {
        this.times = list;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("HiDataDeleteOption{");
        stringBuffer.append("times=").append(this.times);
        stringBuffer.append(", types=");
        if (this.types == null) {
            stringBuffer.append("null");
        } else {
            stringBuffer.append('[');
            int i = 0;
            while (i < this.types.length) {
                stringBuffer.append(i == 0 ? "" : ", ").append(this.types[i]);
                i++;
            }
            stringBuffer.append(']');
        }
        stringBuffer.append(", ownerID=").append(this.ownerID);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
