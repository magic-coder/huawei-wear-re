package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OfflineMapCity extends City {
    public static final Creator<OfflineMapCity> CREATOR = new C3378b();
    private String f11772a = "";
    private long f11773b = 0;
    private int f11774c = 6;
    private String f11775d = "";
    private int f11776e = 0;

    public String getUrl() {
        return this.f11772a;
    }

    public void setUrl(String str) {
        this.f11772a = str;
    }

    public long getSize() {
        return this.f11773b;
    }

    public void setSize(long j) {
        this.f11773b = j;
    }

    public int getState() {
        return this.f11774c;
    }

    public void setState(int i) {
        this.f11774c = i;
    }

    public String getVersion() {
        return this.f11775d;
    }

    public void setVersion(String str) {
        this.f11775d = str;
    }

    public int getcompleteCode() {
        return this.f11776e;
    }

    public void setCompleteCode(int i) {
        this.f11776e = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f11772a);
        parcel.writeLong(this.f11773b);
        parcel.writeInt(this.f11774c);
        parcel.writeString(this.f11775d);
        parcel.writeInt(this.f11776e);
    }

    public OfflineMapCity(Parcel parcel) {
        super(parcel);
        this.f11772a = parcel.readString();
        this.f11773b = parcel.readLong();
        this.f11774c = parcel.readInt();
        this.f11775d = parcel.readString();
        this.f11776e = parcel.readInt();
    }
}
