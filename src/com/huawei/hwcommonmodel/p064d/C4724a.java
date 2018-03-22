package com.huawei.hwcommonmodel.p064d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.p190v.C2538c;

/* compiled from: BroadcastManagerUtil */
public class C4724a {
    private static final String f17275a = C4724a.class.getSimpleName();

    public static final void m22612a(Context context, Intent intent) {
        C2538c.c(f17275a, new Object[]{"broadcast", intent.getAction()});
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        intent.setPackage(context.getPackageName());
        if (instance != null) {
            instance.sendBroadcast(intent);
        }
    }

    public static final void m22611a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        if (instance != null) {
            instance.registerReceiver(broadcastReceiver, intentFilter);
        }
    }

    public static final void m22610a(Context context, BroadcastReceiver broadcastReceiver) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        if (instance != null) {
            instance.unregisterReceiver(broadcastReceiver);
        }
    }

    public static void m22613b(Context context, Intent intent) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        if (instance != null) {
            instance.sendBroadcast(intent);
        }
    }
}
