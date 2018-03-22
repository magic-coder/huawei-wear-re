package com.amap.api.services.busline;

import com.amap.api.services.core.C3394b;
import com.amap.api.services.core.SuggestionCity;
import java.util.ArrayList;
import java.util.List;

public final class BusLineResult {
    private int f12230a;
    private ArrayList<BusLineItem> f12231b = new ArrayList();
    private BusLineQuery f12232c;
    private List<String> f12233d = new ArrayList();
    private List<SuggestionCity> f12234e = new ArrayList();

    static BusLineResult m16543a(C3394b c3394b, ArrayList<?> arrayList) {
        return new BusLineResult(c3394b, arrayList);
    }

    private BusLineResult(C3394b c3394b, ArrayList<?> arrayList) {
        this.f12232c = (BusLineQuery) c3394b.m16733c();
        this.f12230a = m16542a(c3394b.m16734d());
        this.f12234e = c3394b.mo4114f();
        this.f12233d = c3394b.b_();
        this.f12231b = arrayList;
    }

    private int m16542a(int i) {
        int pageSize = this.f12232c.getPageSize();
        pageSize = ((i + pageSize) - 1) / pageSize;
        if (pageSize > 30) {
            return 30;
        }
        return pageSize;
    }

    public int getPageCount() {
        return this.f12230a;
    }

    public BusLineQuery getQuery() {
        return this.f12232c;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f12233d;
    }

    public List<SuggestionCity> getSearchSuggestionCities() {
        return this.f12234e;
    }

    public List<BusLineItem> getBusLines() {
        return this.f12231b;
    }
}
