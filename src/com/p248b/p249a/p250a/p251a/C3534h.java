package com.p248b.p249a.p250a.p251a;

/* compiled from: GaiaLink */
public enum C3534h {
    UNHANDLED,
    CONNECTED,
    ERROR,
    DEBUG,
    DISCONNECTED,
    STREAM;

    public static C3534h m17703a(int i) {
        if (i < 0 || i >= C3534h.values().length) {
            return null;
        }
        return C3534h.values()[i];
    }
}
