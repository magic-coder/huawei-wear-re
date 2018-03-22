package com.huawei.pay.p130e.p488a;

import com.huawei.wallet.utils.log.LogC;
import java.text.DecimalFormat;
import java.util.Locale;

/* compiled from: MoneyUtils */
public class C5726a {
    public static String m26396a(String str) {
        try {
            double parseDouble = Double.parseDouble(str);
            DecimalFormat decimalFormat = (DecimalFormat) DecimalFormat.getInstance(Locale.US);
            decimalFormat.applyPattern("0.00");
            return decimalFormat.format(parseDouble);
        } catch (NumberFormatException e) {
            LogC.m28534d("NumberFormatException: getFormatAmount failed: amount=" + str, true);
            return null;
        }
    }
}
