package com.huawei.bone.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.bone.ui.setting.NotificationPushListener;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;

public class NotificationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null && "com.huawei.bone.notification.rebindService".equals(intent.getAction())) {
            C2538c.m12677c("NotificationReceiver", "need to rebind notification service!");
            C0977d.m3531a(context, NotificationPushListener.class);
        }
    }
}
