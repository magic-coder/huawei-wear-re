package com.amap.api.services.busline;

import com.amap.api.services.core.C3409d;

public class BusLineQuery {
    private String f12225a;
    private String f12226b;
    private int f12227c = 10;
    private int f12228d = 0;
    private SearchType f12229e;

    public enum SearchType {
        BY_LINE_ID,
        BY_LINE_NAME
    }

    public BusLineQuery(String str, SearchType searchType, String str2) {
        this.f12225a = str;
        this.f12229e = searchType;
        this.f12226b = str2;
        if (!m16541a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    private boolean m16541a() {
        return !C3409d.m16882a(this.f12225a);
    }

    public SearchType getCategory() {
        return this.f12229e;
    }

    public String getQueryString() {
        return this.f12225a;
    }

    public void setQueryString(String str) {
        this.f12225a = str;
    }

    public String getCity() {
        return this.f12226b;
    }

    public void setCity(String str) {
        this.f12226b = str;
    }

    public int getPageSize() {
        return this.f12227c;
    }

    public void setPageSize(int i) {
        this.f12227c = i;
    }

    public int getPageNumber() {
        return this.f12228d;
    }

    public void setPageNumber(int i) {
        this.f12228d = i;
    }

    public void setCategory(SearchType searchType) {
        this.f12229e = searchType;
    }

    protected BusLineQuery clone() {
        BusLineQuery busLineQuery = new BusLineQuery(this.f12225a, this.f12229e, this.f12226b);
        busLineQuery.setPageNumber(this.f12228d);
        busLineQuery.setPageSize(this.f12227c);
        return busLineQuery;
    }

    protected boolean weakEquals(BusLineQuery busLineQuery) {
        if (busLineQuery.getQueryString().equals(this.f12225a) && busLineQuery.getCity().equals(this.f12226b) && busLineQuery.getPageSize() == this.f12227c && busLineQuery.getCategory().compareTo(this.f12229e) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f12226b == null ? 0 : this.f12226b.hashCode()) + (((this.f12229e == null ? 0 : this.f12229e.hashCode()) + 31) * 31)) * 31) + this.f12228d) * 31) + this.f12227c) * 31;
        if (this.f12225a != null) {
            i = this.f12225a.hashCode();
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
        BusLineQuery busLineQuery = (BusLineQuery) obj;
        if (this.f12229e != busLineQuery.f12229e) {
            return false;
        }
        if (this.f12226b == null) {
            if (busLineQuery.f12226b != null) {
                return false;
            }
        } else if (!this.f12226b.equals(busLineQuery.f12226b)) {
            return false;
        }
        if (this.f12228d != busLineQuery.f12228d) {
            return false;
        }
        if (this.f12227c != busLineQuery.f12227c) {
            return false;
        }
        if (this.f12225a == null) {
            if (busLineQuery.f12225a != null) {
                return false;
            }
            return true;
        } else if (this.f12225a.equals(busLineQuery.f12225a)) {
            return true;
        } else {
            return false;
        }
    }
}
