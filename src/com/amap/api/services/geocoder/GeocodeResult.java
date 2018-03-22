package com.amap.api.services.geocoder;

import java.util.ArrayList;
import java.util.List;

public class GeocodeResult {
    private GeocodeQuery f12567a;
    private List<GeocodeAddress> f12568b = new ArrayList();

    public GeocodeResult(GeocodeQuery geocodeQuery, List<GeocodeAddress> list) {
        this.f12567a = geocodeQuery;
        this.f12568b = list;
    }

    public GeocodeQuery getGeocodeQuery() {
        return this.f12567a;
    }

    public void setGeocodeQuery(GeocodeQuery geocodeQuery) {
        this.f12567a = geocodeQuery;
    }

    public List<GeocodeAddress> getGeocodeAddressList() {
        return this.f12568b;
    }

    public void setGeocodeAddressList(List<GeocodeAddress> list) {
        this.f12568b = list;
    }
}
