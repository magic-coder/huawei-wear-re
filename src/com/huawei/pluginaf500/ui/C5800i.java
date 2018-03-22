package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: AlarmAddActivity */
class C5800i extends TimerTask {
    final /* synthetic */ AlarmAddActivity f19962a;

    C5800i(AlarmAddActivity alarmAddActivity) {
        this.f19962a = alarmAddActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.SYNC_ALARM)) {
            this.f19962a.sendBroadcast(new Intent("com.fenda.hwbracelet.ALARM_SET_FAIL"), "com.af500.permission.MYBRODCAST");
            this.f19962a.m26638p();
        }
    }
}
