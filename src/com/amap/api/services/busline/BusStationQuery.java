package com.amap.api.services.busline;

import com.amap.api.services.core.C3409d;

public class BusStationQuery {
    private String f12249a;
    private String f12250b;
    private int f12251c = 10;
    private int f12252d = 0;

    public BusStationQuery(String str, String str2) {
        this.f12249a = str;
        this.f12250b = str2;
        if (!m16550a()) {
            throw new IllegalArgumentException("Empty query");
        }
    }

    private boolean m16550a() {
        return !C3409d.m16882a(this.f12249a);
    }

    public String getQueryString() {
        return this.f12249a;
    }

    public String getCity() {
        return this.f12250b;
    }

    public int getPageSize() {
        return this.f12251c;
    }

    public int getPageNumber() {
        return this.f12252d;
    }

    public void setQueryString(String str) {
        this.f12249a = str;
    }

    public void setCity(String str) {
        this.f12250b = str;
    }

    public void setPageSize(int i) {
        int i2 = 20;
        if (i <= 20) {
            i2 = i;
        }
        if (i2 <= 0) {
            i2 = 10;
        }
        this.f12251c = i2;
    }

    public void setPageNumber(int i) {
        this.f12252d = i;
    }

    protected BusStationQuery clone() {
        BusStationQuery busStationQuery = new BusStationQuery(this.f12249a, this.f12250b);
        busStationQuery.setPageNumber(this.f12252d);
        busStationQuery.setPageSize(this.f12251c);
        return busStationQuery;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((this.f12250b == null ? 0 : this.f12250b.hashCode()) + 31) * 31) + this.f12252d) * 31) + this.f12251c) * 31;
        if (this.f12249a != null) {
            i = this.f12249a.hashCode();
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
        BusStationQuery busStationQuery = (BusStationQuery) obj;
        if (this.f12250b == null) {
            if (busStationQuery.f12250b != null) {
                return false;
            }
        } else if (!this.f12250b.equals(busStationQuery.f12250b)) {
            return false;
        }
        if (this.f12252d != busStationQuery.f12252d) {
            return false;
        }
        if (this.f12251c != busStationQuery.f12251c) {
            return false;
        }
        if (this.f12249a == null) {
            if (busStationQuery.f12249a != null) {
                return false;
            }
            return true;
        } else if (this.f12249a.equals(busStationQuery.f12249a)) {
            return true;
        } else {
            return false;
        }
    }

    protected boolean weakEquals(BusStationQuery busStationQuery) {
        if (this == busStationQuery) {
            return true;
        }
        if (busStationQuery == null) {
            return false;
        }
        if (this.f12250b == null) {
            if (busStationQuery.f12250b != null) {
                return false;
            }
        } else if (!this.f12250b.equals(busStationQuery.f12250b)) {
            return false;
        }
        if (this.f12251c != busStationQuery.f12251c) {
            return false;
        }
        if (this.f12249a == null) {
            if (busStationQuery.f12249a != null) {
                return false;
            }
            return true;
        } else if (this.f12249a.equals(busStationQuery.f12249a)) {
            return true;
        } else {
            return false;
        }
    }
}
