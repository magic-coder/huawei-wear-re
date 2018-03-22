package com.huawei.operation.utils;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.p111o.p479c.C5705a;
import java.util.Calendar;

public class OperationUtils {
    private static final String MESSAGE_HW_PHONE = "HW";
    private static String MESSAGE_OTHER_PHONE = "3RD";

    public static String getAppId(Context context) {
        String str = "";
        if (context != null) {
            return C5705a.m26330a(context);
        }
        return str;
    }

    public static String getSysVersion() {
        return VERSION.RELEASE;
    }

    public static int getAppType() {
        return 5;
    }

    public static String getTokenType() {
        return "1";
    }

    public static long getUTC() {
        Calendar instance = Calendar.getInstance();
        instance.add(14, -(instance.get(15) + instance.get(16)));
        return instance.getTimeInMillis();
    }

    public static int getIVersion() {
        return 2;
    }

    public static String getDeviceModel() {
        return Build.MODEL;
    }

    public static String getDeviceSn() {
        return Build.SERIAL;
    }

    public static String getPhoneType() {
        if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
            return MESSAGE_HW_PHONE;
        }
        return MESSAGE_OTHER_PHONE;
    }
}
