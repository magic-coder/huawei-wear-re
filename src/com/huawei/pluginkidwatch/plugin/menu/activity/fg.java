package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationHistoryActivity */
class fg extends BroadcastReceiver {
    final /* synthetic */ NotificationHistoryActivity f6117a;

    fg(NotificationHistoryActivity notificationHistoryActivity) {
        this.f6117a = notificationHistoryActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("NotificationHistoryActivity", "===NotificationHistoryReceiver onReceive is enter");
        this.f6117a.m9459d();
    }
}
