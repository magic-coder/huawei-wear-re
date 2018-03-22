package com.tencent.stat;

public enum C6473f {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int f22494h;

    private C6473f(int i) {
        this.f22494h = i;
    }

    public static C6473f m29550a(int i) {
        for (C6473f c6473f : C6473f.values()) {
            if (i == c6473f.m29551a()) {
                return c6473f;
            }
        }
        return null;
    }

    public int m29551a() {
        return this.f22494h;
    }
}
