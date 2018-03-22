package com.huawei.hihealth.p394c;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import org.apache.log4j.helpers.FileWatchdog;

/* compiled from: HiDateUtil */
public class C4540b {
    public static Date m21753a(String str, String str2) throws ParseException {
        DateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ENGLISH);
        simpleDateFormat.setLenient(false);
        return simpleDateFormat.parse(str);
    }

    public static int m21750a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return instance.get(5) + ((instance.get(1) * 10000) + ((instance.get(2) + 1) * 100));
    }

    public static long m21751a(int i) {
        long j = 0;
        if (i >= 10000000 && i <= 100000000) {
            try {
                j = C4540b.m21753a(Integer.toString(i), "yyyyMMdd").getTime();
            } catch (ParseException e) {
            }
        }
        return j;
    }

    public static String m21752a(String str) {
        if (str != null && !str.isEmpty()) {
            return str;
        }
        return new SimpleDateFormat("Z").format(Calendar.getInstance().getTime());
    }

    public static long m21754b(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static long m21755c(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.add(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static long m21756d(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        instance.set(14, 999);
        return instance.getTime().getTime();
    }

    public static long m21757e(long j) {
        return j - (j % FileWatchdog.DEFAULT_DELAY);
    }

    public static long m21758f(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.add(5, -1);
        instance.set(11, 20);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static long m21759g(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.add(5, 1);
        instance.set(11, 20);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static long m21760h(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(11, 20);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTime().getTime();
    }

    public static long m21761i(long j) {
        if (j < C4540b.m21760h(j)) {
            return C4540b.m21754b(j);
        }
        return C4540b.m21755c(j);
    }

    public static long m21762j(long j) {
        long h = C4540b.m21760h(j);
        return j >= h ? h : C4540b.m21758f(j);
    }

    public static long m21763k(long j) {
        long h = C4540b.m21760h(j);
        if (j < h) {
            return h - 1;
        }
        return C4540b.m21759g(j) - 1;
    }

    public static String m21764l(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
    }
}
