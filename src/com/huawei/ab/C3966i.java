package com.huawei.ab;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hihealth.p036a.C4509c;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.p190v.C2538c;

/* compiled from: HWUserInfoMgr */
class C3966i extends BroadcastReceiver {
    final /* synthetic */ C3956a f15196a;

    C3966i(C3956a c3956a) {
        this.f15196a = c3956a;
    }

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            C2538c.c("HWUserInfoMgr", new Object[]{"onReceive hiHealthCloudSyncReceiver action is null"});
            return;
        }
        C2538c.c("HWUserInfoMgr", new Object[]{"onReceive hiHealthCloudSyncReceiver:" + action});
        if (action.equals("com.huawei.hihealth.action_sync_data")) {
            int intExtra = intent.getIntExtra("com.huawei.hihealth.action_sync_type", 6);
            int intExtra2 = intent.getIntExtra("com.huawei.hihealth.action_sync_status", 6);
            C2538c.c("HWUserInfoMgr", new Object[]{"onReceive hiHealthCloudSyncReceiver dataType:" + intExtra + ",status:" + intExtra2});
            if ((2 == intExtra2 || 3 == intExtra2) && HwAccountConstants.MY_PERMISSIONS_REQUEST_lOCTION == intExtra) {
                C2538c.c("HWUserInfoMgr", new Object[]{"start fetchUserData"});
                C4509c.m21594a(this.f15196a.f15173e).m21617b(new C3967j(this));
            }
        }
        if ("com.huawei.hihealth.action_data_refresh".equals(action)) {
            C2538c.c("HWUserInfoMgr", new Object[]{"收到数据平台数据刷新广播"});
            if (intent.getIntExtra("refresh_type", 0) == 5) {
                C2538c.c("HWUserInfoMgr", new Object[]{"收到数据平台用户信息改变广播"});
                this.f15196a.m19663a(new C3968k(this));
            }
        }
    }
}
