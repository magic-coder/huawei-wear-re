package com.p248b.p249a.p250a.p251a;

/* compiled from: Gaia */
public enum C3530d {
    SUCCESS,
    NOT_SUPPORTED,
    NOT_AUTHENTICATED,
    INSUFFICIENT_RESOURCES,
    AUTHENTICATING,
    INVALID_PARAMETER,
    INCORRECT_STATE;

    public static C3530d m17648a(int i) {
        if (i < 0 || i >= C3530d.values().length) {
            return null;
        }
        return C3530d.values()[i];
    }
}
