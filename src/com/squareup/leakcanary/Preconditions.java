package com.squareup.leakcanary;

final class Preconditions {
    static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str + " must not be null");
    }

    private Preconditions() {
        throw new AssertionError();
    }
}
