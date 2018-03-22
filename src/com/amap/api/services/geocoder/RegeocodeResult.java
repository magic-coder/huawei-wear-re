package com.amap.api.services.geocoder;

public class RegeocodeResult {
    private RegeocodeQuery f12593a;
    private RegeocodeAddress f12594b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.f12593a = regeocodeQuery;
        this.f12594b = regeocodeAddress;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.f12593a;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.f12593a = regeocodeQuery;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.f12594b;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.f12594b = regeocodeAddress;
    }
}
