package com.huawei.hwdatamigrate.hihealth.p066a;

import android.content.Context;
import android.content.Intent;
import com.huawei.hihealth.b.b;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: HiBroadcastUtil */
public class C1001a {
    public static void m3638a(Context context) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendSyncBeginBroadcast");
        Intent intent = new Intent("com.huawei.hihealth.action_sync");
        intent.putExtra("com.huawei.hihealth.action_sync_status", 0);
        C1001a.m3642a(context, intent);
    }

    public static void m3639a(Context context, double d) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendSyncProcessBroadcast process is ", Double.valueOf(d));
        Intent intent = new Intent("com.huawei.hihealth.action_sync");
        intent.putExtra("com.huawei.hihealth.action_sync_status", 1);
        intent.putExtra("com.huawei.hihealth.action_sync_process", d);
        C1001a.m3642a(context, intent);
    }

    public static void m3643b(Context context) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendPullSportDataFinishBroadcast");
        Intent intent = new Intent("com.huawei.hihealth.action_sync");
        intent.putExtra("com.huawei.hihealth.action_sync_status", 1000);
        C1001a.m3642a(context, intent);
    }

    public static void m3645c(Context context) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendSyncDoneBroadcast");
        Intent intent = new Intent("com.huawei.hihealth.action_sync");
        intent.putExtra("com.huawei.hihealth.action_sync_status", 2);
        C1001a.m3642a(context, intent);
    }

    public static void m3646d(Context context) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendSyncFailedBroadcast");
        Intent intent = new Intent("com.huawei.hihealth.action_sync");
        intent.putExtra("com.huawei.hihealth.action_sync_status", 3);
        C1001a.m3642a(context, intent);
    }

    public static void m3641a(Context context, int i, int i2) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendSyncDataBroadcast syncDataType is ", Integer.valueOf(i), " syncStatus is ", Integer.valueOf(i2));
        Intent intent = new Intent("com.huawei.hihealth.action_sync_data");
        intent.putExtra("com.huawei.hihealth.action_sync_type", i);
        intent.putExtra("com.huawei.hihealth.action_sync_status", i2);
        C1001a.m3642a(context, intent);
    }

    public static void m3640a(Context context, int i) {
        C2538c.m12677c("HiH_HiBroadcastUtil", "sendDataRefreshBroadcast refreshType = ", Integer.valueOf(i));
        Intent intent = new Intent("com.huawei.hihealth.action_data_refresh");
        intent.putExtra("refresh_type", i);
        C1001a.m3642a(context, intent);
    }

    public static void m3647e(Context context) {
        C1001a.m3644b(context, 0);
    }

    public static void m3644b(Context context, int i) {
        String packageName = context.getPackageName();
        if (WeChat.HEALTH_PACKAGE_NAME.equals(packageName)) {
            Intent intent = new Intent("com.huawei.hihealth.action_today_sport_data_refresh");
            C2538c.m12677c("HiH_HiBroadcastUtil", "sendTodaySportDataRefreshBroadcast is health start DaemonService");
            intent.setPackage(packageName);
            intent.setClassName(packageName, "com.huawei.health.manager.DaemonService");
            intent.putExtra("refresh_type", i);
            context.startService(intent);
        }
    }

    private static void m3642a(Context context, Intent intent) {
        b.b(context, intent);
    }
}
