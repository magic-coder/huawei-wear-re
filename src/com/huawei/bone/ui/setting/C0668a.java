package com.huawei.bone.ui.setting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationPushListener */
class C0668a extends BroadcastReceiver {
    final /* synthetic */ NotificationPushListener f1222a;

    C0668a(NotificationPushListener notificationPushListener) {
        this.f1222a = notificationPushListener;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("com.huawei.bone.ACTION_NOTIFICATION_TIME_CHANGED".equals(action)) {
                C2538c.m12661a("04", 1, "NotificationPushListener", "ACTION_NOTIFICATION_TIME_CHANGED");
            } else if ("com.huawei.bone.ACTION_NOTIFICATION_AUTHORIZED_CHANGED".equals(action)) {
                action = intent.getStringExtra(SNBConstant.FIELD_PKG);
                C2538c.m12661a("04", 1, "NotificationPushListener", "NotificationAppListInfo.ACTION_NOTIFICATION_AUTHORIZED_CHANGED, mPushApp: " + action + " : " + intent.getIntExtra("authorized_flag", 0));
                if (action == null) {
                    return;
                }
                if (1 == r1) {
                    if (!this.f1222a.f1218b.contains(action)) {
                        this.f1222a.f1218b.add(action);
                    }
                } else if (this.f1222a.f1218b.contains(action)) {
                    this.f1222a.f1218b.remove(action);
                }
            }
        }
    }
}
