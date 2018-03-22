package com.huawei.hwid.core.p435d;

import android.text.TextUtils;
import android.util.Xml;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.encrypt.C5203g;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.regex.Pattern;

/* compiled from: StringUtil */
public class C5181l {
    public static boolean m25038a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !Pattern.compile(str2).matcher(str).matches()) {
            return false;
        }
        return true;
    }

    public static boolean m25037a(String str) {
        if (str.endsWith("@inner.up.huawei")) {
            return false;
        }
        return C5181l.m25038a(str, "^\\s*([A-Za-z0-9_-]+(\\.\\w+)*@(\\w+\\.)+\\w+)\\s*$");
    }

    public static boolean m25039b(String str) {
        if (Pattern.compile("^1[0-9]{10}$").matcher(str).matches()) {
            return true;
        }
        return false;
    }

    public static boolean m25042c(String str) {
        if (str == null) {
            return false;
        }
        return C5181l.m25038a(str, "^[0-9]{0,128}$");
    }

    public static boolean m25040b(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null || str2 == null) {
            if (str == null) {
                if (str2.trim().length() == 0) {
                    return true;
                }
            } else if (str.trim().length() == 0) {
                return true;
            }
        } else if (str.equals(str2)) {
            return true;
        }
        return false;
    }

    public static boolean m25043d(String str) {
        String str2 = "0";
        if (str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!"0".equals(str.subSequence(i, i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static String m25041c(String str, String str2) {
        if (TextUtils.isEmpty(str) || !C5166b.m24947e(str2)) {
            return str;
        }
        try {
            Xml.newSerializer().text(str);
            return str;
        } catch (IllegalArgumentException e) {
            String stringBuffer;
            C5165e.m24908c("StringUtil", "IllegalArgumentException / " + e.getMessage());
            C5165e.m24906b("StringUtil", "thirdName: " + C5203g.m25322d(str));
            if ("7".equals(str2)) {
                stringBuffer = new StringBuffer("QQ").append(C5181l.m25034a()).toString();
            } else if ("4".equals(str2)) {
                stringBuffer = new StringBuffer("Sina").append(C5181l.m25034a()).toString();
            } else if (HwAccountConstants.TYPE_WEIXIN.equals(str2)) {
                stringBuffer = new StringBuffer("Weixin").append(C5181l.m25034a()).toString();
            } else {
                stringBuffer = new StringBuffer("ThirdName").append(C5181l.m25034a()).toString();
            }
            return stringBuffer;
        } catch (IllegalStateException e2) {
            C5165e.m24908c("StringUtil", "IllegalStateException / " + e2.getMessage());
            return str;
        } catch (IOException e3) {
            C5165e.m24908c("StringUtil", "IOException / " + e3.getMessage());
            return str;
        } catch (Exception e4) {
            C5165e.m24908c("StringUtil", "Exception / " + e4.getMessage());
            return str;
        }
    }

    public static String m25044e(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] toCharArray = str.toCharArray();
        char[] cArr = new char[toCharArray.length];
        int length = toCharArray.length;
        int i2 = 0;
        while (i < length) {
            cArr[i2] = (char) (toCharArray[i] + 2);
            i2++;
            i++;
        }
        return new String(cArr);
    }

    public static String m25034a() {
        Random secureRandom = new SecureRandom();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            stringBuilder.append(String.valueOf(secureRandom.nextInt(10)));
        }
        return stringBuilder.toString();
    }

    public static String m25045f(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (C5181l.m25037a(str)) {
            String[] split = str.split("@");
            if (split.length != 2 || split[0].length() <= 0 || split[1].length() <= 0) {
                return str;
            }
            String str2 = split[0];
            String str3 = split[1];
            if (str2.length() <= 6 || !C5181l.m25038a(str2, HwAccountConstants.DIGITAL_REGX)) {
                if (str2.length() > 8) {
                    return str2.substring(0, str2.length() - 4) + "****@" + str3;
                }
                if (str2.length() > 2) {
                    return str2.substring(0, str2.length() - 2) + "**@" + str3;
                }
                return C5181l.m25035a("*", str2.length()) + "@" + str3;
            } else if (str2.length() > 8) {
                return str2.substring(0, str2.length() - 8) + "****" + str2.substring(str2.length() - 4) + "@" + str3;
            } else {
                return C5181l.m25035a("*", str2.length() - 4) + str2.substring(str2.length() - 4) + "@" + str3;
            }
        } else if (C5181l.m25039b(str)) {
            if (str.length() < 5) {
                return str;
            }
            if (str.length() < 8) {
                return C5181l.m25035a("*", str.length() - 4) + str.substring(str.length() - 4);
            }
            return str.substring(0, str.length() - 8) + "****" + str.substring(str.length() - 4);
        } else if (str.length() < 5) {
            return str;
        } else {
            if (str.length() < 8) {
                return C5181l.m25035a("*", str.length() - 4) + str.substring(str.length() - 4);
            }
            return str.substring(0, str.length() - 8) + "****" + str.substring(str.length() - 4);
        }
    }

    private static String m25035a(String str, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public static String m25036a(String str, String[] strArr) {
        return Pattern.compile(strArr[0]).matcher(str).replaceAll(strArr[1]);
    }
}
