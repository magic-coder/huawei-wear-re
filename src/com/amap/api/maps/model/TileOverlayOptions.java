package com.amap.api.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class TileOverlayOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private final int f12138a;
    private TileProvider f12139b;
    private boolean f12140c;
    private float f12141d;
    private int f12142e;
    private int f12143f;
    private String f12144g;
    private boolean f12145h;
    private boolean f12146i;

    public TileOverlayOptions() {
        this.f12140c = true;
        this.f12142e = 5242880;
        this.f12143f = 20971520;
        this.f12144g = null;
        this.f12145h = true;
        this.f12146i = true;
        this.f12138a = 1;
    }

    TileOverlayOptions(int i, IBinder iBinder, boolean z, float f) {
        this.f12140c = true;
        this.f12142e = 5242880;
        this.f12143f = 20971520;
        this.f12144g = null;
        this.f12145h = true;
        this.f12146i = true;
        this.f12138a = i;
        this.f12140c = z;
        this.f12141d = f;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.f12138a);
        parcel.writeValue(this.f12139b);
        parcel.writeByte((byte) (this.f12140c ? 1 : 0));
        parcel.writeFloat(this.f12141d);
        parcel.writeInt(this.f12142e);
        parcel.writeInt(this.f12143f);
        parcel.writeString(this.f12144g);
        if (this.f12145h) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.f12146i) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }

    public TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this.f12139b = tileProvider;
        return this;
    }

    public TileOverlayOptions zIndex(float f) {
        this.f12141d = f;
        return this;
    }

    public TileOverlayOptions visible(boolean z) {
        this.f12140c = z;
        return this;
    }

    public TileOverlayOptions memCacheSize(int i) {
        this.f12142e = i;
        return this;
    }

    public TileOverlayOptions diskCacheSize(int i) {
        this.f12143f = i * 1024;
        return this;
    }

    public TileOverlayOptions diskCacheDir(String str) {
        this.f12144g = str;
        return this;
    }

    public TileOverlayOptions memoryCacheEnabled(boolean z) {
        this.f12145h = z;
        return this;
    }

    public TileOverlayOptions diskCacheEnabled(boolean z) {
        this.f12146i = z;
        return this;
    }

    public TileProvider getTileProvider() {
        return this.f12139b;
    }

    public float getZIndex() {
        return this.f12141d;
    }

    public boolean isVisible() {
        return this.f12140c;
    }

    public int getMemCacheSize() {
        return this.f12142e;
    }

    public int getDiskCacheSize() {
        return this.f12143f;
    }

    public String getDiskCacheDir() {
        return this.f12144g;
    }

    public boolean getMemoryCacheEnabled() {
        return this.f12145h;
    }

    public boolean getDiskCacheEnabled() {
        return this.f12146i;
    }
}
