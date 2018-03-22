package com.tencent.wxop.stat;

public enum C6545w {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);
    
    int f22839h;

    private C6545w(int i) {
        this.f22839h = i;
    }

    public static C6545w m29857a(int i) {
        for (C6545w c6545w : C6545w.values()) {
            if (i == c6545w.f22839h) {
                return c6545w;
            }
        }
        return null;
    }
}
