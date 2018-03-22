package com.p248b.p249a.p250a.p251a;

/* compiled from: Gaia */
public enum C3529c {
    START,
    RSSI_LOW_THRESHOLD,
    RSSI_HIGH_THRESHOLD,
    BATTERY_LOW_THRESHOLD,
    BATTERY_HIGH_THRESHOLD,
    DEVICE_STATE_CHANGED,
    PIO_CHANGED,
    DEBUG_MESSAGE,
    BATTERY_CHARGED,
    CHARGER_CONNECTION,
    CAPSENSE_UPDATE,
    USER_ACTION,
    SPEECH_RECOGNITION,
    AV_COMMAND,
    REMOTE_BATTERY_LEVEL,
    KEY,
    DFU_STATE;

    public static C3529c m17647a(int i) {
        if (i < 0 || i >= C3529c.values().length) {
            return null;
        }
        return C3529c.values()[i];
    }
}
