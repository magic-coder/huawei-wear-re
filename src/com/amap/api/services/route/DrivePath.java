package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

public class DrivePath extends Path implements Parcelable {
    public static final Creator<DrivePath> CREATOR = new C3475f();
    private String f12769a;
    private float f12770b;
    private float f12771c;
    private List<DriveStep> f12772d = new ArrayList();

    public String getStrategy() {
        return this.f12769a;
    }

    public void setStrategy(String str) {
        this.f12769a = str;
    }

    public float getTolls() {
        return this.f12770b;
    }

    public void setTolls(float f) {
        this.f12770b = f;
    }

    public float getTollDistance() {
        return this.f12771c;
    }

    public void setTollDistance(float f) {
        this.f12771c = f;
    }

    public List<DriveStep> getSteps() {
        return this.f12772d;
    }

    public void setSteps(List<DriveStep> list) {
        this.f12772d = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.f12769a);
        parcel.writeFloat(this.f12770b);
        parcel.writeFloat(this.f12771c);
        parcel.writeTypedList(this.f12772d);
    }

    public DrivePath(Parcel parcel) {
        super(parcel);
        this.f12769a = parcel.readString();
        this.f12770b = parcel.readFloat();
        this.f12771c = parcel.readFloat();
        this.f12772d = parcel.createTypedArrayList(DriveStep.CREATOR);
    }
}
