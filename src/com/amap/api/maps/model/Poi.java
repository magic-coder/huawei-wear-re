package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Poi implements Parcelable {
    public static final PoiCreator CREATOR = new PoiCreator();
    private final String f12088a;
    private final LatLng f12089b;
    private final String f12090c;

    public Poi(String str, LatLng latLng, String str2) {
        this.f12088a = str;
        this.f12089b = latLng;
        this.f12090c = str2;
    }

    public String getName() {
        return this.f12088a;
    }

    public LatLng getCoordinate() {
        return this.f12089b;
    }

    public String getPoiId() {
        return this.f12090c;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Poi)) {
            return false;
        }
        Poi poi = (Poi) obj;
        if (poi.getName().equals(this.f12088a) && poi.getCoordinate().equals(this.f12089b) && poi.getPoiId().equals(this.f12090c)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "poiid " + this.f12090c + " name:" + this.f12088a + "  coordinate:" + this.f12089b.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f12088a);
        parcel.writeParcelable(this.f12089b, i);
        parcel.writeString(this.f12090c);
    }
}
