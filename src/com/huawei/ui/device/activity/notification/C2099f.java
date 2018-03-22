package com.huawei.ui.device.activity.notification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationSettingActivity */
class C2099f extends BroadcastReceiver {
    final /* synthetic */ NotificationSettingActivity f7415a;

    C2099f(NotificationSettingActivity notificationSettingActivity) {
        this.f7415a = notificationSettingActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.m12677c("NotificationSettingActivity", "mAPPInstalledReceiver: intent = null");
            return;
        }
        String action = intent.getAction();
        if ("android.intent.action.PACKAGE_ADDED".equals(action) || "android.intent.action.PACKAGE_REMOVED".equals(action)) {
            this.f7415a.f7401l = new C2100g(this.f7415a);
            this.f7415a.f7401l.start();
        }
    }
}
