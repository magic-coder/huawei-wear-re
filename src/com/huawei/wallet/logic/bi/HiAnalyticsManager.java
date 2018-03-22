package com.huawei.wallet.logic.bi;

import android.content.Context;
import com.c.a.c.a;
import com.huawei.wallet.utils.SettingUtil;

public class HiAnalyticsManager {
    public static boolean m27965a(Context context) {
        if (!SettingUtil.m28477a(context) || SettingUtil.m28478b(context)) {
            return false;
        }
        return true;
    }

    public static void m27964a(Context context, String str, String str2) {
        if (!m27965a(context)) {
            a.a(context, str, str2);
        }
    }

    public static void m27966b(Context context) {
        if (!m27965a(context)) {
            a.c(context);
        }
    }
}
