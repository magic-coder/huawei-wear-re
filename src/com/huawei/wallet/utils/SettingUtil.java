package com.huawei.wallet.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.provider.Settings.Secure;
import com.huawei.wallet.utils.log.LogC;

public class SettingUtil {
    private static boolean f21604a = false;
    private static boolean f21605b = true;

    public static boolean m28477a(Context context) {
        if (!f21604a) {
            try {
                context.getPackageManager().getApplicationInfo("com.huawei.bd", 8192);
            } catch (NameNotFoundException e) {
                LogC.m28530b("isSupportUserExperience: bd is not installed", false);
                try {
                    context.getPackageManager().getApplicationInfo("com.huawei.lcagent", 8192);
                } catch (NameNotFoundException e2) {
                    f21605b = false;
                    LogC.m28530b("isSupportUserExperience: lcagent is not installed", false);
                }
            }
            f21604a = true;
            LogC.m28527a("isSupportUserExperience: has checked， need not check again, isSupportUserExperience = " + f21605b, false);
        }
        return f21605b;
    }

    public static boolean m28478b(Context context) {
        boolean z = true;
        if (context == null || context.getContentResolver() == null) {
            return false;
        }
        int i = Secure.getInt(context.getContentResolver(), "user_experience_involved", -1);
        LogC.m28527a("get settings userExperienceInvolved value, userExperienceInvolved=" + i, false);
        if (i != 1) {
            z = false;
        }
        return z;
    }
}
