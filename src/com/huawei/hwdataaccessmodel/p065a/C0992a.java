package com.huawei.hwdataaccessmodel.p065a;

import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: SqlUtil */
public class C0992a {
    public static String m3604a(String str) {
        if (str == null) {
            return "";
        }
        return str.replaceAll(".*([';]+|(--)+).*", HwAccountConstants.BLANK);
    }
}
