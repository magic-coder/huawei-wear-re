package com.huawei.crowdtestsdk.constants;

import com.huawei.crowdtestsdk.utils.DateUtils;
import java.util.Date;

public class SdfConstants {
    public static String getDateTime(long j) {
        try {
            return DateUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
        } catch (Exception e) {
            return "Null";
        }
    }

    public static String getDateTimeNoSecond(long j) {
        try {
            return DateUtils.getSimpleDateFormat("yyyy/MM/dd HH:mm").format(Long.valueOf(j));
        } catch (Exception e) {
            return "Null";
        }
    }

    public static Date getDateTime(String str) {
        try {
            return DateUtils.getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static String getDateTime(Date date) {
        try {
            return DateUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        } catch (Exception e) {
            return "Null";
        }
    }
}
