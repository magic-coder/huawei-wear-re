package com.huawei.wallet.utils.log;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class LogErrorConstant {
    public static Map<String, String> m28535a(String str, String str2) {
        Map<String, String> map = null;
        if (!TextUtils.isEmpty(str)) {
            map = new HashMap();
            map.put("loc", str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (map == null) {
                map = new HashMap();
            }
            map.put("err", str2);
        }
        return map;
    }
}
