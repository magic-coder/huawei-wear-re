package com.amap.api.services.busline;

import com.amap.api.services.core.C3394b;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusStationResult {
    private int f12253a;
    private ArrayList<BusStationItem> f12254b = new ArrayList();
    private BusStationQuery f12255c;
    private List<String> f12256d = new ArrayList();
    private List<SuggestionCity> f12257e = new ArrayList();

    static BusStationResult m16552a(C3394b c3394b, ArrayList<?> arrayList) {
        return new BusStationResult(c3394b, arrayList);
    }

    private BusStationResult(C3394b c3394b, ArrayList<?> arrayList) {
        this.f12255c = (BusStationQuery) c3394b.m16733c();
        this.f12253a = m16551a(c3394b.m16734d());
        this.f12257e = c3394b.mo4114f();
        this.f12256d = c3394b.b_();
        this.f12254b = arrayList;
    }

    private int m16551a(int i) {
        int pageSize = this.f12255c.getPageSize();
        pageSize = ((i + pageSize) - 1) / pageSize;
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public int getPageCount() {
        return this.f12253a;
    }

    public BusStationQuery getQuery() {
        return this.f12255c;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f12256d;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f12257e;
    }

    public List<BusStationItem> getBusStations() {
        return this.f12254b;
    }
}
