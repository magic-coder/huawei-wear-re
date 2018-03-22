package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class BusStationItem implements Parcelable {
    public static final Creator<BusStationItem> CREATOR = new C3386b();
    private String f12243a;
    private String f12244b;
    private LatLonPoint f12245c;
    private String f12246d;
    private String f12247e;
    private List<BusLineItem> f12248f;

    public BusStationItem() {
        this.f12248f = new ArrayList();
    }

    public String getBusStationId() {
        return this.f12243a;
    }

    public void setBusStationId(String str) {
        this.f12243a = str;
    }

    public String getBusStationName() {
        return this.f12244b;
    }

    public void setBusStationName(String str) {
        this.f12244b = str;
    }

    public LatLonPoint getLatLonPoint() {
        return this.f12245c;
    }

    public void setLatLonPoint(LatLonPoint latLonPoint) {
        this.f12245c = latLonPoint;
    }

    public String getCityCode() {
        return this.f12246d;
    }

    public void setCityCode(String str) {
        this.f12246d = str;
    }

    public String getAdCode() {
        return this.f12247e;
    }

    public void setAdCode(String str) {
        this.f12247e = str;
    }

    public List<BusLineItem> getBusLineItems() {
        return this.f12248f;
    }

    public void setBusLineItems(List<BusLineItem> list) {
        this.f12248f = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        BusStationItem busStationItem = (BusStationItem) obj;
        if (this.f12243a == null) {
            if (busStationItem.f12243a != null) {
                return false;
            }
            return true;
        } else if (this.f12243a.equals(busStationItem.f12243a)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.f12243a == null ? 0 : this.f12243a.hashCode()) + 31;
    }

    public String toString() {
        return "BusStationName: " + this.f12244b + " LatLonPoint: " + this.f12245c.toString() + " BusLines: " + m16549a(this.f12248f) + " CityCode: " + this.f12246d + " AdCode: " + this.f12247e;
    }

    private String m16549a(List<BusLineItem> list) {
        StringBuffer stringBuffer = new StringBuffer();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                stringBuffer.append(((BusLineItem) list.get(i)).getBusLineName());
                if (i < list.size() - 1) {
                    stringBuffer.append("|");
                }
            }
        }
        return stringBuffer.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12244b);
        parcel.writeString(this.f12243a);
        parcel.writeValue(this.f12245c);
        parcel.writeString(this.f12246d);
        parcel.writeString(this.f12247e);
        parcel.writeList(this.f12248f);
    }

    private BusStationItem(Parcel parcel) {
        this.f12248f = new ArrayList();
        this.f12244b = parcel.readString();
        this.f12243a = parcel.readString();
        this.f12245c = (LatLonPoint) parcel.readValue(LatLonPoint.class.getClassLoader());
        this.f12246d = parcel.readString();
        this.f12247e = parcel.readString();
        this.f12248f = parcel.readArrayList(BusLineItem.class.getClassLoader());
    }
}
