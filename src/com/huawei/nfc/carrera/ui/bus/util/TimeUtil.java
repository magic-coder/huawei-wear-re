package com.huawei.nfc.carrera.ui.bus.util;

import android.text.TextUtils;
import com.huawei.nfc.carrera.util.LogX;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {
    private static long lastClickTime;

    public static Calendar getCalendar(String str) {
        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        if (!TextUtils.isEmpty(str)) {
            int month;
            Date date = null;
            try {
                date = simpleDateFormat.parse(str);
                month = date.getMonth();
            } catch (ParseException e) {
                LogX.e("date parse error.", false);
                month = -1;
            }
            if (-1 < month && month < 13 && date != null) {
                instance.setTime(date);
            }
        }
        return instance;
    }

    public static Date parseString2Date(String str, String str2) {
        try {
            return new SimpleDateFormat(str2, Locale.getDefault()).parse(str);
        } catch (ParseException e) {
            LogX.e("parseDateStr ParseException dateStr : " + str, false);
            return null;
        }
    }

    public static String formatDate2String(Date date, String str) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(str, Locale.getDefault()).format(date);
    }

    public static boolean isFastDoubleClick() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - lastClickTime < 1000) {
            lastClickTime = currentTimeMillis;
            return true;
        }
        lastClickTime = currentTimeMillis;
        return false;
    }
}
