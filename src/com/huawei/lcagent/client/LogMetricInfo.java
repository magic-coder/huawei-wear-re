package com.huawei.lcagent.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LogMetricInfo implements Parcelable {
    public static final Creator<LogMetricInfo> CREATOR = new C54201();
    public String description;
    public String[] files;
    public long id;
    public String logDetailedInfo;
    public String path;
    public String zipTime;

    class C54201 implements Creator<LogMetricInfo> {
        C54201() {
        }

        public LogMetricInfo createFromParcel(Parcel parcel) {
            return new LogMetricInfo(parcel);
        }

        public LogMetricInfo[] newArray(int i) {
            return new LogMetricInfo[i];
        }
    }

    public LogMetricInfo() {
        this.id = 0;
        this.description = null;
        this.files = null;
        this.path = null;
        this.zipTime = null;
        this.logDetailedInfo = null;
    }

    public LogMetricInfo(long j, String str, String str2, String[] strArr, String str3, String str4) {
        this.id = j;
        this.path = str;
        this.description = str2;
        this.zipTime = str3;
        this.logDetailedInfo = str4;
        if (strArr == null || strArr.length == 0) {
            this.files = null;
            return;
        }
        this.files = new String[strArr.length];
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            this.files[i] = strArr[i];
        }
    }

    private LogMetricInfo(Parcel parcel) {
        this.id = parcel.readLong();
        this.path = parcel.readString();
        this.description = parcel.readString();
        this.files = parcel.createStringArray();
        this.zipTime = parcel.readString();
        this.logDetailedInfo = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.id);
        parcel.writeString(this.path);
        parcel.writeString(this.description);
        parcel.writeStringArray(this.files);
        parcel.writeString(this.zipTime);
        parcel.writeString(this.logDetailedInfo);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id = " + this.id + "\n");
        stringBuilder.append("path = " + this.path + "\n");
        stringBuilder.append("description = " + this.description + "\n");
        if (this.files == null) {
            return stringBuilder.toString();
        }
        int length = this.files.length;
        for (int i = 0; i < length; i++) {
            stringBuilder.append("files[" + i + "]=" + this.files[i] + "\n");
        }
        stringBuilder.append("zipTime = " + this.zipTime + "\n");
        stringBuilder.append("logDetailedInfo = " + this.logDetailedInfo + "\n");
        return stringBuilder.toString();
    }
}
