package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.au;
import com.amap.api.mapcore.util.bh;
import com.amap.api.mapcore.util.bk;

public final class CameraPosition implements Parcelable {
    public static final CameraPositionCreator CREATOR = new CameraPositionCreator();
    public final float bearing;
    public final boolean isAbroad;
    public final LatLng target;
    public final float tilt;
    public final float zoom;

    public final class Builder {
        private LatLng f12006a;
        private float f12007b;
        private float f12008c;
        private float f12009d;

        public Builder(CameraPosition cameraPosition) {
            target(cameraPosition.target).bearing(cameraPosition.bearing).tilt(cameraPosition.tilt).zoom(cameraPosition.zoom);
        }

        public Builder target(LatLng latLng) {
            this.f12006a = latLng;
            return this;
        }

        public Builder zoom(float f) {
            this.f12007b = f;
            return this;
        }

        public Builder tilt(float f) {
            this.f12008c = f;
            return this;
        }

        public Builder bearing(float f) {
            this.f12009d = f;
            return this;
        }

        public CameraPosition build() {
            au.m15519a(this.f12006a);
            return new CameraPosition(this.f12006a, this.f12007b, this.f12008c, this.f12009d);
        }
    }

    public CameraPosition(LatLng latLng, float f, float f2, float f3) {
        au.m15520a((Object) latLng, (Object) "CameraPosition 位置不能为null ");
        this.target = latLng;
        this.zoom = bk.m15640a(f);
        this.tilt = bk.m15641a(f2, this.zoom);
        if (((double) f3) <= 0.0d) {
            f3 = (f3 % 360.0f) + 360.0f;
        }
        this.bearing = f3 % 360.0f;
        this.isAbroad = !bh.m15628a(latLng.latitude, latLng.longitude);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.bearing);
        parcel.writeFloat((float) this.target.latitude);
        parcel.writeFloat((float) this.target.longitude);
        parcel.writeFloat(this.tilt);
        parcel.writeFloat(this.zoom);
    }

    public int describeContents() {
        return 0;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public static final CameraPosition fromLatLngZoom(LatLng latLng, float f) {
        return new CameraPosition(latLng, f, 0.0f, 0.0f);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(CameraPosition cameraPosition) {
        return new Builder(cameraPosition);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CameraPosition)) {
            return false;
        }
        CameraPosition cameraPosition = (CameraPosition) obj;
        if (this.target.equals(cameraPosition.target) && Float.floatToIntBits(this.zoom) == Float.floatToIntBits(cameraPosition.zoom) && Float.floatToIntBits(this.tilt) == Float.floatToIntBits(cameraPosition.tilt) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(cameraPosition.bearing)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return bk.m15658a(bk.m15657a("target", this.target), bk.m15657a("zoom", Float.valueOf(this.zoom)), bk.m15657a("tilt", Float.valueOf(this.tilt)), bk.m15657a("bearing", Float.valueOf(this.bearing)));
    }
}
