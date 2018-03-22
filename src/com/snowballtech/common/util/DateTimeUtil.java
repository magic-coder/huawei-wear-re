package com.snowballtech.common.util;

import com.snowballtech.common.log.LogUtil;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateTimeUtil {
    public static final long DayLong = 86400000;
    private static String TAG = "DateTimeUtil";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public static Timestamp parseDateString(String str, String str2) {
        if (str2 == null || "".equals(str2)) {
            str2 = "yyyy-MM-dd HH:mm:ss";
        }
        try {
            return new Timestamp(new SimpleDateFormat(str2).parse(str).getTime());
        } catch (ParseException e) {
            LogUtil.loge(TAG, e.getMessage());
            return null;
        }
    }

    public static String currentDateTimeString() {
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date());
    }

    public static String currentDateString(String str) {
        if (str == null) {
            str = "yyyy-MM-dd";
        }
        simpleDateFormat.applyPattern(str);
        return simpleDateFormat.format(new Date());
    }

    public static String format(Timestamp timestamp) {
        if (timestamp != null) {
            return simpleDateFormat.format(new Date());
        }
        return "";
    }

    public static String format(Date date, String str) {
        if (ValueUtil.isEmpty(str)) {
            str = "yyyy-MM-dd";
        }
        simpleDateFormat.applyPattern(str);
        return simpleDateFormat.format(date);
    }

    public static String format(Timestamp timestamp, String str) {
        if (timestamp == null) {
            return "";
        }
        simpleDateFormat.applyPattern(str);
        return simpleDateFormat.format(timestamp);
    }

    public static String currentGMTTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat.format(new Date());
    }
}
