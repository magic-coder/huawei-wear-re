package com.huawei.hwbasemgr;

import android.annotation.TargetApi;
import android.content.Context;
import android.text.SpannableString;
import android.text.format.DateUtils;
import android.text.style.TextAppearanceSpan;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.db.a;
import com.huawei.p190v.C2538c;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: UnitUtil */
public class C0956c {
    private static double f1563a = 2.54d;
    private static double f1564b = 0.3048d;
    private static double f1565c = 0.9144d;
    private static double f1566d = 1.6093d;
    private static double f1567e = 0.3937d;
    private static double f1568f = 3.2808d;
    private static double f1569g = 1.0936d;
    private static double f1570h = 0.6214d;
    private static String f1571i = "";
    private static String f1572j = "show_imperial_unit_key";
    private static int f1573k = -1;

    public static void m3347a(int i) {
        f1573k = i;
    }

    public static double m3342a(double d, int i) {
        switch (i) {
            case 0:
                return f1567e * d;
            case 1:
                return f1568f * d;
            case 2:
                return f1569g * d;
            case 3:
                return f1570h * d;
            default:
                return 0.0d;
        }
    }

    public static double m3341a(double d) {
        return 2.2046d * d;
    }

    public static double m3350b(double d) {
        return 0.4536d * d;
    }

    public static boolean m3349a() {
        if ("false".equals(f1571i)) {
            return false;
        }
        if ("true".equals(f1571i)) {
            return true;
        }
        String a = a.a(f1572j);
        f1571i = a;
        C2538c.m12677c("UnitUtil", "isShow:" + a);
        if ("true".equals(a)) {
            return true;
        }
        if ("".equals(a) && C0956c.m3351b()) {
            return true;
        }
        f1571i = "false";
        return false;
    }

    public static void m3348a(boolean z) {
        f1571i = "";
        if (z) {
            a.b(f1572j, "true");
        } else {
            a.b(f1572j, "false");
        }
    }

    @TargetApi(3)
    public static String m3345a(Calendar calendar, int i) {
        String str = "";
        if (calendar != null) {
            str = DateUtils.formatDateTime(BaseApplication.m2632b(), calendar.getTimeInMillis(), i);
        } else {
            C2538c.m12679d("UnitUtil", "formatDateAndTime error, calendar is null");
        }
        C2538c.m12677c("UnitUtil", "formatDateAndTime myDateStr = " + str);
        return str;
    }

    @TargetApi(3)
    public static String m3346a(Date date, int i) {
        String str = "";
        if (date != null) {
            str = DateUtils.formatDateTime(BaseApplication.m2632b(), date.getTime(), i);
        } else {
            C2538c.m12679d("UnitUtil", "formatDateAndTime error, date is null");
        }
        C2538c.m12677c("UnitUtil", "formatDateAndTime myDateStr = " + str);
        return str;
    }

    public static String m3344a(double d, int i, int i2) {
        String str = "";
        NumberFormat instance;
        switch (i) {
            case 1:
                instance = NumberFormat.getInstance();
                instance.setMaximumFractionDigits(i2);
                instance.setMinimumFractionDigits(i2);
                return instance.format(d);
            case 2:
                instance = NumberFormat.getPercentInstance();
                instance.setMaximumFractionDigits(i2);
                instance.setMinimumFractionDigits(i2);
                return instance.format(d / 100.0d);
            default:
                return str;
        }
    }

    public static SpannableString m3343a(Context context, String str, String str2, int i, int i2) {
        CharSequence spannableString = new SpannableString(str2);
        spannableString.setSpan(new TextAppearanceSpan(context, i2), 0, spannableString.toString().length(), 33);
        Matcher matcher = Pattern.compile(str, 2).matcher(spannableString);
        while (matcher.find()) {
            spannableString.setSpan(new TextAppearanceSpan(context, i), matcher.start(), matcher.end(), 33);
        }
        return spannableString;
    }

    public static boolean m3351b() {
        C2538c.m12677c("UnitUtil", "strCountryCode:" + BaseApplication.m2632b().getResources().getConfiguration().locale.getCountry());
        if ("US".equals(BaseApplication.m2632b().getResources().getConfiguration().locale.getCountry())) {
            return true;
        }
        return false;
    }
}
