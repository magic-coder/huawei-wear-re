package com.aps;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: Storage */
public class bq {
    private static bq f13062a = null;

    static String m17436a(Object obj, String str) {
        DecimalFormat decimalFormat = new DecimalFormat("#", new DecimalFormatSymbols(Locale.US));
        decimalFormat.applyPattern(str);
        return decimalFormat.format(obj);
    }

    static byte[] m17439a(String str) {
        return m17437a(Integer.parseInt(str));
    }

    static byte[] m17437a(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255), (byte) ((i >> 16) & 255), (byte) ((i >> 24) & 255)};
    }

    static byte[] m17441b(String str) {
        return m17440b(Integer.parseInt(str));
    }

    static byte[] m17440b(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i >> 8) & 255)};
    }

    public static byte[] m17438a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) ((int) ((j >> (i * 8)) & 255));
        }
        return bArr;
    }
}
