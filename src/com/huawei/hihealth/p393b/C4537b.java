package com.huawei.hihealth.p393b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.p190v.C2538c;

/* compiled from: HiBroadcastManager */
public class C4537b {
    public static void m21741a(Context context, Intent intent) {
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context);
        if (instance == null) {
            C2538c.d("Debug_HiBroadcastManager", new Object[]{"sendLocalBroadcast localBroadcastManager == null"});
            return;
        }
        instance.sendBroadcast(intent);
    }

    public static void m21742b(Context context, Intent intent) {
        context.sendBroadcast(intent, "com.huawei.hihealth.DEFAULT_PERMISSION");
    }

    public static final void m21740a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        context.registerReceiver(broadcastReceiver, intentFilter, "com.huawei.hihealth.DEFAULT_PERMISSION", null);
    }

    public static final void m21739a(Context context, BroadcastReceiver broadcastReceiver) {
        context.unregisterReceiver(broadcastReceiver);
    }
}
