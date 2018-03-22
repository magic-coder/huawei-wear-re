package com.tencent.wxop.stat.p546a;

public enum C6499e {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(1001),
    MONITOR_STAT(1002),
    MTA_GAME_USER(1003),
    NETWORK_MONITOR(1004),
    NETWORK_DETECTOR(1005);
    
    private int f22591j;

    private C6499e(int i) {
        this.f22591j = i;
    }

    public final int m29642a() {
        return this.f22591j;
    }
}
