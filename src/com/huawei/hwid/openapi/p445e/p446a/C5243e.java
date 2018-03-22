package com.huawei.hwid.openapi.p445e.p446a;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class C5243e {
    private static String m25419a(char c, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    public static String m25420a(Intent intent) {
        if (intent == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (!TextUtils.isEmpty(intent.getAction())) {
            stringBuffer.append("act:" + intent.getAction()).append(HwAccountConstants.BLANK);
        }
        stringBuffer.append(" flag:" + intent.getFlags()).append(HwAccountConstants.BLANK);
        if (intent.getExtras() != null) {
            stringBuffer.append(C5243e.m25421a(intent.getExtras()));
        }
        return stringBuffer.toString();
    }

    public static String m25421a(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        Set<String> keySet = bundle.keySet();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : keySet) {
            stringBuffer.append(str).append("=").append(C5243e.m25422a(bundle.get(str))).append(HwAccountConstants.BLANK);
        }
        return stringBuffer.toString();
    }

    public static String m25422a(Object obj) {
        return C5243e.m25423a(String.valueOf(obj));
    }

    public static String m25423a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int ceil = (int) Math.ceil(((double) (str.length() * 30)) / 100.0d);
        return C5243e.m25419a('*', ceil) + str.substring(ceil);
    }

    public static String m25424a(String str, boolean z) {
        if (!z) {
            return C5243e.m25423a(str);
        }
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] toCharArray = str.toCharArray();
        for (int i = 0; i < toCharArray.length; i += 2) {
            if (!"{:=@}/#?%\"(),/\\<>| &".contains(String.valueOf(toCharArray[i]))) {
                toCharArray[i] = '*';
            }
        }
        return String.valueOf(toCharArray);
    }

    public static String m25425a(Map map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Entry entry : map.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(C5243e.m25423a(String.valueOf(entry.getValue()))).append(HwAccountConstants.BLANK);
        }
        return stringBuffer.toString();
    }

    public static String m25426b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int indexOf = str.indexOf("=");
        return indexOf > 0 ? str.substring(0, indexOf) + C5243e.m25424a(str, true).substring(indexOf) : str;
    }
}
