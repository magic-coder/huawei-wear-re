package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions implements Parcelable {
    public static final PolygonOptionsCreator CREATOR = new PolygonOptionsCreator();
    String f12094a;
    private final List<LatLng> f12095b = new ArrayList();
    private float f12096c = 10.0f;
    private int f12097d = ViewCompat.MEASURED_STATE_MASK;
    private int f12098e = ViewCompat.MEASURED_STATE_MASK;
    private float f12099f = 0.0f;
    private boolean f12100g = true;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f12095b);
        parcel.writeFloat(this.f12096c);
        parcel.writeInt(this.f12097d);
        parcel.writeInt(this.f12098e);
        parcel.writeFloat(this.f12099f);
        parcel.writeByte((byte) (this.f12100g ? 1 : 0));
        parcel.writeString(this.f12094a);
    }

    public PolygonOptions add(LatLng latLng) {
        this.f12095b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f12095b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f12095b.add(add);
        }
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f12096c = f;
        return this;
    }

    public PolygonOptions strokeColor(int i) {
        this.f12097d = i;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f12098e = i;
        return this;
    }

    public PolygonOptions zIndex(float f) {
        this.f12099f = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f12100g = z;
        return this;
    }

    public List<LatLng> getPoints() {
        return this.f12095b;
    }

    public float getStrokeWidth() {
        return this.f12096c;
    }

    public int getStrokeColor() {
        return this.f12097d;
    }

    public int getFillColor() {
        return this.f12098e;
    }

    public float getZIndex() {
        return this.f12099f;
    }

    public boolean isVisible() {
        return this.f12100g;
    }
}
