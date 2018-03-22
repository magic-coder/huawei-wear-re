package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: SleepRemindActivity */
class by extends TimerTask {
    final /* synthetic */ SleepRemindActivity f19945a;

    by(SleepRemindActivity sleepRemindActivity) {
        this.f19945a = sleepRemindActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.SYNC_SLEEP_REMIND)) {
            this.f19945a.m26512c();
            this.f19945a.sendBroadcast(new Intent("com.fenda.hwbracelet.SLEEP_REMIND_SET_FAIL"), "com.af500.permission.MYBRODCAST");
            this.f19945a.m26832n();
        }
    }
}
