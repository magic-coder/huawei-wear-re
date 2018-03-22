package com.huawei.androidcommon.utils;

import android.text.TextUtils;
import android.util.Log;
import com.huawei.androidcommon.constants.AC;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateTimeUtils {
    public static long getCurrentTimeInMillis() {
        return System.currentTimeMillis();
    }

    public static long getTimeInSeconds(Date date) {
        return date.getTime() / 1000;
    }

    public static long getCurrentTimeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }

    public static long getTimeInSeconds(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
        if (str.contains("T")) {
            str = str.replaceAll("\\+.+", "");
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US);
        }
        try {
            return simpleDateFormat.parse(str).getTime() / 1000;
        } catch (Throwable e) {
            Log.e(AC.TAG, "[DateTimeUtils.getTimeInSecond]Error:", e);
            return 0;
        }
    }

    public static String getDateStr(long j) {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j));
    }

    public static String getTimeStr(long j) {
        return new SimpleDateFormat("HH:mm:ss", Locale.US).format(Long.valueOf(j));
    }

    public static String getDateTimeStrWithMillSec(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Long.valueOf(j));
    }

    public static String getCurrentDateStr() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentTimeStr() {
        return new SimpleDateFormat("HH:mm:ss", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDateTimeStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getCurrentDateTimeStrNoHyphen() {
        return new SimpleDateFormat("yyyyMMdd HHmmss", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String getDateTimeStrWithSec(long j) {
        if (j <= 0) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(new Date(1000 * j));
    }

    public static String getMinuteTimeStrWithSec(long j) {
        if (j <= 0) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.US).format(new Date(1000 * j));
    }

    public static long parseDateTimeStr(String str) {
        long j = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str).getTime();
            } catch (Throwable e) {
                Log.e(AC.TAG, "[DateTimeUtils.parseDateTimeStr]Error:", e);
            }
        }
        return j;
    }

    public static long parseDateStr(String str) {
        long j = 0;
        if (!TextUtils.isEmpty(str)) {
            try {
                j = new SimpleDateFormat("yyyy-MM-dd", Locale.US).parse(str).getTime();
            } catch (Throwable e) {
                Log.e(AC.TAG, "[DateTimeUtils.parseDateStr]Error:", e);
            }
        }
        return j;
    }

    public static String formatDate(SimpleDateFormat simpleDateFormat, Date date) {
        try {
            return simpleDateFormat.format(date);
        } catch (Throwable e) {
            Log.e(AC.TAG, "[DateTimeUtils.formatDate]Error:", e);
            return "";
        }
    }

    public static boolean beyondOneDay(long j, long j2) {
        return j2 - j >= 86400000;
    }

    public static boolean beyondDays(long j, long j2, int i) {
        return j2 - j >= ((long) ((((i * 24) * 60) * 60) * 1000));
    }
}
