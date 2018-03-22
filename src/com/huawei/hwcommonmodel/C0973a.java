package com.huawei.hwcommonmodel;

import android.annotation.SuppressLint;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

@SuppressLint({"DefaultLocale"})
/* compiled from: HEXUtils */
public class C0973a {
    public static String m3506a(int i) {
        String str = "";
        if (i < 0) {
            str = Integer.toHexString(i);
            return str.substring(str.length() - 2, str.length());
        } else if (16 > i) {
            return "0" + Integer.toHexString(i);
        } else {
            str = Integer.toHexString(i);
            return str.length() % 2 != 0 ? "0" + str : str;
        }
    }

    public static String m3507a(long j) {
        String str = "";
        long j2 = (j >> 16) & 255;
        long j3 = (j >> 8) & 255;
        long j4 = 255 & j;
        return ((C0973a.m3506a((int) ((j >> 24) & 255)) + C0973a.m3506a((int) j2)) + C0973a.m3506a((int) j3)) + C0973a.m3506a((int) j4);
    }

    public static String m3510b(int i) {
        String str = "";
        int i2 = i & 255;
        return C0973a.m3506a((i >> 8) & 255) + C0973a.m3506a(i2);
    }

    public static String m3508a(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            String toHexString = Integer.toHexString(charAt);
            if (charAt > '') {
                stringBuilder.append(toHexString);
            } else {
                stringBuilder.append("00" + toHexString);
            }
        }
        return stringBuilder.toString();
    }

    public static byte[] m3512b(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace(HwAccountConstants.BLANK, "");
        int length = replace.length() / 2;
        byte[] bArr = new byte[length];
        String str2 = "";
        str2 = "";
        for (int i = 0; i < length; i++) {
            int i2 = (i * 2) + 1;
            int i3 = i2 + 1;
            String substring = replace.substring(i * 2, i2);
            bArr[i] = (byte) Integer.parseInt(substring + replace.substring(i2, i3), 16);
        }
        return bArr;
    }

    public static String m3509a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str = "";
        StringBuilder stringBuilder = new StringBuilder("");
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append("0" + toHexString);
            } else {
                stringBuilder.append(toHexString);
            }
        }
        return stringBuilder.toString().toUpperCase(Locale.US).trim();
    }

    public static String m3514c(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        byte[] bArr = new byte[(str.length() / 2)];
        String str2 = "0123456789ABCDEF";
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (((str2.indexOf(toCharArray[i * 2]) * 16) + str2.indexOf(toCharArray[(i * 2) + 1])) & 255);
        }
        try {
            return new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    public static int m3515d(String str) {
        int i = 0;
        C2538c.m12680e("hexToString2", "hexToString2:" + str);
        if (str == null) {
            C2538c.m12680e("hexToString2", "hexToString2:null");
        } else {
            try {
                i = Integer.parseInt(str, 16);
            } catch (NumberFormatException e) {
                C2538c.m12680e("NumberFormatException", e.getMessage());
            }
        }
        return i;
    }

    public static String m3518e(String str) {
        int i = 0;
        if (str == null) {
            C2538c.m12674b("stringToHex:", "string is null");
            return "";
        }
        char[] toCharArray = "0123456789ABCDEF".toCharArray();
        StringBuilder stringBuilder = new StringBuilder("");
        byte[] bArr = new byte[0];
        try {
            bArr = str.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
        }
        while (i < bArr.length) {
            stringBuilder.append(toCharArray[(bArr[i] & 240) >> 4]);
            stringBuilder.append(toCharArray[bArr[i] & 15]);
            i++;
        }
        return stringBuilder.toString().trim();
    }

    public static int m3513c(int i) {
        int i2 = 0;
        if (i >= 100) {
            i2 = i / 100;
            i %= 100;
        }
        return Integer.parseInt(C0973a.m3506a(i2) + C0973a.m3506a(i), 16);
    }

    public static String m3516d(int i) {
        int i2 = 0;
        if (i >= 100) {
            i2 = i / 100;
            i %= 100;
        }
        return i2 + ":" + i;
    }

    public static int m3519f(String str) {
        return (Integer.parseInt(str.substring(0, str.indexOf(":")), 10) * 100) + Integer.parseInt(str.substring(str.indexOf(":") + 1, str.length()), 10);
    }

    public static String m3517e(int i) {
        if (i <= 127) {
            return C0973a.m3506a(i);
        }
        int i2 = i & 127;
        int i3 = i >> 7;
        if (i3 > 127) {
            int i4 = i3 & 255;
            return C0973a.m3506a((i3 >> 7) + 128) + C0973a.m3506a(i4) + C0973a.m3506a(i2);
        }
        return C0973a.m3506a((i >> 7) + 128) + C0973a.m3506a(i2);
    }

    public static String m3505a(double d) {
        return C0973a.m3509a(C0973a.m3511b(d));
    }

    public static byte[] m3511b(double d) {
        byte[] bArr = new byte[8];
        long doubleToLongBits = Double.doubleToLongBits(d);
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = Long.valueOf(doubleToLongBits).byteValue();
            doubleToLongBits >>= 8;
        }
        return bArr;
    }

    public static byte[] m3520g(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    public static String a(final byte[] bArr) {
        return null;
    }
}
