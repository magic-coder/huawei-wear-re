package com.huawei.hihealth.p393b;

import android.content.IntentFilter;

/* compiled from: HiBroadcastAction */
public class C4536a {
    public static IntentFilter m21738a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.huawei.hihealth.action_account_login_datas_switch_finish");
        intentFilter.addAction("com.huawei.hihealth.action_data_refresh");
        intentFilter.addAction("com.huawei.hihealth.action_receive_push");
        intentFilter.addAction("com.huawei.hihealth.action_sqlite_upgrade_done");
        intentFilter.addAction("com.huawei.hihealth.action_sqlite_upgrade_exception");
        intentFilter.addAction("com.huawei.hihealth.action_sqlite_upgrade_working");
        intentFilter.addAction("com.huawei.hihealth.action_sync");
        intentFilter.addAction("com.huawei.hihealth.action_sync_data");
        intentFilter.addAction("com.huawei.hihealth.action_sync_type");
        intentFilter.addAction("com.huawei.hihealth.action_sync_process");
        intentFilter.addAction("com.huawei.hihealth.action_sync_status");
        intentFilter.addAction("com.huawei.hihealth.action_user_goal_change");
        intentFilter.addAction("com.huawei.hihealth.user_preference");
        return intentFilter;
    }
}
