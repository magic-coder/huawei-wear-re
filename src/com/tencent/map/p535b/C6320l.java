package com.tencent.map.p535b;

import android.location.Location;

public final class C6320l implements Cloneable {
    private Location f22022a;
    private long f22023b;
    private int f22024c;

    public final boolean m28988a() {
        return this.f22022a == null ? false : (this.f22024c <= 0 || this.f22024c >= 3) && System.currentTimeMillis() - this.f22023b <= StatisticConfig.MIN_UPLOAD_INTERVAL;
    }

    public final Location m28989b() {
        return this.f22022a;
    }

    public final Object clone() {
        C6320l c6320l;
        try {
            c6320l = (C6320l) super.clone();
        } catch (Exception e) {
            c6320l = null;
        }
        if (this.f22022a != null) {
            c6320l.f22022a = new Location(this.f22022a);
        }
        return c6320l;
    }
}
