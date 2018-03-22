package com.google.analytics.tracking.android;

import android.text.TextUtils;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.apache.log4j.spi.LocationInfo;

/* compiled from: Utils */
class bj {
    private static final char[] f14177a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static Map<String, String> m18341a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String split : str.split(SNBConstant.FILTER)) {
            String[] split2 = split.split("=");
            if (split2.length > 1) {
                hashMap.put(split2[0], split2[1]);
            } else if (split2.length == 1 && split2[0].length() != 0) {
                hashMap.put(split2[0], null);
            }
        }
        return hashMap;
    }

    public static double m18339a(String str, double d) {
        if (str != null) {
            try {
                d = Double.parseDouble(str);
            } catch (NumberFormatException e) {
            }
        }
        return d;
    }

    public static boolean m18343a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        if (str.equalsIgnoreCase("true") || str.equalsIgnoreCase("yes") || str.equalsIgnoreCase("1")) {
            return true;
        }
        if (str.equalsIgnoreCase("false") || str.equalsIgnoreCase("no") || str.equalsIgnoreCase("0")) {
            return false;
        }
        return z;
    }

    public static String m18344b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.contains(LocationInfo.NA)) {
            String[] split = str.split("[\\?]");
            if (split.length > 1) {
                str = split[1];
            }
        }
        if (str.contains("%3D")) {
            try {
                str = URLDecoder.decode(str, GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                return null;
            }
        } else if (!str.contains("=")) {
            return null;
        }
        Map a = m18341a(str);
        String[] strArr = new String[]{"dclid", "utm_source", "gclid", "utm_campaign", "utm_medium", "utm_term", "utm_content", "utm_id", "gmob_t"};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            if (!TextUtils.isEmpty((CharSequence) a.get(strArr[i]))) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append(SNBConstant.FILTER);
                }
                stringBuilder.append(strArr[i]).append("=").append((String) a.get(strArr[i]));
            }
        }
        return stringBuilder.toString();
    }

    static String m18340a(Locale locale) {
        if (locale == null || TextUtils.isEmpty(locale.getLanguage())) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(locale.getLanguage().toLowerCase());
        if (!TextUtils.isEmpty(locale.getCountry())) {
            stringBuilder.append("-").append(locale.getCountry().toLowerCase());
        }
        return stringBuilder.toString();
    }

    public static void m18342a(Map<String, String> map, String str, String str2) {
        if (!map.containsKey(str)) {
            map.put(str, str2);
        }
    }
}
