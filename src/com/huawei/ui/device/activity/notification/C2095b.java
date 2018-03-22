package com.huawei.ui.device.activity.notification;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationSettingActivity */
class C2095b implements OnClickListener {
    final /* synthetic */ NotificationSettingActivity f7411a;

    C2095b(NotificationSettingActivity notificationSettingActivity) {
        this.f7411a = notificationSettingActivity;
    }

    public void onClick(View view) {
        C2538c.m12677c("NotificationSettingActivity", "cancel click");
        this.f7411a.f7393d.setChecked(true);
    }
}
