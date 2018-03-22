package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class BusPath extends Path implements Parcelable {
    public static final Creator<BusPath> CREATOR = new C3470a();
    private float f12751a;
    private boolean f12752b;
    private float f12753c;
    private float f12754d;
    private List<BusStep> f12755e = new ArrayList();

    public float getCost() {
        return this.f12751a;
    }

    public void setCost(float f) {
        this.f12751a = f;
    }

    public boolean isNightBus() {
        return this.f12752b;
    }

    public void setNightBus(boolean z) {
        this.f12752b = z;
    }

    public float getDistance() {
        return this.f12753c + this.f12754d;
    }

    public float getWalkDistance() {
        return this.f12753c;
    }

    public void setWalkDistance(float f) {
        this.f12753c = f;
    }

    public float getBusDistance() {
        return this.f12754d;
    }

    public void setBusDistance(float f) {
        this.f12754d = f;
    }

    public List<BusStep> getSteps() {
        return this.f12755e;
    }

    public void setSteps(List<BusStep> list) {
        this.f12755e = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeFloat(this.f12751a);
        parcel.writeBooleanArray(new boolean[]{this.f12752b});
        parcel.writeFloat(this.f12753c);
        parcel.writeFloat(this.f12754d);
        parcel.writeTypedList(this.f12755e);
    }

    public BusPath(Parcel parcel) {
        super(parcel);
        this.f12751a = parcel.readFloat();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.f12752b = zArr[0];
        this.f12753c = parcel.readFloat();
        this.f12754d = parcel.readFloat();
        this.f12755e = parcel.createTypedArrayList(BusStep.CREATOR);
    }
}
