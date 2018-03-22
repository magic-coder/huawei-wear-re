package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Path implements Parcelable {
    public static final Creator<Path> CREATOR = new C3478i();
    private float f12749a;
    private long f12750b;

    public float getDistance() {
        return this.f12749a;
    }

    public void setDistance(float f) {
        this.f12749a = f;
    }

    public long getDuration() {
        return this.f12750b;
    }

    public void setDuration(long j) {
        this.f12750b = j;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.f12749a);
        parcel.writeLong(this.f12750b);
    }

    public Path(Parcel parcel) {
        this.f12749a = parcel.readFloat();
        this.f12750b = parcel.readLong();
    }
}
