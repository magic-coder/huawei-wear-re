package com.huawei.androidcommon.utils;

import android.content.Context;
import android.content.Intent;

public class ComponentUtils {
    public static void startNewActivity(Context context, Class<?> cls) {
        context.startActivity(new Intent(context, cls));
    }

    public static void startOrStopService(Context context, String str, boolean z) {
        Intent intent = new Intent();
        intent.setAction(str);
        if (z) {
            context.startService(intent);
        } else {
            context.stopService(intent);
        }
    }

    public static void startOrStopService(Context context, Class<?> cls, boolean z) {
        Intent intent = new Intent(context, cls);
        if (z) {
            context.startService(intent);
        } else {
            context.stopService(intent);
        }
    }
}
