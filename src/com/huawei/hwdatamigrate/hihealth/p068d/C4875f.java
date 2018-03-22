package com.huawei.hwdatamigrate.hihealth.p068d;

import com.huawei.hwid.core.constants.HwAccountConstants;

/* compiled from: HiCacheUtil */
public class C4875f {
    public static String m23636a(String str, String str2, String str3) {
        if (str == null || str2 == null || str3 == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str2).append(HwAccountConstants.SPLIIT_UNDERLINE).append(str3);
        return stringBuffer.toString();
    }
}
