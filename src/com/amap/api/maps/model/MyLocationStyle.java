package com.amap.api.maps.model;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.volley.DefaultRetryPolicy;

public class MyLocationStyle implements Parcelable {
    private BitmapDescriptor f12078a;
    private float f12079b = 0.5f;
    private float f12080c = 0.5f;
    private int f12081d = Color.argb(100, 0, 0, 180);
    private int f12082e = Color.argb(255, 0, 0, 220);
    private float f12083f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;

    public MyLocationStyle myLocationIcon(BitmapDescriptor bitmapDescriptor) {
        this.f12078a = bitmapDescriptor;
        return this;
    }

    public MyLocationStyle anchor(float f, float f2) {
        this.f12079b = f;
        this.f12080c = f2;
        return this;
    }

    public MyLocationStyle radiusFillColor(int i) {
        this.f12081d = i;
        return this;
    }

    public MyLocationStyle strokeColor(int i) {
        this.f12082e = i;
        return this;
    }

    public MyLocationStyle strokeWidth(float f) {
        this.f12083f = f;
        return this;
    }

    public BitmapDescriptor getMyLocationIcon() {
        return this.f12078a;
    }

    public float getAnchorU() {
        return this.f12079b;
    }

    public float getAnchorV() {
        return this.f12080c;
    }

    public int getRadiusFillColor() {
        return this.f12081d;
    }

    public int getStrokeColor() {
        return this.f12082e;
    }

    public float getStrokeWidth() {
        return this.f12083f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12078a, i);
        parcel.writeFloat(this.f12079b);
        parcel.writeFloat(this.f12080c);
        parcel.writeInt(this.f12081d);
        parcel.writeInt(this.f12082e);
        parcel.writeFloat(this.f12083f);
    }
}
