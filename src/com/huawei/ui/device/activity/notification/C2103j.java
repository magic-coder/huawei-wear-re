package com.huawei.ui.device.activity.notification;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: NotificationSettingActivity */
class C2103j extends Handler {
    WeakReference<NotificationSettingActivity> f7420a = null;

    public C2103j(NotificationSettingActivity notificationSettingActivity) {
        this.f7420a = new WeakReference(notificationSettingActivity);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        NotificationSettingActivity notificationSettingActivity = (NotificationSettingActivity) this.f7420a.get();
        if (notificationSettingActivity != null) {
            switch (message.what) {
                case 0:
                    if (!(notificationSettingActivity.isFinishing() || notificationSettingActivity.isDestroyed())) {
                        notificationSettingActivity.f7400k.notifyDataSetChanged();
                    }
                    notificationSettingActivity.m10848d();
                    return;
                default:
                    return;
            }
        }
    }
}
