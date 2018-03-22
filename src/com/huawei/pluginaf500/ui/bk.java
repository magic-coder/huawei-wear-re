package com.huawei.pluginaf500.ui;

import android.os.Handler;
import android.os.Message;
import com.fenda.hwbracelet.connection.C3596n;

/* compiled from: SettingActivity */
class bk extends Handler {
    final /* synthetic */ SettingActivity f19931a;

    bk(SettingActivity settingActivity) {
        this.f19931a = settingActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 101:
            case 102:
                if (this.f19931a.m26514e() != null && 3 != C3596n.m18054a()) {
                    this.f19931a.m26514e().m26562c();
                    return;
                }
                return;
            default:
                return;
        }
    }
}
