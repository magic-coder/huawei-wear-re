package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.au;
import com.amap.api.mapcore.util.bk;

public final class LatLngBounds implements Parcelable {
    public static final LatLngBoundsCreator CREATOR = new LatLngBoundsCreator();
    private final int f12060a;
    public final LatLng northeast;
    public final LatLng southwest;

    public final class Builder {
        private double f12056a = Double.POSITIVE_INFINITY;
        private double f12057b = Double.NEGATIVE_INFINITY;
        private double f12058c = Double.NaN;
        private double f12059d = Double.NaN;

        public Builder include(LatLng latLng) {
            this.f12056a = Math.min(this.f12056a, latLng.latitude);
            this.f12057b = Math.max(this.f12057b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f12058c)) {
                this.f12058c = d;
                this.f12059d = d;
            } else if (!m16459a(d)) {
                if (LatLngBounds.m16465c(this.f12058c, d) < LatLngBounds.m16466d(this.f12059d, d)) {
                    this.f12058c = d;
                } else {
                    this.f12059d = d;
                }
            }
            return this;
        }

        private boolean m16459a(double d) {
            boolean z = false;
            if (this.f12058c > this.f12059d) {
                if (this.f12058c <= d || d <= this.f12059d) {
                    z = true;
                }
                return z;
            } else if (this.f12058c > d || d > this.f12059d) {
                return false;
            } else {
                return true;
            }
        }

        public LatLngBounds build() {
            boolean z;
            if (Double.isNaN(this.f12058c)) {
                z = false;
            } else {
                z = true;
            }
            au.m15521a(z, (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f12056a, this.f12058c, false), new LatLng(this.f12057b, this.f12059d, false));
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        au.m15520a((Object) latLng, (Object) "null southwest");
        au.m15520a((Object) latLng2, (Object) "null northeast");
        au.m15522a(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", new Object[]{Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude)});
        this.f12060a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    int m16467a() {
        return this.f12060a;
    }

    public static Builder builder() {
        return new Builder();
    }

    public boolean contains(LatLng latLng) {
        return m16461a(latLng.latitude) && m16464b(latLng.longitude);
    }

    public boolean contains(LatLngBounds latLngBounds) {
        if (latLngBounds != null && contains(latLngBounds.southwest) && contains(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public boolean intersects(LatLngBounds latLngBounds) {
        if (latLngBounds == null) {
            return false;
        }
        if (m16462a(latLngBounds) || latLngBounds.m16462a(this)) {
            return true;
        }
        return false;
    }

    private boolean m16462a(LatLngBounds latLngBounds) {
        if (latLngBounds == null || latLngBounds.northeast == null || latLngBounds.southwest == null || this.northeast == null || this.southwest == null) {
            return false;
        }
        double d = ((latLngBounds.northeast.latitude + latLngBounds.southwest.latitude) - this.northeast.latitude) - this.southwest.latitude;
        double d2 = ((this.northeast.latitude - this.southwest.latitude) + latLngBounds.northeast.latitude) - latLngBounds.southwest.latitude;
        if (Math.abs(((latLngBounds.northeast.longitude + latLngBounds.southwest.longitude) - this.northeast.longitude) - this.southwest.longitude) >= ((this.northeast.longitude - this.southwest.longitude) + latLngBounds.northeast.longitude) - this.southwest.longitude || Math.abs(d) >= d2) {
            return false;
        }
        return true;
    }

    public LatLngBounds including(LatLng latLng) {
        double d;
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        double d4 = latLng.longitude;
        if (m16464b(d4)) {
            d4 = d3;
            d = d2;
        } else if (m16465c(d3, d4) < m16466d(d2, d4)) {
            d = d2;
        } else {
            d = d4;
            d4 = d3;
        }
        return new LatLngBounds(new LatLng(min, d4, false), new LatLng(max, d, false));
    }

    private static double m16465c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    private static double m16466d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    private boolean m16461a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean m16464b(double d) {
        boolean z = false;
        if (this.southwest.longitude > this.northeast.longitude) {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        } else if (this.southwest.longitude > d || d > this.northeast.longitude) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return bk.m15647a(new Object[]{this.southwest, this.northeast});
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        if (this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return bk.m15658a(bk.m15657a("southwest", this.southwest), bk.m15657a("northeast", this.northeast));
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        LatLngBoundsCreator.m16468a(this, parcel, i);
    }
}
