package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.au;
import com.android.volley.DefaultRetryPolicy;

public final class GroundOverlayOptions implements Parcelable {
    public static final GroundOverlayOptionsCreator CREATOR = new GroundOverlayOptionsCreator();
    public static final float NO_DIMENSION = -1.0f;
    private final int f12028a;
    private BitmapDescriptor f12029b;
    private LatLng f12030c;
    private float f12031d;
    private float f12032e;
    private LatLngBounds f12033f;
    private float f12034g;
    private float f12035h;
    private boolean f12036i;
    private float f12037j;
    private float f12038k;
    private float f12039l;

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7) {
        this.f12035h = 0.0f;
        this.f12036i = true;
        this.f12037j = 0.0f;
        this.f12038k = 0.5f;
        this.f12039l = 0.5f;
        this.f12028a = i;
        this.f12029b = BitmapDescriptorFactory.fromBitmap(null);
        this.f12030c = latLng;
        this.f12031d = f;
        this.f12032e = f2;
        this.f12033f = latLngBounds;
        this.f12034g = f3;
        this.f12035h = f4;
        this.f12036i = z;
        this.f12037j = f5;
        this.f12038k = f6;
        this.f12039l = f7;
    }

    public GroundOverlayOptions() {
        this.f12035h = 0.0f;
        this.f12036i = true;
        this.f12037j = 0.0f;
        this.f12038k = 0.5f;
        this.f12039l = 0.5f;
        this.f12028a = 1;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f12029b = bitmapDescriptor;
        return this;
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f12038k = f;
        this.f12039l = f2;
        return this;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z;
        boolean z2 = true;
        if (this.f12033f == null) {
            z = true;
        } else {
            z = false;
        }
        au.m15521a(z, (Object) "Position has already been set using positionFromBounds");
        if (latLng != null) {
            z = true;
        } else {
            z = false;
        }
        au.m15523b(z, "Location must be specified");
        if (f < 0.0f) {
            z2 = false;
        }
        au.m15523b(z2, "Width must be non-negative");
        return m16442a(latLng, f, f);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z;
        boolean z2 = true;
        if (this.f12033f == null) {
            z = true;
        } else {
            z = false;
        }
        au.m15521a(z, (Object) "Position has already been set using positionFromBounds");
        if (latLng != null) {
            z = true;
        } else {
            z = false;
        }
        au.m15523b(z, "Location must be specified");
        if (f >= 0.0f) {
            z = true;
        } else {
            z = false;
        }
        au.m15523b(z, "Width must be non-negative");
        if (f2 < 0.0f) {
            z2 = false;
        }
        au.m15523b(z2, "Height must be non-negative");
        return m16442a(latLng, f, f2);
    }

    private GroundOverlayOptions m16442a(LatLng latLng, float f, float f2) {
        this.f12030c = latLng;
        this.f12031d = f;
        this.f12032e = f2;
        return this;
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        au.m15521a(this.f12030c == null, "Position has already been set using position: " + this.f12030c);
        this.f12033f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f12034g = f;
        return this;
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f12035h = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f12036i = z;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
        au.m15523b(z, "Transparency must be in the range [0..1]");
        this.f12037j = f;
        return this;
    }

    public BitmapDescriptor getImage() {
        return this.f12029b;
    }

    public LatLng getLocation() {
        return this.f12030c;
    }

    public float getWidth() {
        return this.f12031d;
    }

    public float getHeight() {
        return this.f12032e;
    }

    public LatLngBounds getBounds() {
        return this.f12033f;
    }

    public float getBearing() {
        return this.f12034g;
    }

    public float getZIndex() {
        return this.f12035h;
    }

    public float getTransparency() {
        return this.f12037j;
    }

    public float getAnchorU() {
        return this.f12038k;
    }

    public float getAnchorV() {
        return this.f12039l;
    }

    public boolean isVisible() {
        return this.f12036i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12028a);
        parcel.writeParcelable(this.f12029b, i);
        parcel.writeParcelable(this.f12030c, i);
        parcel.writeFloat(this.f12031d);
        parcel.writeFloat(this.f12032e);
        parcel.writeParcelable(this.f12033f, i);
        parcel.writeFloat(this.f12034g);
        parcel.writeFloat(this.f12035h);
        parcel.writeByte((byte) (this.f12036i ? 1 : 0));
        parcel.writeFloat(this.f12037j);
        parcel.writeFloat(this.f12038k);
        parcel.writeFloat(this.f12039l);
    }
}
