package com.huawei.lcagent.client;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class CompressInfo implements Parcelable {
    public static final int COLLECT_LOG = 0;
    public static final int COMPRESS_LOG = 1;
    public static final Creator<CompressInfo> CREATOR = new C54191();
    public static final int FINISHED = 2;
    public String description;
    public String path;
    public int progress;
    public int status;

    class C54191 implements Creator<CompressInfo> {
        C54191() {
        }

        public CompressInfo createFromParcel(Parcel parcel) {
            return new CompressInfo(parcel);
        }

        public CompressInfo[] newArray(int i) {
            return new CompressInfo[i];
        }
    }

    public CompressInfo() {
        this.status = 0;
        this.progress = 0;
        this.path = "";
        this.description = "";
    }

    private CompressInfo(Parcel parcel) {
        this.status = parcel.readInt();
        this.progress = parcel.readInt();
        this.path = parcel.readString();
        this.description = parcel.readString();
    }

    public void setCompressInfo(int i, int i2, String str, String str2) {
        this.status = i;
        this.progress = i2;
        this.path = str;
        this.description = str2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.status);
        parcel.writeInt(this.progress);
        parcel.writeString(this.path);
        parcel.writeString(this.description);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("status = " + this.status + "\n");
        stringBuilder.append("progress = " + this.progress + "%" + "\n");
        stringBuilder.append("path = " + this.path + "\n");
        stringBuilder.append("description = " + this.description + "\n");
        return stringBuilder.toString();
    }

    public void readFromParcel(Parcel parcel) {
        this.status = parcel.readInt();
        this.progress = parcel.readInt();
        this.path = parcel.readString();
        this.description = parcel.readString();
    }
}
