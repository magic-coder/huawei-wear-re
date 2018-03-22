package com.amap.api.services.core;

/* compiled from: Util */
class at {
    at() {
    }

    static String m16692a(String str) {
        if (str == null) {
            return null;
        }
        String b = aa.m16586b(str.getBytes());
        return ((char) ((b.length() % 26) + 65)) + b;
    }

    static String m16693b(String str) {
        if (str.length() < 2) {
            return "";
        }
        return aa.m16582a(str.substring(1));
    }
}
