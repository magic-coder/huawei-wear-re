package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.volley.DefaultRetryPolicy;
import java.util.ArrayList;

public final class MarkerOptions implements Parcelable {
    public static final MarkerOptionsCreator CREATOR = new MarkerOptionsCreator();
    String f12062a;
    private LatLng f12063b;
    private String f12064c;
    private String f12065d;
    private float f12066e = 0.5f;
    private float f12067f = DefaultRetryPolicy.DEFAULT_BACKOFF_MULT;
    private float f12068g = 0.0f;
    private boolean f12069h = false;
    private boolean f12070i = true;
    private boolean f12071j = false;
    private int f12072k = 0;
    private int f12073l = 0;
    private ArrayList<BitmapDescriptor> f12074m = new ArrayList();
    private int f12075n = 20;
    private boolean f12076o = false;
    private boolean f12077p = false;

    public MarkerOptions icons(ArrayList<BitmapDescriptor> arrayList) {
        this.f12074m = arrayList;
        return this;
    }

    public ArrayList<BitmapDescriptor> getIcons() {
        return this.f12074m;
    }

    public MarkerOptions period(int i) {
        if (i <= 1) {
            this.f12075n = 1;
        } else {
            this.f12075n = i;
        }
        return this;
    }

    public int getPeriod() {
        return this.f12075n;
    }

    public boolean isPerspective() {
        return this.f12071j;
    }

    public MarkerOptions perspective(boolean z) {
        this.f12071j = z;
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        this.f12063b = latLng;
        return this;
    }

    public MarkerOptions setFlat(boolean z) {
        this.f12077p = z;
        return this;
    }

    private void m16469a() {
        if (this.f12074m == null) {
            this.f12074m = new ArrayList();
        }
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        m16469a();
        this.f12074m.clear();
        this.f12074m.add(bitmapDescriptor);
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f12066e = f;
        this.f12067f = f2;
        return this;
    }

    public MarkerOptions setInfoWindowOffset(int i, int i2) {
        this.f12072k = i;
        this.f12073l = i2;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f12064c = str;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f12065d = str;
        return this;
    }

    public MarkerOptions draggable(boolean z) {
        this.f12069h = z;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f12070i = z;
        return this;
    }

    public MarkerOptions setGps(boolean z) {
        this.f12076o = z;
        return this;
    }

    public LatLng getPosition() {
        return this.f12063b;
    }

    public String getTitle() {
        return this.f12064c;
    }

    public String getSnippet() {
        return this.f12065d;
    }

    public BitmapDescriptor getIcon() {
        if (this.f12074m == null || this.f12074m.size() == 0) {
            return null;
        }
        return (BitmapDescriptor) this.f12074m.get(0);
    }

    public float getAnchorU() {
        return this.f12066e;
    }

    public int getInfoWindowOffsetX() {
        return this.f12072k;
    }

    public int getInfoWindowOffsetY() {
        return this.f12073l;
    }

    public float getAnchorV() {
        return this.f12067f;
    }

    public boolean isDraggable() {
        return this.f12069h;
    }

    public boolean isVisible() {
        return this.f12070i;
    }

    public boolean isGps() {
        return this.f12076o;
    }

    public boolean isFlat() {
        return this.f12077p;
    }

    public MarkerOptions zIndex(float f) {
        this.f12068g = f;
        return this;
    }

    public float getZIndex() {
        return this.f12068g;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f12063b, i);
        if (!(this.f12074m == null || this.f12074m.size() == 0)) {
            parcel.writeParcelable((Parcelable) this.f12074m.get(0), i);
        }
        parcel.writeString(this.f12064c);
        parcel.writeString(this.f12065d);
        parcel.writeFloat(this.f12066e);
        parcel.writeFloat(this.f12067f);
        parcel.writeInt(this.f12072k);
        parcel.writeInt(this.f12073l);
        parcel.writeBooleanArray(new boolean[]{this.f12070i, this.f12069h, this.f12076o, this.f12077p});
        parcel.writeString(this.f12062a);
        parcel.writeInt(this.f12075n);
        parcel.writeList(this.f12074m);
        parcel.writeFloat(this.f12068g);
    }
}
