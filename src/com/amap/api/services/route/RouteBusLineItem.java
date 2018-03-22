package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.amap.api.services.busline.BusLineItem;
import com.amap.api.services.busline.BusStationItem;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;

public class RouteBusLineItem extends BusLineItem implements Parcelable {
    public static final Creator<RouteBusLineItem> CREATOR = new C3479j();
    private BusStationItem f12788a;
    private BusStationItem f12789b;
    private List<LatLonPoint> f12790c = new ArrayList();
    private int f12791d;
    private List<BusStationItem> f12792e = new ArrayList();
    private float f12793f;

    public BusStationItem getDepartureBusStation() {
        return this.f12788a;
    }

    public void setDepartureBusStation(BusStationItem busStationItem) {
        this.f12788a = busStationItem;
    }

    public BusStationItem getArrivalBusStation() {
        return this.f12789b;
    }

    public void setArrivalBusStation(BusStationItem busStationItem) {
        this.f12789b = busStationItem;
    }

    public List<LatLonPoint> getPolyline() {
        return this.f12790c;
    }

    public void setPolyline(List<LatLonPoint> list) {
        this.f12790c = list;
    }

    public int getPassStationNum() {
        return this.f12791d;
    }

    public void setPassStationNum(int i) {
        this.f12791d = i;
    }

    public List<BusStationItem> getPassStations() {
        return this.f12792e;
    }

    public void setPassStations(List<BusStationItem> list) {
        this.f12792e = list;
    }

    public float getDuration() {
        return this.f12793f;
    }

    public void setDuration(float f) {
        this.f12793f = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeParcelable(this.f12788a, i);
        parcel.writeParcelable(this.f12789b, i);
        parcel.writeTypedList(this.f12790c);
        parcel.writeInt(this.f12791d);
        parcel.writeTypedList(this.f12792e);
        parcel.writeFloat(this.f12793f);
    }

    public RouteBusLineItem(Parcel parcel) {
        super(parcel);
        this.f12788a = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f12789b = (BusStationItem) parcel.readParcelable(BusStationItem.class.getClassLoader());
        this.f12790c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f12791d = parcel.readInt();
        this.f12792e = parcel.createTypedArrayList(BusStationItem.CREATOR);
        this.f12793f = parcel.readFloat();
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12789b == null ? 0 : this.f12789b.hashCode()) + (super.hashCode() * 31)) * 31;
        if (this.f12788a != null) {
            i = this.f12788a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        RouteBusLineItem routeBusLineItem = (RouteBusLineItem) obj;
        if (this.f12789b == null) {
            if (routeBusLineItem.f12789b != null) {
                return false;
            }
        } else if (!this.f12789b.equals(routeBusLineItem.f12789b)) {
            return false;
        }
        if (this.f12788a == null) {
            if (routeBusLineItem.f12788a != null) {
                return false;
            }
            return true;
        } else if (this.f12788a.equals(routeBusLineItem.f12788a)) {
            return true;
        } else {
            return false;
        }
    }
}
