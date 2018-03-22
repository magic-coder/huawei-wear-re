package com.tencent.stat.p544a;

public enum C6445c {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004);
    
    private int f22356i;

    private C6445c(int i) {
        this.f22356i = i;
    }

    public int m29371a() {
        return this.f22356i;
    }
}
