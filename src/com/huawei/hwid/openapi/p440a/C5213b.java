package com.huawei.hwid.openapi.p440a;

import com.huawei.hwid.openapi.out.OutConst;

public class C5213b {
    public static final String f18818a = ("HwID_OpenSDK_LOG[" + C5213b.m25352a() + "/" + 1007 + "]");

    private static int m25352a() {
        try {
            return OutConst.getIterfaceVersion();
        } catch (Throwable th) {
            return 1005;
        }
    }
}
