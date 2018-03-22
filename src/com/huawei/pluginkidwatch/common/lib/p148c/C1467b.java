package com.huawei.pluginkidwatch.common.lib.p148c;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.utils.C1497q;

/* compiled from: K1CommonMethod */
public class C1467b {
    private static final String f3412a = ("KIDWATCH_" + C1467b.class.getSimpleName());

    public static void m6784a(Context context, int i) {
        C2538c.m12677c(f3412a, "setK1DeviceType... deviceType = ", Integer.valueOf(i));
        C1497q.m6947b(context, "k1_device_type", i);
    }

    public static int m6783a(Context context) {
        return C1497q.m6935a(context, "k1_device_type", 0);
    }

    public static void m6785b(Context context) {
        C1497q.m6947b(context, "k1_device_type", 0);
    }

    public static void m6786b(Context context, int i) {
        C2538c.m12677c(f3412a, "setK1K2DeviceType... deviceType = ", Integer.valueOf(i));
        C1497q.m6947b(context, "k1k2_device_type", i);
    }

    public static int m6787c(Context context) {
        return C1497q.m6935a(context, "k1k2_device_type", -1);
    }

    public static void m6788c(Context context, int i) {
        C2538c.m12677c(f3412a, "setK1K2DeviceTypeTempSelect... deviceType = ", Integer.valueOf(i));
        C1497q.m6947b(context, "k1k2_device_type_temp_select", i);
    }

    public static int m6789d(Context context) {
        return C1497q.m6935a(context, "k1k2_device_type_temp_select", -1);
    }
}
