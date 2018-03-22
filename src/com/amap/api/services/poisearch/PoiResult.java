package com.amap.api.services.poisearch;

import com.amap.api.services.core.PoiItem;
import com.amap.api.services.core.SuggestionCity;
import com.amap.api.services.poisearch.PoiSearch.Query;
import com.amap.api.services.poisearch.PoiSearch.SearchBound;
import java.util.ArrayList;
import java.util.List;

public final class PoiResult {
    private int f12687a;
    private ArrayList<PoiItem> f12688b = new ArrayList();
    private C3463j f12689c;

    static PoiResult m17064a(C3463j c3463j, ArrayList<PoiItem> arrayList) {
        return new PoiResult(c3463j, arrayList);
    }

    private PoiResult(C3463j c3463j, ArrayList<PoiItem> arrayList) {
        this.f12689c = c3463j;
        this.f12687a = m17063a(c3463j.m17108i());
        this.f12688b = arrayList;
    }

    public int getPageCount() {
        return this.f12687a;
    }

    public Query getQuery() {
        return this.f12689c.m17109j();
    }

    public SearchBound getBound() {
        return this.f12689c.m17110k();
    }

    public ArrayList<PoiItem> getPois() {
        return this.f12688b;
    }

    public List<String> getSearchSuggestionKeywords() {
        return this.f12689c.m17111l();
    }

    public List<SuggestionCity> getSearchSuggestionCitys() {
        return this.f12689c.m17112m();
    }

    private int m17063a(int i) {
        int f = this.f12689c.mo4114f();
        f = ((i + f) - 1) / f;
        if (f > 30) {
            return 30;
        }
        return f;
    }
}
