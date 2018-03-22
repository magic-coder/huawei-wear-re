package com.huawei.openalliance.ad.utils;

import java.util.List;

public class C1365i {
    public static String m6078a(String str, String str2, String str3) {
        if (str == null) {
            return null;
        }
        int length = str3.length() + 2;
        int indexOf = str.indexOf("<" + str2);
        if (-1 == indexOf) {
            return null;
        }
        int indexOf2 = str.indexOf(str3 + "=\"", indexOf);
        if (-1 != indexOf2) {
            indexOf = str.indexOf("\"", indexOf2 + length);
        } else {
            indexOf2 = str.indexOf(str3 + "='", indexOf);
            indexOf = -1 != indexOf2 ? str.indexOf("'", indexOf2 + length) : -1;
        }
        return -1 != indexOf ? str.substring(indexOf2 + length, indexOf) : null;
    }

    public static String m6079a(List<String> list, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(list == null || list.isEmpty())) {
            Object obj = 1;
            for (String str2 : list) {
                if (obj == null) {
                    stringBuilder.append(str);
                }
                stringBuilder.append(str2);
                obj = null;
            }
        }
        return stringBuilder.toString();
    }

    public static String m6080a(List<String> list, String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!(list == null || list.isEmpty())) {
            Object obj = 1;
            for (String str3 : list) {
                if (obj == null) {
                    stringBuilder.append(str);
                }
                stringBuilder.append(str2);
                stringBuilder.append(str3);
                stringBuilder.append(str2);
                obj = null;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean m6081a(String str) {
        return str == null || str.trim().length() == 0;
    }
}
