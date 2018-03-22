package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class BusStep implements Parcelable {
    public static final Creator<BusStep> CREATOR = new C3472c();
    private RouteBusWalkItem f12761a;
    private List<RouteBusLineItem> f12762b = new ArrayList();
    private Doorway f12763c;
    private Doorway f12764d;

    public RouteBusWalkItem getWalk() {
        return this.f12761a;
    }

    public void setWalk(RouteBusWalkItem routeBusWalkItem) {
        this.f12761a = routeBusWalkItem;
    }

    public RouteBusLineItem getBusLine() {
        if (this.f12762b == null || this.f12762b.size() == 0) {
            return null;
        }
        return (RouteBusLineItem) this.f12762b.get(0);
    }

    public void setBusLine(RouteBusLineItem routeBusLineItem) {
        if (this.f12762b != null) {
            if (this.f12762b.size() == 0) {
                this.f12762b.add(routeBusLineItem);
            }
            this.f12762b.set(0, routeBusLineItem);
        }
    }

    public void setBusLines(List<RouteBusLineItem> list) {
        this.f12762b = list;
    }

    public Doorway getEntrance() {
        return this.f12763c;
    }

    public void setEntrance(Doorway doorway) {
        this.f12763c = doorway;
    }

    public Doorway getExit() {
        return this.f12764d;
    }

    public void setExit(Doorway doorway) {
        this.f12764d = doorway;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12761a, i);
        parcel.writeTypedList(this.f12762b);
        parcel.writeParcelable(this.f12763c, i);
        parcel.writeParcelable(this.f12764d, i);
    }

    public BusStep(Parcel parcel) {
        this.f12761a = (RouteBusWalkItem) parcel.readParcelable(RouteBusWalkItem.class.getClassLoader());
        this.f12762b = parcel.createTypedArrayList(RouteBusLineItem.CREATOR);
        this.f12763c = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
        this.f12764d = (Doorway) parcel.readParcelable(Doorway.class.getClassLoader());
    }
}
