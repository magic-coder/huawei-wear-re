package com.huawei.openalliance.ad.utils;

import com.huawei.openalliance.ad.utils.p129b.C1336d;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C1356d {
    private static String m5978a(char c, int i) {
        StringBuffer stringBuffer = new StringBuffer(i);
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(c);
        }
        return stringBuffer.toString();
    }

    private static String m5979a(String str) {
        try {
            if (!C1365i.m6081a(str)) {
                int ceil = (int) Math.ceil(((double) (str.length() * 30)) / 100.0d);
                str = C1356d.m5978a('*', ceil) + str.substring(ceil);
            }
        } catch (Throwable e) {
            C1336d.m5883a("HiAdSDKMyProguard", "get proguard fail", e);
        }
        return str;
    }

    public static String m5980a(String str, boolean z) {
        if (!z) {
            return C1356d.m5979a(str);
        }
        if (str == null) {
            return str;
        }
        try {
            if (str.trim().equals("")) {
                return str;
            }
            char[] toCharArray = str.toCharArray();
            int i = 0;
            while (i < toCharArray.length) {
                if (!("0123456789".contains(String.valueOf(toCharArray[i])) || "{:=@}/#?%\"(),/\\<>| &".contains(String.valueOf(toCharArray[i])))) {
                    toCharArray[i] = '*';
                }
                i += 2;
            }
            str = String.valueOf(toCharArray);
            Matcher matcher = Pattern.compile("[0-9]{7,}").matcher(str);
            while (matcher.find()) {
                String group = matcher.group();
                if (group == null) {
                    return str;
                }
                char[] toCharArray2 = group.toCharArray();
                for (i = 0; i < toCharArray2.length; i += 2) {
                    if (!"{:=@}/#?%\"(),/\\<>| &".contains(String.valueOf(toCharArray2[i]))) {
                        toCharArray2[i] = '*';
                    }
                }
                str = str.replaceAll(group, String.valueOf(toCharArray2));
            }
            return str;
        } catch (Throwable e) {
            C1336d.m5883a("HiAdSDKMyProguard", "get proguard fail", e);
            return str;
        }
    }
}
