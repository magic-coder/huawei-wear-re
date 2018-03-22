package com.tencent.mm.sdk.p539b;

import java.util.TimeZone;

public final class C6346e {
    private static final long[] f22093G = new long[]{300, 200, 300, 200};
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    private static final long[] f22094H = new long[]{300, 50, 300, 50};
    private static final char[] f22095I = new char[]{'<', '>', '\"', '\'', '&', '\r', '\n', ' ', '\t'};
    private static final String[] f22096J = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};

    public static boolean m29043j(String str) {
        return str == null || str.length() <= 0;
    }
}
