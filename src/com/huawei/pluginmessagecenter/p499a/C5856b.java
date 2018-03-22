package com.huawei.pluginmessagecenter.p499a;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: DateUtil */
public class C5856b {
    public static long m27003a(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date(j));
        instance.add(14, -(instance.get(15) + instance.get(16)));
        return instance.getTimeInMillis();
    }

    public static long m27004a(String str) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (!(simpleDateFormat == null || str == null || str.isEmpty())) {
            try {
                date = simpleDateFormat.parse(str);
            } catch (ParseException e) {
                C5861g.m27023b("DateUtil", "dateString2Long ParseException e = " + e.getMessage());
            }
        }
        return date.getTime();
    }

    public static long m27006b(String str) {
        C5861g.m27024c("DateUtil", "DateUtils getTime:" + str);
        Date date = new Date();
        if (!(str == null || str.equals(""))) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd ");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            try {
                int length = str.split(":").length;
                if (length >= 3 || length <= 0) {
                    date = simpleDateFormat2.parse(simpleDateFormat.format(new Date()) + str);
                } else {
                    if (length == 2) {
                        date = simpleDateFormat2.parse(simpleDateFormat.format(new Date()) + str + ":00");
                    }
                    if (length == 1) {
                        date = str.endsWith(":") ? simpleDateFormat2.parse(simpleDateFormat.format(new Date()) + str + "00:00") : simpleDateFormat2.parse(simpleDateFormat.format(new Date()) + str + ":00:00");
                    }
                }
            } catch (ParseException e) {
                C5861g.m27024c("DateUtil", "getTime====" + e.getMessage());
            }
        }
        return date.getTime();
    }

    public static long m27005a(Date date, int i) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        instance.add(1, i);
        return instance.getTime().getTime();
    }
}
