package com.huawei.hwcommonmodel.p064d;

import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: TimeDateFormatUtil */
public class C4734m {
    static final SimpleDateFormat f17286a = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);
    private static final Object f17287b = new Object();

    public static String m22638a(Date date) {
        return DateFormat.getDateInstance().format(date);
    }

    public static Date m22640a() {
        Calendar instance = Calendar.getInstance();
        instance.set(instance.get(1), instance.get(2), instance.get(5));
        return instance.getTime();
    }

    public static int m22643b(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance.get(2) + 1;
    }

    public static Date m22646c(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, 1);
        return instance.getTime();
    }

    public static long m22647d(Date date) {
        return Long.valueOf(date.getTime()).longValue() / 1000;
    }

    public static Date m22641a(long j) {
        return new Date((1000 * j) + ((long) TimeZone.getDefault().getRawOffset()));
    }

    public static Date m22642a(String str, String str2) {
        Date date = null;
        if (!TextUtils.isEmpty(str2)) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
            simpleDateFormat.setTimeZone(TimeZone.getDefault());
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException e) {
                C2538c.b("TimeDateFormatUtil", new Object[]{"parse date wrong:" + str + ", e.Message:" + e.getMessage()});
            }
        }
        return date;
    }

    public static String m22639a(Date date, String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getDefault());
        Calendar instance = Calendar.getInstance();
        instance.setTimeZone(TimeZone.getDefault());
        instance.setTime(date);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String m22637a(String str) {
        StringBuffer stringBuffer = new StringBuffer(str);
        if (stringBuffer.length() == 1) {
            stringBuffer.insert(0, "0:0");
        } else if (stringBuffer.length() == 2) {
            stringBuffer.insert(0, "0:");
        } else if (stringBuffer.length() == 3) {
            stringBuffer.insert(1, ":");
        } else {
            stringBuffer.insert(2, ":");
        }
        return stringBuffer.toString();
    }

    public static String m22636a(int i) {
        return C4734m.m22637a(String.valueOf(i));
    }

    public static String m22644b(long j) {
        String str = null;
        try {
            str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        } catch (Exception e) {
            C2538c.e("TimeDateFormatUtil", new Object[]{"mformateDate exception=" + e});
        }
        return str;
    }

    public static Date m22645b(String str) {
        Date date = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
            } catch (ParseException e) {
                C2538c.e("TimeDateFormatUtil", new Object[]{"ParseException = " + e.getMessage()});
            }
        }
        return date;
    }
}
