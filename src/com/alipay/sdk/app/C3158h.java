package com.alipay.sdk.app;

public final class C3158h {
    public static String f10542a;

    public static String m13994a() {
        C3159i a = C3159i.m13996a(C3159i.CANCELED.f10551h);
        return C3158h.m13995a(a.f10551h, a.f10552i, "");
    }

    public static String m13995a(int i, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("resultStatus={").append(i).append("};memo={").append(str).append("};result={").append(str2).append("}");
        return stringBuilder.toString();
    }
}
