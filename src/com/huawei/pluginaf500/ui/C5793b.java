package com.huawei.pluginaf500.ui;

/* compiled from: AF500BaseActivity */
public enum C5793b {
    BT_NONE(0),
    BT_CONNECTING(2),
    BT_CONNECTTED(3),
    BT_ALARM_SYN_FAIL(4),
    BT_ALARM_SYN_SUCCESS(5),
    BT_SET_SLEEP_SYN_FAIL(6),
    BT_SET_SLEEP_SYN_SUCCESS(7),
    BT_SET_SPORT_SYN_FAIL(8),
    BT_SET_SPORT_SYN_SUCCESS(9),
    BC_DISPLAY_STAE(33),
    BC_GESTURE_STATE(34),
    UPDATE_SETTING_VIEW(35),
    DISPLAY_GESTURE_SYN_FAIL(36),
    BIND_SERVICE_SUCCESS(41),
    UNKNOWN(10086);
    
    private int f19920p;

    private C5793b(int i) {
        this.f19920p = i;
    }

    public static C5793b m26878a(int i) {
        for (C5793b c5793b : C5793b.values()) {
            if (c5793b.f19920p == i) {
                return c5793b;
            }
        }
        return UNKNOWN;
    }

    public int m26879a() {
        return this.f19920p;
    }
}
