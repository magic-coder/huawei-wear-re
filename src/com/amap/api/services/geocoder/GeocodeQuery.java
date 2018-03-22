package com.amap.api.services.geocoder;

public class GeocodeQuery {
    private String f12565a;
    private String f12566b;

    public GeocodeQuery(String str, String str2) {
        this.f12565a = str;
        this.f12566b = str2;
    }

    public String getLocationName() {
        return this.f12565a;
    }

    public void setLocationName(String str) {
        this.f12565a = str;
    }

    public String getCity() {
        return this.f12566b;
    }

    public void setCity(String str) {
        this.f12566b = str;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f12566b == null ? 0 : this.f12566b.hashCode()) + 31) * 31;
        if (this.f12565a != null) {
            i = this.f12565a.hashCode();
        }
        return hashCode + i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        GeocodeQuery geocodeQuery = (GeocodeQuery) obj;
        if (this.f12566b == null) {
            if (geocodeQuery.f12566b != null) {
                return false;
            }
        } else if (!this.f12566b.equals(geocodeQuery.f12566b)) {
            return false;
        }
        if (this.f12565a == null) {
            if (geocodeQuery.f12565a != null) {
                return false;
            }
            return true;
        } else if (this.f12565a.equals(geocodeQuery.f12565a)) {
            return true;
        } else {
            return false;
        }
    }
}
