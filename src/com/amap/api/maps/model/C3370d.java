package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;

/* compiled from: TileCreator */
class C3370d implements Creator<Tile> {
    C3370d() {
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m16477a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m16478a(i);
    }

    public Tile m16477a(Parcel parcel) {
        return new Tile(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.createByteArray());
    }

    public Tile[] m16478a(int i) {
        return new Tile[i];
    }
}
