package com.huawei.hwdatamigrate.common;

import android.text.TextUtils;
import com.huawei.p190v.C2538c;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: DateUtil */
public class C4803g {
    private static final Object f17750a = new Object();
    private static Map<Integer, String> f17751b = new HashMap();

    static {
        f17751b.put(Integer.valueOf(1), "yyyy-MM-dd");
        f17751b.put(Integer.valueOf(2), "yyyy/MM/dd");
        f17751b.put(Integer.valueOf(3), "yyyy年MM月dd日");
        f17751b.put(Integer.valueOf(4), "yyyyMMdd");
        f17751b.put(Integer.valueOf(5), "dd/MM/yyyy");
        f17751b.put(Integer.valueOf(6), "yyyy年MM月");
        f17751b.put(Integer.valueOf(7), "MM/dd");
        f17751b.put(Integer.valueOf(8), "HH:mm");
    }

    public static boolean m23004a(Date date, Date date2) {
        return C4803g.m23002a(date).equals(C4803g.m23002a(date2));
    }

    public static String m23002a(Date date) {
        String format;
        synchronized (f17750a) {
            format = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).format(date);
        }
        return format;
    }

    public static Date m23005b(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, 1);
        return instance.getTime();
    }

    public static Date m23003a(String str) {
        Date date = null;
        synchronized (f17750a) {
            if (TextUtils.isEmpty(str)) {
            } else {
                try {
                    date = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH).parse(str);
                } catch (ParseException e) {
                    C2538c.e("DateUtil", new Object[]{"Exception error:" + e.getMessage()});
                }
            }
        }
        return date;
    }

    public static Date m23006c(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(5, -1);
        return instance.getTime();
    }
}
