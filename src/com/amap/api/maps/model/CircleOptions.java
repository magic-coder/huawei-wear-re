package com.amap.api.maps.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

public final class CircleOptions implements Parcelable {
    public static final CircleOptionsCreator CREATOR = new CircleOptionsCreator();
    String f12011a;
    private LatLng f12012b = null;
    private double f12013c = 0.0d;
    private float f12014d = 10.0f;
    private int f12015e = ViewCompat.MEASURED_STATE_MASK;
    private int f12016f = 0;
    private float f12017g = 0.0f;
    private boolean f12018h = true;

    public void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        if (this.f12012b != null) {
            bundle.putDouble("lat", this.f12012b.latitude);
            bundle.putDouble("lng", this.f12012b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeDouble(this.f12013c);
        parcel.writeFloat(this.f12014d);
        parcel.writeInt(this.f12015e);
        parcel.writeInt(this.f12016f);
        parcel.writeFloat(this.f12017g);
        parcel.writeByte((byte) (this.f12018h ? 1 : 0));
        parcel.writeString(this.f12011a);
    }

    public int describeContents() {
        return 0;
    }

    public CircleOptions center(LatLng latLng) {
        this.f12012b = latLng;
        return this;
    }

    public CircleOptions radius(double d) {
        this.f12013c = d;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f12014d = f;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f12015e = i;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f12016f = i;
        return this;
    }

    public CircleOptions zIndex(float f) {
        this.f12017g = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f12018h = z;
        return this;
    }

    public LatLng getCenter() {
        return this.f12012b;
    }

    public double getRadius() {
        return this.f12013c;
    }

    public float getStrokeWidth() {
        return this.f12014d;
    }

    public int getStrokeColor() {
        return this.f12015e;
    }

    public int getFillColor() {
        return this.f12016f;
    }

    public float getZIndex() {
        return this.f12017g;
    }

    public boolean isVisible() {
        return this.f12018h;
    }
}
