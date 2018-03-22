package com.huawei.crowdtestsdk.utils;

import com.huawei.androidcommon.utils.StringUtils;

public class ComponentUtils {
    public static String parseValue(String str, String str2) {
        if (StringUtils.isNullOrEmpty(str) || StringUtils.isNullOrEmpty(str) || !str2.contains(str)) {
            return null;
        }
        int indexOf = str2.indexOf(str);
        if (indexOf <= -1) {
            return null;
        }
        String substring = str2.substring(indexOf);
        if (StringUtils.isNullOrEmpty(substring)) {
            return null;
        }
        int indexOf2 = substring.indexOf("\n");
        if (indexOf2 <= -1) {
            return null;
        }
        substring = substring.substring(0, indexOf2);
        if (StringUtils.isNullOrEmpty(substring)) {
            return null;
        }
        String[] split = substring.split(":");
        if (split.length >= 2) {
            return split[1];
        }
        return null;
    }
}
