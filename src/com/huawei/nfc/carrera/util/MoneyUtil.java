package com.huawei.nfc.carrera.util;

import java.text.DecimalFormat;

public class MoneyUtil {
    public static String changeIntoDisplayMoney(String str, double d) {
        return str + formatMoneyByTwoPoint(d);
    }

    public static String formatMoneyByTwoPoint(double d) {
        return new DecimalFormat("0.00").format(d);
    }

    public static int convertYuanToFen(String str) {
        try {
            return (int) Math.round(Double.parseDouble(str) * 100.0d);
        } catch (NumberFormatException e) {
            LogX.i("MoneyUtil convertYuanToFen NumberFormatException. amount : " + str);
            return -1;
        }
    }

    public static String convertFenToYuan(long j) {
        Object obj;
        String str;
        if (j >= 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            j *= -1;
        }
        long j2 = j % 100;
        long j3 = j / 100;
        if (j2 < 10) {
            str = "0" + String.valueOf(j2);
        } else {
            str = String.valueOf(j2);
        }
        if (obj != null) {
            return String.valueOf(j3) + "." + str;
        }
        return "-" + String.valueOf(j3) + "." + str;
    }

    public static String convertFenToYuan(String str) {
        try {
            return convertFenToYuan(Long.parseLong(str));
        } catch (NumberFormatException e) {
            return "";
        }
    }
}
