package com.huawei.pluginaf500.ui;

import com.huawei.pluginaf500.utils.C5818a;
import com.huawei.pluginaf500.utils.C5820c;
import java.util.TimerTask;

/* compiled from: SettingActivity */
class bm extends TimerTask {
    final /* synthetic */ SettingActivity f19933a;

    bm(SettingActivity settingActivity) {
        this.f19933a = settingActivity;
    }

    public void run() {
        if (C5818a.m26894a().m26896a(C5820c.BC_DISPLAY_STATE)) {
            this.f19933a.m26800o();
            this.f19933a.f.obtainMessage(C5793b.DISPLAY_GESTURE_SYN_FAIL.m26879a()).sendToTarget();
        }
    }
}
