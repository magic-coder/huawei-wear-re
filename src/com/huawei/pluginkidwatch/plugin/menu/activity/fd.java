package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.os.Handler;
import android.os.Message;

/* compiled from: NotificationHistoryActivity */
class fd extends Handler {
    final /* synthetic */ NotificationHistoryActivity f6114a;

    fd(NotificationHistoryActivity notificationHistoryActivity) {
        this.f6114a = notificationHistoryActivity;
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.f6114a.f5782c.setVisibility(0);
                this.f6114a.f5783d.setVisibility(8);
                break;
            case 2:
                this.f6114a.f5782c.setVisibility(8);
                this.f6114a.f5783d.setVisibility(0);
                break;
        }
        super.handleMessage(message);
    }
}
