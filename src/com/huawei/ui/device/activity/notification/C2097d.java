package com.huawei.ui.device.activity.notification;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.huawei.hwcommonmodel.p062a.C0972a;
import com.huawei.p190v.C2538c;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.device.i;

/* compiled from: NotificationSettingActivity */
class C2097d implements OnCheckedChangeListener {
    final /* synthetic */ NotificationSettingActivity f7413a;

    C2097d(NotificationSettingActivity notificationSettingActivity) {
        this.f7413a = notificationSettingActivity;
    }

    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        C2538c.m12677c("NotificationSettingActivity", "mNotificationSwitchOnlyWear clicked : isChecked = " + z);
        if (C0972a.m3499a() == null || !C0972a.m3499a().isSupportWearMessagePush()) {
            a.a(this.f7413a.f7392c, i.IDS_music_management_operation_failed);
        } else {
            this.f7413a.f7398i.m10303a(z, new C2098e(this));
        }
    }
}
