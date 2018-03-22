package com.huawei.hwdatamigrate.common;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.p190v.C2538c;

import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;
import org.apache.log4j.net.SyslogAppender;

/* compiled from: BOneUtil */
public class C4800b {
    public static final String f17742a = C4800b.m22984a(1440);
    public static final String f17743b = C4800b.m22984a((int) SyslogAppender.LOG_LOCAL2);
    public static final String f17744c = C4800b.m22984a(432);
    private static boolean f17745d = true;
    private static double f17746e = 6378.137d;
    private static final Object f17747f = new Object();

    private static String m22984a(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(',').append(0);
        }
        return stringBuilder.substring(1);
    }

    public static int[] m22986a(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(",");
        int[] iArr = new int[split.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = Integer.parseInt(split[i]);
        }
        return iArr;
    }

    public static int m22982a(String str, int i) {
        if (!(str == null || str.trim().length() == 0)) {
            String trim = str.trim();
            try {
                i = Integer.parseInt(trim);
            } catch (Exception e) {
                try {
                    i = Float.valueOf(Float.parseFloat(trim)).intValue();
                } catch (Exception e2) {
                }
            }
        }
        return i;
    }

    public static int m22987b(String str) {
        return C4800b.m22982a(str, 0);
    }

    public static String m22988c(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return C4802d.f17749a;
        }
        int i2;
        String[] split = str.split(",");
        int[] iArr = new int[1440];
        Arrays.fill(iArr, -1);
        for (int i3 = 0; i3 < split.length; i3++) {
            int b = C4800b.m22987b(split[i3]);
            if (b > 0) {
                if (b < 10) {
                    for (i2 = 0; i2 < 10; i2++) {
                        iArr[(i3 * 10) + i2] = 0;
                    }
                    iArr[i3 * 10] = b;
                } else {
                    int i4 = b / 10;
                    b %= 10;
                    for (i2 = 0; i2 < 9; i2++) {
                        iArr[(i3 * 10) + i2] = i4;
                    }
                    iArr[(i3 * 10) + 9] = b + i4;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        i2 = iArr.length;
        while (i < i2) {
            stringBuilder.append("," + iArr[i]);
            i++;
        }
        return stringBuilder.toString().substring(1);
    }

    public static String m22989d(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return C4802d.f17749a;
        }
        int i2;
        String[] split = str.split(",");
        float[] fArr = new float[1440];
        Arrays.fill(fArr, 0.0f);
        for (int i3 = 0; i3 < split.length; i3++) {
            float floatValue = C4800b.m22991f(split[i3]).floatValue();
            if (floatValue > 0.0f) {
                if (floatValue < 10.0f) {
                    for (i2 = 0; i2 < 10; i2++) {
                        fArr[(i3 * 10) + i2] = 0.0f;
                    }
                    fArr[i3 * 10] = floatValue;
                } else {
                    int i4 = ((int) floatValue) / 10;
                    floatValue -= (float) (i4 * 10);
                    for (i2 = 0; i2 < 9; i2++) {
                        fArr[(i3 * 10) + i2] = (float) i4;
                    }
                    fArr[(i3 * 10) + 9] = floatValue + ((float) i4);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        i2 = fArr.length;
        while (i < i2) {
            stringBuilder.append("," + fArr[i]);
            i++;
        }
        return stringBuilder.toString().substring(1);
    }

    public static String m22985a(Context context, String str) {
        String str2;
        synchronized (f17747f) {
            if (str == null) {
                C2538c.b("BOneUtil", new Object[]{"getSleepDataDetailInMin strDataDetail = null "});
                str2 = "";
            } else {
                String[] split = str.split(",");
                if (432 != split.length) {
                    C2538c.b("BOneUtil", new Object[]{"getSleepDataDetailInMin strDataDetail length= " + split.length});
                    str2 = "";
                } else {
                    StringBuilder stringBuilder = new StringBuilder();
                    Object obj = null;
                    for (int i = 0; i < 432; i++) {
                        int b = C4800b.m22987b(split[i]);
                        if (obj == null) {
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            obj = 1;
                        } else if (1 == obj) {
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            int i2 = 2;
                        } else if (2 == obj) {
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            stringBuilder.append("," + b);
                            obj = null;
                        }
                    }
                    str2 = stringBuilder.substring(1);
                }
            }
        }
        return str2;
    }

    public static String[] m22990e(String str) {
        int i = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",", false);
        String[] strArr = new String[stringTokenizer.countTokens()];
        while (stringTokenizer.hasMoreElements()) {
            int i2 = i + 1;
            strArr[i] = stringTokenizer.nextToken();
            i = i2;
        }
        return strArr;
    }

    public static Float m22983a(String str, Float f) {
        if (!(str == null || str.trim().length() == 0)) {
            try {
                f = Float.valueOf(str.trim());
            } catch (NumberFormatException e) {
                C2538c.e("BOneUtil", new Object[]{"getFloat()->Float.valueOf(" + r0 + ") Exception=" + e.getMessage()});
            }
        }
        return f;
    }

    public static Float m22991f(String str) {
        return C4800b.m22983a(str, Float.valueOf(0.0f));
    }

    public static String m22992g(String str) {
        String str2 = "";
        if (str == null || str.trim().isEmpty()) {
            return str2;
        }
        Locale[] availableLocales = Locale.getAvailableLocales();
        String str3 = str2;
        for (int i = 0; i < availableLocales.length; i++) {
            if (str.equalsIgnoreCase(availableLocales[i].getCountry())) {
                str3 = availableLocales[i].getDisplayCountry();
                if (!"".equals(str3)) {
                    return str3;
                }
            }
        }
        return str3;
    }

    public static String m22993h(String str) {
        String str2 = "";
        if (!(str == null || str.trim().isEmpty())) {
            Locale[] availableLocales = Locale.getAvailableLocales();
            for (int i = 0; i < availableLocales.length; i++) {
                if (str.equalsIgnoreCase(availableLocales[i].getDisplayCountry())) {
                    return availableLocales[i].getCountry();
                }
            }
        }
        return str2;
    }
}
