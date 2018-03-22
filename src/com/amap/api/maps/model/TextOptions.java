package com.amap.api.maps.model;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.ViewCompat;

public final class TextOptions implements Parcelable {
    public static final TextOptionsCreator CREATOR = new TextOptionsCreator();
    String f12123a;
    private LatLng f12124b;
    private String f12125c;
    private Typeface f12126d = Typeface.DEFAULT;
    private float f12127e;
    private int f12128f = 4;
    private int f12129g = 32;
    private int f12130h = -1;
    private int f12131i = ViewCompat.MEASURED_STATE_MASK;
    private Object f12132j;
    private int f12133k = 20;
    private float f12134l = 0.0f;
    private boolean f12135m = true;

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12123a);
        Bundle bundle = new Bundle();
        if (this.f12124b != null) {
            bundle.putDouble("lat", this.f12124b.latitude);
            bundle.putDouble("lng", this.f12124b.longitude);
        }
        parcel.writeBundle(bundle);
        parcel.writeString(this.f12125c);
        parcel.writeInt(this.f12126d.getStyle());
        parcel.writeFloat(this.f12127e);
        parcel.writeInt(this.f12128f);
        parcel.writeInt(this.f12129g);
        parcel.writeInt(this.f12130h);
        parcel.writeInt(this.f12131i);
        parcel.writeInt(this.f12133k);
        parcel.writeFloat(this.f12134l);
        parcel.writeByte((byte) (this.f12135m ? 1 : 0));
        if (this.f12132j instanceof Parcelable) {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("obj", (Parcelable) this.f12132j);
            parcel.writeBundle(bundle2);
        }
    }

    public int describeContents() {
        return 0;
    }

    public TextOptions position(LatLng latLng) {
        this.f12124b = latLng;
        return this;
    }

    public TextOptions text(String str) {
        this.f12125c = str;
        return this;
    }

    public TextOptions typeface(Typeface typeface) {
        if (typeface != null) {
            this.f12126d = typeface;
        }
        return this;
    }

    public TextOptions visible(boolean z) {
        this.f12135m = z;
        return this;
    }

    public TextOptions zIndex(float f) {
        this.f12134l = f;
        return this;
    }

    public TextOptions rotate(float f) {
        this.f12127e = f;
        return this;
    }

    public TextOptions align(int i, int i2) {
        this.f12128f = i;
        this.f12129g = i2;
        return this;
    }

    public TextOptions backgroundColor(int i) {
        this.f12130h = i;
        return this;
    }

    public TextOptions setObject(Object obj) {
        this.f12132j = obj;
        return this;
    }

    public TextOptions fontColor(int i) {
        this.f12131i = i;
        return this;
    }

    public TextOptions fontSize(int i) {
        this.f12133k = i;
        return this;
    }

    public LatLng getPosition() {
        return this.f12124b;
    }

    public String getText() {
        return this.f12125c;
    }

    public Typeface getTypeface() {
        return this.f12126d;
    }

    public float getRotate() {
        return this.f12127e;
    }

    public int getAlignX() {
        return this.f12128f;
    }

    public int getAlignY() {
        return this.f12129g;
    }

    public int getBackgroundColor() {
        return this.f12130h;
    }

    public int getFontColor() {
        return this.f12131i;
    }

    public Object getObject() {
        return this.f12132j;
    }

    public int getFontSize() {
        return this.f12133k;
    }

    public float getZIndex() {
        return this.f12134l;
    }

    public boolean isVisible() {
        return this.f12135m;
    }
}
