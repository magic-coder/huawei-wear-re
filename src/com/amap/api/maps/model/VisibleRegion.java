package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.bk;

public final class VisibleRegion implements Parcelable {
    public static final VisibleRegionCreator CREATOR = new VisibleRegionCreator();
    private final int f12147a;
    public final LatLng farLeft;
    public final LatLng farRight;
    public final LatLngBounds latLngBounds;
    public final LatLng nearLeft;
    public final LatLng nearRight;

    VisibleRegion(int i, LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this.f12147a = i;
        this.nearLeft = latLng;
        this.nearRight = latLng2;
        this.farLeft = latLng3;
        this.farRight = latLng4;
        this.latLngBounds = latLngBounds;
    }

    public VisibleRegion(LatLng latLng, LatLng latLng2, LatLng latLng3, LatLng latLng4, LatLngBounds latLngBounds) {
        this(1, latLng, latLng2, latLng3, latLng4, latLngBounds);
    }

    public void writeToParcel(Parcel parcel, int i) {
        VisibleRegionCreator.m16471a(this, parcel, i);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return bk.m15647a(new Object[]{this.nearLeft, this.nearRight, this.farLeft, this.farRight, this.latLngBounds});
    }

    int m16470a() {
        return this.f12147a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VisibleRegion)) {
            return false;
        }
        VisibleRegion visibleRegion = (VisibleRegion) obj;
        if (this.nearLeft.equals(visibleRegion.nearLeft) && this.nearRight.equals(visibleRegion.nearRight) && this.farLeft.equals(visibleRegion.farLeft) && this.farRight.equals(visibleRegion.farRight) && this.latLngBounds.equals(visibleRegion.latLngBounds)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return bk.m15658a(bk.m15657a("nearLeft", this.nearLeft), bk.m15657a("nearRight", this.nearRight), bk.m15657a("farLeft", this.farLeft), bk.m15657a("farRight", this.farRight), bk.m15657a("latLngBounds", this.latLngBounds));
    }
}
