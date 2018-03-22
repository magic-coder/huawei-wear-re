package com.huawei.ui.device.activity.notification;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: NotificationSettingActivity */
class C2098e implements IBaseResponseCallback {
    final /* synthetic */ C2097d f7414a;

    C2098e(C2097d c2097d) {
        this.f7414a = c2097d;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12661a("NotificationSettingActivity", 1, "NotificationSettingActivity", "setWearMessagePushSwitchStatus err_code =" + i + ",objData = " + obj);
    }
}
