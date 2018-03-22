package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: AlarmEditActivity */
class C5804m extends TimerTask {
    final /* synthetic */ AlarmEditActivity f19966a;

    C5804m(AlarmEditActivity alarmEditActivity) {
        this.f19966a = alarmEditActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.SYNC_ALARM)) {
            this.f19966a.sendBroadcast(new Intent("com.fenda.hwbracelet.ALARM_SET_FAIL"), "com.af500.permission.MYBRODCAST");
            this.f19966a.m26656p();
        }
    }
}
