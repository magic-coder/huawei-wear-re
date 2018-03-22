package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: AlarmRemindActivity */
class C5817z extends TimerTask {
    final /* synthetic */ AlarmRemindActivity f19984a;

    C5817z(AlarmRemindActivity alarmRemindActivity) {
        this.f19984a = alarmRemindActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.SYNC_ALARM)) {
            this.f19984a.sendBroadcast(new Intent("com.fenda.hwbracelet.ALARM_SET_FAIL"), "com.af500.permission.MYBRODCAST");
            this.f19984a.m26697o();
        }
    }
}
