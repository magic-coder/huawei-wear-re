package com.amap.api.maps.offlinemap;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class OfflineMapProvince extends Province {
    public static final Creator<OfflineMapProvince> CREATOR = new C3379c();
    private String f12175a;
    private int f12176b = 6;
    private long f12177c;
    private String f12178d;
    private int f12179e = 0;
    private ArrayList<OfflineMapCity> f12180f;

    public String getUrl() {
        return this.f12175a;
    }

    public void setUrl(String str) {
        this.f12175a = str;
    }

    public int getState() {
        return this.f12176b;
    }

    public void setState(int i) {
        this.f12176b = i;
    }

    public long getSize() {
        return this.f12177c;
    }

    public void setSize(long j) {
        this.f12177c = j;
    }

    public String getVersion() {
        return this.f12178d;
    }

    public void setVersion(String str) {
        this.f12178d = str;
    }

    public int getcompleteCode() {
        return this.f12179e;
    }

    public void setCompleteCode(int i) {
        this.f12179e = i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f12175a);
        parcel.writeInt(this.f12176b);
        parcel.writeLong(this.f12177c);
        parcel.writeString(this.f12178d);
        parcel.writeInt(this.f12179e);
        parcel.writeTypedList(this.f12180f);
    }

    public ArrayList<OfflineMapCity> getCityList() {
        if (this.f12180f == null) {
            return new ArrayList();
        }
        return this.f12180f;
    }

    public void setCityList(ArrayList<OfflineMapCity> arrayList) {
        this.f12180f = arrayList;
    }

    public OfflineMapProvince(Parcel parcel) {
        super(parcel);
        this.f12175a = parcel.readString();
        this.f12176b = parcel.readInt();
        this.f12177c = parcel.readLong();
        this.f12178d = parcel.readString();
        this.f12179e = parcel.readInt();
        this.f12180f = parcel.createTypedArrayList(OfflineMapCity.CREATOR);
    }
}
