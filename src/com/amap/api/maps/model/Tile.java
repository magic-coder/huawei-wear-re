package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public final class Tile implements Parcelable {
    public static final C3370d CREATOR = new C3370d();
    private final int f12136a;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f12136a = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12136a);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
    }
}
