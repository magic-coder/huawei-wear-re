package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: HitBuilder */
class aq {
    static Map<String, String> m18263a(Map<String, String> map) {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : map.entrySet()) {
            if (((String) entry.getKey()).startsWith(SNBConstant.FILTER) && entry.getValue() != null) {
                CharSequence substring = ((String) entry.getKey()).substring(1);
                if (!TextUtils.isEmpty(substring)) {
                    hashMap.put(substring, entry.getValue());
                }
            }
        }
        return hashMap;
    }

    static String m18261a(ap apVar, long j) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(apVar.m18255a());
        if (apVar.m18259c() > 0) {
            long c = j - apVar.m18259c();
            if (c >= 0) {
                stringBuilder.append("&qt").append("=").append(c);
            }
        }
        stringBuilder.append("&z").append("=").append(apVar.m18257b());
        return stringBuilder.toString();
    }

    static String m18262a(String str) {
        try {
            return URLEncoder.encode(str, GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("URL encoding failed for: " + str);
        }
    }
}
