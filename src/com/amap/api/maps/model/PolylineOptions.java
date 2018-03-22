package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions implements Parcelable {
    public static final PolylineOptionsCreator CREATOR = new PolylineOptionsCreator();
    String f12102a;
    private final List<LatLng> f12103b = new ArrayList();
    private float f12104c = 10.0f;
    private int f12105d = ViewCompat.MEASURED_STATE_MASK;
    private float f12106e = 0.0f;
    private boolean f12107f = true;
    private BitmapDescriptor f12108g;
    private List<BitmapDescriptor> f12109h;
    private List<Integer> f12110i;
    private List<Integer> f12111j;
    private boolean f12112k = true;
    private boolean f12113l = false;
    private boolean f12114m = false;
    private boolean f12115n = false;

    public PolylineOptions setUseTexture(boolean z) {
        this.f12112k = z;
        return this;
    }

    public PolylineOptions setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        this.f12108g = bitmapDescriptor;
        return this;
    }

    public BitmapDescriptor getCustomTexture() {
        return this.f12108g;
    }

    public PolylineOptions setCustomTextureList(List<BitmapDescriptor> list) {
        this.f12109h = list;
        return this;
    }

    public List<BitmapDescriptor> getCustomTextureList() {
        return this.f12109h;
    }

    public PolylineOptions setCustomTextureIndex(List<Integer> list) {
        this.f12111j = list;
        return this;
    }

    public List<Integer> getCustomTextureIndex() {
        return this.f12111j;
    }

    public PolylineOptions colorValues(List<Integer> list) {
        this.f12110i = list;
        return this;
    }

    public List<Integer> getColorValues() {
        return this.f12110i;
    }

    public PolylineOptions useGradient(boolean z) {
        this.f12115n = z;
        return this;
    }

    public boolean isUseGradient() {
        return this.f12115n;
    }

    public boolean isUseTexture() {
        return this.f12112k;
    }

    public boolean isGeodesic() {
        return this.f12113l;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f12103b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f12103b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f12103b.add(add);
        }
        return this;
    }

    public PolylineOptions width(float f) {
        this.f12104c = f;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f12105d = i;
        return this;
    }

    public PolylineOptions zIndex(float f) {
        this.f12106e = f;
        return this;
    }

    public PolylineOptions visible(boolean z) {
        this.f12107f = z;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f12113l = z;
        return this;
    }

    public PolylineOptions setDottedLine(boolean z) {
        this.f12114m = z;
        return this;
    }

    public boolean isDottedLine() {
        return this.f12114m;
    }

    public List<LatLng> getPoints() {
        return this.f12103b;
    }

    public float getWidth() {
        return this.f12104c;
    }

    public int getColor() {
        return this.f12105d;
    }

    public float getZIndex() {
        return this.f12106e;
    }

    public boolean isVisible() {
        return this.f12107f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f12103b);
        parcel.writeFloat(this.f12104c);
        parcel.writeInt(this.f12105d);
        parcel.writeFloat(this.f12106e);
        parcel.writeString(this.f12102a);
        parcel.writeBooleanArray(new boolean[]{this.f12107f, this.f12114m, this.f12113l, this.f12115n});
        if (this.f12108g != null) {
            parcel.writeParcelable(this.f12108g, i);
        }
        if (this.f12109h != null) {
            parcel.writeList(this.f12109h);
        }
        if (this.f12111j != null) {
            parcel.writeList(this.f12111j);
        }
        if (this.f12110i != null) {
            parcel.writeList(this.f12110i);
        }
    }
}
