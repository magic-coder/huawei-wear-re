package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: AlarmEditListActivity */
class C5809r extends TimerTask {
    final /* synthetic */ AlarmEditListActivity f19971a;

    C5809r(AlarmEditListActivity alarmEditListActivity) {
        this.f19971a = alarmEditListActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.SYNC_ALARM)) {
            this.f19971a.sendBroadcast(new Intent("com.fenda.hwbracelet.ALARM_SET_FAIL"), "com.af500.permission.MYBRODCAST");
            this.f19971a.m26676o();
        }
    }
}
