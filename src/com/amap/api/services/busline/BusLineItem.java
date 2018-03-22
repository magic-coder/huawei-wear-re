package com.amap.api.services.busline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.core.C3409d;
import com.amap.api.services.core.LatLonPoint;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusLineItem implements Parcelable {
    public static final Creator<BusLineItem> CREATOR = new C3385a();
    private float f12209a;
    private String f12210b;
    private String f12211c;
    private String f12212d;
    private List<LatLonPoint> f12213e = new ArrayList();
    private List<LatLonPoint> f12214f = new ArrayList();
    private String f12215g;
    private String f12216h;
    private String f12217i;
    private Date f12218j;
    private Date f12219k;
    private String f12220l;
    private float f12221m;
    private float f12222n;
    private List<BusStationItem> f12223o = new ArrayList();

    public float getDistance() {
        return this.f12209a;
    }

    public void setDistance(float f) {
        this.f12209a = f;
    }

    public String getBusLineName() {
        return this.f12210b;
    }

    public void setBusLineName(String str) {
        this.f12210b = str;
    }

    public String getBusLineType() {
        return this.f12211c;
    }

    public void setBusLineType(String str) {
        this.f12211c = str;
    }

    public String getCityCode() {
        return this.f12212d;
    }

    public void setCityCode(String str) {
        this.f12212d = str;
    }

    public List<LatLonPoint> getDirectionsCoordinates() {
        return this.f12213e;
    }

    public void setDirectionsCoordinates(List<LatLonPoint> list) {
        this.f12213e = list;
    }

    public List<LatLonPoint> getBounds() {
        return this.f12214f;
    }

    public void setBounds(List<LatLonPoint> list) {
        this.f12214f = list;
    }

    public String getBusLineId() {
        return this.f12215g;
    }

    public void setBusLineId(String str) {
        this.f12215g = str;
    }

    public String getOriginatingStation() {
        return this.f12216h;
    }

    public void setOriginatingStation(String str) {
        this.f12216h = str;
    }

    public String getTerminalStation() {
        return this.f12217i;
    }

    public void setTerminalStation(String str) {
        this.f12217i = str;
    }

    public Date getFirstBusTime() {
        if (this.f12218j == null) {
            return null;
        }
        return (Date) this.f12218j.clone();
    }

    public void setFirstBusTime(Date date) {
        if (date == null) {
            this.f12218j = null;
        } else {
            this.f12218j = (Date) date.clone();
        }
    }

    public Date getLastBusTime() {
        if (this.f12219k == null) {
            return null;
        }
        return (Date) this.f12219k.clone();
    }

    public void setLastBusTime(Date date) {
        if (date == null) {
            this.f12219k = null;
        } else {
            this.f12219k = (Date) date.clone();
        }
    }

    public String getBusCompany() {
        return this.f12220l;
    }

    public void setBusCompany(String str) {
        this.f12220l = str;
    }

    public float getBasicPrice() {
        return this.f12221m;
    }

    public void setBasicPrice(float f) {
        this.f12221m = f;
    }

    public float getTotalPrice() {
        return this.f12222n;
    }

    public void setTotalPrice(float f) {
        this.f12222n = f;
    }

    public List<BusStationItem> getBusStations() {
        return this.f12223o;
    }

    public void setBusStations(List<BusStationItem> list) {
        this.f12223o = list;
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
        BusLineItem busLineItem = (BusLineItem) obj;
        if (this.f12215g == null) {
            if (busLineItem.f12215g != null) {
                return false;
            }
            return true;
        } else if (this.f12215g.equals(busLineItem.f12215g)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (this.f12215g == null ? 0 : this.f12215g.hashCode()) + 31;
    }

    public String toString() {
        return this.f12210b + HwAccountConstants.BLANK + C3409d.m16879a(this.f12218j) + "-" + C3409d.m16879a(this.f12219k);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f12209a);
        parcel.writeString(this.f12210b);
        parcel.writeString(this.f12211c);
        parcel.writeString(this.f12212d);
        parcel.writeList(this.f12213e);
        parcel.writeList(this.f12214f);
        parcel.writeString(this.f12215g);
        parcel.writeString(this.f12216h);
        parcel.writeString(this.f12217i);
        parcel.writeString(C3409d.m16879a(this.f12218j));
        parcel.writeString(C3409d.m16879a(this.f12219k));
        parcel.writeString(this.f12220l);
        parcel.writeFloat(this.f12221m);
        parcel.writeFloat(this.f12222n);
        parcel.writeList(this.f12223o);
    }

    public BusLineItem(Parcel parcel) {
        this.f12209a = parcel.readFloat();
        this.f12210b = parcel.readString();
        this.f12211c = parcel.readString();
        this.f12212d = parcel.readString();
        this.f12213e = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f12214f = parcel.readArrayList(LatLonPoint.class.getClassLoader());
        this.f12215g = parcel.readString();
        this.f12216h = parcel.readString();
        this.f12217i = parcel.readString();
        this.f12218j = C3409d.m16886e(parcel.readString());
        this.f12219k = C3409d.m16886e(parcel.readString());
        this.f12220l = parcel.readString();
        this.f12221m = parcel.readFloat();
        this.f12222n = parcel.readFloat();
        this.f12223o = parcel.readArrayList(BusStationItem.class.getClassLoader());
    }
}
