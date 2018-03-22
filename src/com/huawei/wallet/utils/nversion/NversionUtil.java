package com.huawei.wallet.utils.nversion;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserManager;

public final class NversionUtil {
    @TargetApi(24)
    public static boolean m12764a(Context context) {
        if (VERSION.SDK_INT < 24) {
            return true;
        }
        if (((UserManager) context.getSystemService("user")) == null) {
            return true;
        }
        return false;
    }
}
