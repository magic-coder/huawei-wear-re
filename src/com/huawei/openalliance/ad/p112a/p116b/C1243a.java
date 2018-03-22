package com.huawei.openalliance.ad.p112a.p116b;

public class C1243a {
    public static final C1242a f2653a = C1242a.FORMAL;
    public static String f2654b = "https://sdkserver.op.hicloud.com/sdkserver/query";
    public static String f2655c = "https://acd.op.hicloud.com/result.ad";
    public static String f2656d = "https://events.op.hicloud.com/contserver/newcontent/action";

    public enum C1242a {
        DEV,
        TEST,
        MIRROR,
        FORMAL
    }

    public static void m5517a() {
        if (C1242a.FORMAL == f2653a) {
            f2654b = "https://sdkserver.op.cp13.ott.cibntv.net/sdkserver/query";
            f2655c = "https://acd.op.cp13.ott.cibntv.net/result.ad";
            f2656d = "https://events.op.cp13.ott.cibntv.net/contserver/newcontent/action";
        }
    }
}
