package com.huawei.hwid.openapi.p445e.p448c;

import com.huawei.hwdevicedfxmanager.constants.HWDeviceDFXConstants;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5248c;
import java.util.HashMap;
import java.util.Locale;

public class C5247a {
    static HashMap f18879a = new HashMap();
    private static final String f18880b = C5213b.f18818a;

    static {
        C5247a.m25441a(10001, "Network abnormally, please check your network.", "网络异常,请检查网络.");
        C5247a.m25441a(10002, "System abnormally, error code:", "系统异常, 错误码:");
        C5247a.m25441a(HwAccountConstants.MY_PERMISSIONS_REQUEST_READ_PHONE_STATE, "try again?", "是否重试?");
        C5247a.m25441a(HWDeviceDFXConstants.ERROR_CODE_GET_FILE_NAME_ERROR, "Loading...", "加载中...");
    }

    public static String m25439a() {
        String toLowerCase = Locale.getDefault().getLanguage().toLowerCase();
        return toLowerCase + "-" + Locale.getDefault().getCountry().toLowerCase();
    }

    public static String m25440a(int i) {
        try {
            HashMap hashMap = (HashMap) f18879a.get(Integer.valueOf(i));
            if (hashMap == null) {
                C5248c.m25450d(f18880b, "the id:" + i + " is not exist, return empty string");
                return "";
            }
            String str = (String) hashMap.get(C5247a.m25439a());
            return str == null ? (String) hashMap.get("en_US") : str;
        } catch (Throwable e) {
            C5248c.m25448b(f18880b, e.toString(), e);
            return "";
        }
    }

    private static void m25441a(int i, String str, String... strArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("en_US", str);
        if (strArr.length >= 1) {
            hashMap.put("zh-cn", strArr[0]);
        }
        f18879a.put(Integer.valueOf(i), hashMap);
    }
}
