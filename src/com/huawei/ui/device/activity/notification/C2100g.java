package com.huawei.ui.device.activity.notification;

/* compiled from: NotificationSettingActivity */
class C2100g extends Thread {
    final /* synthetic */ NotificationSettingActivity f7416a;

    private C2100g(NotificationSettingActivity notificationSettingActivity) {
        this.f7416a = notificationSettingActivity;
    }

    public void run() {
        super.run();
        this.f7416a.m10857a();
        this.f7416a.f7391b.sendEmptyMessage(0);
    }
}
