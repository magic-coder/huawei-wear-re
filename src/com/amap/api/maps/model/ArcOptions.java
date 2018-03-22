package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

public final class ArcOptions implements Parcelable {
    public static final ArcOptionsCreator CREATOR = new ArcOptionsCreator();
    String f11995a;
    private LatLng f11996b;
    private LatLng f11997c;
    private LatLng f11998d;
    private float f11999e = 10.0f;
    private int f12000f = ViewCompat.MEASURED_STATE_MASK;
    private float f12001g = 0.0f;
    private boolean f12002h = true;

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f11996b != null) {
            bundle.putDouble("startlat", this.f11996b.latitude);
            bundle.putDouble("startlng", this.f11996b.longitude);
        }
        if (this.f11997c != null) {
            bundle.putDouble("passedlat", this.f11997c.latitude);
            bundle.putDouble("passedlng", this.f11997c.longitude);
        }
        if (this.f11998d != null) {
            bundle.putDouble("endlat", this.f11998d.latitude);
            bundle.putDouble("endlng", this.f11998d.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeFloat(this.f11999e);
        parcel.writeInt(this.f12000f);
        parcel.writeFloat(this.f12001g);
        parcel.writeByte((byte) (this.f12002h ? 1 : 0));
        parcel.writeString(this.f11995a);
    }

    public int describeContents() {
        return 0;
    }

    public ArcOptions point(LatLng latLng, LatLng latLng2, LatLng latLng3) {
        this.f11996b = latLng;
        this.f11997c = latLng2;
        this.f11998d = latLng3;
        return this;
    }

    public ArcOptions strokeWidth(float f) {
        this.f11999e = f;
        return this;
    }

    public ArcOptions strokeColor(int i) {
        this.f12000f = i;
        return this;
    }

    public ArcOptions zIndex(float f) {
        this.f12001g = f;
        return this;
    }

    public ArcOptions visible(boolean z) {
        this.f12002h = z;
        return this;
    }

    public float getStrokeWidth() {
        return this.f11999e;
    }

    public int getStrokeColor() {
        return this.f12000f;
    }

    public float getZIndex() {
        return this.f12001g;
    }

    public boolean isVisible() {
        return this.f12002h;
    }

    public LatLng getStart() {
        return this.f11996b;
    }

    public LatLng getPassed() {
        return this.f11997c;
    }

    public LatLng getEnd() {
        return this.f11998d;
    }
}
