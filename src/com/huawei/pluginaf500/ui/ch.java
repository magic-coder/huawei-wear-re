package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: SportRemindActivity */
class ch extends TimerTask {
    final /* synthetic */ SportRemindActivity f19955a;

    ch(SportRemindActivity sportRemindActivity) {
        this.f19955a = sportRemindActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.SYNC_SPORT_REMIND)) {
            this.f19955a.m26512c();
            this.f19955a.sendBroadcast(new Intent("com.fenda.hwbracelet.SPORT_REMIND_SET_FAIL"), "com.af500.permission.MYBRODCAST");
            this.f19955a.m26869p();
        }
    }
}
